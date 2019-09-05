package com.chinasofti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hibernate.dao.DishinfoDAO;
import com.hibernate.dao.Dishinfo;

@Controller
public class ModifyDish {
	String ekind;
	@RequestMapping("/modifyDish")
	public String modifyDish(@RequestParam("name")String name,@RequestParam("price")String price,@RequestParam("dis")String discript,@RequestParam("kind")String kind)
	{
		ekind="main";
		float fprice=Float.parseFloat(price);
		System.out.println(kind);
		DishinfoDAO dishDAO=new DishinfoDAO();
		List<Dishinfo> list=new ArrayList<Dishinfo>();
		list=dishDAO.findByDishName(name);
		if(!list.isEmpty())
		{
			Dishinfo dish=list.get(0);
			dish.setDishName(name);
			dish.setDishPrice(fprice);
			dish.setDishDiscript(discript);
			if(kind.equals("主食套餐"))
				ekind="main";
			else if(kind.equals("寿司刺身"))
				ekind="sushi";
			else if(kind.equals("甜品饮料"))
				ekind="dessert";
			dish.setClassification(ekind);
			dishDAO.save(dish);
		}
		else
			System.out.println("list is null");
		return "DishesManagement";
	}
}
