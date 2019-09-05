package com.chinasofti.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hibernate.dao.Information;
import com.hibernate.dao.InformationDAO;
import com.hibernate.dao.InformationId;

@Controller
public class AncetoCustomer {
	public String ancemsg;
	@RequestMapping("/toCustom")
	public String Announce(HttpServletRequest request,@RequestParam("announce")String announce)
	{
		InformationDAO informDAO=new InformationDAO();
		if(announce!=null &&!announce.equals(""))
		{
			InformationId tocustomer=new InformationId(announce,"custom");
			Information informCustomer=new Information();
			informCustomer.setId(tocustomer);
			informDAO.save(informCustomer);
			ancemsg="公告发布成功！";
			request.getSession().setAttribute("ancemsg", ancemsg);
		}
		else
		{
			ancemsg="公告发布失败！";
			request.getSession().setAttribute("ancemsg", ancemsg);	
		}
		return "Announce";
	}
	
}
