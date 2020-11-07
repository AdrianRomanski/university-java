package basics_of_programming.labs.lab_2;

import java.util.Scanner;

public class anotherLab {

    public static void main(String[] args) {

        exercise11(true, false);
        exercise11(true, true);
        exercise11(false, true);
        exercise11(false, false);

    }

    //Używając operacji koniunkcji bitowej, dokonaj weryfikacji czy na bicie 0 i bicie 5 wy- stępują wartości 1.
    static void exercise1() {
        // koniunka bitowa & endowanie
        // endowanie przez zero - zmienia wszystkie bity na 0
        // endowanie przez 1  - bez zmian
                     /////////  32 16 8  4  2  1
                            //  1  0  0  0  0  1
                            //  b5 b4 b3 b2 b1 b0
        int value33 = 0b100001;
        System.out.println(value33);

        int value1 = 0b1;

        // dokonaj weryfikacji czy na bicie 0
        int resultFirst =  value33 & value1;

        System.out.println("100001 & 000001 = " + resultFirst);

        // bicie 5
        int value32 = 32; // 100000

        // dokonaj weryfikacji  na bicie 5

        int valueB5 = value1 << 5;

        int resultSecond = value33 & valueB5;

        System.out.println("100001 & 100000 = " + resultSecond);

        // wartosc (1) << 2**x

        // 1 << 2  2**2  0001 = 1 << 2 0100 == 5

        // b0 b1 b2 b3 b4 b5 b6
        // 1 2 4 8 16 32 64 128

        //
        // 0010 1000 = 136
        // >> 4 2**4 == 64
        // 0000 0010 = 2

        byte wrt = (byte)136;
                            ///      & 0000 0001
        System.out.println( (wrt >> 0) & 1);
        System.out.println( (wrt >> 4) & 1);
    }


    // Zadeklaruj i zainicjuj zmienną typu int, a następnie wyświetl na konsoli przechowy- waną w niej wartość.
    static void exercise3() {
        int i = 2;
        System.out.println("int=" + i);
    }


    //Spróbuj zadeklarować zestaw zmiennych typu int,tak aby nazwy spełniały kolejno następujące kryteria:
    static void exercise4() {
        //pierwszy znak jest literą, kolejne znaki są cyframi;
        int v123 = 1;

        //.pierwszy znak jest cyfrą, kolejne znaki są literami
//        int 1sdf = 1;

        //pierwszy znak jest znakiem specjalnym @, następne znaki są dowolnymi znakami z przedziału a–z
//        int @sdfg = 1;

        //nazwa zmiennej jest taka sama jak dowolne słowo z nagłówka metody main i nie jest jej nazwą
//        int main = 1;
        //public static void - nie mozna
    }


    //Zadeklaruj i zainicjuj dowolnymi znakami dwie zmienne typu char nadając im nazwy:
    static void exercise5() {
        // camel case
        char charValue = 'a';
        // bad naming convention
        char charvalue = 'a';
    }


    //Przyjmij że dane są wartości logiczne jak w poniższej tabelce:\
    static void exercise6() {
        boolean bol1 = true;
        boolean bol2 = true;

        // Prawa de Morgana
        System.out.println("boolean1 = true, boolean 2 = true");
        System.out.println((bol1 && !bol2) || (bol2 && !bol1));

        bol1 = true;
        bol2 = false;

        System.out.println("boolean1 = true, boolean 2 = false");
        System.out.println((bol1 && !bol2) || (bol2 && !bol1));

        bol1 = false;
        bol2 = true;

        System.out.println("boolean1 = false, boolean 2 = true");
        System.out.println((bol1 && !bol2) || (bol2 && !bol1));

        bol1 = false;
        bol2 = false;

        System.out.println("boolean1 = false, boolean 2 = false");
        System.out.println((bol1 && !bol2) || (bol2 && !bol1));
    }


    static void exercise7() {
                            //  2 * ( 8 * 4 - 8)
        int zadanie_7_08 = 2 * ((5 + 3) * 4 - 8);
        System.out.println(zadanie_7_08); // powinno byc ok
    }


