package com.thread.numbers.three;


public class MainPrinterUsingLock {
    public static void main(String[] args) {
        int end = 1500;

        Thread t1 = new Thread(new PrinterUsingLock(1, end));
        Thread t2 = new Thread(new PrinterUsingLock(2, end));
        Thread t3 = new Thread(new PrinterUsingLock(3, end));

        t1.start();
        t2.start();
        t3.start();
    }
}

