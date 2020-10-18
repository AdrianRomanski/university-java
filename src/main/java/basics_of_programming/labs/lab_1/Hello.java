package basics_of_programming.labs.lab_1;

public class Hello {

    public static void main(String[] args) {

        byte a =  (byte) 0b00001010;
        byte b =  (byte) 0b00001001;
        byte c =  (byte) 0b11111111;

        // Xsorowanie ^ (bitwise XOR)
        System.out.println("Xorowanie");
        System.out.println("a^b=" + (a^b));

        // Xsorowanie przez zero
        System.out.println("Nic nie zmiania - Xsorowanie przez zero");
        System.out.println("a^0=" +  (a^0));

        // Xsorowanie przez jedynki
        System.out.println("Xorowanie przez jedynki - Negacja - Odwraca bity");
        System.out.println("a^c=" + (a^c));

        //Endowanie & (bitwise and)
        System.out.println("Endowanie");
        System.out.println("a&b=" +  (a&b));

        // Endowanie przez zero
        System.out.println("Czyszczenie - Endowanie przez zero");
        System.out.println("a&0=" + (a&0));

        // Endowanie przez jedynki
        System.out.println("Nic nie zmiania - Endowanie przez jedynki");
        System.out.println("a&c=" + (a&c));

        //Orowanie |(bitwise or)
        System.out.println("Orowanie");
        System.out.println("a|b=" + (a|b));

        // Orowanie przez zero
        System.out.println("Nic nie zmiania - Orowanie przez zero");
        System.out.println("a|0=" +  (a|0));

        // Orowanie przez jedynki
        System.out.println("Czyszczenia - Orowanie przez jedynki");
        // Java byte value 1111 1111 = - 1
        System.out.println("Wartosc signed byte dla 1111 1111 to -1");
        System.out.println("a|c=" + (a|c));

        // << (left shift)
        System.out.println("a<<b=" + (a<<b));

        // >> (right shift)
        System.out.println("a>>b=" + (a>>b));

        // >>> (zero fill right shift)
        System.out.println("a<<<b=" + (a>>>b));

    }
}

