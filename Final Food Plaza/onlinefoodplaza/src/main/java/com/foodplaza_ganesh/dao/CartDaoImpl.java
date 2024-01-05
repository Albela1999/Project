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

import com.foodplaza_ganesh.pojo.Cart;
import com.foodplaza_ganesh.utility.DbUtility;

public class CartDaoImpl implements CartDao {
	Connection con=DbUtility.getConnect();
	PreparedStatement ps;
	ResultSet rs;
	int row;
	String sql;

	@Override
	public boolean addCart(Cart c) {
		sql="insert into cart(foodid,foodname,email,price,quantity,totalprice) values(?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,c.getFoodid());
			ps.setString(2,c.getFoodname());
			ps.setString(3,c.getEmail());
			ps.setDouble(4,c.getPrice());
			ps.setInt(5,c.getQuantity());
			ps.setDouble(6,c.getTotalprice());
			row=ps.executeUpdate();
			if(row>0)
			{
				return true;
			}
			else {
				return false;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	
		return false;
	}

	@Override
	public List<Cart> getAllCart(String email) {
		List<Cart> clist=new ArrayList<Cart>();
		try {
			sql="select * from cart where email=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Cart c=new Cart();
				c.setId(rs.getInt("id"));
				c.setFoodid(rs.getInt("foodid"));
				c.setFoodname(rs.getString("foodname"));
				c.setEmail(rs.getString("email"));
				c.setPrice(rs.getDouble("price"));
				c.setQuantity(rs.getInt("quantity"));
				c.setTotalprice(rs.getDouble("totalprice"));
				clist.add(c);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return clist;
	}

	@Override
	public boolean deleteCart(int id) {
		try {
			sql="delete from cart where id=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
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
	public boolean clearCart(String email) {
		try {
			sql="delete from cart where email=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			row=ps.executeUpdate();
				if(row>0) {
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
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		CartDaoImpl cdi=new CartDaoImpl();
		InputStreamReader str=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(str);
		int foodid,quantity;
		String foodname,email;
		double price,totalprice;
		System.out.println("1.Add To cart 2.Get Cart 3.Delete from Cart 4.Clear Cart");
		System.out.println("Enter your choice :");
		int choice=sc.nextInt();
		int id;
		switch(choice) {
		case 1:
		System.out.println("Enter the food id :");
		foodid=sc.nextInt();

		System.out.println("Enter the food name :");
		foodname=br.readLine();
		System.out.println("Enter email :");
		email=sc.next();
		System.out.println("Enter price");
		price=sc.nextDouble();
		System.out.println("Enter quantity :");
		quantity=sc.nextInt();
		System.out.println("Total cart value :");
		totalprice=sc.nextDouble();
		Cart c1=new Cart(foodid,quantity,foodname,email,price,totalprice);
		boolean b=cdi.addCart(c1);
		if(b)
		{
			System.out.println("Cart Added");
		}
		else
		{
			
			System.out.println("Failed");
		}
		
		break;
		case 2:
			System.out.println("Enter email to Get all cart :");
			email=sc.next();
			List<Cart> c=cdi.getAllCart(email);
			if(c!=null) {
				for(Cart c2:c) {
					System.out.println(c2);
				}
			}
			break;
			
		case 3:
			System.out.println("Enter the id to delete cart :");
			id=sc.nextInt();
			boolean b1=cdi.deleteCart(id);
			if(b1)
			{
				System.out.println("Cart deleted");
			}
			else {
				System.out.println("failed");
			}
			break;
			
		case 4:
			System.out.println("Enter email to clear cart :");
			email=sc.next();
			boolean b2=cdi.clearCart(email);
			if(b2) {
				System.out.println("Cart Clear");
			}
			else {
				System.out.println("Failed");
			}
	}
		}

}
