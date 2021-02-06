package basics_of_programming.projects.project_1_normal.enums.reefer;

public enum RybyEnum {

    DORSZ(420),
    LOSOS(370),
    SARDYNKA(250),
    DORADA( 315),
    PSTRAG(220);

    private double waga;

    RybyEnum(int waga) {
        this.waga = waga;
    }

    public double getWaga() {
        return waga;
    }
}

