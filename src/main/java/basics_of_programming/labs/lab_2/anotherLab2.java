package basics_of_programming.labs.lab_2;

public class anotherLab2 {

    public static void main(String[] args) {

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
}
