package com.MultiThreading.ExecutorFramework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulerDemo {

	public static void main(String[] args) {

		System.out.println("Main: Starting the Application...");

		// Create a pool with exactly 2 threads for scheduling tasks
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

		// ---------------------------------------------------------
		// METHOD 1: Run ONCE after a 3-second delay
		// ---------------------------------------------------------
		scheduler.schedule(() -> {
			System.out.println("⏰ [Delayed Task]: Executed exactly once after 3 seconds!");
		}, 3, TimeUnit.SECONDS);

		// ---------------------------------------------------------
		// METHOD 2: Run REPEATEDLY every 2 seconds
		// (Initial delay of 1 second before the first run)
		// ---------------------------------------------------------
		scheduler.scheduleAtFixedRate(() -> {
			System.out.println("🔄 [Fixed Rate Task]: Running every 2 seconds... "
					+ System.currentTimeMillis());

			// Simulating a quick task
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}

		}, 1, 2, TimeUnit.SECONDS);

		// Let the Main thread sleep for 10 seconds so we can watch the scheduler work,
		// otherwise the program will just end immediately!
		try {
			System.out.println("Main: Sleeping for 10 seconds to let the background jobs run...");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Shut down the scheduler so the Java program can finally exit
		System.out.println("Main: Shutting down the scheduler!");
		scheduler.shutdown();
	}
}
