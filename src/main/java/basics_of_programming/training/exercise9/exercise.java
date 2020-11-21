package basics_of_programming.training.exercise9;

import java.util.Random;

public class exercise {

    public static void main(String[] args) {

//        exercise1();
        exercise3();
    }

    static void exercise1() {
        Random random = new Random();
        int wrt = random.nextInt(11);

        System.out.println(wrt);

        if(wrt > 5) {
            System.out.println("int z przedziału <6, 10>");
        } else {
            System.out.println("int z przedziału <0, 5>");
        }
    }

    static void exercise2() {
        boolean stat;
        double val;

        stat = Math.random() > 0.5;

        if (stat) {
            val = 5.0;
        } else {
            val = 8.0;
        }
        System.out.println(val);
    }

    static void exercise3() {
        byte bajt = 12;

        String[] strings = new String[16];

        for(int i =0; i < 10; i++) {
            strings[i] = String.valueOf(i);
        }

        strings[10] = "A";
        strings[11] = "B";
        strings[12] = "C";
        strings[13] = "D";
        strings[14] = "E";
        strings[15] = "F";

        System.out.println("Liczba " + bajt + " w systemie heksadecymalnym to: " + strings[bajt]);
    }

    static void exercise4() {

    }

    static void exercise5() {

    }

    static void exercise6() {

    }

    static void exercise7() {

    }

    static void exercise8() {

    }
}
