package basics_of_programming.lectures.lecture_2;

public class PPJWin {

    public static void main(String[] args) {
        System.out.println("Hello PPJ");
        System.out.println("Hello PPJ");

//      System.out.println(null);

        System.out.println(5);
        System.out.println(05); // 5 - Octal Decimal 1 * 10^1 + 5 * 10^0

        System.out.println(15);
        System.out.println(015); // 13 - Octal Decimal 8^1 + 5 * 8^0 => 13

        System.out.println(15L);
        System.out.println(15l);

        System.out.println(0x15); // 21

        System.out.println(0b0001_0110); // 22

        System.out.println('a');
        System.out.println('0');
        System.out.println('O');

        System.out.println('\t');
        System.out.println('\uFFFF'); // UTF-16

        System.out.println(1e-9d);
        System.out.println(1e127);
    }
}
