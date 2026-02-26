package com.MultiThreading.ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedPoolDemo {
	public static void main(String[] args) {
		// Starts with 0 threads, grows infinitely as needed
		ExecutorService executor = Executors.newCachedThreadPool();

		System.out.println("Submitting 5 tasks simultaneously to a Cached Pool...");

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