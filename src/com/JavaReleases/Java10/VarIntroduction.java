package com.JavaReleases.Java10;

import java.util.*;

public class VarIntroduction {

	public static void main(String[] args) {
		
		//Before Java 10
		String message = "Hello, Java 10!";
		System.out.println(message);
		//After Java 10
		var greeting = "Hello, Java 10!";
		System.out.println(greeting);
		
		
		//	Before Java 10
		System.out.println("\nBefore Java 10:");
		Map<String, List<String>> userRoles = new HashMap<>();
		List<String> adminRoles = new ArrayList<>();
		adminRoles.add("READ");
		adminRoles.add("WRITE");
		userRoles.put("admin", adminRoles);
		
		userRoles.put("user", List.of("READ"));
		
		for (Map.Entry<String, List<String>> entry : userRoles.entrySet()) {
			String role = entry.getKey();
			List<String> permissions = entry.getValue();
			System.out.println(role + " has permissions: " + permissions);
		}
		
		//	After Java 10
		System.out.println("\nAfter Java 10 using var:");
		var userRoles2 = new HashMap<String, List<String>>();
		var adminRoles2 = new ArrayList<String>();
		adminRoles2.add("READ");
		adminRoles2.add("WRITE");
		userRoles2.put("admin", adminRoles2);
		
		userRoles2.put("user", List.of("READ"));
		
		for (var entry : userRoles2.entrySet()) {
			var role = entry.getKey();
			var permissions = entry.getValue();
			System.out.println(role + " has permissions: " + permissions);
		}
		
	}

}
