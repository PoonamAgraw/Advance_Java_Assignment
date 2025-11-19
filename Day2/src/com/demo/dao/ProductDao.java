package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	boolean save(Product p);

	List<Product> displayAll();

	Product findById(int id);

	boolean updateById(int id, int qty, double price);

	boolean deleteById(int id);

	List<Product> sortByPrice();

	void closeConnection();

}
