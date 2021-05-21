package oop.labs.lab_6.zadanie_12;

import java.util.concurrent.ThreadLocalRandom;

class Producer implements Runnable {
    Buffer buffer;

    Producer(Buffer buffer) {
        this.buffer = buffer;
        new Thread(this).start();
    }

    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            int random = ThreadLocalRandom.current().nextInt(1, 4);
            int randomNumber = random * random * random * random * random;
            System.out.println("Production of randomNumber: " + randomNumber);
            buffer.put(randomNumber);
            try {
                Thread.sleep(random * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



