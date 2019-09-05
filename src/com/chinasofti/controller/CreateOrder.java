package com.chinasofti.controller;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;









import net.sf.json.JSONArray;



import net.sf.json.JSONObject;

import com.hibernate.dao.Dishinfo;
import com.hibernate.dao.DishinfoDAO;
import com.hibernate.dao.Orderdishes;
import com.hibernate.dao.OrderdishesDAO;
import com.hibernate.dao.OrderdishesId;
import com.hibernate.dao.Orderinfo;
import com.hibernate.dao.OrderinfoDAO;

public class CreateOrder {
	private Orderinfo orderinfo;
	private OrderinfoDAO orderinfoDAO=new OrderinfoDAO();
	private OrderdishesDAO orderdishDAO=new OrderdishesDAO();
	private DishinfoDAO dishDAO=new DishinfoDAO();
	public CreateOrder(String waiterid,String tableid,JSONArray dishjson){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(new Date()); 
		Timestamp ts = Timestamp.valueOf(time);
		orderinfo=new Orderinfo(ts,Integer.parseInt(waiterid),Integer.parseInt(tableid),0);
		orderinfoDAO.save(orderinfo);
		Integer order_id=orderinfo.getOrderId();
		System.out.print(order_id);
		Float totalPrice=(float) 0;
		for(int i=0;i<dishjson.size();i++){
			Orderdishes orderdish=new Orderdishes();
			JSONObject object=JSONObject.fromObject(dishjson.get(i));
			Integer dishid=Integer.parseInt(object.getString("dishId"));
			Integer num=Integer.parseInt(object.getString("num"));
			orderdish.setNum(num);
			orderdish.setState(0);
			orderdish.setOrderinfo(orderinfo);
			orderdish.setId(new OrderdishesId(orderinfo.getOrderId(),dishid));
			
			
			Dishinfo dish=dishDAO.findById(dishid);
			orderdish.setDishName(dish.getDishName());
			totalPrice+=dish.getDishPrice()*num;
			orderdishDAO.save(orderdish);
		}
		Orderinfo order2=orderinfoDAO.findById(order_id);
		order2.setTotalPrice(totalPrice);
		
		orderinfoDAO.save(order2);
		System.out.print(totalPrice);
	}
}
