package basics_of_programming.projects.project_1_normal.kontener.standard;

import basics_of_programming.projects.project_1_normal.kontener.Kontener;

import static basics_of_programming.projects.project_1_normal.enums.KontenerEnum.*;

public class Standard20 extends Kontener {

    public Standard20() {
        super(STANDARD_20.dlugoscWnetrza, STANDARD_20.szerokoscWnetrza, STANDARD_20.wysokoscWnetrza,
                STANDARD_20.szerokoscDrzwi, STANDARD_20.wysokoscDrzwi, STANDARD_20.pojemnoscKontenera,
                STANDARD_20.wagaKontenera, STANDARD_20.maksWagaLadunku,
                10, 11);
    }

    public Standard20(String rodzajTowaru, Double wagaTowaru) {
        this();
        this.setAktualnaWagaLadunku(wagaTowaru);
        this.setRodzajLadunku(rodzajTowaru);
    }



    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "\t" + super.toString();
    }

    public String getRodzajKontenera() {
        return "Standard";
    }
}
