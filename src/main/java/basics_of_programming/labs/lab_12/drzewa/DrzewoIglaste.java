package basics_of_programming.labs.lab_12.drzewa;

public class DrzewoIglaste extends Drzewo{

    private int iloscIgiel;
    private double dlugoscSzyszki;

    public DrzewoIglaste(boolean wiecznieZielone, int wysokosc, String przekrojDrzewa,
                         int iloscIgiel, double dlugoscSzyszki) {
        super(wiecznieZielone, wysokosc, przekrojDrzewa);
        this.iloscIgiel = iloscIgiel;
        this.dlugoscSzyszki = dlugoscSzyszki;
    }

    public int getIloscIgiel() { return iloscIgiel; }
    public double getDlugoscSzyszki() { return dlugoscSzyszki; }

    @Override
    public String toString() {
        return super.toString() + "Typ DrzewoIglaste{" +
                "iloscIgiel=" + iloscIgiel +
                ", dlugoscSzyszki=" + dlugoscSzyszki +
                '}';
    }

    @Override
    public String zerwijOwoc() throws DrzewoBezOwocoweException {
        return super.zerwijOwoc();
    }
}
