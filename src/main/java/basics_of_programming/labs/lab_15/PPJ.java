package basics_of_programming.labs.lab_15;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PPJ {

    public static void main(String[] args) {
                    // 0        1       2         3          4       5           6      7     8
        String str = "Lisboa (Lisbon, Portugal), Warszawa (Warsaw, Poland), and Roma (Rome, Italy)";

        String pattern2 = "([(),])";

        String replaced = str.replaceAll(pattern2, "");

        String[] split = replaced.split(" ");

        String[] split2 = new String[split.length-1];

        int index = 0;

        for (String value : split) {
            if (!value.equals("and")) {
                split2[index++] = value;
            }
        }

        for(int i = 1; i < split2.length-1; i+=3) {
            System.out.println(split2[i+1] + " -> " + split2[i]);
        }
    }
}
