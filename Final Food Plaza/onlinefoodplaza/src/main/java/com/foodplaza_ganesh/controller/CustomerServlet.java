package com.foodplaza_ganesh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.foodplaza_ganesh.dao.CustomerDaoImpl;
import com.foodplaza_ganesh.pojo.CustomerList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/customer")
public class CustomerServlet extends HttpServlet{
	CustomerDaoImpl cdi=new CustomerDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String action=req.getParameter("action");
		if(action!=null && action.equals("delete"))
		{
			String email=req.getParameter("email");
			boolean b=cdi.deleteCustomer(email);
			
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
					List<CustomerList> customerList=cdi.getAllCust();
					session.setAttribute("clist", customerList);
					if(customerList!=null && !(customerList.isEmpty()))
					{
						resp.sendRedirect("CustomerList.jsp");
					}
					else
					{
						resp.sendRedirect("Failed.jsp");
					}
				}
			
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String action=req.getParameter("action");
		if(action!=null && action.equals("addCustomer"))
		{
			String customername=req.getParameter("name");
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			String address=req.getParameter("address");
			String contact=req.getParameter("contact");
			
	        CustomerList customer=new CustomerList(customername, email, password, address, contact);
	        boolean b=cdi.addCustomer(customer);
	        if(b)
	        {
	        	resp.sendRedirect("Success.jsp");
	        }
	        else
	        {
	        	resp.sendRedirect("Failed.jsp");
	        }
		}
		else if(action!=null && action.equals("UpdateCustomer"))
		{
			String customername=req.getParameter("name");
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			String address=req.getParameter("address");
			String contact=req.getParameter("contact");
			
	        CustomerList customer1=new CustomerList(customername, email, password, address, contact);
            customer1.setEmail(email);
            boolean b=cdi.updateCustomer(customer1);
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
