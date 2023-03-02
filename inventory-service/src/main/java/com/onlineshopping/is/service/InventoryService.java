package com.onlineshopping.is.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.onlineshopping.is.dto.InventoryResponse;
import com.onlineshopping.is.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

	private final InventoryRepository inventoryRepository;
	
	@Transactional
	public List<InventoryResponse> isInStock(List<String> skuCode) {
		return inventoryRepository.findBySkuCodeIn(skuCode).stream().map(inventory ->
			InventoryResponse.builder().skuCode(inventory.getSkuCode()).isInStock(inventory.getQuantity() > 0).build()).collect(Collectors.toList());
	}
}
