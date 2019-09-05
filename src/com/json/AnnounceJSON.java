package com.json;

import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.hibernate.dao.Information;
import com.hibernate.dao.InformationDAO;
public class AnnounceJSON {
	InformationDAO informationDAO=new InformationDAO();
	public JSONArray announceJSON(){
		JSONArray announceJson=new JSONArray();
		List announceList=informationDAO.findAll();
		Iterator<Information> itr=announceList.iterator();
		while(itr.hasNext()){
			JSONObject json=new JSONObject();
			Information information=itr.next();
			json.put("position",information.getId().getPosition());
			json.put("announce", information.getId().getMessage());
			announceJson.add(json);
		}
		return announceJson;
	}
}
