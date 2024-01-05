package com.foodplaza_ganesh.dao;

public interface LoginDao {
	boolean userLogin(String email,String password);
	boolean userChangePass(String email,String newpassword);
	boolean adminLogin(String email,String password);
	boolean adminChangePass(String email,String newpassword);

}
