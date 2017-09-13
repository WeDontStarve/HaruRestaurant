package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.json.*;
public class AdminServlet extends HttpServlet {
	
	
	   public AdminServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			response.setContentType("application/json;charset=utf-8");
			//解析ajax data字段的值，返回相应字符串
			String method=request.getParameter("method");
			String action=request.getParameter("action");
	
			//菜品管理
			if(method.equals("dish")){
				DishInfoJSON dishinfo=new DishInfoJSON();
				if(action.equals("display")){
					JSONObject dishJSON=dishinfo.infoToJSON();
					response.getWriter().write(dishJSON.toString());
					//return;
				}
				else if(action.equals("change")){
					String id=request.getParameter("id");
					JSONObject dish_change=dishinfo.createJSONById(Integer.valueOf(id));
					response.getWriter().write(dish_change.toString());
					//return;
				}
			}
			//员工管理
			else if(method.equals("employee")){
				EmployeeInfoJSON employeeinfo=new EmployeeInfoJSON();
				if(action.equals("display")){
					JSONObject emloyeeJSON=employeeinfo.EmployeeJSON();
					response.getWriter().write(emloyeeJSON.toString());
					//return;
				}
				else if(action.equals("change")){
					String position=request.getParameter("position");
					String id=request.getParameter("id");
					if(position.equals("waiter")){
						JSONObject waiter_change=employeeinfo.createWaiterJSONById(Integer.valueOf(id));
						response.getWriter().write(waiter_change.toString());
						//return;
					}
					else if(position.equals("cheif")){
						JSONObject cheif_change=employeeinfo.createCheifJSONById(Integer.valueOf(id));
						response.getWriter().write(cheif_change.toString());
						//return;
					}
				}
			}
			//座位管理
			else if(method.equals("seat")){
				TableInfoJSON tableinfo=new TableInfoJSON();
				if(action.equals("display")){
					//返回所有seat值
					JSONObject tableJSON=tableinfo.infoToJSON();
					response.getWriter().write(tableJSON.toString());
					//return;
				}
				else if(action.equals("change")){
					String id=request.getParameter("id");
					JSONObject seat_change=tableinfo.createJSONById(Integer.valueOf(id));
					response.getWriter().write(seat_change.toString());
					//return;
				}
			}
			
			
			//String s=request.getParameterNames().nextElement();//获取ajax data中的键
			//System.out.print(s);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

}
