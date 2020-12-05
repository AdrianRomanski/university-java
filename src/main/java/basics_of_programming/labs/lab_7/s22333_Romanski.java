package basics_of_programming.labs.lab_7;

import java.util.Random;

public class s22333_Romanski {

    static int[][] array2d = new int[3][128];

    public static void main(String[] args) {

        exercise7();

    }


    static void exercise1() {
        int[] tab = {1,2,3,4,4,3,2,1};

        int right = tab.length-1;
    }

    static void exercise2() {
        Random random = new Random();
        long[] numbers = new long[32];
        int firstRandomNum;
        int secondRandomNum;
        numbers[0] = 0;
        for(int i = 1; i < numbers.length; i++) {
            numbers[i] = numbers[i-1] + 1;
        }

        System.out.println("Przed mieszaniem");
        for(long l: numbers) {
            System.out.print(l + " ");
        }

        while(!check(numbers)) {
            firstRandomNum =random.nextInt(32);
            secondRandomNum =random.nextInt(32);
            long first = numbers[firstRandomNum];
            long second = numbers[secondRandomNum];
            numbers[firstRandomNum] = second;
            numbers[secondRandomNum] = first;
        }

        System.out.println();
        System.out.println("Po mieszaniu");
        for(long l: numbers) {
            System.out.print(l + " ");
        }
    }

    static boolean check(long[] numbers) {
        for(int i = 0; i<numbers.length-1; i++) {
            if(numbers[i] == numbers[i+1]-1) {
                return false;
            }
        }
        return true;
    }


    static void exercise3(int arrSize) {
        int[] ints = new int[arrSize];
        double[] doubles = new double[arrSize];
        double[] sums = new double[arrSize];

        double max = Double.MIN_VALUE;

        double sum = 0;

        Random random = new Random();

        for(int i = 0; i < arrSize-1; i++) {
            ints[i] = random.nextInt();
        }
        for(int i = 0; i < arrSize-1; i++) {
            doubles[i] = random.nextDouble();
        }

        for(int i = 0; i < arrSize-1; i++) {
            sum = doubles[i] + ints[i];
        }

    }


    static void exercise4() {
        int[][] tab={ {1, 0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1}};
        int[] newArr = new int[12];
        int count = 0;
        for(int i = 0; i < tab.length; i++) {
            for(int j = 0; j < tab[i].length; j++) {
                newArr[count++] = tab[i][j];
            }
        }
    }

    static void exercise5() {
        Random random = new Random();

        int firstArrSize = random.nextInt(128);
        int[] firstArr = new int[firstArrSize];

        int secondArrSize = random.nextInt(128);
        int[] secondArr = new int[secondArrSize];

        int thirdArrSize = random.nextInt(128);
        int[] thirdArr = new int[thirdArrSize];

        for (int i = 0; i < firstArrSize; i++) {
            firstArr[i] = random.nextInt();
        }
        for (int i = 0; i < secondArrSize; i++) {
            secondArr[i] = random.nextInt();
        }
        for (int i = 0; i < thirdArrSize; i++) {
            thirdArr[i] = random.nextInt();
        }
        copyArray(firstArr, 0);
        copyArray(secondArr, 1);
        copyArray(thirdArr, 2);

        for(int i = 0; i < array2d.length; i++) {
            System.out.println(i + " row");
            for(int j = 0; j < array2d[i].length; j++) {
                System.out.print(array2d[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void copyArray(int[] array, int count) {
        for(int i = count; i < count+1; i++) {
            for(int j = 0; j < array.length; j++) {
                array2d[i][j] = array[j];
            }
        }
    }

    static void exercise6() {
        float[][] floats = new float[8][8];
        Random random = new Random();

        float sum = 0;

        for(int i = 0; i < floats.length; i++) {
            for(int j = 0; j < floats[i].length; j++) {
                floats[i][j] = random.nextFloat();
            }
        }

        //  lew przekt        prawa przekt    // int count = floats.length-1;
        //  * - - - - - - -   - - - - - - - * // floats[i][count--]
        //  - * - - - - - -   - - - - - - * - // floats[i][count--]
        //  - - * - - - - -   - - - - - * - -
        //  - - - * - - - -   - - - - * - - -
        //  - - - - * - - -   - - - * - - - -
        //  - - - - - * - -   - - * - - - - -
        //  - - - - - - * -   - * - - - - - -
        //  - - - - - - - *   * - - - - - - -
        int count = floats.length-1;
        for(int i = 0; i < floats.length; i++) {
            sum+=floats[i][i];
        }
        System.out.println("First Sum = " + sum);
        sum=0;
        for(int i = 0; i < floats.length; i++) {
            sum+=floats[i][count--];
        }
        System.out.println("Second Sum = " + sum);
    }

    static void exercise7() {
        boolean firstCircle = true;

        int[][] tab = {
                { 1, 2, 3, 4}, // 1 2 3 4
                { 5, 6, 7, 8}, // 8 7 6 5
                { 9,10,11,12}, // 9 10 11 12
                {13 ,14 ,15 ,16} // 16 15 14 13
        };

        for (int[] ints : tab) {
            System.out.println();
            if (firstCircle) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                firstCircle = false;
            } else {
                for (int j = ints.length - 1; j >= 0; j--) {
                    System.out.print(ints[j] + " ");
                }
                firstCircle = true;
            }
        }
    }

    //exercise8
    static void show(int number) {
        System.out.println(number);
    }

    //
    static void modifyValue() {

    }


    // Exercise 10
    static int findMax(int first, int second, int third) {
        if(first >= second && first >= third) {
            return first;
        }
        if(second >= first && second >= third) {
            return second;
        }
        return third;
    }

    // Exercise 11
    static int countingChars(String str) {
        char[] alaMaKota = "Ala ma kota".toCharArray();
        char[] chars = str.toCharArray();
        int count = 0;
        for (char aChar : chars) {
            for (char c : alaMaKota) {
                if (c == aChar) {
                    count++;
                }
            }
        }
        return count;
    }

    //

}
