package com.foodplaza_ganesh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import com.foodplaza_ganesh.dao.LoginDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	
	LoginDaoImpl ldi=new LoginDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		session.invalidate();
		resp.sendRedirect("index.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	    String action=req.getParameter("action");
	    HttpSession session=req.getSession();
		String email=req.getParameter("EmailId");
		String password=req.getParameter("Password");
		String type=req.getParameter("type");
		if(action!=null && action.equals("login")) 
		{
		if(type.equals("User")) 
		{
			boolean b=ldi.userLogin(email, password);	
			if(b) 
			{
				session.setAttribute("custEmailId", email);
				resp.sendRedirect("index.jsp");
			}
			else 
			{
				resp.sendRedirect("Failed.jsp");
			}
		
		}
		if(type.equals("Admin")) 
		{
			boolean b=ldi.adminLogin(email, password);	
			if(b) 
			{
				session.setAttribute("adminEmailId", email);
				resp.sendRedirect("index.jsp");
			}
			else 
			{
				resp.sendRedirect("Failed.jsp");
			}
		
		}
		}
		
		else if(action!=null && action.equals("changepassword")) 
		{
			String newpassword=req.getParameter("newpass");
			
			if(type.equals("User")) 
			{
				boolean b=ldi.userChangePass(email, newpassword);
				if(b) 
				{
					resp.sendRedirect("Success.jsp");
				}
				else 
				{
					resp.sendRedirect("Failed.jsp");
				}
			}
			
			if(type.equals("Admin")) 
			{
				boolean b=ldi.adminChangePass(email, newpassword);
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
		
		
		
	

}
