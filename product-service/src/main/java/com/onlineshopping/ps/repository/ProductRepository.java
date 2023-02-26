package com.onlineshopping.ps.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.onlineshopping.ps.model.Product;

@Component
public class ProductRepository {

	private List<Product> DB = new ArrayList<Product>();
	
	public ProductRepository() {
		DB.add(new Product(UUID.randomUUID().toString(), "iPhone 12", "iPhone 12", new BigDecimal(10000)));
	}
	
	public List<Product> findAll() {
		return DB;
	}

	public void save(Product product) {
		product.setId(new Random().toString());
		DB.add(product);
	}
}
