package basics_of_programming.labs.lab_11;

public class Telefon {

    private String interfejsKomunikacyjny;
    private String color;

    public Telefon(String interfejsKomunikacyjny, String color) {
        this.interfejsKomunikacyjny = interfejsKomunikacyjny;
        this.color = color;
    }

    public void zadzwon(String numer) {
        System.out.println("Dzwonisz na numer: " + numer);
    }

    public void wyswietlHistoriePolaczen() {
        System.out.println("brak historii");
    }

}
