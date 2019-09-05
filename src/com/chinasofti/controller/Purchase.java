package com.chinasofti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Purchase {
	@RequestMapping("/purchase")
	public String purchase(@RequestParam("dish_name")String dish_name,@RequestParam("dish_num")String dish_num)
	{
		System.out.println("run into");
		System.out.println(dish_name);
		System.out.println(dish_num);
		return "custom";
	}
}
