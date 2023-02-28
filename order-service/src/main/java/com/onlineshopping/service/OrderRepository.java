package com.onlineshopping.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshopping.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
