package com.foodplaza_ganesh.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtility {
	public static Connection getConnect() {
		Connection con=null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodplaza","root","Albela@1999");
				
			}catch(Exception e)
			{
				e.printStackTrace();
				
			}
			return con;
		}


}
