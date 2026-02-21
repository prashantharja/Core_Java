package com.MultiThreading;

public class InterThreadCommunicatioWaitNotify {

	public static void main(String[] args) throws InterruptedException {

		Kitchen kitchen = new Kitchen();

		Thread waiterThread = new Thread(() -> {
			try {
				int waiterId = 1; // Example waiter ID
				kitchen.serveFood(waiterId);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		Thread cookThread = new Thread(() -> {
			try {
				kitchen.cookFood();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		waiterThread.start();
		Thread.sleep(5000);
		cookThread.start();

	}

}

class Kitchen {

	boolean isFoodReady = false;

	public synchronized void serveFood(int waiterId)
			throws InterruptedException {

		System.out.println(
				"Server-" + waiterId + ": Waiting for food to be ready...");

		while (!isFoodReady) {
			wait(); // 1. WAIT (Server thread freezes here until 'isFoodReady'
					// becomes true)
			System.out.println("Server-" + waiterId + " : Notified that food is ready!");
		}

		System.out.println("Server-" +waiterId + ": Serving food...");
	}

	public synchronized void cookFood() throws InterruptedException {

		System.out.println("Cook: Cooking food ...");
		isFoodReady = true;

		System.out.println("Cook: Food is ready! Notifying server...");
		notify(); // 2. NOTIFY (Cook thread wakes up one waiting thread, which
					// is the Server)
	}

	public synchronized void cookingMassiveBatch() throws InterruptedException {

		System.out.println("Cook: Cooking food ...");
		isFoodReady = true;

		System.out.println("Cook: Food is ready! Notifying server...");
		notifyAll(); // 3. NOTIFY ALL (Cook thread wakes up all waiting threads,
						// if there are multiple servers waiting)

	}
}
