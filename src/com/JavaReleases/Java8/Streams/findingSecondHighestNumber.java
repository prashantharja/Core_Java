package com.JavaReleases.Java8.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class findingSecondHighestNumber {

	public static void main(String[] args) {

		// Find the 2nd highest distinct number in the list
		List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 4, 7, 6, 2, 8, 5 );

		Integer secondHighest = numbers.stream()
				.distinct()
				.sorted(Comparator.reverseOrder())
				.skip(1)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Not enough distinct numbers"));
		
		System.out.println("The 2nd highest distinct number is: " + secondHighest);
	}

}
