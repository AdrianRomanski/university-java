package basics_of_programming.projects.project_1_normal.enums.reefer;

public enum WarzywaEnum {

    ZIEMNIAK(240),
    PAPRYKA(180),
    CEBULA(140),
    CUKINIA( 165),
    POMIDOR(190);

    private double waga;

    WarzywaEnum(int waga) {
        this.waga = waga;
    }

    public double getWaga() {
        return waga;
    }
}
