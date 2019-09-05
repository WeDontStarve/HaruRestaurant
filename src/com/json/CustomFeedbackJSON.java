package com.json;

import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.hibernate.dao.Commentinfo;
import com.hibernate.dao.CommentinfoDAO;

public class CustomFeedbackJSON {
	private Commentinfo comment=new Commentinfo();
	private CommentinfoDAO commentDAO=new CommentinfoDAO();
	
	public JSONArray commentJSON(){
		JSONArray commentArray=new JSONArray();
		List<Commentinfo> commentList=commentDAO.findAll();
		Iterator<Commentinfo> itr=commentList.iterator();
		while(itr.hasNext()){
			JSONObject json=new JSONObject();
			comment=itr.next();
			json.put("comment", comment.getComment());
			commentArray.add(json);
		}
		return commentArray;
	}
}
