package basics_of_programming.labs.lab_2;

import java.util.Random;
import java.util.Scanner;

public class anotherLab0 {
    public static void main(String[] args) {

//         zadanie01();
//         zadanie06();
       zadanie07();
//          zadanie08();
//        zadanie09(10, 3);
//        zadanie10(true);
//        zadanie10(false);
//        zadanie11(false, true);
//        zadanie11(true, true);
//        zadanie11(true, false);
//        zadanie11(false, false);
        zadanie12();


    }
    // 1, 6, 7, 8

    static void zadanie01() {
                          // 4  3 2 1 0
                          // 16 8 4 2 1
        int number = 17;  // 1  0 0 0 1
        int number1 = 1;
        int resultOfbit0 = 17 & number1;
        System.out.println("result of 17 & 1  = " + resultOfbit0);

        //  0 0 0 1 << 5 = 1 0 0 0 0 0
        int movedNumber = 1 << 5;

        // jesli jest zero, to nie bylo tam jedynki
        final int resultOfBit5 = number & movedNumber;
        System.out.println(resultOfBit5);
    }

    static void zadanie06() {
        // 1 przyklad  boolean 1 = true | boolean 2 = true
        boolean booleanFirst = true;
        boolean booleanSecond = true;

        boolean result = (booleanFirst && !booleanSecond) || (booleanSecond && !booleanFirst);

        System.out.println("1 przyklad  boolean 1 = true | boolean 2 = true");
        System.out.println("result = " + result);

        // 2 przyklad  boolean 1 = true | boolean 2 = false
        booleanFirst = true;
        booleanSecond = true;

        result = (booleanFirst && !booleanSecond) || (booleanSecond && !booleanFirst);
        System.out.println("2 przyklad  boolean 1 = true | boolean 2 = false");
        System.out.println("result = " + result);

        // 3 przyklad  boolean 1 = false | boolean 2 = true
        booleanFirst = true;
        booleanSecond = true;

        result = (booleanFirst && !booleanSecond) || (booleanSecond && !booleanFirst);
        System.out.println("3 przyklad  boolean 1 = false | boolean 2 = true");
        System.out.println("result = " + result);

        result = (booleanFirst && !booleanSecond) || (booleanSecond && !booleanFirst);

        // 4 przyklad  boolean 1 = false | boolean 2 = false
        booleanFirst = true;
        booleanSecond = true;

        result = (booleanFirst && !booleanSecond) || (booleanSecond && !booleanFirst);

        System.out.println("4 przyklad  boolean 1 = false | boolean 2 = false");
        System.out.println("result = " + result);
    }

    static void zadanie07() {
        int zadanie_7_01 = 2 * 5 + (3 * 4) - 8;
        System.out.println(zadanie_7_01); // 14
        int zadanie_7_02 = (2 * 5 + 3) * 4 - 8;
        System.out.println(zadanie_7_02); // 44
        int zadanie_7_03 = 2 * (5 + 3 * 4 - 8);
        System.out.println(zadanie_7_03); // 18
        int zadanie_7_04 = 2 * (5 + 3 * 4) - 8;
        System.out.println(zadanie_7_04); // 26
        int zadanie_7_05 = 2 * 5 + 3 * (4 - 8);
        System.out.println(zadanie_7_05); // -2
        int zadanie_7_06 = (2 * 5 + 3 * 4) - 8;
        System.out.println(zadanie_7_06); // 14
        int zadanie_7_07 = 2 * 5 + 3 * (4 - 8);
        System.out.println(zadanie_7_06); // 14
        // int x = 2 * ((5 + 3) * 4 - 8); Gracias
        int zadanie_7_08 = 2 * ((5 + 3) * 4 - 8);
        System.out.println(zadanie_7_08); // powinno byc ok
    }

    static void zadanie08() {
        Scanner in = new Scanner(System.in);
        int studentId = in.nextInt();
        System.out.println("Please enter student number");
        System.out.println("Hello s" + studentId);
    }

    static void zadanie09(int number1, int number2) {
        System.out.println("Wynik dzielenia=" + number1 / number2 + " reszta=" + number1 % number2);
    }

    static void zadanie10(boolean czyPada) {
        int x;
        if(czyPada) {
            x = 5;
        } else {
            x = 8;
        }
        System.out.println("czyPada ma wartosc " + czyPada + " , wiec x = " + x);
    }

    static void zadanie11(boolean czySwieciSlonce, boolean czyPada) {
        if (czyPada && !czySwieciSlonce) {
            System.out.println("plucha");
        } else if(czyPada && czySwieciSlonce) {
            System.out.println("tecza");
        } else if(!czyPada && czySwieciSlonce) {
            System.out.println("slonecznie");
        } else if(!czyPada && !czySwieciSlonce) {
            System.out.println("pochmurno");
        }
    }

    static void zadanie12() {
        //  0 0 nie pada nie swieci slonce = 0
        //  0 1 pada nie swieci slonce = 1
        //  1 0 swieci slonce i nie pada = 2
        //  1 1 pada i swieci slonce = 3

        boolean czyPada = false;
        boolean czySwieciSlonce = false;

        int number = -1;

        Random random = new Random();
        int intCzyPada =  random.nextInt(2);
        int intSwieciSlonce =  random.nextInt(2);
        if(intCzyPada < 1) {
            czyPada = true;
        } if(intSwieciSlonce < 1) {
            czySwieciSlonce = true;
        }

        if (czyPada && !czySwieciSlonce) {
            number = 1;
        } else if(czyPada && czySwieciSlonce) {
            number = 3;
        } else if(!czyPada && czySwieciSlonce) {
            number = 2;
        } else if(!czyPada && !czySwieciSlonce) {
            number = 0;
        }

        switch (number) {
            case 0 -> System.out.println("pochmurno - nie pada i nie swieci slonce");
            case 1 -> System.out.println("plucha -  pada nie swieci slonce");
            case 2 -> System.out.println("slonecznie - swieci slonce i nie pada ");
            case 3 -> System.out.println("tecza - pada i swieci slonce");
            default -> System.out.println("cos poszlo nie tak");
        }

    }

}

