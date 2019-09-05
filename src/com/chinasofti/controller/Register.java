package com.chinasofti.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hibernate.dao.Admininfo;
import com.hibernate.dao.AdmininfoDAO;

@Controller
public class Register {
	public String errorMsg;
	
	@RequestMapping("/register")
	public String Register(HttpServletRequest request,@RequestParam("regusername") String username, @RequestParam("regpassword") String password, @RequestParam("confirm") String confirm,@RequestParam("ID") String id,@RequestParam("phone") String phone,@RequestParam("resName") String resName,@RequestParam("resAdd") String resAdd,Model model)throws IOException
	{
		errorMsg=null;
		System.out.println(username);
		if(isEntity(username,password))
		{
			if(isConfirm(password,confirm))
			{
				if(id!=null && !id.trim().equals("") && phone!=null && !phone.trim().equals("") && resName!=null && !resName.trim().equals("") &&resAdd!=null&&!resAdd.trim().equals(""))
				{
					Admininfo admin=new Admininfo(username,password,"meiyou",id,phone,resName,resAdd);
					AdmininfoDAO adminDAO=new AdmininfoDAO();
					adminDAO.save(admin);
					return "Announce";
				}
				else
				{
					errorMsg="信息不全!";
					request.getSession().setAttribute("msg", errorMsg);
					//弹出对话框   
					return "reg";
				}
			}
			else
			{
				errorMsg="密码输入不一致!";
				request.getSession().setAttribute("msg", errorMsg);
				return "reg";
			}
		}
		else
		{
			errorMsg="用户密码与确认密码不一致！!";
			request.getSession().setAttribute("msg", errorMsg);
			return "reg";
		}
		
	}
	public boolean isEntity(String username,String password)
	{
		if(username!=null &&!username.trim().equals("") && password!=null && !password.trim().equals(""))
			return true;
		else
			return false;
	}
	public boolean isConfirm(String password,String confirm)
	{
		if(password.equals(confirm))
			return true;
		else
			return false;
	}
}

