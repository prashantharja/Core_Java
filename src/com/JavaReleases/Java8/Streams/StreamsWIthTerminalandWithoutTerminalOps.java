package com.JavaReleases.Java8.Streams;

import java.util.Arrays;
import java.util.List;

public class StreamsWIthTerminalandWithoutTerminalOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		// Stream without terminal operation
		numbers.stream()
		.filter(n -> {
			System.out.println("Filtering number: " + n);
			 if(n > 3) {
				 System.out.println(" current number is: " + n + 
						 " and is greater than 3");
				 return true;
			 }else {
				 return false; 
			 }
			 
		});
		
		
		// Stream with terminal operation
		long count = numbers.stream()
				.filter(n -> n % 2 == 0)
				.map(n -> n * 2)
				.count();
		
		System.out.println("Count of even numbers doubled: " + count);

	}

}
