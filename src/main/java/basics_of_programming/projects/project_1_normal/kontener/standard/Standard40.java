package basics_of_programming.projects.project_1_normal.kontener.standard;

import basics_of_programming.projects.project_1_normal.kontener.Kontener;

import static basics_of_programming.projects.project_1_normal.enums.KontenerEnum.STANDARD_40;

public class Standard40 extends Kontener {

    public Standard40() {
        super(STANDARD_40.dlugoscWnetrza, STANDARD_40.szerokoscWnetrza, STANDARD_40.wysokoscWnetrza,
                STANDARD_40.szerokoscDrzwi, STANDARD_40.wysokoscDrzwi, STANDARD_40.pojemnoscKontenera,
                STANDARD_40.wagaKontenera, STANDARD_40.maksWagaLadunku, 21, 24);
    }

    public Standard40(String rodzajTowaru, Double wagaTowaru) {
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


