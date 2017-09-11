package com.json;
import java.util.List;

import org.json.simple.JSONObject;
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

import com.DAO.*;
public class EmployeeInfoJSON {
	private WaiterDAO waiterDAO=new WaiterDAO();
	private CheifinfoDAO cheifDAO=new CheifinfoDAO();
	
	public JSONObject EmployeeJSON(){
		JSONObject employeeJson=new JSONObject();
		
		employeeJson.put("waiter", this.WaiterInfoJSON());
		employeeJson.put("cheif", this.CheifInfoJSON());
		
		return employeeJson;
	}
	public JSONObject WaiterInfoJSON(){
		JSONObject waiterJson=new JSONObject();
		
		List idList=waiterDAO.findAllId();
		int listSize=idList.size();
		
		for(int i=0;i<listSize;i++){
			Integer id=(Integer) idList.get(i);
			JSONObject index=this.createChiefJSONById(id);
			waiterJson.put(id.toString(),index);
		}
		return waiterJson;
	}
	
	public JSONObject CheifInfoJSON(){
		JSONObject cheifJson=new JSONObject();
		
		List idList=cheifDAO.findAllId();
		int listSize=idList.size();
		
		for(int i=0;i<listSize;i++){
			Integer id=(Integer) idList.get(i);
			JSONObject index=this.createChiefJSONById(id);
			cheifJson.put(id.toString(),index);
		}
		return cheifJson;
	}
	//单个waiter根据id查找，封装成json
	private JSONObject createWaiterJSONById(java.lang.Integer id){
		JSONObject jsonById=new JSONObject();
		JSONObject statusToJSON=new JSONObject();
		Waiter waiter=waiterDAO.findById(id);
		statusToJSON.put("name",waiter.getWaiterAccount());
		statusToJSON.put("img",waiter.getWaiterFaceing());
		statusToJSON.put("phone",waiter.getWaiterPhone());
		statusToJSON.put("salary", waiter.getWaiterSalary());
		statusToJSON.put("bonus",waiter.getWaiterBonus());
		//jsonById.put(id.toString(),statusToJSON);
		//return jsonById;
		return statusToJSON;
	}
	//单个cheif根据id查找，封装成json
		private JSONObject createChiefJSONById(java.lang.Integer id){
			JSONObject jsonById=new JSONObject();
			JSONObject statusToJSON=new JSONObject();
			Cheifinfo cheif=new Cheifinfo();
			statusToJSON.put("name",cheif.getCheifAccount());
			statusToJSON.put("img",cheif.getCheifFaceing());
			statusToJSON.put("phone",cheif.getCheifPhone());
			statusToJSON.put("salary", cheif.getCheifSalary());
			statusToJSON.put("bonus",cheif.getCheifBonus());
			//jsonById.put(id.toString(),statusToJSON);
			//return jsonById;
			return statusToJSON;
		}
}
