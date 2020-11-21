package basics_of_programming.training.exercise5;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class exercise {

    public static void main(String[] args) {

//        exercise1();
//        exercise2();
//        exercise3();
//        exercise4();
//        exercise5();
//        exercise6();
//        exercise7();
//        exercise8();
//
        exercise10();
    }


    static void exercise1() {
        for(int i = 0; i < 11; i++)
            System.out.println(i);
    }

    static void exercise2() {
        final int wrt = 4;
        for(int i = 0; i < 11; i++)
            System.out.println(i * wrt);
    }

    static void exercise3() {
//        int var = 2;
//        int var2 = 2;
//
//        while(var < 3) {
//            System.out.println("While Loop");
//            System.out.println(var);
//            var++;
//        }
//
//        do{
//            System.out.println("Do Loop");
//            System.out.println(var);
//        }
//        while(var2 < 3);
//        var2++;
//        System.out.println("While inside do");
    }



    static void exercise4() {
        double q = 1;
        double number = 1;

        for(int i = 0; i < 11; i++) {
            System.out.println(number / q);
            q*=2;
        }
    }

    static void exercise5() {
        final String fiveStars = "* * * * *";
        final String fourStars = " * * * * ";

        for(int i = 1; i < 11; i++) {
            if(i % 2 == 1) {
                System.out.println(fiveStars);
            } else {
                System.out.println(fourStars);
            }
        }
    }

    static void exercise6() {
        final int size = 25;
        final int totalSize = 2 * size + 1;
        boolean firstCircle = true;

        int starsCount = 1;
        int dotsCount = size;

        for(int i = 0; i < totalSize; i++) {

            if(firstCircle && starsCount!=totalSize) {
                System.out.println(createString('.', dotsCount) + createString('*', starsCount) + createString('.', dotsCount));
                starsCount+=2;
                dotsCount-=1;
            } else {
                firstCircle = false;
                System.out.println(createString('.', dotsCount) + createString('*', starsCount) + createString('.', dotsCount));
                starsCount-=2;
                dotsCount+=1;
            }
        }
    }

    static String createString(char c, int repeat) {
        return String.valueOf(c).repeat(repeat);
    }

    static void exercise7() {
        char[] chars = {'c', 'a', 'd'};

        int index = 0;
        int minValue = 129;

        for(int i = 0; i < chars.length; i++) {

            if(chars[i] < minValue) {
                minValue = chars[i];
                index = i;
            }
        }
        System.out.println(index);
    }

    static void exercise8() {
        byte[] tablica1 = {0, 1, 2};
        byte[] tablica2 = {0, 1, 2};

        boolean flaga = true;

        for (int i = 0; i < tablica1.length; i++) {
            if (tablica1[i] != tablica2[i]) {
                flaga = false;
                break;
            }
        }
        if (flaga) {
            System.out.println("Tablice te mają identyczną zawartość.");
        } else {
            System.out.println("Tablice te mają różną zawartość");
        }
    }


    static void exercise9() {
        int[] arr = {1,4,5,6,7,-1};

        int closestIndex = 0;

        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; ++i) {
            int abs = Math.abs(arr[i]);
            if (abs < diff) {
                closestIndex = i;
                diff = abs;
            } else if (abs == diff && arr[i] > 0 && arr[closestIndex] < 0) {
                //same distance to zero but positive
                closestIndex =i;
            }
        }
        System.out.println(arr[closestIndex ]);
    }



    static void exercise10() {
        Random random = new Random();
        int size = 10 + random.nextInt(6);

        int[] ints = new int[size];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }

        for (int i = 0; i < ints.length; i += 2) {
            if (i < ints.length - 1) {
                int temp = ints[i];
                ints[i] = ints[i + 1];
                ints[i + 1] = temp;
            }
        }

        for(int i: ints) {
            System.out.print(i +" ");
        }

        for (int i = 0; i < ints.length; i++) {
            System.out.println();
            for (int j = 0; j < ints.length; j++) {
                StringBuilder sb = new StringBuilder();
                if(ints[j] == -1) {
                    sb.append(". ");
                }
                else if (ints[j] == 0) {
                    sb.append("* ");
                    ints[j] = -1;
                } else {
                    sb.append(". ");
                    ints[j] = ints[j] - 1;
                }
                System.out.print(sb.toString());
            }
        }
    }

    static void exercise11() {

        final int hashCode = 2142102;

        int[] ints = new int[10];

        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 9; i++) {
            System.out.println("Please enter number ");
            ints[i] = scanner.nextInt();
        }

        int sum = 0;

        for (int anInt : ints) {
            sum += anInt;
        }

        ints[9] = sum * hashCode;

    }

}
