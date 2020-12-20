package basics_of_programming.labs.lab_10;

public class Kwadrat {

    private double bok;

    public Kwadrat(double bok) {
        this.bok = bok;
    }

    public double getBok() {
        return bok;
    }

    public double getPoleKwadratu() {
        return bok * bok;
    }

    public double getObjetośćSześćianu() {
        return bok * bok * bok;
    }


    public double getPrzekatna() {
        return bok * Math.sqrt(3);
    }

    @Override
    public String toString() {
        return "Pole kwadratu o boku " + this.bok + " = " + getPoleKwadratu() + "\n"
                + "Objętość sześcianu " + getObjetośćSześćianu();
    }
}
