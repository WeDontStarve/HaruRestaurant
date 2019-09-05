package com.chinasofti.controller;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hibernate.dao.Admininfo;
import com.hibernate.dao.AdmininfoDAO;
import com.hibernate.dao.Waiterinfo;
import com.hibernate.dao.WaiterinfoDAO;
import com.hibernate.dao.Cheifinfo;
import com.hibernate.dao.CheifinfoDAO;
import com.hibernate.dao.Tableinfo;
import com.hibernate.dao.TableinfoDAO;

@Controller
public class Login {
	public String errorMsg;
	public String index;
	public String id;
	@RequestMapping("/login")
	public String login(HttpServletRequest request,@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("identity") String role,Model model){
		errorMsg=null;
		index=null;
		id=username;
		
		System.out.println(role);
		if(role.equals("-1"))//错误
		{
			index="login";	
			errorMsg="没有选择身份!";
			request.getSession().setAttribute("msg", errorMsg);
			return index;
		}
		
		else if(role.equals("1"))//顾客
		{
			if(isCompare(username,password,role))
			{
				index="custom_init";
				request.getSession().setAttribute("userid1", id);
				return index;
			}
			else
			{
				index="login";
				errorMsg="不存在此桌号!";
				request.getSession().setAttribute("msg", errorMsg);
				return index;
			}
		}
			
	
		else if(role.equals("2"))//管理员
		{
			if(isCompare(username,password,role))
			{
				index="Announce";
				request.getSession().setAttribute("userid", id);
				return index;
			}
			else
			{
				index="login";
				errorMsg="用户名或密码错误!";
				request.getSession().setAttribute("msg", errorMsg);
				return index;
			}
			
		}
			
		else if(role.equals("3"))//服务员
		{
			if(isCompare(username,password,role))
			{
				index="ser";
				request.getSession().setAttribute("userid2", id);
				return index;
			}
			else
			{
				index="login";
				errorMsg="用户名或密码错误!";
				request.getSession().setAttribute("msg", errorMsg);
				return index;
			}
		}
				
		else if(role.equals("4"))//后厨
		{
			if(isCompare(username,password,role))
			{
				index="cook";
				request.getSession().setAttribute("userid3", id);
				return index;
			}
			else
			{
				index="login";
				errorMsg="用户名或密码错误!";
				request.getSession().setAttribute("msg", errorMsg);
				return index;
			}
		}
		return index;
	}
	
	public boolean isCompare(String username,String password,String role)
	{
		int id=Integer.parseInt(username);
		if(role.equals("1"))//顾客判定
		{
			TableinfoDAO tableDAO=new TableinfoDAO();
			Tableinfo idtable=tableDAO.findById(id);
			if(idtable!=null)
				return true;
			else
				return false;
			
		}
		else if(role.equals("2"))//管理员判定
		{
			AdmininfoDAO adminDAO=new AdmininfoDAO();
			Admininfo idadmin=adminDAO.findById(id);
			if(idadmin==null)
				return false;
			if(idadmin.getAdminPassword().equals(password))
				return true;
			else
				return false;
		}
		else if(role.equals("3"))//服务员判定
		{
			WaiterinfoDAO waiterDAO=new WaiterinfoDAO();
			Waiterinfo idwaiter=waiterDAO.findById(id);
			if(idwaiter==null)
				return false;
			if(idwaiter.getWaiterPassword().equals(password))
				return true;
			else
				return false;
		}
		else if(role.equals("4"))//后厨判定
		{
			CheifinfoDAO chefDAO=new CheifinfoDAO();
			Cheifinfo idchef=chefDAO.findById(id);
			if(idchef==null)
				return false;
			if(idchef.getCheifPassword().equals(password))
				return true;
			else
				return false;
		}
		return false;
	}
}