package basics_of_programming.lectures.lecture_14;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PPJ {

    public static void main(String[] args) {

        String str = "23.01.2021";

        int sep = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '.') {
                System.out.println(
                        str.substring(sep, i)
                );
                sep=i+1;
            }
        }

        System.out.println("******************");

        for(String s: str.split("\\."))
            System.out.println(s);

        System.out.println("******************");

        {
            Pattern p = Pattern.compile("[2][0-9][/.-][0][1][/.-][2][0][2][1]");
            Matcher m = p.matcher(str);
            System.out.println(
                    m.matches()
            );
        }


        System.out.println("******************");


        {
            Pattern p = Pattern.compile("[1][2][3][^b]");
            Matcher m = p.matcher("123b");
            System.out.println(
                   "negacja -" + m.matches()
            );
        }


        // [0-9a-zA-Z]

        {
            Pattern p = Pattern.compile("[1][2][3][0-9a-zA-Z]");
            Matcher m = p.matcher("123b");
            System.out.println(
                    "zasieg -" + m.matches()
            );
        }


        //[a-z&&^bf]
        {
            Pattern p = Pattern.compile("[1][2][3][a-z&&[def]]");
            Matcher m = p.matcher("123e");
            System.out.println(
                    "przeciecie -" + m.matches()
            );
        }

        //[0-9]{n}
        //[0-9]{n, m}
        //[0-9]{n,}

        //[0-9]? ==> [0-9]{0,1}
        //[0-9]+ ==> [0-9]{1,}
        //[0-9]* ==> [0-9]{0,}

        {
            Pattern p = Pattern.compile("[0-9]{3}[a-z&&[def]]");
            Matcher m = p.matcher("789e");
            System.out.println(
                    "krotnosc -" + m.matches()
            );
        }

        // \d ==> [0-9]
        // \D ==> [^0-9]
        // \s ==> [\t\n\r\x0B]
        // \S ==> [^\t\n\r\x0B]
        // \w
        // \W

        {
            Pattern p = Pattern.compile("\\d{3}[a-z&&[def]]");
            Matcher m = p.matcher("789e");
            System.out.println(
                    "- " + m.matches()
            );
        }

        // . - dowolny znak


        {
            Pattern p = Pattern.compile(".*");
            Matcher m = p.matcher("sdasgsagsa7868#@@");
            System.out.println(
                    "- " + m.matches()
            );
        }


        /*



         */

        {
            String data = "23.01.2021";
            Pattern p = Pattern.compile("(((0[1-9])|([1-2]\\d)|(3[0-1]))\\.((0[1-9])|(1[0-2]))\\.\\d{1,4})");
            Matcher m = p.matcher(data);
            System.out.println(
                    "data " + m.matches()
            );

            int ref = 0;

            while (m.find()) {
                System.out.println(
                        data.substring(ref, m.start())
                );
                ref = m.start()+1;
            }
        }

    }

}
