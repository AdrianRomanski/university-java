package basics_of_programming.labs.lab_13.strumienie;

import java.io.*;

public class Strumienie {

    public static void main(String[] args) throws IOException {

        final String path = "src/main/java/basics_of_programming/labs/lab_13/strumienie/TestStrumienia.java";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        WordHelper[] words = {new WordHelper("public"), new WordHelper("private"), new WordHelper("String")};

        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }

        String completeString = stringBuilder.toString();
        String[] splitted = completeString.split(" ");

        for(String s: splitted) {
            for(WordHelper w: words) {
                if(w.getWord().equals(s))
                    w.incrementCount();
            }
        }

        for(WordHelper w: words) {
            System.out.println(w);
        }
    }
}
