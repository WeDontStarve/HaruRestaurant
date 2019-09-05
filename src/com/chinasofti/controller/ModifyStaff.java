package com.chinasofti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hibernate.dao.Waiterinfo;
import com.hibernate.dao.WaiterinfoDAO;
import com.hibernate.dao.CheifinfoDAO;
import com.hibernate.dao.Cheifinfo;


@Controller
public class ModifyStaff {
	@RequestMapping("/modifyStaff")
	public String modifyStaff(@RequestParam("name")String name,@RequestParam("phone")String phone,@RequestParam("position")String position)
	{
		if(position.equals("服务员"))
		{
			WaiterinfoDAO waiterDAO=new WaiterinfoDAO();
			List<Waiterinfo> waiterlist=waiterDAO.findByWaiterAccount(name);
			if(!waiterlist.isEmpty())
			{
				Waiterinfo waiter=waiterlist.get(0);
				waiter.setWaiterAccount(name);
				waiter.setWaiterPhone(phone);
				waiterDAO.save(waiter);
			}
		}
		else if(position.equals("后厨"))
		{
			CheifinfoDAO chefDAO=new CheifinfoDAO();
			List<Cheifinfo> cheflist=chefDAO.findByCheifAccount(name);
			if(!cheflist.isEmpty())
			{
				Cheifinfo chef=cheflist.get(0);
				chef.setCheifAccount(name);
				chef.setCheifPhone(phone);
				chefDAO.save(chef);
			}
			
		}
		return "StaffManagement";
	}
}
