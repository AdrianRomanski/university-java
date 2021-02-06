package basics_of_programming.projects.project_1_normal.produkt;

public class Produkt {

    private String nazwa;
    private double waga;

    public Produkt(String nazwa, double waga) {
        this.nazwa = nazwa;
        this.waga = waga;
    }

    public double getWaga() {
        return waga;
    }
}
