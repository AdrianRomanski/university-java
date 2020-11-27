package basics_of_programming.training.exercise6.exercise6_03;

import java.util.Scanner;

public class Exercise {

    public static void main(String[] args) {

        exercise3();

    }


    static void exercise1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number ");
        intToBinary(sc.nextInt());
    }

    static void intToBinary(int number) {
        if(number!=0) {
            intToBinary(number/2);
            System.out.print(number%2);
        }
    }

    static void exercise2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number ");
        int number = sc.nextInt();
        for(int i = 2; i <= number; i++) {
            if (checkForPrime(i))
                System.out.println(i + " is a prime number");
        }
    }

    static boolean checkForPrime(int number) {
        for(int i = 2; i < number/2; i++) {
            if(number % i == 0)
                return false;
        }
        return true;
    }

    static void exercise3() {
        int[] arr = {10, 3, 12, 5, 15, 8};
        for(int i: arr) {
            if(checkForFibonacci(i))
                System.out.println(i + " is a fibonacci number");
        }
    }

    static boolean checkForFibonacci(int number) {
        int first = 0;
        int second = 1;
        int temp;
        if(number == first || number == second) {
            return true;
        }
        while (number > second) {
            temp = second;
            second = first + second;
            first = temp;
            if(number == second)
                return true;
        }
        return false;
    }
}
