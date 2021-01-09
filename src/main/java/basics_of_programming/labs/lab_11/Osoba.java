package basics_of_programming.labs.lab_11;

public class Osoba {

    private String imie;
    private String nazwisko;
    private String numer;

    public Osoba(String imie, String nazwisko, String numer) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numer = numer;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getNumer() {
        return numer;
    }
}
