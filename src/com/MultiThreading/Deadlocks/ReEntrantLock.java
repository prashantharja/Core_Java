package com.MultiThreading.Deadlocks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLock {

	private static final ReentrantLock lock = new ReentrantLock();

	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {
			lock.lock();
			try {
				System.out.println("Thread 1 acquired lock");
				// Simulate some work
				Thread.sleep(5000);
				// Re-acquire the lock
				lock.lock();
				try {
					System.out.println("Thread 1 re-acquired lock");
				} finally {
					System.out.println("Thread 1 releasing lock");
					lock.unlock();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		});

		Thread t2 = new Thread(() -> {

			try {

				boolean acquired = lock.tryLock(2, TimeUnit.SECONDS);
				// Wait for a moment to ensure t1 has acquired the lock
				if (acquired) {
					try {
						System.out.println("Thread 2 acquired lock");
					} finally {
						System.out.println("Thread 2 releasing lock");
						lock.unlock();
					}
				} else {
					System.out.println(
							"Thread 2 could not acquire lock, it is held by another thread");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		t1.start();
		try {
			Thread.sleep(100); // Ensure t1 starts first
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t2.start();
	}
}