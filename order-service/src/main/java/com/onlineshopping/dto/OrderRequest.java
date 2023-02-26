package com.onlineshopping.dto;

import java.util.List;

import com.onlineshopping.model.OrderLineItems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

	private List<OrderLineItemsDto> orderLineItemsDto;
	
}
