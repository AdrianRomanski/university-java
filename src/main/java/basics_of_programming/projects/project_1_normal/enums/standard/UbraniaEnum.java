package basics_of_programming.projects.project_1_normal.enums.standard;

public enum UbraniaEnum {

    KOSZULKA(230),
    SPODNIE(340),
    BLUZA(420),
    KURTKA(315),
    SKARPETKI(180);

    private double waga;

    UbraniaEnum(double waga) {
        this.waga = waga;
    }

    public double getWaga() {
        return waga;
    }
}
