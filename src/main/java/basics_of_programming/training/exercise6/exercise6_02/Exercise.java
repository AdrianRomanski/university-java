package basics_of_programming.training.exercise6.exercise6_02;

import java.util.Scanner;

public class Exercise {

    public static void main(String[] args) {


        exercise2();

    }

    static void exercise1() {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        while (number <= 0) {
            System.out.println("Please enter number starting from 1");
            number = sc.nextInt();
        }
        sc.close();
        int sum = 0;
        while(number != 0) {
            if(number == 10) {
                sum+=1;
                number=0;
            } else if(number < 10) {
                // 4
                sum+=number;
                number=0;
            } else {
                // 484 % 10 = 4
                // 48 % 10 = 8
                sum+=number%10;
                // 484 / 10 = 48
                // 48 / 10 = 4
                number/=10;
            }
        }
        System.out.println("Sum of every digit is equal to: " + sum);
    }


    static void exercise2() {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        while (number <= 0) {
            System.out.println("Please enter number starting from 1");
            number = sc.nextInt();
        }
        sc.close();
        StringBuilder sb = new StringBuilder();
        int first = 0;
        int second = 1;
        int temp;
        sb.append(first);
        for(int i = 1; i < number; i++) {
            sb.append(" ").append(second);
            temp = second;
            second = first+second;
            first = temp;
        }
        System.out.println(sb.toString());
    }


    static void exercise3() {
        int[] arr = {153, 333, 370, 515, 407, 80};
        for(int i: arr) {
            if(i >= 100) {
                int sum = 0;
                int[] ints = toDigits(i);
                for(int j: ints) {
                    sum+=(int)Math.pow(j, 3);
                }
                if(sum == i) {
                    System.out.println(i + " is an armstrong number");
                }
            }
        }
    }

    static int[] toDigits(int number) {
        int[] digits = new int[3];
        for(int i = 0; i <=2; i++) {
            if(number == 10)
                digits[i]=10;
            else if(number < 10)
                // 1
                digits[i]=number;
            else {
                // 153 % 10 = 3
                // 15 % 10 = 5
                digits[i]=number%10;
                // 153 / 10 = 15
                // 15 / 10 = 1
                number/=10;
            }
        }
        return digits;
    }


}
