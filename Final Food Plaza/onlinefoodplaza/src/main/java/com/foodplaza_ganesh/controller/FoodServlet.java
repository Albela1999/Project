package com.foodplaza_ganesh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.foodplaza_ganesh.dao.FoodPlazaDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.foodplaza_ganesh.pojo.*;

@WebServlet("/food")
public class FoodServlet extends HttpServlet {
	
	FoodPlazaDaoImpl fdi=new FoodPlazaDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
	{
		HttpSession session=req.getSession();
		String action=req.getParameter("action");
		if(action!=null && action.equals("delete"))
		{
			
			int id=Integer.parseInt(req.getParameter("id"));
			boolean b=fdi.deleteFood(id);
			if(b)
			{
				resp.sendRedirect("Success.jsp");
			}
			else
			{
				resp.sendRedirect("Failed.jsp");
			}
		}
			else
			{
				List<FoodPlaza> foodlist=fdi.getAllFood();
				session.setAttribute("flist", foodlist);
				if(foodlist!=null && !(foodlist.isEmpty()))
				{
					resp.sendRedirect("FoodList.jsp");
				}
				else
				{
					resp.sendRedirect("Failed.jsp");
				}
			}
	
			}
		
	protected void doPost(HttpServletRequest req,HttpServletResponse  resp) throws ServletException,IOException
	{
		PrintWriter out=resp.getWriter();
		String action=req.getParameter("action");
		
		if(action!=null && action.equals("addFood")) 
		{
			String name=req.getParameter("Name");
			
			String category=req.getParameter("Category");
			
			double price=Double.parseDouble(req.getParameter("Price"));
			
			String desc=req.getParameter("Description");
			
			String image=req.getParameter("Image");
			
			FoodPlaza foodplaza=new FoodPlaza( image, name, category, desc, price);
			boolean b=fdi.addFood(foodplaza);
			System.out.println(b);
			if(b)
			{
				resp.sendRedirect("Success.jsp");
			}
			else {
				
				resp.sendRedirect("Failed.jsp");
			}
			
			
		}
		else if(action!=null && action.equals("updateFood")) 
		{
			
			int foodId=Integer.parseInt(req.getParameter("Id"));
            String name=req.getParameter("Name");
			
			String category=req.getParameter("Category");
			
			double price=Double.parseDouble(req.getParameter("Price"));
			
			String desc=req.getParameter("Description");
			
			String image=req.getParameter("Image");
			
			FoodPlaza foodplaza=new FoodPlaza(image, name, category, desc, price);
			foodplaza.setId(foodId);
			boolean b=fdi.updateFood(foodplaza);
			if(b) 
			{
				resp.sendRedirect("Success.jsp");
			}
			else 
			{
				resp.sendRedirect("Failed.jsp");
			}
			
		}
		
		}
	

}
