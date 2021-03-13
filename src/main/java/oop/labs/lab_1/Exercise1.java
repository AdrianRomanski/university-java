package oop.labs.lab_1;

public class Exercise1 {

    public static void main(String[] args) {
        Muzyk[] muzycy = {new Skrzypek("Aleks", 2),
                new Wiolonczelista("Bartek", 1),
                new Flecista("Czarek", 0.5)};
        for (Muzyk m : muzycy)
            System.out.println("Muzyk: " + m.imie() + '\n' +
                    "Instrument: " + m.instrument() + '\n' +
                    "Czas wystąpienia: " + m.czas() + " godz. " + '\n' +
                    "Stawka godzinowa: " + m.stawka() + '\n');

        System.out.println(Muzyk.maxHonorarium(muzycy));
    }
}

abstract class Muzyk {
    private final String imie;
    private final double czas;

    protected Muzyk(String imie, double czas) {
        this.imie = imie;
        this.czas = czas;
    }

    protected String imie() {return this.imie; }
    protected double czas() { return this.czas; }

    abstract protected String instrument();
    abstract protected double stawka();

    @Override
    public String toString() {
        return imie + ", czas = " + czas + " godz., stawka = " + stawka();
    }

    public static Muzyk maxHonorarium(Muzyk[] muzycy) {
        double max = 0;
        int maxIndex = 0;
        for(int i =0; i < muzycy.length; i++) {
            if((muzycy[i].stawka() * muzycy[i].czas) > max) {
                maxIndex=i;
                max=(muzycy[i].stawka() * muzycy[i].czas);
            }
        }
        return muzycy[maxIndex];
    }
}

class Flecista extends Muzyk {
    public Flecista(String nazwisko, double czas) {
        super(nazwisko, czas);
    }

    @Override
    public String instrument() { return "flet"; }

    @Override
    public double stawka() { return 300; }
}

class Wiolonczelista extends Muzyk {
    public Wiolonczelista(String nazwisko, double czas) {
        super(nazwisko, czas);
    }

    @Override
    public String instrument() { return "wiolonczela"; }

    @Override
    public double stawka() { return 250; }
}

class Skrzypek extends Muzyk {
    public Skrzypek(String nazwisko, double czas) {
        super(nazwisko, czas);
    }

    @Override
    public String instrument() { return "skrzypce"; }

    @Override
    public double stawka() { return 200; }
}


