package com.json;

import java.util.List;

import javassist.bytecode.Descriptor.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.hibernate.dao.*;

//json格式为
//{
//	id值1:{dishname:"",dishprice:"",dishimg:"",dishDis:"",recommend:""},
//	id值2:{dishname:"",dishprice:"",dishimg:"",dishDis:"",recommend:""},
//	.....
//}
public class DishInfoJSON {
	private DishinfoDAO dishinfoDAO=new DishinfoDAO();
	
	public JSONArray dishJSON(){
		JSONArray dishArray=new JSONArray();
		List<Dishinfo> dishList=dishinfoDAO.findAll();
		java.util.Iterator<Dishinfo> itr=dishList.iterator();
		while(itr.hasNext()){
			JSONObject dishJson=new JSONObject();
			Dishinfo dish=itr.next();
			dishJson.put("dishId", dish.getDishId());
			dishJson.put("dishName", dish.getDishName());
			dishJson.put("dishPrice",dish.getDishPrice());
			dishJson.put("dishImg", dish.getDishImg());
			dishJson.put("dishDis", dish.getDishDiscript());
			dishJson.put("classification", dish.getClassification());
			dishJson.put("recommend", dish.getRecommend());
			dishArray.add(dishJson);
		}
		return dishArray;
	}
	
//	public JSONObject infoToJSON(){
//		JSONObject dishJson=new JSONObject();
//		
//		List idList=dishinfoDAO.findAllId();
//		int listSize=idList.size();
//		
//		for(int i=0;i<listSize;i++){
//			Integer id=(Integer) idList.get(i);
//			JSONObject index=this.createJSONById(id);
//			dishJson.put(id.toString(),index);
//		}
//		return dishJson;
//	}
	
	
	//用id查询其他信息，并封装成json
	public JSONObject createJSONById(java.lang.Integer id){
		JSONObject jsonById=new JSONObject();
		//JSONObject idToJSON=new JSONObject();
		JSONObject statusToJSON=new JSONObject();
		Dishinfo dish=dishinfoDAO.findById(id);
		statusToJSON.put("dishId", id);
		statusToJSON.put("dishName", dish.getDishName());
		statusToJSON.put("dishPrice",dish.getDishPrice());
		statusToJSON.put("dishImg", dish.getDishImg());
		statusToJSON.put("dishDis", dish.getDishDiscript());
		statusToJSON.put("classification", dish.getClassification());
		statusToJSON.put("recommend", dish.getRecommend());
		//jsonById.put(id.toString(),statusToJSON);
		//return jsonById;
		return statusToJSON;
	}
}
