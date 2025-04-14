package com.thread.numbers.three;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrinterUsingLock implements Runnable {

    private final int threadId;  // Each thread has a unique ID: 1, 2, or 3
    private final int end;       // The last number we want to print

    private static int currentNumber = 1;  // Shared number across all threads

    // ReentrantLock allows fine-grained control over locking
    private static final Lock lock = new ReentrantLock();

    // Condition is used for waiting and notifying threads (like wait/notify)
    private static final Condition condition = lock.newCondition();

    // Constructor to set thread ID and end number
    public PrinterUsingLock(int threadId, int end) {
        this.threadId = threadId;
        this.end = end;
    }

    @Override
    public void run() {
        while (true) {  // Keep looping until we manually break
            lock.lock();  // Only one thread can enter this block at a time
            try {
                // Stop if we've printed enough numbers
                if (currentNumber > end) {
                    break;  // Exit the loop and end the thread
                }

                // Check if it's this thread's turn to print
                if (currentNumber % 3 == threadId % 3) {
                    // If yes, print the number
                    System.out.println("Thread " + threadId + ": " + currentNumber);
                    currentNumber++;  // Move to the next number
                    condition.signalAll();  // Wake up all waiting threads
                } else {
                    // If not this thread's turn, wait until someone calls signal
                    try {
                        condition.await();  // Puts the thread to sleep
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();  // Reset the interrupted status
                    }
                }
            } finally {
                lock.unlock();  // Always release the lock (even if exception occurs)
            }
        }
    }
}