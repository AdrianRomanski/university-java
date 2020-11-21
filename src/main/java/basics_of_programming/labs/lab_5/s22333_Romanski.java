package basics_of_programming.labs.lab_5;

import java.util.*;

public class s22333_Romanski {

    public static void main(String[] args) {

//        exercise1();
//        exercise2();
//        exercise3();
//        exercise4();
//        exercise5();
        exercise6();
//        exercise5();
//        exercise8();
//        exercise9();
//        exercise10();

    }

    static void exercise1() {
        for(int i = 0; i < 11; i++) {
            System.out.print(i + ", ");
        }
    }

    static void exercise2() {
        int wrt = 3;
        for(int i = 0; i < 11; i++) {
            System.out.print(i  * wrt + ", ");
        }
    }

    static void exercise3() {
        int i = 0;
        int j = 0;


        // Executed twice
        while (i <= 2) {
            System.out.println("While Loop: i = " + i);
            i++;
        }

        // Excuted with j == 0
        do {
            System.out.println("Do Loop: j = " + j);
        }
        while (j != 0);
        }


    static void exercise4() {
        double q = 1;
        double sum = 0;

        for(int i = 0; i < 11; i++) {
            sum+=q;
            q/=2;
            System.out.println(sum);
        }

    }

    static void exercise5() {
        final String fiveStars = "* * * * *";
        final String fourStars = " * * * * ";

        for(int i = 0; i < 7; i++) {
            if(i % 2 == 1) {
                System.out.println(fourStars);
            } else {
                System.out.println(fiveStars);
            }
        }

    }

    static void exercise6() {
        final int size = 3;
        final int finalSize = (2 * size + 1);

        int tempDots = size;
        int tempStars = 1;

        String dots;
        String stars;

        boolean firstCircle = true;

        for(int i = 0; i < finalSize; i ++) {
            dots = getString('.', tempDots);
            stars = getString('*', tempStars);
            System.out.println(dots + stars + dots);
            if(tempStars != finalSize && firstCircle) {
                tempStars+=2;
                tempDots-=1;
            } else {
                firstCircle = false;
                tempStars-=2;
                tempDots+=1;
            }
        }
    }

    public static String getString(char ch, int n){
        return String.valueOf(ch).repeat(n);
    }


    static void exercise7() {
        char[] chars = {'c', 'a', 'b'};

        int index = 0;
        int minValue = 128;

        for(int i = 0; i < chars.length; i++) {
            if(chars[i] < minValue) {
                index = i;
                minValue = chars[i];
            }
        }
        System.out.println(index);
    }

    static void exercise8() {
        byte[] byteArray1 = {2,2};
        byte[] byteArray2 = {1,2};

        int sum1 = 0;
        int sum2 = 0;

        for(int i = 0; i < byteArray1.length; i++) {
            sum1+=byteArray1[i];
            sum2+=byteArray2[i];
        }
        System.out.println(sum1 == sum2);

    }

    static void exercise9() {
        // najblizsze zeru = 1 + 2
        int[] numbers = {-24, -21, -15, - 4, 1, 4, 6, 2, 5, 7, 11, 15};

        for(int i = 0; i < numbers.length; i++) {

            for(int j = 0; j < numbers.length; j++) {

            }
        }

    }

    static void exercise10() {
        Random random = new Random();
        int size = 10 + random.nextInt(6);

        int[] ints = new int[size];

        // wypelnianie
        for(int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }

        // mieszanie
        for(int i = 0; i < ints.length; i++) {
            ints[i] = ints[random.nextInt(size)];
        }
    }

    static void exercise11() {

    }

}
