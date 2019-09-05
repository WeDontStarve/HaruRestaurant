package com.chinasofti.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hibernate.dao.Information;
import com.hibernate.dao.InformationDAO;
import com.hibernate.dao.InformationId;
@Controller
public class PayBill {
	public String cusmsg;
	@RequestMapping("/paybill.action")
	public String needService(HttpServletRequest request,@RequestParam("id") String tableId)
	{
		InformationDAO informDAO=new InformationDAO();
		String announce=tableId+"号桌买单成功！";
		InformationId towaiter=new InformationId(announce,"manager");
		Information informwaiter=new Information();
		informwaiter.setId(towaiter);
		informDAO.save(informwaiter);
		
		cusmsg="买单成功！";
		request.getSession().setAttribute("cusmsg", cusmsg);
		return "custom_init";
	}

}
