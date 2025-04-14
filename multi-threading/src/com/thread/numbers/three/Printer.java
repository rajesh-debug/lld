package com.thread.numbers.three;

public class Printer implements Runnable {

    private final int threadId;  // The unique identifier for each thread (1, 2, or 3)
    private final int end;       // The end number up to which we need to print
    private static int currentNumber = 1;  // Shared counter for printing numbers
    private static final Object lock = new Object();  // Lock object for thread synchronization

    public Printer(int threadId, int end) {
        this.threadId = threadId;
        this.end = end;
    }

    @Override
    public void run() {
        while (currentNumber <= end) {
            synchronized (lock) {
                // Only proceed if it's this thread's turn
                if (threadId % 3 == currentNumber % 3) {
                    System.out.println("Thread " + threadId + ": " + currentNumber);
                    currentNumber++;  // Increment the shared counter
                    lock.notifyAll();  // Notify all other threads to check if it's their turn
                } else {
                    try {
                        lock.wait();  // Wait for the other threads to complete their turn
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();  // Proper thread interruption handling
                    }
                }
            }
        }
    }
}
