package oop.labs.lab_6.zadanie_12;

import java.util.concurrent.ThreadLocalRandom;

class Consumer extends Thread {
    Buffer buffer;

    Consumer(Buffer buffer) {
        this.buffer = buffer;
        this.start();
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Consuming: " + buffer.get());
            int random = ThreadLocalRandom.current().nextInt(1, 4);
            try {
                Thread.sleep(random * 1000L);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
