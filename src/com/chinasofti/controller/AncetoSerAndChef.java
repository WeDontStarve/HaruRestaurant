package com.chinasofti.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hibernate.dao.Information;
import com.hibernate.dao.InformationDAO;
import com.hibernate.dao.InformationId;

@Controller
public class AncetoSerAndChef {
	public String ancemsg;
	@RequestMapping("/toSerAndChef")
	public String Announce(HttpServletRequest request,@RequestParam("serance")String serannounce,@RequestParam("chefance")String chefannounce)
	{
		ancemsg="公告发布失败！";
		InformationDAO informDAO=new InformationDAO();
		//System.out.println(announce);
		if(serannounce!=null && !serannounce.equals(""))
		{
			InformationId toSer=new InformationId(serannounce,"waiter");//对服务员
			Information informSer=new Information();
			informSer.setId(toSer);
			informDAO.save(informSer);
			ancemsg="公告发布成功！";
			request.getSession().setAttribute("ancemsg", ancemsg);
		}
		if(chefannounce!=null && !chefannounce.equals(""))
		{
			InformationId toChef=new InformationId(chefannounce,"chef");//对后厨
			Information informChef=new Information();
			informChef.setId(toChef);
			informDAO.save(informChef);
			ancemsg="公告发布成功！";
			request.getSession().setAttribute("ancemsg", ancemsg);
		}
		
		return "Announce";
	}
	
}
