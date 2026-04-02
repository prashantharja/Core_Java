package com.JavaReleases.Java14;

public class SwitchEnhancement {

	public static void main(String[] args) {

		// Before Java 14

		int dayOfWeek = 2;

		switch (dayOfWeek) {
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tuesday");
		case 3:
			System.out.println("Wednesday");
		case 4:
			System.out.println("Thursday");
		case 5:
			System.out.println("Friday");
		default:
			System.out.println("Weekend");
			break;
		}
		System.out.println("dayOfWeek " + dayOfWeek);

		// After Java 14
		/*
		 * //In the legacy switch, if you forgot to type the word break; at the end of a
		 * case, Java would silently keep executing the code in the next case below it.
		 * This is called a "fall-through" bug, and it has caused catastrophic issues in
		 * production systems because the compiler doesn't warn you about it.
		 * 
		 * The Benefit: By using the arrow syntax (->), Java 14 strictly executes only
		 * the code on the right side of the arrow. The concept of break; is completely
		 * eliminated. Fall-through bugs are now mathematically impossible.
		 */

		// Direct Assignment & Immutability (Cleanliness)
		/*
		 * In legacy Java, a switch was just a "Statement" (an action). It couldn't
		 * return a value. If you wanted to figure out a message based on a status, you
		 * had to declare a mutable (changeable) variable outside the switch, and then
		 * assign it inside the switch.
		 * 
		 * The Benefit: A Switch Expression actually evaluates to a single value. This
		 * means you can assign the result directly to a variable in one clean step. It
		 * allows you to use the final keyword, making your variables immutable and
		 * thread-safe!
		 */ System.out.println("\nAfter Java 14:");
		String dayName = switch (dayOfWeek) {
		case 1 -> "Monday";
		case 2 -> "Tuesday";
		case 3 -> "Wednesday";
		case 4 -> "Thursday";
		case 5 -> "Friday";
		default -> "Weekend!";
		};
		System.out.println("dayName: " + dayName);
	}
}
