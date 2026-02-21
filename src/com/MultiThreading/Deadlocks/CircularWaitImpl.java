package com.MultiThreading.Deadlocks;

public class CircularWaitImpl {

	public void safeTransfer(BankAccount fromAccount, BankAccount toAccount, double amount) {

		BankAccount firstLock, secondLock;

		if (fromAccount.accountId < toAccount.accountId) {

			firstLock = fromAccount;
			secondLock = toAccount;
		} else {
			firstLock = toAccount;
			secondLock = fromAccount;
		}

		synchronized (firstLock) {

			System.out.println("Locked first account: " + firstLock.accountId + " by thread " + Thread.currentThread().getName());

			try {
				Thread.sleep(1000); // Simulate some processing time
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			synchronized (secondLock) {
				System.out.println("Locked second account: " + secondLock.accountId + " by thread " + Thread.currentThread().getName());

				// Perform transfer logic here
				fromAccount.balance -= amount;
				toAccount.balance += amount;
				System.out.println("Transferred " + amount + " from account "
						+ fromAccount.accountId + " to account " + toAccount.accountId);

				System.out.println("New balance of account " + fromAccount.accountId + ": "
						+ fromAccount.balance);
				System.out.println(
						"New balance of account " + toAccount.accountId + ": " + toAccount.balance);
			}

		}

	}

	public static void main(String[] args) {

		CircularWaitImpl transferService = new CircularWaitImpl();

		BankAccount acc1 = new BankAccount(101, 1000);
		BankAccount acc2 = new BankAccount(205, 1000);

		Thread t1 = new Thread(() -> transferService.safeTransfer(acc1, acc2, 100));
		Thread t2 = new Thread(() -> transferService.safeTransfer(acc2, acc1, 100));

		t1.start();
		t2.start();

	}

}

class BankAccount {

	public int accountId = 0;
	public double balance;

	public BankAccount(int accountId, double balance) {

		this.accountId = accountId;
		this.balance = balance;
	}

}