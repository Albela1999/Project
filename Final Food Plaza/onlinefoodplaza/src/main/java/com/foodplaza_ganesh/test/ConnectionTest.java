package com.foodplaza_ganesh.test;

import com.foodplaza_ganesh.utility.DbUtility;

import java.sql.Connection;

public class ConnectionTest {
	public static void main(String[] args) {
		Connection con=DbUtility.getConnect();
		if(con!=null)
		{
			System.out.println("Connection Successful");
		}
		else
		{
			System.out.println("Connection failed");
		}
	}

}
