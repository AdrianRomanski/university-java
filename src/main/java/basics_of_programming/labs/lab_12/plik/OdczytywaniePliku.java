package basics_of_programming.labs.lab_12.plik;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OdczytywaniePliku {

    public static void main(String[] args) throws IOException {


        FileInputStream inputStream = new FileInputStream("src/main/java/basics_of_programming/labs/lab_12/plik/tekst.txt");

        byte[] bytes = inputStream.readAllBytes();
        char newChar;
        ArrayList<CharHelper> charHelpers = new ArrayList<>();
        boolean flag;

        for(byte b: bytes) {
            newChar = (char) b;
            flag = false;
            CharHelper temp = new CharHelper();
            for(CharHelper charHelper: charHelpers) {
                if(charHelper.getCharacter() == newChar) {
                    charHelper.incrementCount();
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                temp.setCharacter(newChar);
                charHelpers.add(temp);
            }
        }

        for(CharHelper charHelper: charHelpers) {
            System.out.println(charHelper);
        }

    }



}
