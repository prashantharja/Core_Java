package com.Collections;

import java.util.ArrayList;

public class ArrayListUtilities {

	public static void main(String[] args) {

		// String[] names = { "Alice", "Bob", "Charlie", "David", "Eve" };

		ArrayList<String> nameList = new ArrayList<>();

		nameList.add("Alice");
		nameList.add("Bob");
		nameList.add("Charlie");
		nameList.add("David");
		nameList.add("Eve");

		System.out.println("--- Original Array ---" + nameList);
		System.out.println("--- Original Array (Reversed) ---" + nameList.reversed());
		System.out.println("--- Original Array (To Upper case) ---" 
		+ nameList.stream().map(String::toUpperCase).toList());
		System.out.println("--- Original Array (To Lower case) ---" 
		+ nameList.stream().map(String::toLowerCase).toList());
		
		//remove names ending with 'e'
		System.out.println("--- Original Array (Remove names ending with 'e') ---" +
		nameList.stream().filter(name -> !name.endsWith("e")).toList());
		
		String strName = "Alice in the Wonderland";
		
	}

}
