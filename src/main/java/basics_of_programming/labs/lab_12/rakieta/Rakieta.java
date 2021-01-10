package basics_of_programming.labs.lab_12.rakieta;

public class Rakieta {

    private String nazwa;
    private int wagaPaliwa;

    public Rakieta(String nazwa) {
        this.nazwa = nazwa;
    }

    public void zatankuj() {
        this.wagaPaliwa+=Math.random()*1000;
    }

    public void start() throws Exception {
        if(this.wagaPaliwa < 1000)
            throw new Exception("start anulowany - za malo paliwa");
        else
            System.out.println("Przygotowujemy sie do startu");
    }
}
