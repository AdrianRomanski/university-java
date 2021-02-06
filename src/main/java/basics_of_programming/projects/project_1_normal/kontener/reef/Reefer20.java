package basics_of_programming.projects.project_1_normal.kontener.reef;

import basics_of_programming.projects.project_1_normal.kontener.Kontener;

import static basics_of_programming.projects.project_1_normal.enums.KontenerEnum.REEFER_20;


public class Reefer20 extends Kontener {

    public Reefer20() {
        super(REEFER_20.dlugoscWnetrza, REEFER_20.szerokoscWnetrza, REEFER_20.wysokoscWnetrza,
                REEFER_20.szerokoscDrzwi, REEFER_20.wysokoscDrzwi, REEFER_20.pojemnoscKontenera,
                REEFER_20.wagaKontenera, REEFER_20.maksWagaLadunku,
                10, 11);
    }

    public Reefer20(String rodzajTowaru, Double wagaTowaru) {
        this();
        this.setAktualnaWagaLadunku(wagaTowaru);
        this.setRodzajLadunku(rodzajTowaru);
    }



    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "\t" + super.toString();
    }

    public String getRodzajKontenera() {
        return "Reefer";
    }
}

