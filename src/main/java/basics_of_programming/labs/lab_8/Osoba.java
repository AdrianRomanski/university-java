package basics_of_programming.labs.lab_8;

public class Osoba {

    public String imie;
    public String nazwisko;
    public int rokUrodzenia;

    public Osoba() {}

    public Osoba(String imie, String naziwsko, int rokUrodzenia) {
        this.imie = imie;
        this.nazwisko = naziwsko;
        this.rokUrodzenia = rokUrodzenia;
    }

    public void show() {
        System.out.println(
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", rok urodzenia=" + rokUrodzenia);
    }
}
