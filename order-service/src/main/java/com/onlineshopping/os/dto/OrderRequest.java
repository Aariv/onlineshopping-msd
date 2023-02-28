package com.onlineshopping.os.dto;

import java.util.List;

import com.onlineshopping.os.model.OrderLineItems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

	private List<OrderLineItemsDto> orderLineItemsDto;
	
}
