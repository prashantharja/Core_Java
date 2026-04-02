package com.MultiThreading;

public class ThreadJoins {

	public static void main(String[] args) throws InterruptedException {

		Thread worker = new Thread(() -> {
			try {
				System.out.println("Worker: I am cooking pasta (3 sec)...");
				Thread.sleep(5000); // 1. PAUSE
				System.out.println("Worker: Pasta is ready!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		worker.start();

		System.out.println("Main: I am waiting for food...");

		worker.join(); // 2. WAIT (Main thread freezes here until 'worker' dies)

		System.out.println("Main: Finally eating!");
	}

}
