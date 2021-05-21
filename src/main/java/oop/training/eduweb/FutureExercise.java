package oop.training.eduweb;

import java.util.concurrent.*;

public class FutureExercise {


    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        long start = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        UserService userService = new UserService(executorService);

        Future<String> userNameF = userService.getUserName(1L);
        String result = userNameF.get(10, TimeUnit.SECONDS);
        System.out.println(result);

        System.out.println("Duration: " + (System.currentTimeMillis() - start));
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }

}
