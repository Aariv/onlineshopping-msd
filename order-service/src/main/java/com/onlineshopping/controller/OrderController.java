package com.onlineshopping.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineshopping.dto.OrderRequest;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@PostMapping
	public String placeOrder(@RequestBody OrderRequest orderRequest) {
		
		return "Order Placed Successfully";
	}
}
