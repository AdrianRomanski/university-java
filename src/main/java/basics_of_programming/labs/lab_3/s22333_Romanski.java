package basics_of_programming.labs.lab_3;

public class s22333_Romanski {

    public static void main(String[] args) {
         // exercise2(); // - gotowe
         // exercise2(); // - gotowe
         // exercise3(); // - gotowe
    }

    static void exercise1() {
        System.out.println("Zadanie pierwsze");
        // 1327 = 1024 (2**10) + 256(2 ** 8) + 32(2**5) + 8(2**3) + 4(2**2) + 2(2**1) + 1(2**0)
        int binarny = 0b0101_0010_1111;
        System.out.println("Binarnie = 0b0101_0010_1111 wynik = " + binarny);

        // Kazda cyfra w systemie ósemkowym odpowiada 3 w dwojkowym
        // 0101 0010 1111
        // 010 = 2,  100 = 4, 101 = 5, 111 = 7
        int oktalnie = 02457;
        System.out.println("Oktalnie = 02457 wynik = " + oktalnie);

        // Kazda cyfra w systemie szesnastkowym odpowiada 4 w dwojkowym
        // 0101 0010 1111
        // 0101 = 5, 0010 = 2, 1111 = F
        int heksadecymalnie = 0x52F;
        System.out.println("Heksadecymalnie = 0x52F wynik = " + heksadecymalnie);
    }

    static void exercise2() {
        System.out.println("Zadanie Drugie");
        //  1100
        int number12 = 0b1100;

        //  1000                  [1]100
        int number8 = number12 & 0b1000;
        //                         1000

        System.out.println("0b1100 &");
        System.out.println("0b1000");
        System.out.println("-------");
        System.out.println("0b1000");
        System.out.println(number8);
    }

    static void exercise3() {
        System.out.println("Zadanie Trzecie");
        // 1101 = 13
        byte x = 0xD;

        // Czy jest parzysta?
        //                                     xxxx_xxx1 - nieparzysta
        //                                     xxxx_xxx0 - parzysta
        byte resultCzyParzysta = (byte) (x & 0b0000_0001);
        //                                     xxxx_xxx1 - nieparzysta
        //                                     xxxx_xxx0 - parzysta
        // Gotowe

        // jesli wynik endowanie przez 1 jest rowny 0, to liczba jest parzysta,
        boolean czyParzysta = resultCzyParzysta == 0b0000_0000 ? true : false;

        System.out.println("Czy " + x + " jest liczba parzysta? " + czyParzysta);

        // czy wszystkie bity na nieparzystych pozycjach mają wartość 1.
        // 1010_1010 - pierwszy bit jest na pozycji 0

        //                               0b0000_1101
        byte resultPozycje = (byte) (x & 0b1010_1010);
        //                               0b1x1x_1x1x
        //                               0b0000_1000 - tylko jeden jest na nieparzystej pozycji dla liczby 13

        boolean czyWszystNaNieparzPoz = resultPozycje == 0b1010_1010 ? true : false;

        System.out.println("Czy wszystkie bity w liczbie " + x + " sa na nieparzystych pozycjach?");
        System.out.println("0b0000_1101 &");
        System.out.println("0b1010_1010");
        System.out.println("------------");
        System.out.println("0b0000_1000");
        System.out.println(czyWszystNaNieparzPoz);
    }


}
