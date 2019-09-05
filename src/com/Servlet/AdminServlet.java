package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.hibernate.dao.Admininfo;
import com.hibernate.dao.AdmininfoDAO;
import com.hibernate.dao.Cheifinfo;
import com.hibernate.dao.CheifinfoDAO;
import com.hibernate.dao.Dishinfo;
import com.hibernate.dao.DishinfoDAO;
import com.hibernate.dao.Tableinfo;
import com.hibernate.dao.TableinfoDAO;
import com.hibernate.dao.Waiterinfo;
import com.hibernate.dao.WaiterinfoDAO;
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
					JSONArray dishJSON=dishinfo.dishJSON();
					response.getWriter().write(dishJSON.toString());
					//return;
				}
				else if(action.equals("change")){
					String id=request.getParameter("id");
					JSONObject dish_change=dishinfo.createJSONById(Integer.valueOf(id));
					response.getWriter().write(dish_change.toString());
					//return;
				}
				else if(action.equals("delete")){
					String id=request.getParameter("id");
					DishinfoDAO dishDAO=new DishinfoDAO();
					Dishinfo dish=dishDAO.findById(Integer.valueOf(id));
					dishDAO.delete(dish);
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
					else if(position.equals("chef")){
						JSONObject cheif_change=employeeinfo.createCheifJSONById(Integer.valueOf(id));
						response.getWriter().write(cheif_change.toString());
						//return;
					}
				}
				else if(action.equals("delete")){
					String position=request.getParameter("position");
					String id=request.getParameter("id");
					if(position.equals("waiter")){
						WaiterinfoDAO waiterDAO=new WaiterinfoDAO();
						Waiterinfo waiter=waiterDAO.findById(Integer.valueOf(id));
						waiterDAO.delete(waiter);
					}
					else if(position.equals("chef")){
						CheifinfoDAO cheifDAO=new CheifinfoDAO();
						Cheifinfo cheif=cheifDAO.findById(Integer.valueOf(id));
						cheifDAO.delete(cheif);
					}
				}
			}
			//座位管理
			else if(method.equals("seat")){
				TableInfoJSON tableinfo=new TableInfoJSON();
				if(action.equals("display")){
					//返回所有seat值
					JSONArray tableJSON=tableinfo.tableJSON();
					response.getWriter().write(tableJSON.toString());
					//return;
				}
				else if(action.equals("change")){
					String id=request.getParameter("id");
					JSONObject seat_change=tableinfo.createJSONById(Integer.valueOf(id));
					response.getWriter().write(seat_change.toString());
					//return;
				}
				else if(action.equals("delete")){
					String id=request.getParameter("id");
					TableinfoDAO tableDAO=new TableinfoDAO();
					Tableinfo table=tableDAO.findById(Integer.valueOf(id));
					tableDAO.delete(table);
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
