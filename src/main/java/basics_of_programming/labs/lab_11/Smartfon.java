package basics_of_programming.labs.lab_11;

public class Smartfon extends Komórka{

    private Osoba[] znajomi;
    private int counter;
    private int currentSize;

    public Smartfon(String interfejsKomunikacyjny, String color) {
        super(interfejsKomunikacyjny, color);
        this.currentSize = 5;
        this.znajomi = new Osoba[currentSize];
    }

    public Osoba[] getZnajomi() { return znajomi; }

    public void wyswietlHistoriePolaczen() {
        boolean flag;
        for(String s: getOstatniePolaczenia()) {
            flag = false;
            for(Osoba o: znajomi) {
                if(o!=null && o.getNumer().equals(s)) {
                    System.out.println(o.getImie() + " "  + s);
                    flag=true;
                }
            }
            if(!flag && s!=null)
                System.out.println(s);
        }
    }

    public void dodajZnajomego(Osoba osoba) {
        if(currentSize > counter) {
            this.znajomi[counter++] = osoba;
        } else {
            Osoba[] nowiZnajomi = new Osoba[currentSize*2];
            for(int i = 0; i < counter; i++) {
                nowiZnajomi[i] = znajomi[i];
            }
            nowiZnajomi[counter++] = osoba;
            this.znajomi = nowiZnajomi;
        }
    }
}
