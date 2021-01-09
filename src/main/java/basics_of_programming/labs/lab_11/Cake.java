package basics_of_programming.labs.lab_11;

public class Cake {


    private String creator;
    private double mass;
    private int barCode;

    public Cake(String creator, double mass, int barCode) {
        this.creator = creator;
        this.mass = mass;
        this.barCode = barCode;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "creator='" + creator + '\'' +
                ", mass=" + mass +
                ", barCode=" + barCode +
                '}';
    }
}
