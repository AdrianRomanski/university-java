package basics_of_programming.projects.project_1_normal.enums;

public enum KontenerEnum {

    STANDARD_20(5.900, 2.350, 2.393,
            2.342, 2.280, 33.2,2230,21770,  "Standard"),
    STANDARD_40(12.036, 2.350, 2.392,
                        2.340, 2.280, 67.7,3700,26780,  "Standard"),
    REEFER_20(5.900, 2.350, 2.393,
            2.342, 2.280, 33.2,2230,21770,  "Reefer"),
    REEFER_40(12.010, 2.330, 2.690,
                        2.330, 2.560, 76.28,3968,26512,  "Reefer");


    public final double dlugoscWnetrza;
    public final double szerokoscWnetrza;
    public final double wysokoscWnetrza;
    public final double szerokoscDrzwi;
    public final double wysokoscDrzwi;
    public final double pojemnoscKontenera;
    public final double wagaKontenera;
    public final double maksWagaLadunku;
    public final String rodzajKontenera;

    KontenerEnum(double dlugoscWnetrza, double szerokoscWnetrza,
                 double wysokoscWnetrza, double szerokoscDrzwi, double wysokoscDrzwi,
                 double pojemnoscKontenera, double wagaKontenera, double maksWagaLadunku, String rodzajKontenera) {
        this.dlugoscWnetrza = dlugoscWnetrza;
        this.szerokoscWnetrza = szerokoscWnetrza;
        this.wysokoscWnetrza = wysokoscWnetrza;
        this.szerokoscDrzwi = szerokoscDrzwi;
        this.wysokoscDrzwi = wysokoscDrzwi;
        this.pojemnoscKontenera = pojemnoscKontenera;
        this.wagaKontenera = wagaKontenera;
        this.maksWagaLadunku = maksWagaLadunku;
        this.rodzajKontenera = rodzajKontenera;
    }
}
