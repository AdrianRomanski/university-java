package basics_of_programming.projects.project_1_normal.enums.reefer;

public enum OwoceEnum {

    BANAN(420),
    TRUSKAWKA(315),
    JABLKO(170),
    GRUSZKA(150),
    ARBUZ(230);

    private double waga;

    OwoceEnum(int waga) {
        this.waga = waga;
    }

    public double getWaga() {
        return waga;
    }
}
