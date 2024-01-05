package com.foodplaza_ganesh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.foodplaza_ganesh.utility.DbUtility;

public class LoginDaoImpl implements LoginDao {
	Connection con=DbUtility.getConnect();
	PreparedStatement ps;
	ResultSet rs;
	int row;
	String sql;

	public boolean userLogin(String email, String password) {
		try {
			sql="select * from customers where email=? and password=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next())
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


	public boolean userChangePass(String email, String newpassword) {
		sql="update customers set password=? where email=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(2, email);
			ps.setString(1, newpassword);
			row=ps.executeUpdate();
			if(row>0)
			{
				return true;
			}
			else 
			{
				return false;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

		
		return false;
	}

	
	public boolean adminLogin(String email, String password) {
		try {
			sql="select * from admin where email=? and password=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next())
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

	
	public boolean adminChangePass(String email, String newpassword) {
		sql="update admin set password=? where email=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(2, email);
			ps.setString(1, newpassword);
			row=ps.executeUpdate();
			if(row>0)
			{
				return true;
			}
			else 
			{
				return false;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

		
		return false;
	}
	

}
