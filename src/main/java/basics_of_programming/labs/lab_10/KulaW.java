package basics_of_programming.labs.lab_10;

public class KulaW {

    private double promien;

    public KulaW(Walec walec) {
        promien = Math.min(walec.getPromien(), walec.getWysokosc() / 2);
    }

    public KulaW(Kwadrat kwadrat) {
        promien = kwadrat.getBok() / 2;
    }

}
