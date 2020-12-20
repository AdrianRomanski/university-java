package basics_of_programming.labs.lab_10;

public class Pomegranate extends Fruit{

    private int seedCount;

    public Pomegranate(String name, int seedCount) {
        super(name);
        this.seedCount = seedCount;
    }

    @Override
    public String toString() {
        return super.toString() +  " ma " + seedCount + " nasion";

    }
}
