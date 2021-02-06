package basics_of_programming.projects.project_1_normal.enums.standard;

public enum MotoryzacjaEnum {

    MOTOR(650),
    SAMOCHOD_MIEJSKI(1100),
    SAMOCHOD_RODZINMY(1500),
    SKUTER(450),
    QUAD(2000);

    private double waga;

    MotoryzacjaEnum(double waga) {
        this.waga = waga;
    }

    public double getWaga() {
        return waga;
    }
}

