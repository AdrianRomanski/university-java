package oop.lectures.lecture_1;

public class Main {

    public static void main(String[] args) {


        FigGeom[] arr = {
                new Circle(10),
                new Square(5)
        };

        for(FigGeom f : arr)
            System.out.println(f.getField());
    }


}


interface Comparable {
    int compare(Object o);
}

interface I {
    void a();
    void b();
    void c();
    void d();
    void e();
}

abstract class FigGeom implements Comparable, I{
    public abstract double getField();

    public String toString() {
        return "FigGeom";
    }
    public void a(){};
    public void b(){};
    public void c(){};
    public void d(){};
    public void e(){};
}

class  Circle extends FigGeom {
    protected  double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getField() {
        return Math.PI * (radius * radius);
    }

    @Override
    public String toString() {
        return super.toString() + "Circle{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public int compare(Object o) {
        return 0;
    }
}

class Square extends  FigGeom {

    protected double bok;

    public Square(double bok) {
        this.bok = bok;
    }

    @Override
    public double getField() {
        return bok * bok;
    }

    @Override
    public int compare(Object o) {
        return 0;
    }
}


