package com.MultiThreading;

public class SynchronizedBlock {

	private int sharedCounter = 0;

	private final Object lock = new Object();

	Thread ReadWriterThread = new Thread(() -> {

		System.out.println("Mimicking a read operation... " + ""
				+ "value of sharedCounter: " + sharedCounter);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		synchronized (lock) {

			System.out.println("Mimicking write operation... "
					+ "incrementing sharedCounter");
			sharedCounter++;
			System.out.println(
					"Value of sharedCounter after increment: " + sharedCounter);

		}

	});

	public static void main(String[] args) {

		SynchronizedBlock synchronizedBlock = new SynchronizedBlock();
		synchronizedBlock.ReadWriterThread.start();
		
		

	}

}
