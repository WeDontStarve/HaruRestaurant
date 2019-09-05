package com.json;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.hibernate.dao.*;
//json格式为
//{
//	id值1:{tableseat:"",tablestatus:""},
//	id值2:{tableseat:"",tablestatus:""},
//	.....
//}
public class TableInfoJSON {
	private TableinfoDAO tableDAO=new TableinfoDAO(); 
	
//	//封装成二层json
//	public JSONObject infoToJSON(){
//		JSONObject tableJson=new JSONObject();
//		
//		List idList=tableDAO.findAllId();
//		int listSize=idList.size();
//		
//		for(int i=0;i<listSize;i++){
//			Integer id=(Integer) idList.get(i);
//			JSONObject index=this.createJSONById(id);
//			tableJson.put(id.toString(),index);
//		}
//		return tableJson;
//	}
	
	public JSONArray tableJSON(){
		JSONArray tableArray=new JSONArray();
		List<Tableinfo> tableList=tableDAO.findAll();
		java.util.Iterator<Tableinfo> itr=tableList.iterator();
		while(itr.hasNext()){
			JSONObject tableJson=new JSONObject();
			Tableinfo table=itr.next();
			
			tableJson.put("tableId", table.getTableId());
			tableJson.put("tableSeat", table.getTableSeat());
			tableJson.put("tableStatus",table.getTableStatus());
			tableArray.add(tableJson);
		}
		return tableArray;
	}
	
	public JSONObject createJSONById(java.lang.Integer id){
		JSONObject jsonById=new JSONObject();
		//JSONObject idToJSON=new JSONObject();
		JSONObject statusToJSON=new JSONObject();
		Tableinfo table=tableDAO.findById(id);
		statusToJSON.put("tableId", table.getTableId());
		statusToJSON.put("tableSeat", table.getTableSeat());
		statusToJSON.put("tableStatus",table.getTableStatus());
		//jsonById.put(id.toString(),statusToJSON);
		//return jsonById;
		return statusToJSON;
	}
}
