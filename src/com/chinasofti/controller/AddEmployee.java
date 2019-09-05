package com.chinasofti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hibernate.dao.Waiterinfo;
import com.hibernate.dao.WaiterinfoDAO;
import com.hibernate.dao.Cheifinfo;
import com.hibernate.dao.CheifinfoDAO;

@Controller
public class AddEmployee {
	@RequestMapping("/addEmployee")
	public String addEmployee(@RequestParam("name")String name,@RequestParam("position")String position,@RequestParam("phone")String phone)
	{
		System.out.println("123");
		System.out.println(position);
		if(position.equals("服务员"))
		{
			Waiterinfo waiter=new Waiterinfo(name,"000000",null,phone);
			WaiterinfoDAO waiterDAO=new WaiterinfoDAO();
			waiterDAO.save(waiter);
		}
		else if(position.equals("后厨"))
		{
			Cheifinfo chef=new Cheifinfo(name,"000000",null,phone);
			CheifinfoDAO chefDAO=new CheifinfoDAO();
			chefDAO.save(chef);
		}
		
		return "StaffManagement";
	}

}
