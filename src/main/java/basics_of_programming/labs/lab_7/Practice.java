package basics_of_programming.labs.lab_7;

import java.util.Random;

public class Practice {

    static Random random = new Random();
    static int[][] ints = new int[3][1024];

    public static void main(String[] args) {

//
//        int value = 5;
//        modifyValue(value);
//
//        System.out.println("After metod " + value);


        int[] ints = exercise12(-2);

        System.out.println();
        System.out.println("Third Array");


        for(int i: ints) {
            System.out.print(i + " ");
        }


    }

    static boolean exercise1() {
        int[] tab = {1,2,3,4,4,3,2,1};
        int right = tab.length-1;
        for(int i = 0; i < tab.length/2; i++) {
            if(tab[i] != tab[right--])
                return false;
        }
        return true;
    }

    static void exercise2(int arrLength) {
        long[] longs = new long[arrLength];
        int firstRandom, secondRandom;
        long temp;
        for(int i = 0; i < longs.length; i++) {
            longs[i] = i;
        }
        while (!checkExercise2(longs)) {
            firstRandom = random.nextInt(arrLength);
            secondRandom = random.nextInt(arrLength);
            temp = longs[firstRandom];
            longs[firstRandom] = longs[secondRandom];
            longs[secondRandom] = temp;
        }
    }

    static boolean checkExercise2(long[] longs) {
        for(int i = 0; i < longs.length-1; i++) {
            if(longs[i] + 1 == longs[++i])
                return false;
        }
        return true;
    }

    static void exercise3() {}


    static void exercise4() {
        int[][] ints = {{1, 0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1}};
        int size = 0;
        for (int[] anInt : ints) {
            size += anInt.length;
        }
        int[] ints1d = new int[size];
        int count = 0;
        for (int[] anInt : ints) {
            for (int i : anInt) {
                ints1d[count++] = i;
            }
        }
     }

    static void exercise5() {
        int firstArrSize = random.nextInt(1024);
        int secondArrSize = random.nextInt(1024);
        int thirdArrSize = random.nextInt(1024);

        int[] firstArr = new int[firstArrSize];
        int[] secondArr = new int[secondArrSize];
        int[] thirdArr = new int[thirdArrSize];

        fillArrayWithRandoms(firstArr);
        fillArrayWithRandoms(secondArr);
        fillArrayWithRandoms(thirdArr);

        fill2DArray(firstArr, 0);
        fill2DArray(secondArr, 1);
        fill2DArray(thirdArr, 2);
    }

    static void fillArrayWithRandoms(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            arr[i]+=random.nextInt();
        }
    }

    static void fill2DArray(int[] arr, int row) {
        for(int i = row; i < row+1; i++) {
            for(int j = 0; j < arr.length; j++) {
                ints[i][j] = arr[j];
            }
        }
    }

    static void exercise6() {
        float[][] floats = new float[8][8];
        for(int i = 0; i < floats.length; i++) {
            for(int j = 0; j < floats[i].length; j++) {
                floats[i][j] = random.nextFloat();
            }
        }
        int leftSum = 0;
        int rightSum = 0;
        int right = floats.length-1;

        // * - - - - - - - floats[0][0]   - - - - - - - * floats[0][floats.length-1);
        // - * - - - - - - floats[1][1]   - - - - - - * -
        // - - * - - - - - floats[2][2]   - - - - - * - -
        // - - - * - - - - floats[3][3]   - - - - * - - -
        // - - - - * - - - floats[4][4]   - - - * - - - -
        // - - - - - * - -                - - * - - - - -
        // _ - - - - - * -                - * - - - - - -
        // - - - - - - - *                * - - - - - - -

        for (float[] value : floats) {
            for (float v : value) {
                leftSum += v;
            }
        }
        System.out.println("Left sum " + leftSum);

        for (float[] aFloat : floats) {
            for (int j = 0; j < aFloat.length; j++) {
                leftSum += aFloat[right--];
            }
        }
        System.out.println("Right sum " + rightSum);
    }

    static void exercise7() {
        int[][] arr = { {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};
        // |1 2 3 4 | 8 12 16 | 15 14 13 | 9 5 | 6 7 | 11 10

        boolean direction = true;
        boolean firstCircle = true;
        boolean secondCircle = false;

        for(int i = 0; i < arr.length-1; i++) {
            if(firstCircle) {
                for(int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                    direction  = false;
                    firstCircle = false;
                    secondCircle = true;
                }
            }

        }
    }


    static void show(int number) {
        System.out.println(number);
    }

    static void modifyValue(int val) {
        int wrt = 5;
        System.out.println("wrt before = " + wrt);
        System.out.println("val before =" + val);
        val*=5;
        System.out.println("val after =" + val);
        System.out.println("wrt after= " + wrt);
    }

    static int exercise10(int first, int second, int third) {
        if(first >= second && first >= third)
            return first;
        if(second >= first && second >= third)
            return second;
        return third;
    }

    static int exercise11(String str) {
        char[] alaMaKota = "Ala ma kota".toCharArray();
        // a - 3 m - 1 k - 1
        char[] chars = str.toCharArray();
        int count = 0;
        for(int i = 0; i < alaMaKota.length; i++) {
            for(int j = 0; j < chars.length; j++) {
                if(alaMaKota[i] == chars[j])
                    count++;
            }
        }
        return count;
    }


    static int[] exercise12(int value)  {
        int[] ints1 = new int[random.nextInt(32)];
        int[] ints2 = new int[random.nextInt(32)];

        for(int i = 0; i < ints1.length; i++) {
            ints1[i] = random.nextInt();
        }

        System.out.println("First Array");
        for(int i: ints1) {
            System.out.print(i + " ");
        }
        System.out.println();

        for(int i = 0; i < ints2.length; i++) {
            ints2[i] = random.nextInt();
        }

        System.out.println("Second Array");
        for(int i: ints2) {
            System.out.print(i + " ");
        }

        int[] intArr = new int[32];
        if(ints1.length == ints2.length) {
            return intArr;
        }
        if(value < 0) {
            for (int i = 0; i < ints1.length; i++)
                intArr[i] = ints1[i];
            for (int i = 0; i < ints2.length; i++)
                if (intArr[i] != 0) {
                    intArr[i] = ints2[i] + ints1[i];
                }
            }
        return intArr;
    }



}
