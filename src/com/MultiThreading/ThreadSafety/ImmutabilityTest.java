package com.MultiThreading.ThreadSafety;

import java.util.ArrayList;
import java.util.List;

public class ImmutabilityTest {
	public static void main(String[] args) {

		// 1. Original data
		List<String> mySkills = new ArrayList<>();
		mySkills.add("Java");
		mySkills.add("Spring Boot");

		// 2. Create the Immutable object
		ImmutableEmployeeProfile profile = new ImmutableEmployeeProfile("Prashanth", mySkills);

		// 3. Malicious Thread tries to break it (Rule #1: Defensive Copy In test)
		mySkills.add("Hacking"); // Modifying the original list passed to the constructor
		System.out.println("Maliciously added to original list.");

		// 4. Another Thread tries to break it (Rule #2: Defensive Copy Out test)
		try {
			profile.getSkills().add("Python"); // Trying to modify the returned list
		} catch (UnsupportedOperationException e) {
			System.out.println("Blocked attempt to modify the returned list!");
		}

		// 5. Verify the Immutable object remained perfectly safe
		System.out.println("\nFinal Profile Skills for " + profile.getName() + ":");
		System.out.println(profile.getSkills());
		// OUTPUT: [Java, Spring Boot]
		// (No "Hacking" and no "Python"!)
	}
}