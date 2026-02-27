package com.JavaReleases.Java15;

public class TextBlocks {
	
	public static void main(String[] args) {
		
		//Before Java 15
		
		String jsonString = "{\n" +
				"    \"name\": \"John\",\n" +
				"    \"age\": 30,\n" +
				"    \"city\": \"New York\"\n" +
				"}";
		
		System.out.println("Before Java 15:\n" + jsonString);
		
		// After Java 15
				String jsonString2 = """
						{
							"name": "John",
							"age": 30,
							"city": "New York"
						}
						""";
				System.out.println("\nAfter Java 15:" + jsonString2);
	}
	
		
				
}
