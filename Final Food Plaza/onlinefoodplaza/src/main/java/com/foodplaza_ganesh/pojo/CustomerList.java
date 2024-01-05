package com.foodplaza_ganesh.pojo;

public class CustomerList {
	 String name,email,password,address,contact;

	@Override
	public String toString() {
		return "CustomerList [name=" + name + ", email=" + email + ", password=" + password + ", address=" + address
				+ ", contact=" + contact + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public CustomerList(String name, String email, String password, String address, String contact) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.contact = contact;
	}
	public CustomerList() {
		
	}

}
