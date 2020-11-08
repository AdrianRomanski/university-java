package basics_of_programming.labs.lab_2;

import java.util.Scanner;

public class anotherLab2 {

    public static void main(String[] args) {

        System.out.println(32 >> 2);
    }

    static void exercise1() {
        int number10 = 13;
        System.out.print(number10);

        int number2 = 0b1101;
        System.out.print(number2);

        // 8 do potegi 0 = 1 8 do potegi 1 = 8
        int number8 = 015;
        System.out.print(number8);

        int number16 = 0xD;
        System.out.print(number16);

        System.out.println(number10 == number2 && number2 == number8 && number8 == number16);

        // 0 000
        // 1 001
        // 2 010
        // 3 011
        // 4 100
        // 5 101
        // 6 110
        // 7 111

        // 23420 w systemie osemkowym
        // 2 = 010, 3 = 011, 4 = 100, 2 = 010, 0 = 000
        // 0010 0111 0001 0000

        // System szesnastkowy
        // 0 0000
        // 1 0001
        // 2 0010
        // 3 0011
        // 4 0100
        // 5 0101
        // 6 0110
        // 7 0111
        // 8 1000
        // 9 1001
        // A 1010
        // B 1011
        // C 1100
        // D 1101
        // E 1110
        // F 1111

        // AF9D7
        // 1010 1111 1001 1101 0111
    }

    static void exercise2() {
        int number = 41 ;
        System.out.print(number);

        int numberDwojkowy = 0b101001;
        System.out.print(numberDwojkowy);

        // 8 do potegi 0 = 1 8 do potegi 1 = 8
        int numberOsemkowy = 051;
        System.out.print(numberOsemkowy);

        // 2 x 16 = 32 + 9 * 1 = 41
        int numberSzesnastkowy = 0x29;
        System.out.print(numberSzesnastkowy);
    }

    static void exercise3() {
        int number4 = 4;
        // 0100 = 4
        // 0101 = 5
        //5
        int number5 = number4 ^ 0b0001;
        int number5vol2 = number4 ^ 0b0101;
        //6
        // 0110                   0100
        int number6 = number4 ^ 0b0010;
        //7                       0100
        int number7 = number4 ^ 0b0011;
        //12
        int number12 = number4 ^ 0b1000;
        //4                           0100
        int number4vol2 = number4 ^ 0b0000;
        //13
        int number13 = number4 ^ 0b1001;
    }


    // Aby uzyskac jakas liczbe poprzez endowanie musimy endowac ta sama liczba
    static void exercise4() {
        int number5 = 5;

        //1                     0b1001
        int number1 = number5 & 0b0001;

        //4                     0b1001
        int number4 = number5 & 0b0100;
        //5

        int number0 = number5 & 0b0000;

        //3                     0b1001
        int number3 = number5 & 0b0011;
        //                      0b0011
        // Endowanie przez jedynki nic nie zmienia
    }


    static void exercise5() {
        int number7 = 7;

        // 15                    0b0111
        int number15 = number7 ^ 0b1111;
        //                       0b1111

        // 4                    0b0111
        int number4 = number7 & 0b0100;
        //                      0b0100

        // 3                    0b0111
        int number3 = number7 & 0b0011;
        //                      0b0011

        // 11                       0b0111    0b0011
        int number11 =   (number7 & 0b1011) ^ 0b1011;
        //                          0b0011    0b1011 - Sukces!

        // Endowanie przez liczbe a pozniej orowanie przez ta sama liczbe da nam ta liczbe
        // (7 & 11) ^ 11 = 11
        // (7 & 9) ^ 9 = 9;
        // (7 & 16) ^ 16 = 16;
        // (7 & 38) ^ 38 = 38;
    }

    static void exercise6() {
        Scanner in = new Scanner(System.in);
        System.out.println("Prosze wprowadzic liczbe: ");
        int number = in.nextInt();

        // jesli wyjdzie zero to jest parzysta
        int result = number & 0b1;
        boolean parzysta = result == 0 ? true : false;

        System.out.println(number + " czy jest liczba parzysta? " + parzysta);
    }

    static void exercise7() {
        int number32 = 32;
        // 8
        int number8 = number32 >> 2;

        // 16
        int number16 = number32 >> 1;

        // 4
        int number4 = number32 >> 3;

        // 1
        int number1 = number32 >> 5;

        // 0
        int number0 = number32 >> 6;
    }

    static void exercise8() {
        int number4 = 4;
    //16
        int number16 = number4 << 2;
    //8
        int number8 = number4 << 1;
    //32
        int number32 = number4 << 3;
    //64
    //128
    //256
    }

    static void exercise9() {
        // Zakladajac, ze w javie liczby od zera 1 bit jest dla mnie b0
        //- 2 bit
        //- 3 bit
        //- 1 bit i 4 bit - 2 bit i 3 bit

        Scanner sc = new Scanner(System.in);
        int nextInt = sc.nextInt();

        //- 1 bit
        int bit1 = nextInt & 0b1;
        System.out.println("Pierwszy bit ma wartosc " + bit1);

        //- 2 bit
        int bit2 = nextInt & 0b10;

        int bit2val = bit2 == 2 ? 1 : 0;
        System.out.println("Drugi bit ma wartosc " + bit2val);

        //- 3 bit
        int bit3 = nextInt & 0b100;

        int bit3val = bit3 == 4 ? 1 : 0;
        System.out.println("Trzeci bit ma wartosc " + bit3val);

        //- 1 bit i 4 bi
        int bit4 = nextInt & 0b1000;

        int bit4val = bit4 == 8 ? 1 : 0;

        int bit1_4 = nextInt & 0b0001;

        int bit1_4val = bit1_4 == 1 ? 1 : 0;
        System.out.println("Pierwszy bit ma wartosc" + bit1_4val + "Czwarty bit ma wartosc " + bit4val);

        //-  2 bit i 3 bit
        int bit2_2 = nextInt & 0b010;

        int bit2val2 = bit2 == 2 ? 1 : 0;

        int bit2_3 = nextInt & 0b0100;

        int bit2_3val = bit2_3 == 4 ? 1 : 0;
        System.out.println("Drugi bit ma wartosc" + bit2val2 + "Trzeci bit ma wartosc " + bit2_3val);
    }

    static void exercise10() {
        //- 1 -> 2
        int number1 = 1;
        int number2 = 1 << 1;
        //- 2 -> 4
        int number2_2 = 2;
        int number4 = 2 << 1;
        //- 4 -> 2
        int number4_1 = 4;
        int number2_3 = number4_1 >> 1;
        //- 3 -> 1
        int number3 = 3;
        int number1_1 = number3 >> 1;
        //- 3 -> 2
        int number3_1 = 3;
        int number2_4 = (number3 >> 1) << 1;
        //- 7 -> 6
        int number7 = 7;
        int number6 = (number7 >> 1) << 1;
    }
}
