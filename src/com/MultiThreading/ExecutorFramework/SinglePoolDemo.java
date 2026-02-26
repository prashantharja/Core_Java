package com.MultiThreading.ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SinglePoolDemo {
	public static void main(String[] args) {
		// Create exactly 1 thread
		ExecutorService executor = Executors.newSingleThreadExecutor();

		System.out.println("Submitting 5 tasks to a Single Thread Pool...");

		for (int i = 1; i <= 10; i++) {
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