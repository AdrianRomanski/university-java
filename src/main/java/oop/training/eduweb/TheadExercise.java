package oop.training.eduweb;

public class TheadExercise {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("ThreadID: " + Thread.currentThread().getId());
        System.out.println("ThreadName: " + Thread.currentThread().getName());

        Thread thread = new Thread(() -> {
            System.out.println("ThreadID: " + Thread.currentThread().getId());
            System.out.println("ThreadName: " + Thread.currentThread().getName());
        });
        thread.start();

        Worker worker = new Worker();
        worker.start();

        Thread thread1 = new Thread(() -> {
            System.out.println("Start of: " + Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The end of: " + Thread.currentThread().getName());
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Tick");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted Exception");
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("The end of worker thread");
        });
        thread2.start();
        Thread.sleep(1000);
        thread2.interrupt();
        System.out.println("The end of main");


    }

    private static class Worker extends Thread {
        @Override
        public void run() {
            System.out.println("ThreadID: " + Thread.currentThread().getId());
            System.out.println("ThreadName: " + Thread.currentThread().getName());
        }
    }

}
