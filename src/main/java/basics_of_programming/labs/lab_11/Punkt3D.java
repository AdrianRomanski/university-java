package basics_of_programming.labs.lab_11;

public class Punkt3D extends Punkt2D {

    private int z;

    public Punkt3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() { return z; }

    public double odleglosc(Punkt3D punkt3D) {
        return Math.sqrt(Math.pow(this.getY() - this.getX(), 2)
                + Math.pow(punkt3D.getY() - punkt3D.getX(), 2)
                + Math.pow(this.getZ() - punkt3D.getZ(), 2));
    }


}
