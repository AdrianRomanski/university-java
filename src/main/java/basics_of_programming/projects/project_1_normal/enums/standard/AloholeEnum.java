package basics_of_programming.projects.project_1_normal.enums.standard;

public enum AloholeEnum {

    PIWO(40),
    WINO(60),
    WINO_MUSUJACE(55),
    WODKA(30),
    CYDR(35);

    private double waga;

    AloholeEnum(double waga) {
        this.waga = waga;
    }

    public double getWaga() {
        return waga;
    }

}
