package basics_of_programming.labs.lab_12.drzewa;

public class DrzewoLisciaste extends Drzewo{

    private String ksztaltLiscia;

    public DrzewoLisciaste(boolean wiecznieZielone, int wysokosc, String przekrojDrzewa, String ksztaltLiscia) {
        super(wiecznieZielone, wysokosc, przekrojDrzewa);
        this.ksztaltLiscia = ksztaltLiscia;
    }

    public String getKsztaltLiscia() { return ksztaltLiscia; }

    @Override
    public String toString() {
        return super.toString() + " Typ: DrzewoLisciaste{" +
                "ksztaltLiscia=" + ksztaltLiscia +
                '}';
    }

    @Override
    public String zerwijOwoc() throws DrzewoBezOwocoweException {
        return super.zerwijOwoc();
    }
}
