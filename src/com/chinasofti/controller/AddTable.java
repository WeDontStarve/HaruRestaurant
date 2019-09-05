package com.chinasofti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hibernate.dao.TableinfoDAO;
import com.hibernate.dao.Tableinfo;

@Controller
public class AddTable {
	@RequestMapping("/addTable")
	public String addTable(@RequestParam("tableSeat")String seat)
	{
		int cseat=Integer.parseInt(seat);
		Tableinfo newtable=new Tableinfo(cseat,0);
		TableinfoDAO tableDAO=new TableinfoDAO();
		tableDAO.save(newtable);
		return "SeatInformation";
	}

}
