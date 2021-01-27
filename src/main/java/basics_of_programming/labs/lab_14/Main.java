package basics_of_programming.labs.lab_14;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    // '\n' '\r'
    // poslac system in do konstruktora inputStreamReaader
    // BufferedReader, readLine

    public static void main(String[] args) throws Exception {

        // Pattern dla bitow
        Pattern binaryPattern1 = Pattern.compile("[0-1]{4} [0-1]{4}");

        String binary = "1011 1001";

        System.out.println(binaryPattern1.matcher(binary).matches());

        // Pattern dla bitow
        Pattern binaryPattern2 = Pattern.compile("[1][0-1]{3} [1][0-1]{3}");

        String binary2 = "1000 1011";

        System.out.println(binaryPattern2.matcher(binary2).matches());


        System.out.println("Zadanie 3");
        Pattern binaryPattern3 = Pattern.compile("[a-c h]{4,9}");

        String test0 = "aaaabbcch";
        String test1 = "bbaaaacch";
        String test2 = "ccaaacch";
        String test3 = "bbaaaabbh";
        String test4 = "abch";

        System.out.println(binaryPattern3.matcher(test0).matches());
        System.out.println(binaryPattern3.matcher(test1).matches());
        System.out.println(binaryPattern3.matcher(test2).matches());
        System.out.println(binaryPattern3.matcher(test3).matches());
        System.out.println(binaryPattern3.matcher(test4).matches());


        String test5 = "aaaabbcchjgfj";
        String test6 = "bbaaaacchjghjhg";
        String test7 = "ccaaacchgg";
        String test8 = "bbaaaabbhghjg";
        String test9 = "abs";

        System.out.println(binaryPattern3.matcher(test5).matches());
        System.out.println(binaryPattern3.matcher(test6).matches());
        System.out.println(binaryPattern3.matcher(test7).matches());
        System.out.println(binaryPattern3.matcher(test8).matches());
        System.out.println(binaryPattern3.matcher(test9).matches());




    }

}
