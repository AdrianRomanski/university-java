package basics_of_programming.lectures.lecture_9_10;

class Point {

    protected int x, y;

    public Point() {}

    public Point(int x) {
        this(x, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return super.toString() + " Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public boolean equals(Point point) {
        if(this == point)
            return true;
        return this.y == point.y && this.x == point.x;
    }

}
