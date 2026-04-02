package com.JavaReleases.Java8.Streams;

import java.util.List;

public class findAllUniqueItems {
	
	class Order {
		
		List<String> items;
		
		public Order(List<String> of) {
			this.items = of;
		}

		public void setItems(List<String> items) {
			this.items = items;
		}
		
		public List<String> getItems() {
			return items;
		}
		
	}

	public static void main(String[] args) {

		/*
		 * 
		 * Scenario: You have a List<Order>. Each Order contains a List<String> of item
		 * names.
		 * 
		 * Task: Get a single, comma-separated string of all unique items purchased
		 * across all orders
		 * 
		 */
		
		List<Order> orders = List.of(
				new findAllUniqueItems().new Order(List.of("Laptop", "Mouse", "Keyboard")),
				new findAllUniqueItems().new Order(List.of("Monitor", "Mouse", "USB Cable")),
				new findAllUniqueItems().new Order(List.of("Laptop", "Headphones"))
		);

		// Get all unique items across all orders
		String uniqueItems = orders.stream()
				.flatMap(order -> order.getItems().stream())
				.distinct()
				.reduce((a, b) -> a + "," + b)
				.orElse("");

		System.out.println("Unique items: " + uniqueItems);
	}
}