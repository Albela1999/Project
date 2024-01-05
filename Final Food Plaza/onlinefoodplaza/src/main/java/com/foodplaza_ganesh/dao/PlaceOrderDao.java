package com.foodplaza_ganesh.dao;

import java.util.List;

import com.foodplaza_ganesh.pojo.PlaceOrder;

public interface PlaceOrderDao {
	PlaceOrder placeorder(String email);
	List<PlaceOrder> showorder();

}
