package com.MultiThreading;

public class RaceConditionSetPriority {

	public static void main(String[] args) throws InterruptedException {

		PriorityCounter raceCounter = new PriorityCounter();
		Runnable task = () -> {

			for (int i = 0; i < 10000; i++) {
				raceCounter.increment();
			}
		};

		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		;

		
		t1.setName("RaceThread-1");
		t1.setPriority(Thread.MIN_PRIORITY); // 1. LOW PRIORITY (t1 is less likely to run compared to t2)
		t1.start();

		t2.setName("RaceThread-2");
		t2.setPriority(Thread.MAX_PRIORITY); // 2. HIGH PRIORITY (t2 is more likely to run compared to t1)
		t2.start();

		t1.join();

		t2.join();

		System.out.println("Final count: " + raceCounter.getCount());
	}

}

class PriorityCounter {
	private int count = 0;

	public synchronized void increment() {
		System.out.println(Thread.currentThread().getName() + " is incrementing count...");
		count++;
	}

	public int getCount() {
		return count;
	}
}
