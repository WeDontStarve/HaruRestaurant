package com.json;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.simple.*;

import com.hibernate.dao.*;

public class OrderJSON {
	private Orderinfo order;
	private OrderinfoDAO orderDAO=new OrderinfoDAO();
	
	public void getOrder(java.lang.Integer id){
		order=orderDAO.findById(id);
	}
	
	public JSONArray dishesJSON(){
		JSONArray dishArray=new JSONArray();
		Set<Orderdishes> dishSet=order.getOrderdisheses();
		System.out.print(dishSet.size());
		Iterator<Orderdishes> itr=dishSet.iterator();
		order.setOrderState(1);
		while(itr.hasNext()){
			JSONObject dishJson=new JSONObject();
			Orderdishes dish=(Orderdishes)itr.next();
			dishJson.put("dish_name", dish.getDishName());
			dishJson.put("num", dish.getNum());
			dishJson.put("state", dish.getState());
			if(dish.getState()==0)
				order.setOrderState(0);
				
			dishArray.add(dishJson);
		}
		orderDAO.save(order);
		return dishArray;
	}
	
	public JSONArray allOrderJSON(){
		JSONArray orderArray=new JSONArray();
		List<Orderinfo> orderList=orderDAO.findAll();
		Iterator<Orderinfo> itr=orderList.iterator();
		while(itr.hasNext()){
			JSONObject orderJson=new JSONObject();
			Orderinfo Order=itr.next();
			orderJson.put("order_id", Order.getOrderId());
			orderJson.put("table_id", Order.getTableId());
			orderJson.put("total_price",Order.getTotalPrice());
			orderJson.put("state", Order.getOrderState());
			if(Order.getOrderState()==0)
				orderArray.add(orderJson);
		}
		return orderArray;
	}
}
