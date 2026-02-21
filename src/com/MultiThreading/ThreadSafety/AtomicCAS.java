package com.MultiThreading.ThreadSafety;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCAS {
	
	private static AtomicInteger counter = new AtomicInteger(0);
	private static int normalCounter = 0;
	

	public static void	main(String[] args) throws InterruptedException {

	Runnable task = new Thread(() -> {

		for (int i = 0; i < 10000; i++) {

			// Atomically increments the counter
			counter.incrementAndGet();

			// Not thread
			normalCounter++;
		}
	});
	
	Thread t1 = new Thread(task);
	Thread t2 = new Thread(task);
	
	t1.start();
	t2.start();
	
	t1.join();
	t2.join();
	
	System.out.println("Atomic Counter: " + counter.get());
	System.out.println("Normal Counter: " + normalCounter);
	

}}
