package com.foodplaza_ganesh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.foodplaza_ganesh.dao.CartDaoImpl;
import com.foodplaza_ganesh.pojo.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	CartDaoImpl cdi=new CartDaoImpl();
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
	{
		
		  HttpSession session=req.getSession(); 
		  String action=(String) req.getParameter("action");
		  if(action!=null && action.equalsIgnoreCase("delete"))
		  {
			 int id=Integer.parseInt(req.getParameter("id")); 
			 boolean b =cdi.deleteCart(id);
			 if(b) {
				 resp.sendRedirect("Success.jsp");
			 }
			 else {
					 resp.sendRedirect("Failed.jsp");
			 }
		  }
		 else {
			 String customerEmailId=(String)session.getAttribute("custEmailId");

		     List<Cart> cartList = cdi.getAllCart(customerEmailId); // Change here
		  if(cartList!=null && !(cartList.isEmpty()))
		  {
			  session.setAttribute("clist", cartList);
			  resp.sendRedirect("cartList.jsp");
		  }
		  else {
			  resp.sendRedirect("Failed.jsp");
		  }
			 }
		  
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    PrintWriter out = resp.getWriter();

	    try {
	        int foodid = Integer.parseInt(req.getParameter("id"));
	        String foodname = req.getParameter("name");
	        String email = req.getParameter("email");
	        int quantity = Integer.parseInt(req.getParameter("quantity"));
	        double price = Double.parseDouble(req.getParameter("price"));

	        
	        double totalprice = quantity * price;

	        Cart cart = new Cart(foodid, quantity, foodname, email, price, totalprice);

	        boolean b = cdi.addCart(cart);

	        if (b) {
	            // Adjust the redirection based on your application flow
	            resp.sendRedirect("Success.jsp");
	        } else {
	            resp.sendRedirect("Failed.jsp");
	        }
	    } catch (NumberFormatException e) {
	        // Handle the case where parsing fails
	        resp.sendRedirect("Failed.jsp");
	    }
	}
}
