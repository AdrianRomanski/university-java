package basics_of_programming.labs.lab_12.dym;

public class DetektorDymu {

    private boolean czySiePali;

    public DetektorDymu() {
        this.czySiePali = false;
    }

    public boolean isCzySiePali() { return czySiePali; }
    public void setCzySiePali(boolean czySiePali) { this.czySiePali = czySiePali; }

    public void sprawdz() throws Alarm {
        if(czySiePali)
            throw new Alarm();
        else
            System.out.println("Wszystko jest ok");
    }
}
