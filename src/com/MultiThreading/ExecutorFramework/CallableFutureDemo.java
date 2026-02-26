package com.MultiThreading.ExecutorFramework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureDemo {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(2);

		// 1. Create a Callable task (Notice we use Callable<Integer> instead of
		// Runnable)
		Callable<Integer> expensiveDatabaseQuery = () -> {
			System.out.println(Thread.currentThread().getName() + " is searching the database...");
			Thread.sleep(3000); // Simulating a 3-second query
			return 42; // The magic number retrieved from the DB!
		};

		System.out.println("Main: Submitting the query to the background...");

		// 2. Submit the task using .submit() instead of .execute()
		// We immediately get a Future (the receipt) back!
		Future<Integer> futureResult = executor.submit(expensiveDatabaseQuery);

		System.out.println("Main: I have the Future receipt. I can do other work now!" + futureResult);

		// Simulating the Main thread doing UI updates or other fast tasks
		System.out.println("Main: Doing other things... loading images, rendering UI...");

		try {
			// 3. Get the actual result
			// IMPORTANT: If the 3 seconds aren't up yet, the Main thread pauses right here.
			System.out.println("Main: Now I actually need the data. Calling future.get()...");

			Integer finalAnswer = futureResult.get();

			System.out.println(
					"Main: Got the answer from the background thread! It is: " + finalAnswer);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}
	}
}