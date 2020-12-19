package basics_of_programming.lectures.lecture_9_10;


public class Main {

    public static void main(String[] args) {

        Point p1 = new Point();
        Point p2 = new Point(10, 20);

        System.out.println(p1.toString());
        System.out.println(p2.toString());


        Point3d point1 = new Point3d(10,20,30);
        Point3d point2 = new Point3d(10,20,30);

        point2.show();

        Object obj = point1;

        System.out.println(obj.toString());

        Object[] tab = new Object[10];
        tab[0] = point1;
        tab[0].equals(point2);

        System.out.println(tab[11]);

    }
}


