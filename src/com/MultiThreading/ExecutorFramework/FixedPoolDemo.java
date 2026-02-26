package com.MultiThreading.ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedPoolDemo {
	public static void main(String[] args) {
		// Create exactly 2 threads
		ExecutorService executor = Executors.newFixedThreadPool(2);

		System.out.println("Submitting 5 tasks to a Fixed Pool of 2 threads...");

		for (int i = 1; i <= 5; i++) {
			final int taskId = i;
			executor.execute(() -> {
				System.out.println(Thread.currentThread().getName() + " is running Task " + taskId);
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
			});
		}

		executor.shutdown();
	}
}
