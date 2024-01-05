package com.foodplaza_ganesh.controller;

import java.io.IOException;

import com.foodplaza_ganesh.dao.CartDaoImpl;
import com.foodplaza_ganesh.dao.PlaceOrderDaoImpl;
import com.foodplaza_ganesh.pojo.PlaceOrder;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/placeorder")
public class OrderServlet extends HttpServlet {
	PlaceOrderDaoImpl ord=new PlaceOrderDaoImpl();
	CartDaoImpl cd=new CartDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String customerEmailId=(String)session.getAttribute("custEmailId");
		PlaceOrder o=ord.placeorder(customerEmailId);
		if(o!=null)
		{
			boolean b=cd.clearCart(customerEmailId);
			if(b)
			{
				req.setAttribute("placeorder", o);
				RequestDispatcher rd=req.getRequestDispatcher("Bill.jsp");
				rd.forward(req, resp);
			}
			else
			{
				resp.sendRedirect("Failed.jsp");
			}
		}
	}

}
