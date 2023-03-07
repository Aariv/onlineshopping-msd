package com.onlineshopping.is.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.onlineshopping.is.dto.InventoryResponse;
import com.onlineshopping.is.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

	private final InventoryRepository inventoryRepository;
	
	@Transactional
	@SneakyThrows // Only development
	public List<InventoryResponse> isInStock(List<String> skuCode) throws InterruptedException {
		log.info("Wait started");
		Thread.sleep(10000);
		log.info("Wait ended");
		return inventoryRepository.findBySkuCodeIn(skuCode).stream().map(inventory ->
			InventoryResponse.builder().skuCode(inventory.getSkuCode()).isInStock(inventory.getQuantity() > 0).build()).collect(Collectors.toList());
	}
}
