package basics_of_programming.labs.lab_12.drzewa;

public class DrzewoOwocowe extends DrzewoLisciaste{

    private String nazwaOwoca;

    public DrzewoOwocowe(boolean wiecznieZielone, int wysokosc, String przekrojDrzewa,
                         String ksztaltLiscia, String nazwaOwoca) {
        super(wiecznieZielone, wysokosc, przekrojDrzewa, ksztaltLiscia);
        this.nazwaOwoca = nazwaOwoca;
    }

    @Override
    public String toString() {
        return super.toString() + " PodTyp: DrzewoOwocowe{" +
                "nazwaOwoca='" + nazwaOwoca + '\'' +
                '}';
    }

    @Override
    public String zerwijOwoc(){
        return nazwaOwoca + " zostala zerwana";
    }
}
