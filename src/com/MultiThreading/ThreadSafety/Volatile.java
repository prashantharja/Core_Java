package com.MultiThreading.ThreadSafety;

public class Volatile {
	
	// BUG: Thread 1 might never see changes made to this by Thread 2
	// remove the volatile keyword and see the effect, program never terminates
    private static volatile boolean stopFlag = false;

    public static void main(String[] args) throws InterruptedException {
        
        Thread t1 = new Thread(() -> {
            int i = 0;
            // Thread 1 caches stopFlag as 'false' and loops forever
            while (!stopFlag) {
                i++; 
            }
            System.out.println("Thread 1 stopped. Count: " + i);
        });

        t1.start();
        
        Thread.sleep(1000); // Let Thread 1 spin for 1 second
        
        System.out.println("Main: Setting stopFlag to true!");
        stopFlag = true; // Main thread updates it
    }
}
