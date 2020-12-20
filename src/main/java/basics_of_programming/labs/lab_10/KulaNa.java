package basics_of_programming.labs.lab_10;

public class KulaNa {

    private double promien;

    public KulaNa(Walec walec) {
        promien = Math.max(walec.getPromien(), walec.getWysokosc()) / 2;
    }

    public KulaNa(Kwadrat kwadrat) {
        promien = kwadrat.getPrzekatna() / 2;
    }

}
