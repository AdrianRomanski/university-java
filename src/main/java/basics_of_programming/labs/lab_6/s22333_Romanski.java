package basics_of_programming.labs.lab_6;

import java.util.Scanner;

public class s22333_Romanski {

    public static void main(String[] args) {
         // exercise2();
          exercise2();
         // exercise3();

    }

    static void exercise1() {
        Scanner sc = new Scanner(System.in);

        // 24251 zalozmy, ze wprowdze tak numer
        // na poczatku musze wyciagnac pierwsze liczbe

        int number = sc.nextInt();

        //
    }

    static void exercise2() {
        Scanner sc = new Scanner(System.in);
        final String one = "1";
        final String two = "2";
        final String three = "3";

        int number = sc.nextInt();

        boolean isPrime = true;

        if(number == 1) {
            System.out.println(one);
        } else if(number == 2 || number> 3) {
            System.out.println(one);
            System.out.println(two);
        } else if(number == 3) {
            System.out.println(one);
            System.out.println(two);
            System.out.println(three);
        }

        for(int i = 4; i <= number; i++) {
            if(isPrime) {
                System.out.println(i - 1);
            }
            isPrime = true;
            for(int j = 2; j <= i; j++) {
                if(isPrime && i != j) {
                    int modulo = i % j;
                    if(modulo == 0) {
                        isPrime = false;
                    }
                }
            }
        }
    }

    static void exercise3() {
        int[] arr = {10, 3, 12, 5, 15, 8};


        // 0 1 1 2 3 5 8 12 itp
        int firstFibonacci = 0;
        int secondFibonacci = 1;
    }


    static void zadanie02() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] primes = new int[n];
        int checked=0;
        boolean isprime = true;
        for (int a=0; a<n;) {

            for (int d = 2; d <= checked / 2; d++) {
                if (checked % d == 0) {
                    isprime = false;
                }
            }
            if (isprime){
                primes[a] = checked;
                checked++;
                a++;
            }
            else{ checked++;

            }


        }
        for(int z = 0; z <n; z++){
            System.out.print(primes[z]);
        }
    }



}


