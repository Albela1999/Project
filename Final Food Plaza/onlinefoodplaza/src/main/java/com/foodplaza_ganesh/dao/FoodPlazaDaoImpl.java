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

import com.foodplaza_ganesh.pojo.FoodPlaza;
import com.foodplaza_ganesh.utility.DbUtility;

public class FoodPlazaDaoImpl implements FoodPlazaDao {
	Connection con=DbUtility.getConnect();
	PreparedStatement ps;
	ResultSet rs;
	int row;
	String sql;
	

	public boolean addFood(FoodPlaza f) {
		sql="insert into  fooddetails(name,category,price,description,image) values (?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,f.getName());
			ps.setString(2,f.getCategory());
			ps.setDouble(3,f.getPrice());
			ps.setString(4,f.getDescription());
			ps.setString(5,f.getImage());
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
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean updateFood(FoodPlaza f) {
		try {
			sql="update fooddetails set name=?,category=?,price=?,description=?,image=? where id=? ";
			ps=con.prepareStatement(sql);
			ps.setString(1,f.getName());
			ps.setString(2,f.getCategory());
			ps.setDouble(3,f.getPrice());
			ps.setString(4,f.getDescription());
			ps.setString(5,f.getImage());
			ps.setInt(6,f.getId());
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
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean deleteFood(int id) {
		try {
			sql="delete from fooddetails where id=?";
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
		}catch(SQLException e)
		{
			e.printStackTrace();
			
		}
		
		return false;
	}

	public FoodPlaza searchFoodById(int id) {
		FoodPlaza f=null;
		try {
			sql="select * from fooddetails where id=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
			f=new FoodPlaza();
			f.setId(rs.getInt("id"));
			f.setName(rs.getString("name"));
			f.setCategory(rs.getString("category"));
			f.setPrice(rs.getDouble("price"));
			f.setDescription(rs.getString("description"));
			f.setImage(rs.getString("image"));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return f;
	}

	public List<FoodPlaza> getAllFood() {
		List<FoodPlaza> flist=new ArrayList<FoodPlaza>();
		try {
			sql="select * from fooddetails";
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				FoodPlaza f=new FoodPlaza();
				f.setId(rs.getInt("id"));
				f.setName(rs.getString("name"));
				f.setCategory(rs.getString("category"));
				f.setPrice(rs.getDouble("price"));
				f.setDescription(rs.getString("description"));
				f.setImage(rs.getString("image"));
				flist.add(f);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return flist;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		FoodPlazaDaoImpl fdi=new FoodPlazaDaoImpl();
		InputStreamReader str=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(str);
		int id;
		String name,category,description,image;
		double price;
		System.out.println("1.Add food 2.Update food 3.Delete Food 4.Search Food 5.Get Menu");
		System.out.println("Enter the choice ");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Enter food id :");
			id=sc.nextInt();
			System.out.println("Enter name of food :");
			name=br.readLine();
			System.out.println("Enter category :");
			category=br.readLine();
			System.out.println("Enter price :");
			price=sc.nextDouble();
			System.out.println("Enter description :");
			description=br.readLine();
			System.out.println("Enter image :");
			image=sc.next();
			FoodPlaza f1=new FoodPlaza(image, name, category, description, price);
			boolean b=fdi.addFood(f1);
			if(b)
			{
				System.out.println("Food added successfully");
			}
			else {
				System.out.println("Failed");
			}
			break;
			
		case 2:
			System.out.println("Enter existing id to update food :");
			id=sc.nextInt();
			System.out.println("Enter name of food :");
			name=br.readLine();
			System.out.println("Enter category :");
			category=br.readLine();
			System.out.println("Enter price :");
			price=sc.nextDouble();
			System.out.println("Enter description :");
			description=br.readLine();
			System.out.println("Enter image :");
			image=sc.next();
			FoodPlaza f2=new FoodPlaza(image, name, category, description, price);
			f2.setId(id);
			boolean b1=fdi.updateFood(f2);
			if(b1)
			{
				System.out.println("------Food updated Successfully------");
			}
			else
			{
				System.out.println("Failed");
			}
			break;
			
		case 3:
			System.out.println("Enter id to delete food :");
			id=sc.nextInt();
			boolean b2=fdi.deleteFood(id);
			if(b2)
			{
				System.out.println("-----Food deleted successfully------");
			}
			else {
				System.out.println("Failed");
			}
			break;
			
		case 4:
			System.out.println("Enter id to search record :");
			id=sc.nextInt();
			FoodPlaza f3=fdi.searchFoodById(id);
			if(f3!=null)
			{
				System.out.println(f3);
			}
			break;
		case 5:
			System.out.println("----All Records-----");
			List<FoodPlaza> flList=fdi.getAllFood();
			if(flList != null)
			{
				for(FoodPlaza fp:flList)
				{
					System.out.println(fp);
				}
			}
			break;
		
	}
	}
	

}
