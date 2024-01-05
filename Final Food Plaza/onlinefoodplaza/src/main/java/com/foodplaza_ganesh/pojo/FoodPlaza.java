package com.foodplaza_ganesh.pojo;

public class FoodPlaza {
	private int id;
	String image,name,category,description;
	double price;
	public FoodPlaza( String image, String name, String category, String description, double price) {
		super();
		
		this.image = image;
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "FoodPlaza [id=" + id + ", image=" + image + ", name=" + name + ", category=" + category
				+ ", description=" + description + ", price=" + price + "]";
	}
	
	public FoodPlaza() {
		
		
	}
	

}
