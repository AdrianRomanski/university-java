package basics_of_programming.lectures.lecture_9_10;

import java.util.Objects;

public class Point3d extends Point{

    protected int z;

    public Point3d(int x, int y, int z) {
        super(x, y);
        this.z = z;
        System.out.println(this);
    }

    public final void show() {
        System.out.println("z: " + z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3d point3d = (Point3d) o;
        return z == point3d.z;
    }


    public boolean equals(Point3d point3d) {
        if(this == point3d)
            return true;
        return super.equals(point3d) && this.z == point3d.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(z);
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
