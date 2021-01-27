package basics_of_programming.labs.lab_14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Osoba {

    private String name;
    private String lastName;
    private int rokUrodzenia;
    private boolean plec;
    short kodPocztowy;


    public Osoba() throws Exception {
        final Pattern stringPattern = Pattern.compile("[a-zA-Z]{3,14}");
        final Pattern numberPattern = Pattern.compile("\\d{4}");
        final Pattern codePattern = Pattern.compile("\\d{5}");
//        final Pattern booleanPattern1 = Pattern.compile("[true]");
//        final Pattern booleanPattern2 = Pattern.compile("[false]");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String name = bufferedReader.readLine();
        if(stringPattern.matcher(name).matches())
            this.name = name;
        else
            throw new NiewlasciweDaneException(name);

        String lastName = bufferedReader.readLine();
        if(stringPattern.matcher(lastName).matches())
            this.lastName = lastName;
        else
            throw new NiewlasciweDaneException(lastName);

        String rokUrodzenia = bufferedReader.readLine();
        if(numberPattern.matcher(rokUrodzenia).matches())
            this.rokUrodzenia = Integer.parseInt(rokUrodzenia);
        else
            throw new NiewlasciweDaneException(rokUrodzenia);

//        String plec = bufferedReader.readLine();
//        if(booleanPattern1.matcher(plec).matches() || booleanPattern2.matcher(plec).matches())
//            this.plec = booleanPattern1.matcher(plec).matches() ? true : false;
//        else
//            throw new NiewlasciweDaneException(plec);

        String kodPocztowy = bufferedReader.readLine();
        if(codePattern.matcher(kodPocztowy).matches())
            this.kodPocztowy = Short.parseShort(kodPocztowy);
        else
            throw new NiewlasciweDaneException(kodPocztowy);
    }
}
