package com.onlineshopping.is;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.onlineshopping.is.model.Inventory;
import com.onlineshopping.is.repository.InventoryRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData(final InventoryRepository inventoryRepository) {
		return inv -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("iPhone 13");
			inventory.setQuantity(10);
			
			Inventory inventory2 = new Inventory();
			inventory.setSkuCode("One plus");
			inventory.setQuantity(10);
			
			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory2);
		};
	}
}
