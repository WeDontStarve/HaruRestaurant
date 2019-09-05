package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.*;

import com.chinasofti.controller.CreateOrder;
import com.hibernate.dao.Commentinfo;
import com.hibernate.dao.CommentinfoDAO;
import com.hibernate.dao.Orderinfo;
import com.hibernate.dao.Tableinfo;
import com.hibernate.dao.TableinfoDAO;
import com.json.CustomFeedbackJSON;
import com.json.OrderJSON;

public class CustomServlet extends HttpServlet {
	/**
	 * Constructor of the object.
	 */
	public CustomServlet() {
		super();
	}
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("application/json;charset=utf-8");
		if(request.getParameter("method").equals("feedback")){
			CustomFeedbackJSON customfb=new CustomFeedbackJSON();
			response.getWriter().write(customfb.commentJSON().toString());
		}
		else if(request.getParameter("method").equals("shop")){
			String shop=request.getParameter("myorder");
			shop = shop.replaceAll("\"", "");
			JSONArray jsonArray =	JSONArray.fromObject(shop);
			//System.out.println(jsonArray);
			String table_id=request.getParameter("table_id");
			CreateOrder order=new CreateOrder("123",table_id,jsonArray);
			
			TableinfoDAO tableDAO=new TableinfoDAO();
			Tableinfo table=tableDAO.findById(Integer.parseInt(table_id));
			table.setTableStatus(1);
			tableDAO.save(table);
			
			JSONObject object = new JSONObject();
			object.put("key", "success");
			response.getWriter().write(object.toString());
		}else if(request.getParameter("method").equals("feedback_delete")){
			String id=request.getParameter("comment");
			CommentinfoDAO commentDAO=new CommentinfoDAO();
			Commentinfo comment=commentDAO.findById(id);
			commentDAO.delete(comment);
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}
