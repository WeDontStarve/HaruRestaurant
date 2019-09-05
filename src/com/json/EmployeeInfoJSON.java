package com.json;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.hibernate.dao.*;
//{
//	waiter:{
//		id1:{name:"",img:"",phone:"",salary:"",bonus:""},
//		id2:{name:"",img:"",phone:"",salary:"",bonus:""},
//		......
//			},
//	cheif:{
//		id1:{name:"",img:"",phone:"",salary:"",bonus:""},
//		id2:{name:"",img:"",phone:"",salary:"",bonus:""},
//		......
//			}
//}

public class EmployeeInfoJSON {
	private WaiterinfoDAO waiterDAO=new WaiterinfoDAO();
	private CheifinfoDAO cheifDAO=new CheifinfoDAO();
	
	public JSONObject EmployeeJSON(){
		JSONObject employeeJson=new JSONObject();
		
		employeeJson.put("waiter", this.WaiterInfoJSON());
		employeeJson.put("chef", this.CheifInfoJSON());
		
		return employeeJson;
	}
	
	public JSONArray WaiterInfoJSON(){
		JSONArray waiterArray=new JSONArray();
		
		List waiterList=waiterDAO.findAll();
		Iterator<Waiterinfo> itr=waiterList.iterator();
		while(itr.hasNext()){
			JSONObject waiterJson=new JSONObject();
			Waiterinfo waiter=itr.next();
			waiterJson.put("id", waiter.getWaiterId());
			waiterJson.put("name",waiter.getWaiterAccount());
			waiterJson.put("img",waiter.getWaiterFaceing());
			waiterJson.put("phone",waiter.getWaiterPhone());
			waiterArray.add(waiterJson);
		}
		return waiterArray;
	}
	
	public JSONArray CheifInfoJSON(){
		JSONArray cheifArray=new JSONArray();
		
		List cheifList=cheifDAO.findAll();
		Iterator<Cheifinfo> itr=cheifList.iterator();
		while(itr.hasNext()){
			JSONObject cheifJson=new JSONObject();
			Cheifinfo cheif=itr.next();
			cheifJson.put("id",cheif.getCheifId());
			cheifJson.put("name",cheif.getCheifAccount());
			cheifJson.put("img",cheif.getCheifFaceing());
			cheifJson.put("phone",cheif.getCheifPhone());
			cheifArray.add(cheifJson);
		}
		return cheifArray;
	}
//	public JSONObject WaiterInfoJSON(){
//		JSONObject waiterJson=new JSONObject();
//		
//		List idList=waiterDAO.findAllId();
//		int listSize=idList.size();
//		
//		for(int i=0;i<listSize;i++){
//			Integer id=(Integer) idList.get(i);
//			JSONObject index=this.createWaiterJSONById(id);
//			waiterJson.put(id.toString(),index);
//		}
//		return waiterJson;
//	}
	
//	public JSONObject CheifInfoJSON(){
//		JSONObject cheifJson=new JSONObject();
//		
//		List idList=cheifDAO.findAllId();
//		int listSize=idList.size();
//		
//		for(int i=0;i<listSize;i++){
//			Integer id=(Integer) idList.get(i);
//			JSONObject index=this.createCheifJSONById(id);
//			cheifJson.put(id.toString(),index);
//		}
//		return cheifJson;
//	}
	//单个waiter根据id查找，封装成json
	public JSONObject createWaiterJSONById(java.lang.Integer id){
		JSONObject jsonById=new JSONObject();
		JSONObject statusToJSON=new JSONObject();
		Waiterinfo waiter=waiterDAO.findById(id);
		statusToJSON.put("id", waiter.getWaiterId());
		statusToJSON.put("name",waiter.getWaiterAccount());
		statusToJSON.put("img",waiter.getWaiterFaceing());
		statusToJSON.put("phone",waiter.getWaiterPhone());
		
		//jsonById.put(id.toString(),statusToJSON);
		//return jsonById;
		return statusToJSON;
	}
	//单个cheif根据id查找，封装成json
		public JSONObject createCheifJSONById(java.lang.Integer id){
			JSONObject jsonById=new JSONObject();
			JSONObject statusToJSON=new JSONObject();
			Cheifinfo cheif=cheifDAO.findById(id);
			statusToJSON.put("id", cheif.getCheifId());
			statusToJSON.put("name",cheif.getCheifAccount());
			statusToJSON.put("img",cheif.getCheifFaceing());
			statusToJSON.put("phone",cheif.getCheifPhone());
			
			//jsonById.put(id.toString(),statusToJSON);
			//return jsonById;
			return statusToJSON;
		}
}
