package basics_of_programming.lectures.lecture_12;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PPJwin {

    public static void main(String[] args) {


        try {
            FileOutputStream fos = new FileOutputStream("/Users/adrianromanski/Desktop/Java/university-java/src/main/java/basics_of_programming/lectures/lecture_12/test2");
            fos.write(12);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

