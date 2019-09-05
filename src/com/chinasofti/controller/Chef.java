package com.chinasofti.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hibernate.dao.Orderdishes;
import com.hibernate.dao.OrderdishesDAO;
import com.hibernate.dao.OrderdishesId;
import com.hibernate.dao.OrderinfoDAO;
import com.hibernate.dao.Orderinfo;
import com.hibernate.dao.Information;
import com.hibernate.dao.InformationDAO;
import com.hibernate.dao.InformationId;
import com.hibernate.dao.DishinfoDAO;
import com.hibernate.dao.Dishinfo;
@Controller
public class Chef {
	@RequestMapping("/Chef")
	public String Chef(@RequestParam("dish_name") String dishname,@RequestParam("dish_num") String dishnum,@RequestParam("order_id") String orderid,Model model){
		System.out.print (dishname+dishnum+orderid);
		
			InformationId inforId = new InformationId(orderid+"订单中"+ dishname+"可以上菜啦","waiter");
			Information infor = new Information(inforId);
			InformationDAO inforDAO = new InformationDAO();
			//session.clean();
			inforDAO.save(infor);
			//Dishinfo dish = findByDishName(dishname);
			DishinfoDAO dishDAO=new DishinfoDAO();
			//Dishinfo dish=dishDAO.findByDishName(dishname);
			List<Dishinfo> dishList=dishDAO.findByDishName(dishname);
			System.out.print(dishList.size());
			if(dishList.size()!=0){
			Dishinfo dish = dishList.get(0);
			int dishid;
			dishid=dish.getDishId();
			int oid=Integer.parseInt(orderid);
			OrderdishesDAO orderDAO=new OrderdishesDAO();
			
			OrderdishesId orderdishesid=new OrderdishesId(oid,dishid);
			Orderdishes orderdish=orderDAO.findById(orderdishesid);
			orderdish.setState(1);
			orderDAO.save(orderdish);
			}
			
			
			return "cook";
	}

}
