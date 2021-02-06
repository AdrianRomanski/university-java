package basics_of_programming.projects.project_1_normal.enums.standard;

public enum PrzyprawyEnum {

    PIEPRZ(120),
    SOL(80),
    PAPRYKA(140),
    KURKUMA(120),
    CYNAMON(100);

    private double waga;

    PrzyprawyEnum(double waga) {
        this.waga = waga;
    }

    public double getWaga() {
        return waga;
    }
}
