package oop.training.eduweb;

import java.util.concurrent.*;

public class ExecutorServiceExercise {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        long start = System.currentTimeMillis();

//        ExecutorService executorService = Executors.newFixedThreadPool(4, task -> {
//            Thread thread = new Thread();
//            thread.setDaemon(true);
//            return thread;
//        });

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        MailSender mailSender = new MailSender(executorService);
        Future<?> mail = mailSender.sendMail("mail");
        Object o = mail.get();
        System.out.println(o);

        System.out.println(System.currentTimeMillis() - start);
        System.out.println("Response to client");

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("End of main");
    }

    private static void shutdownWithAwait(ExecutorService pool) {
        pool.shutdown();
        try {
            if(!pool.awaitTermination(15, TimeUnit.SECONDS)) {
                pool.shutdownNow();
                if(!pool.awaitTermination(15, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ie) {
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

}
