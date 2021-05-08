package oop.lectures.lecture_5.ex_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        ExecutorService es = //Executors.newSingleThreadExecutor();
                Executors.newFixedThreadPool(10);

        es.submit(
                () -> {
                    for(int i = 0; i < 20; i++)
                        System.out.print('a');
                }
        );

        es.submit(
                () -> {
                    for(int i = 0; i < 20; i++)
                        System.out.print('b');
                }
        );

        es.shutdown();



    }
}
