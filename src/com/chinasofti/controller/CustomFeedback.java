package com.chinasofti.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hibernate.dao.Commentinfo;
import com.hibernate.dao.CommentinfoDAO;

@Controller
public class CustomFeedback {
	@RequestMapping("/feedback")
	public String CustomFeedback(@RequestParam("comment") String comment, Model model){
		//model.addAttribute("urgemessage", urgemess);
		System.out.print(comment);
		System.out.print("here");
		if(comment!=null){
			Commentinfo cominfo = new Commentinfo();
			System.out.print("suc");
			cominfo.setComment(comment);
			CommentinfoDAO cominfoDAO = new CommentinfoDAO();
			cominfoDAO.save(cominfo);
		}
			
		return "custom_feedback";
	}	

}
