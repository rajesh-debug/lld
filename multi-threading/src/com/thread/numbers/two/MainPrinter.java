package com.thread.numbers.two;

public class MainPrinter {

    public static void main(String[] args) {

        Thread odd = new Thread(new Printer(Type.ODD, 100));
        Thread even = new Thread(new Printer(Type.EVEN, 100));

        odd.start();
        even.start();
    }
}
