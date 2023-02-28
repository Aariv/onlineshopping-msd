package com.onlineshopping.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.onlineshopping.dto.OrderLineItemsDto;
import com.onlineshopping.dto.OrderRequest;
import com.onlineshopping.model.Order;
import com.onlineshopping.model.OrderLineItems;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderService {

	private final OrderRepository orderRepository;

	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDto().stream()
				.map(orderItemDto -> mapToDto(orderItemDto)).collect(Collectors.toList());
		order.setOrderLineItemsList(orderLineItems);
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
