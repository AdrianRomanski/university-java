package basics_of_programming.labs.lab_12.dym;

public class DymMain {

    public static void main(String[] args) {

        DetektorDymu detektorDymu = new DetektorDymu();

        try {
            detektorDymu.sprawdz();
        } catch (Alarm alarm) {
            System.out.println(alarm.getMessage());
        }

        detektorDymu.setCzySiePali(true);

        try {
            detektorDymu.sprawdz();
        } catch (Alarm alarm) {
            System.out.println(alarm.getMessage());
        }
    }
}
