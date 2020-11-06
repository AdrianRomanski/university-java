package basics_of_programming.lectures.lecture_3;

public class PPJWin {

    public static void main(String[] args) {

        // Rodzaje instrukcji czynnych

        // pusta
        ;
        // grupujaca
        {
            System.out.println("Hello");
            // Zagniezdzona - nested
            {
                System.out.println("Darkness");
                System.out.println("My Old Friend");
            }
        }
        // koniec grupujacej

        // instrukcja deklaracyjna
    //  typ  nazwa


        byte byteNumber = 9;
        short shortNumber = 12;
        int number2 = 11;


        { // scope
            long number;
            number = 14L;
        } // end of scope

        long number;
        // Nie jawna konwersja na int
        number = 10;

        float floatNumber = 3.14f;
        var doubleNumber = 3.14;

        char znak = 'a';
        znak = '\177';
        znak = '\uFFFF';

        // Blad konwersja z Stringa na char
        // znak = "a";

        String str = "a";

        int wrt = 10;

        number2 = wrt;

        wrt = wrt + 1;

        wrt = 7 % 3; // 1

        wrt = wrt + 1;

        wrt++;
        ++wrt;

        wrt += 1;

        ////////////////////

        {
            int fix = 10;
            int fix2 = ++fix;
            System.out.println(fix2);
        }

        {
            int fix = 10;
            int fix2 = fix++;
            System.out.println(fix2);
            System.out.println(fix);
        }

        ////////////////////

        System.out.println(wrt == number2);
        System.out.println(wrt != number2);

        znak = 'a';
        str = "a";

        String str2 = "a";

        System.out.println(str == str2);

        ///////
        boolean boolVar = true;

        int wrt3 = boolVar ? 3 : 5;

        wrt = 99;
        // casting
        znak = (char) wrt;

        String strV1 = "oooo";
        String strV2 = "oooo";
        System.out.println(strV1 == strV2);



    }
}
