package com.foodplaza_ganesh.dao;

import java.util.List;

import com.foodplaza_ganesh.pojo.FoodPlaza;

public interface FoodPlazaDao {
	boolean addFood(FoodPlaza f);
	boolean updateFood(FoodPlaza f);
	boolean deleteFood(int id);
	FoodPlaza searchFoodById(int id);
    List<FoodPlaza> getAllFood();

}
