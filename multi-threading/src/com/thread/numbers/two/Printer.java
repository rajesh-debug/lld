package com.thread.numbers.two;

enum Type {
    ODD, EVEN
}

public class Printer implements Runnable {

    private final int end;
    private final Type type;
    private static int number = 1; // shared counter
    private static final Object lock = new Object();

    public Printer(Type type, int end) {
        this.end = end;
        this.type = type;
    }

    @Override
    public void run() {
        while (number <= end) {
            synchronized (lock) {  // Entering synchronized block
                if ((this.type == Type.EVEN && number % 2 == 0) // to allow even
                        || (this.type == Type.ODD && number % 2 == 1) // to allow odd
                ) {
                    System.out.println(number);  // Print the current number
                    lock.notifyAll();  // Notify other threads that they can proceed
                    number++;  // Increment the shared number
                } else {
                    try {
                        lock.wait();  // Wait until it's the thread's turn
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
