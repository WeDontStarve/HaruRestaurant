package com.chinasofti.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hibernate.dao.Admininfo;
import com.hibernate.dao.AdmininfoDAO;


@Controller
public class ExitConfirm {
	public String errorMsg;
	public String exit;
	
	@RequestMapping("/sureexit.action")
	public String confirmExit(HttpServletRequest request,@RequestParam("name") String name, @RequestParam("psd") String psd)
	{
		if(name==null || name.equals(""))
		{
			errorMsg="管理员用户名或密码不能为空！";
			exit="custom_exit";
			request.getSession().setAttribute("exitmsg", errorMsg);
		}
		
		if(psd==null || psd.equals(""))
		{
			errorMsg="管理员用户名或密码不能为空！";
			exit="custom_exit";
			request.getSession().setAttribute("exitmsg", errorMsg);
		}
		
		int id=Integer.parseInt(name);
		AdmininfoDAO adminDAO=new AdmininfoDAO();
		Admininfo admin=adminDAO.findById(id);
		if(admin!=null)
		{
			String pass=admin.getAdminPassword();
			if(pass.equals(psd))
			{
				exit="login";
				errorMsg="退出成功";
			}
			else 
			{
				exit="custom_exit";
				errorMsg="用户名或密码错误";
				request.getSession().setAttribute("exitmsg", errorMsg);
			}
		}
		else
		{
			exit="custom_exit";
			errorMsg="用户名或密码错误";
			request.getSession().setAttribute("exitmsg", errorMsg);
		}
		return exit;
	}
}
