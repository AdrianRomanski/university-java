package oop.labs.lab_6.zadanie_12;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer(3);
        new Producer(buffer);
        new Consumer(buffer);
        Thread.sleep(15000);
        buffer.closeProduction();
        Thread.currentThread().interrupt();
    }
}

