package basics_of_programming.training.exercise6.exercise6_04;

import java.util.Random;
import java.util.Scanner;

public class Exercise {

    public static void main(String[] args) {


    }


    static void exercise1() {
        int[] mask = {1,2,4,8,16,32,64,128};
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int number = sc.nextInt();
        int sum = 0;

        for(int i = 0; i <= 7; i++) {
            int bit = number & mask[i];
            if(bit != 0)
                sum+=1;
        }
        System.out.println("Sum = " + sum);
    }

    static void exercise2() {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int rd = 0;
        while(flag) {
             rd = random.nextInt(1001);
            if(checkPrime(rd))
                flag = false;
        }
        flag = true;
        while(flag) {
            System.out.println("Guess a number");
            int userGuess = sc.nextInt();
            if(userGuess == rd)
                flag = false;
        }
        System.out.println("Good Job!");
    }

    static boolean checkPrime(int number) {
        for(int i = 2; i < number/2; i++) {
            if(number != i && number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
