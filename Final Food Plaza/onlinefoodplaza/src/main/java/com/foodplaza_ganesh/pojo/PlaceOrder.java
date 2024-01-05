package com.foodplaza_ganesh.pojo;

public class PlaceOrder {
	int id;
	String email,date,totalprice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}
	public PlaceOrder(String email, String date, String totalprice) {
		super();
		this.email = email;
		this.date = date;
		this.totalprice = totalprice;
	}
	
	@Override
	public String toString() {
		return "PlaceOrder [id=" + id + ", email=" + email + ", date=" + date + ", totalprice=" + totalprice + "]";
	}
	public PlaceOrder(){
		
	}

}
