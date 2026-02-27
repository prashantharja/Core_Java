package com.JavaReleases.Java9;

import java.util.*;

public class UnmodifiableList {
	
	public static void main(String[] args) {
		
		//Before Java 9
		List<String> list = new ArrayList<>();
		
		list.add("Java");
		list.add("Python");
		
		System.out.println("Before Java 9: " + list);
		
		list.add("C++");
		System.out.println("After adding C++: " + list);
		List<String> unmodifiableList = Collections.unmodifiableList(list);
		
		//unmodifiableList.add("JavaScript"); // This will throw UnsupportedOperationException
		
		//System.out.println("After adding JavaScript: " + unmodifiableList);
		
		//After Java 9
		List<String> finalLIst = List.of("Java", "Python");
		
		System.out.println("After Java 9: " + finalLIst);
		
	//	finalLIst.add("C++"); // This will throw UnsupportedOperationException
		
	//	System.out.println("After adding C++: in finalLIst " + finalLIst);
		
		
	}
		
}
