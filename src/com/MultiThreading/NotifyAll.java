package com.MultiThreading;

public class NotifyAll {

	public static void main(String[] args) throws InterruptedException {

		Kitchen kitchen = new Kitchen();

		for (int i = 1; i < 11; i++) {

			final int waiterId = i; // Example waiter ID

			new Thread(() -> {
				try {
					kitchen.serveFood(waiterId);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
		}

		Thread.sleep(2000);

		new Thread(() -> {
			try {
				kitchen.cookingMassiveBatch();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

}
