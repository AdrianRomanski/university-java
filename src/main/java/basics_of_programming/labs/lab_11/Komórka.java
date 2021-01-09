package basics_of_programming.labs.lab_11;

public class Komórka extends Telefon{

    private String[] ostatniePolaczenia;
    private int counter;

    public Komórka(String interfejsKomunikacyjny, String color) {
        super(interfejsKomunikacyjny, color);
        this.ostatniePolaczenia = new String[10];
    }


    @Override
    public void zadzwon(String numer) {
        super.zadzwon(numer);
        if(counter == ostatniePolaczenia.length) {
           for(int i = 0; i < counter-1; i++) {
               ostatniePolaczenia[i] = ostatniePolaczenia[i+1];
           }
           ostatniePolaczenia[ostatniePolaczenia.length-1] = numer;
        } else {
            ostatniePolaczenia[counter++] = numer;
        }
    }

    public void wyswietlHistoriePolaczen() {
        for(String s: ostatniePolaczenia) {
            System.out.println(s);
        }
    }

    public String[] getOstatniePolaczenia() {
        return ostatniePolaczenia;
    }
}
