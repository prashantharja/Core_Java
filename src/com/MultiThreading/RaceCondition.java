package com.MultiThreading;

public class RaceCondition {

	public static void main(String[] args) throws InterruptedException {

		Counter counter = new Counter();
		Runnable task = () -> {

			for (int i = 0; i < 10000; i++) {
				counter.increment();
			}
		};

		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		;

		t1.setName("RaceThread-1");
		t1.start();
		
		t2.setName("RaceThread-2");
		t2.start();
		
		t1.join();
		
		t2.join();

		System.out.println("Final count: " + counter.getCount());
	}

}

class Counter {
	private int count = 0;

	public synchronized void increment() {
		System.out.println(Thread.currentThread().getName() + " is incrementing count...");
		count++;
	}

	public int getCount() {
		return count;
	}
}
