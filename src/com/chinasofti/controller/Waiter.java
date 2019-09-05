package com.chinasofti.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hibernate.dao.Information;
import com.hibernate.dao.InformationDAO;
import com.hibernate.dao.InformationId;
@Controller
public class Waiter {
	@RequestMapping("/urge")
	public String Waiter(@RequestParam("urgemessage") String urgemess, Model model){
		//model.addAttribute("urgemessage", urgemess);
		
		if(urgemess!=null){
			InformationId inforId = new InformationId(urgemess,"chef");
			Information infor = new Information();
			infor.setId(inforId);
			InformationDAO inforDAO = new InformationDAO();
			inforDAO.save(infor);
		}
			
		return "ser";
	}	
}
