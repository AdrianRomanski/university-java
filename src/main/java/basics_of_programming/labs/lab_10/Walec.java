package basics_of_programming.labs.lab_10;

public class Walec {

    private double promien; // r
    private double wysokosc; // h

    public Walec(double promien, double wysokosc) {
        this.promien = promien;
        this.wysokosc = wysokosc;
    }

    public double getPromien() {
        return promien;
    }

    public double getWysokosc() {
        return wysokosc;
    }

    public double getPolePodstawy() {
        return Math.PI * Math.pow(this.promien, 2);
    }

    public double getObjetość() {
        return getPolePodstawy() * this.wysokosc;
    }

    @Override
    public String toString() {
        return "Walec o promieniu " + this.promien + " i wysokosci " + this.wysokosc + "\n" +
                "posiada pole podstawy rowne " + getPolePodstawy() + " oraz objetosc rowna " + getObjetość();
    }
}
