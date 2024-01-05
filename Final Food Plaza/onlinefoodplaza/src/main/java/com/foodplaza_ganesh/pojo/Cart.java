package com.foodplaza_ganesh.pojo;

public class Cart {
	int id,foodid,quantity;
	String foodname,email;
	double price,totalprice;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFoodid() {
		return foodid;
	}
	public void setFoodid(int foodid) {
		this.foodid = foodid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public Cart(int foodid, int quantity, String foodname, String email, double price, double totalprice) {
		super();
		this.foodid = foodid;
		this.quantity = quantity;
		this.foodname = foodname;
		this.email = email;
		this.price = price;
		this.totalprice = totalprice;
	}
	public String toString() {
		return "Cart [id=" + id + ", foodid=" + foodid + ", quantity=" + quantity + ", foodname=" + foodname
				+ ", email=" + email + ", price=" + price + ", totalprice=" + totalprice + "]";
	}
	public Cart()
	{

}}
