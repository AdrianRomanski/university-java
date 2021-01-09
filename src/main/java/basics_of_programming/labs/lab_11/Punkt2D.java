package basics_of_programming.labs.lab_11;

public class Punkt2D {

    private double x;
    private double y;

    public Punkt2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }


    public double odleglosc(Punkt2D punkt2D) {
        return Math.sqrt(Math.pow(this.y - this.x, 2) + Math.pow(punkt2D.y - punkt2D.x, 2));
    }

}
