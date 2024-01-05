package com.foodplaza_ganesh.dao;

import java.util.List;

import com.foodplaza_ganesh.pojo.CustomerList;

public interface CustomerDao {
	boolean addCustomer(CustomerList customer);
	boolean updateCustomer(CustomerList customer);
	boolean deleteCustomer(String email);
	CustomerList searchCust(String email);
	List<CustomerList> getAllCust();

}