    static void exercise8() {
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter your student number");
        int scannerInt = in.nextInt();
        System.out.println("Hello s" + scannerInt);
    }

    //IX. Gdy przyjmiemy że operujemy w dziedzinie liczb całkowitych dodatnich,
    // wówczas dzieląc wartość 10 przez 3 uzyskujemy 3.333333(3).
    // Napisz program, który wyświe- tli efekt takiego działania w postaci: “3 reszty 1”.
    // Zadbaj aby program działał poprawnie dla dowolnych danych.
    static void exercise9() {
        int number1 = 10;
        int number2 = 3;
        System.out.println((number1 / 3) + " " + number1 % number2);

        // 10 % 3 = 1
        // x % 2 = 0 - parzyste
        // x % 2 = 1 - nieparzyste
    }

    static void exercise10() {
        boolean czyPada = true;

        // ladnie
        int x = czyPada ? 5 : 8;

        // latwo
        if(czyPada) {
            x = 5;
        } else {
            x = 8;
        }
    }

    static void exercise11(boolean czyPada, boolean czySwieci) {
        //plucha – gdy pada i nie świeci słońce,
        //tęcza – gdy pada i świeci słońce
        //słonecznie - gdy świeci słońce i nie pada,
        //pochmurno - gdy nie świeci słońce i nie pada.
        if(czyPada && !czySwieci) {
            System.out.println("Plucha");
        } else if(czyPada && czySwieci) {
            System.out.println("Tecza");
        } else if(!czyPada && czySwieci) {
            System.out.println("Slonecznie");
        } else {
            System.out.println("Pochmurno");
        }
    }



    //Następnie wykorzystaj instrukcję switch, aby dokonać takiej samej klasyfikacji jak w pierwszej części zadania.
    //////////////////        //////////////////        //////////////////        //////////////////
    //Zadeklaruj zmienną typu byte, której:
    //• bit0 (najmłodzy) będzie reprezentował stan zmiennej czyPada
    //• bit1 będzie reprezentował stan zmiennej czySwieciSlonce

    // 0 0 - nie pada i nie swieci slonce  = 0 // pochmurno
    // 0 1 - pada i nie swieci slonce  = 1 // plucha
    // 1 0 - nie pada i  swieci slonce  = 2 // słonecznie
    // 1 1 - pada i swieci slonce = 3  //

    //Dana jest zmienna typu boolean czy Pada oraz zmienna typu boolean czy Swieci Slonce, obie zainicjowane losową wartością. Przyjmij że jeżeli wylosowana wartość będzie mniejsza
    // niż 0.5 wówczas przypisana zostanie wartość true, a w przeciwnym przy- padku false.

    // i = 00 | 01 == 11
    // alternatywa bitowa
    // Orowanie przez zero nic nie zmienia
    // Orowanie prez 1 czysci na
    static void exercise12() {

        boolean czyPada = Math.random() < 0.5 ? true : false;
        boolean czySwieciSlonce = Math.random() < 0.5 ? true : false;

        // jesli obie sa false to wartosc = 00
        byte i = 0;

        //  b1 = slonce, b0 = padanie
        // Krok 1 true a) - 0b00 = 0b01 kiedy pada
        // Krok 1 false b) - 0b00 = 0b00 nic sie nie zmienia bo blok sie nie wykonuje
        if(czySwieciSlonce)
            i = (byte)(i | 0b01);

        // Krok 2 true a1) true dla swieci slonce 0b01 | 0b10 = 0b11
        // Krok 2 true a2) false dla swieci slonce 0b00 | 0b10 = 0b10
        if(czyPada)
            i = (byte)(i | 0b10);

        switch (i) {
            // case number 0
            case 0b00 -> System.out.println("pochmurno");
            // case number 1
            case 0b01 -> System.out.println("slonecznie");
            // case number 2
            case 0b10 -> System.out.println("plucha");
            // case number 3
            case 0b11 -> System.out.println("tecza");
        }
    }



}