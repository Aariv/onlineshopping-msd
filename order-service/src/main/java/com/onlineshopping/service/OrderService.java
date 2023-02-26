package com.onlineshopping.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.onlineshopping.dto.OrderRequest;
import com.onlineshopping.model.Order;

@Service
public class OrderService {

	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		
	}
}
