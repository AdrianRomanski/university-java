package basics_of_programming.lectures.lecture_9;

public class Point3d extends Point{

    protected int z;

    public Point3d(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }


    @Override
    public String toString() {
        return "Point3d{" +
                "z=" + z +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
