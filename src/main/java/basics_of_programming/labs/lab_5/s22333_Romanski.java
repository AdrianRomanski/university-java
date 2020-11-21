package basics_of_programming.labs.lab_5;

import java.util.*;

public class s22333_Romanski {

    public static void main(String[] args) {

//        exercise1();
//        exercise2();
//        exercise3();
//        exercise4();
//        exercise5();
//        exercise6();
//        exercise7();
//        exercise8();
//        exercise9();
//        exercise10();
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
        boolean state = false;

        while(state) {
            System.out.println("While");
        }
        do{
            System.out.println("Do");
        }
        while(state);
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
        String dots;
        String stars;
        final int size = 25;
        int tempStars = 1;
        int tempDots = size;
        boolean firstCircle = true;
        final int totalSize = 2 * size + 1;

        for(int i = 0; i < totalSize; i ++) {
            dots = getString('.', tempDots);
            stars = getString('*', tempStars);
            System.out.println(dots + stars + dots);
            if(tempStars != totalSize && firstCircle) {
                tempStars+=2;
                tempDots-=1;
            } else {
                firstCircle = false;
                tempStars-=2;
                tempDots+=1;
            }
        }
    }
    static String getString(char c, int repeat) { return String.valueOf(c).repeat(repeat); }


    static void exercise7() {
        int index = 0;
        int minValue = 129;
        char[] chars = {'c', 'a', 'd'};

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
        boolean flag = true;

        for (int i = 0; i < tablica1.length; i++) {
            if (tablica1[i] != tablica2[i]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Arrays Are Same");
        } else {
            System.out.println("Arrays Are Different");
        }
    }


    static void exercise9() {
        int[] ints = {1,4,5,6,7,-298,-3,-12,-9};
        int closest = Integer.MAX_VALUE;
        int index1 = 0;
        int index2 = 0;
        int temp;

        for(int i=0; i < ints.length; i ++) {
            for(int j=0; j< ints.length; j++) {
                if(i!=j) {
                    temp = ints[i] + ints[j];
                    if(temp < 0) {
                        temp*=(-1);
                    }
                    if(temp < closest) {
                        closest = temp;
                        index1 = i;
                        index2 = j;
                    }
                }
            }
        }
        System.out.println("First Index = " + index1);
        System.out.println("Second Index = " + index2);
        System.out.println("Closest sum to zero = " + closest);
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
        Scanner scanner = new Scanner(System.in);
        final int hashCode = 2142102;
        int[] ints = new int[10];
        int sum = 0;

        for(int i = 0; i < 9; i++) {
            System.out.println("Please enter number ");
            ints[i] = scanner.nextInt();
        }

        for (int anInt : ints) {
            sum += anInt;
        }
        ints[9] = sum * hashCode;
    }
}