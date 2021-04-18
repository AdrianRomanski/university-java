package oop.labs.lab_5;

public class Test {

    public static void main(String[] args) {


        long millisActualTime = System.currentTimeMillis();

        for(int i = 0; i < 10000; i++) {
            System.out.print("*");
        }

        System.out.println();

        long executionTime = System.currentTimeMillis() - millisActualTime;

        System.out.println(executionTime);


    }
}
