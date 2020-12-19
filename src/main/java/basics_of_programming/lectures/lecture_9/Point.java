package basics_of_programming.lectures.lecture_9;

class Point {

    protected int x, y;

    public Point() {}

    public Point(int x) {
        this(x, 0);
    }

    public Point(int x, int y) {
        this.x = x;
    }

    @Override
    public String toString() {
        return super.toString() + " Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
