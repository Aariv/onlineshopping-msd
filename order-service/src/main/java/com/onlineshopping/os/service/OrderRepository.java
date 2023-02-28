package com.onlineshopping.os.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshopping.os.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
