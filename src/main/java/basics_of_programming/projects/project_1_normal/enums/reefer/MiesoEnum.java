package basics_of_programming.projects.project_1_normal.enums.reefer;

public enum MiesoEnum {

    WOLOWINA(320),
    KURCZAK(450),
    WIEPRZOWINA(380),
    CIELECINA( 315),
    SARNINA(300);

    private double waga;

    MiesoEnum(int waga) {
        this.waga = waga;
    }

    public double getWaga() {
        return waga;
    }
}



