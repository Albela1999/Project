package com.foodplaza_ganesh.dao;

import java.util.List;

import com.foodplaza_ganesh.pojo.Cart;

public interface CartDao {
	boolean addCart(Cart c);
	List<Cart> getAllCart(String email);
	boolean deleteCart(int id);
	boolean clearCart(String email);

}
