package basics_of_programming.lectures.lecture_14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstLast {

    public static void main(String[] args) {

        String text = null;
        try {
        byte[] bytes =
            Files.readAllBytes(Paths.get("FirstLast.txt"));
            text = new String(bytes);
        } catch(IOException e) {
            System.out.println("Problems...");
            System.exit(1);
        }

        String reg = "";
        Matcher m = Pattern.compile(reg).matcher(text); while (m.find())
        System.out.println(m.group());

    }

}
