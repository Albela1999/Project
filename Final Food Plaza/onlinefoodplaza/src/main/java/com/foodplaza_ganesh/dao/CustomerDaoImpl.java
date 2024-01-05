package com.foodplaza_ganesh.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.foodplaza_ganesh.pojo.CustomerList;
import com.foodplaza_ganesh.utility.DbUtility;
import com.mysql.cj.protocol.Resultset;

	public class CustomerDaoImpl implements CustomerDao {     
		  
		Connection con=DbUtility.getConnect();
		PreparedStatement ps;
		Resultset rs;
		int row;
		String sql;
		public boolean addCustomer(CustomerList customer) {
			sql="insert into  customers(name,email,password,address,contact) values(?,?,?,?,?)";
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1,customer.getName());
				ps.setString(2,customer.getEmail());
				ps.setString(3,customer.getPassword());
				ps.setString(4,customer.getAddress());
				ps.setString(5,customer.getContact());
				row=ps.executeUpdate();
				if(row>0)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
			
		}
		@Override
		public boolean updateCustomer(CustomerList customer) {
			try {
				sql="update customers set name=?,password=?,address=?,contact=? where email=?";
				ps=con.prepareStatement(sql);
				ps.setString(1,customer.getName());
				ps.setString(2,customer.getPassword());
				ps.setString(3,customer.getAddress());
				ps.setString(4,customer.getContact());
				ps.setString(5,customer.getEmail());
				row=ps.executeUpdate();
				if(row>0)
				{
					return true;
				}
				else 
				{
					return false;
				}
			}
				catch(SQLException e) {
					e.printStackTrace();
			}
			
			return false;
		}
		@Override
		public boolean deleteCustomer(String email) {
			try {
				sql="delete from customers where email=?";
				ps=con.prepareStatement(sql);
				ps.setString(1, email);
				row=ps.executeUpdate();
				if(row>0)
				{
					return true;
				}
				else {
					return false;
				}
				
				}catch(SQLException e) {
					e.printStackTrace();
				}
		
			
			return false;
		}
		@Override
		public CustomerList searchCust(String email) {
			CustomerList c=null;
			try {
				sql="select * from customers where email=?";
				ps=con.prepareStatement(sql);
				ps.setString(1, email);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					c=new CustomerList();
					c.setEmail(rs.getString("email"));
					c.setName(rs.getString("name"));
					c.setPassword(rs.getString("password"));
					c.setAddress(rs.getString("address"));
					c.setContact(rs.getString("contact"));
					
					
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
			return c;
		}
		@Override
		public List<CustomerList> getAllCust() {
			List<CustomerList> clist=new ArrayList<CustomerList>();
			try {
				sql="select * from customers";
				ps=con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					CustomerList c=new CustomerList();
					c.setEmail(rs.getString("email"));
					c.setName(rs.getString("name"));
					c.setPassword(rs.getString("password"));
					c.setAddress(rs.getString("address"));
					c.setContact(rs.getString("contact"));
					clist.add(c);
					
					
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		
			return clist;
		}
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		CustomerDaoImpl cdi=new CustomerDaoImpl();
		InputStreamReader str=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(str);
		String name,email,password,address,contact;
		System.err.println("1.Add customer 2.Update customer 3.Delete customer 4.Search Customer 5.Get all customers list");
		System.out.println("Enter the choice :");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Enter the customer name :");
			name=br.readLine();
			System.out.println("Enter the customer mail id :");
			email=sc.next();
			System.out.println("Enter the password:");
			password=sc.next();
			System.out.println("Enter the address :");
			address=br.readLine();
			System.out.println("Enter contact no :");
			contact=sc.next();
			CustomerList c=new CustomerList(name, email, password, address, contact);
			boolean b=cdi.addCustomer(c);
			if(b)
			{
				System.out.println("Customer added successfully");
			}
			else {
				System.out.println("Failed");
			}
			break;
			
		case 2:
			System.out.println("Enter the existing mail id :");
			email=sc.next();
			System.out.println("Enter the customer name :");
			name=br.readLine();
			System.out.println("Enter the password:");
			password=sc.next();
			System.out.println("Enter the address :");
			address=br.readLine();
			System.out.println("Enter contact no :");
			contact=sc.next();
			CustomerList c1=new CustomerList(name, email, password, address, contact);
			c1.setEmail(email);
			boolean b1=cdi.updateCustomer(c1);
			if(b1)
			{
				System.out.println("Customer updated successfully");
			}
			else
			{
				System.out.println("Failed");
			}
			break;
		case 3:
			System.out.println("Enter email to delete recod :");
			email=sc.next();
			boolean b2=cdi.deleteCustomer(email);
			if(b2)
			{
				System.out.println("Record deleted successfully");
			}
			else {
				System.out.println("Failed");
			}
			break;
			
		case 4:
			System.out.println("Enter email to search record :");
			email=sc.next();
			CustomerList c3=cdi.searchCust(email);
			if(c3 != null) {
				System.out.println(c3);
			}
			break;
			
		case 5:
			System.out.println("------All Records------");
			List<CustomerList> cl=cdi.getAllCust();
			if(cl!=null) {
				for(CustomerList c4:cl)
				{
					System.out.println(c4);
				}
			}
			break;
		
		default:
			System.out.println("Invalid Choice");
		}
		
	}
	


}
