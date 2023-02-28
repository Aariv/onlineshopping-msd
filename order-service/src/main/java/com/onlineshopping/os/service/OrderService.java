package com.onlineshopping.os.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.onlineshopping.os.dto.OrderLineItemsDto;
import com.onlineshopping.os.dto.OrderRequest;
import com.onlineshopping.os.model.Order;
import com.onlineshopping.os.model.OrderLineItems;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderService {

	private final OrderRepository orderRepository;
	
	private final WebClient webClient;

	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDto().stream()
				.map(orderItemDto -> mapToDto(orderItemDto)).collect(Collectors.toList());
		order.setOrderLineItemsList(orderLineItems);
		
		// Call inventory service
		webClient.get("http://localhost:8083/api/inventories")
		
		orderRepository.save(order);
		log.info("Order is saved {}", order.getId());
	}

	private OrderLineItems mapToDto(OrderLineItemsDto orderItemDto) {
		OrderLineItems item = new OrderLineItems();
		item.setSkuCode(orderItemDto.getSkuCode());
		item.setPrice(orderItemDto.getPrice());
		item.setQuanitity(orderItemDto.getQuanitity());
		return item;
	}
}
