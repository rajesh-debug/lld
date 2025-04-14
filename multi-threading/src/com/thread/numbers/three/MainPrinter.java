package com.thread.numbers.three;

public class MainPrinter {

    public static void main(String[] args) {

        Thread p1 = new Thread(new Printer(1, 100));
        Thread p2 = new Thread(new Printer(2, 100));
        Thread p3 = new Thread(new Printer(3, 100));

        p1.start();
        p2.start();
        p3.start();
    }
}
