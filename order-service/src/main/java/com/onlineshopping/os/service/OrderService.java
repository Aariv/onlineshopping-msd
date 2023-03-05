package com.onlineshopping.os.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.onlineshopping.os.dto.InventoryResponse;
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

	private final WebClient.Builder webClientBuilder;

	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDto().stream()
				.map(orderItemDto -> mapToDto(orderItemDto)).collect(Collectors.toList());
		
		order.setOrderLineItemsList(orderLineItems);
		
		List<String> skuCodes = order.getOrderLineItemsList().stream().map(OrderLineItems::getSkuCode).collect(Collectors.toList());

		// Call inventory service block is for sync request
		InventoryResponse[] inventoryResponse = webClientBuilder.build().get()
				.uri("http://inventory-service/api/inventories",
						uriBuilder -> uriBuilder.queryParam("sku-code", skuCodes).build())
				.retrieve().bodyToMono(InventoryResponse[].class).block();

		boolean result = Arrays.stream(inventoryResponse).allMatch(InventoryResponse::isInStock);
		
		if (result) {
			orderRepository.save(order);
			log.info("Order is saved {}", order.getId());
		} else {
			throw new IllegalArgumentException("Product is not in the stock");
		}

	}

	private OrderLineItems mapToDto(OrderLineItemsDto orderItemDto) {
		OrderLineItems item = new OrderLineItems();
		item.setSkuCode(orderItemDto.getSkuCode());
		item.setPrice(orderItemDto.getPrice());
		item.setQuanitity(orderItemDto.getQuanitity());
		return item;
	}
}
