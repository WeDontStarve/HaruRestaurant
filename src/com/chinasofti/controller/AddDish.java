package com.chinasofti.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hibernate.dao.Dishinfo;
import com.hibernate.dao.DishinfoDAO;

@Controller
public class AddDish
{
	public String ekind;
	@RequestMapping(value="/upload.action")
	public String AddDish(@RequestParam("name")String name,@RequestParam("dis")String discript,@RequestParam("price")String price,@RequestParam("kind")String kind,@RequestParam(value="file",required=false)MultipartFile file,HttpServletRequest request,ModelMap model)
	{
		//System.out.println("开始了");
		//String path=request.getSession().getServletContext().getRealPath("upload");
		//path=path.replaceAll("\\", "/");
		String path="C:\\apache-tomcat-8.5.20\\webapps\\upload";
		String fileName=file.getOriginalFilename();
		
		System.out.println(path);
		File target=new File(path,fileName);
		if(!target.exists())
		{
			target.mkdirs();
		}
		try
		{
			file.transferTo(target);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//String fileUrl="C:\\apache-tomcat-8.5.20\\webapps\\res\\upload\\"+fileName;
		String fileUrl="/upload/"+fileName;
		System.out.println(fileUrl);
			
		ekind="main";
		//System.out.println("run into");
		System.out.println(name);
			
		if(kind.equals("主食套餐"))
			ekind="main";
		else if(kind.equals("寿司刺身"))
			ekind="sushi";
		else if(kind.equals("甜品饮料"))
			ekind="dessert";
		Float fprice=Float.parseFloat(price);
		Dishinfo dish=new Dishinfo(name,discript,fileUrl,fprice,0,ekind);//recommend?
		DishinfoDAO dishDAO=new DishinfoDAO();
		dishDAO.save(dish);	
		
		return "DishesManagement";
	}
}
