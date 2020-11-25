package basics_of_programming.training.exercise6.exercise6_01;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise {

    public static void main(String[] args) {

        exercise3();

    }

    static boolean exercise1() {
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();
        long[] bits = new long[8];
        long[] mask = {1,2,4,8,16,32,64,128};
        // filling array with bits
        for(int i = 7; i >=0; i--) {
            long bit = mask[i] & number;
            if(bit != 0)
                bits[i] = 1;
            else
                bits[i] = 0;
        }
        // checking for palindrome
        int right = bits.length-1;
        for(int i = 0; i<bits.length/2; i++) {
            if(bits[i] != bits[right])
                return false;
            else
                right--;
        }
        return true;
    }


    static void exercise2() {
        int n = 24;
        int count = 0;
        for(int i = 100; i < Integer.MAX_VALUE; i++) {
            if(count!=n) {
                int[] ints = toIntsArray(i);
                if(check(ints, i)) {
                    System.out.println(i);
                    count++;
                }
            }
        }
    }

    static int[] toIntsArray(int number) {
        int[] tempArray = new int[16];
        int i =0;
        int count = 0;
        while(number != 0) {
            if(number == 10) {
                tempArray[i] = 1;
                count++;
                number = 0;
            } else if(number < 10) {
                tempArray[i] = number;
                count++;
                number = 0;
            } else {
                tempArray[i++] = number % 10;
                count++;
                number/=10;
            }
        }
        int[] finalArr = new int[count];
        for(int h = 0; h<count; h++) {
            finalArr[h] = tempArray[h];
        }
        return finalArr;
    }

    static boolean check(int[] arr, int number) {
        int size = arr.length;
        int number2 = 0;
        for(int num: arr) {
            number2+=Math.pow(num, size);
        }
        return number == number2;
    }


    static void exercise3() {
        int[] arr={10, 2, 20, 7, 30, 17};
        for(int i: arr) {
            if (checkPrimeNumbers(i))
                System.out.println(i + " is a prime number");
        }
    }
    static boolean checkPrimeNumbers(int number) {
        for(int i = 2; i < number/2; i++) {
            if(number % i == 0)
                return false;
        }
        return true;
    }
}
