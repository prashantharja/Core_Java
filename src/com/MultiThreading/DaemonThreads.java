package com.MultiThreading;

public class DaemonThreads {

	public static void main(String[] args) throws InterruptedException {

		Thread DaemonThread = new Thread(() -> {
			while (true) {
				System.out.println("DaemonThread is running...");
				try {
					Thread.sleep(4000);
					System.out.println("DaemonThread is still running wont get printed "
							+ "if main thread finishes before this sleep ends...");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread worker = new Thread(() -> {

			while (!Thread.currentThread().isInterrupted()) {
				try {
					System.out.println("Worker thread is doing some work...");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println("Worker thread was interrupted and is stopping...");
					Thread.currentThread().interrupt(); // Preserve the interrupt status

				}
			}
		});

		DaemonThread.setDaemon(true); // 1. SET AS DAEMON (This thread will run in the background and won't prevent
										// the JVM from exiting)
		DaemonThread.start();
		Thread.sleep(1000); // 2. MAIN THREAD SLEEPS (Main thread simulates doing some work for 1 seconds)

		worker.start();
		Thread.sleep(1000); // 3. MAIN THREAD SLEEPS (Main thread simulates doing some work for 1 seconds)
		worker.interrupt();

		Thread.sleep(500); // 4. MAIN THREAD SLEEPS (Main thread simulates doing some work for .5seconds)
		System.out.println("Main thread is doing some work and will finish now");

	}
}
