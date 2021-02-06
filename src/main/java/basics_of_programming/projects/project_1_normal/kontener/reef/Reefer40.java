package basics_of_programming.projects.project_1_normal.kontener.reef;

import basics_of_programming.projects.project_1_normal.kontener.Kontener;

import static basics_of_programming.projects.project_1_normal.enums.KontenerEnum.REEFER_40;

public class Reefer40 extends Kontener {

    public Reefer40() {
        super(REEFER_40.dlugoscWnetrza, REEFER_40.szerokoscWnetrza, REEFER_40.wysokoscWnetrza,
                REEFER_40.szerokoscDrzwi, REEFER_40.wysokoscDrzwi, REEFER_40.pojemnoscKontenera,
                REEFER_40.wagaKontenera, REEFER_40.maksWagaLadunku,
                10, 11);
    }

    public Reefer40(String rodzajTowaru, Double wagaTowaru) {
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
