package oop.labs.lab_2;

public class Exercise3 {

    public static void main(String[] args)
    {
        Figura[] fig = new Figura[2];
        fig[0] = new Kolo(10, 10, 5);
        fig[1] = new Prostokat(20, 20, 15, 10);

        for (Figura f : fig)
            System.out.println(f);

        fig[0].pozycja(12, 12);
        fig[1].pozycja(25, 30);

        System.out.println(fig[0].obliczObwod());
        System.out.println(fig[0].obliczPole());

        Prostokat2 p2 = new Prostokat2(20, 20, 10, 5, '*');
        p2.rysuj();
    }
}

interface Obliczanie {
    double obliczPole();
    double obliczObwod();
}

interface Rysowanie {
    void rysuj();
}

interface Przesuniecie {
    void przesunDo(int x, int y);
    void powrot();
}

abstract class Figura implements Obliczanie{
    protected int x;
    protected int y;

    public Figura(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract String fig();
    public abstract void pozycja(int x, int y);

    @Override
    public String toString() { return fig(); }
}

class Kolo extends Figura {
    private final int promien;

    public Kolo(int x, int y, int r) {
        super(x, y);
        this.promien = r;
    }

    @Override
    public String fig() { return "Koło"; }

    @Override
    public void pozycja(int x, int y) {
        boolean flag = true;
        if (x > super.x) {
            if (x > super.x + this.promien)
                flag = false;
        } else if (x < super.x) {
            if (x < super.x - this.promien)
                flag = false;
        }
        if (y > super.y) {
            if (y > super.y + this.promien)
                flag = false;
        } else if (y < super.y) {
            if (y < super.y + this.promien)
                flag = false;
        }
        String pozycja = flag ? "wewnatrz" : "zewnatrz";
        System.out.println("Punkt (" + x + "," + y + ") znajduje sie " + pozycja + " koła");
    }

    @Override
    public String toString() {
        return super.toString() + "\nŚrodek - (" + x + ',' + y + ")" + "\nPromień - " + promien + "\n";
    }

    @Override
    public double obliczPole() {
        return Math.PI * Math.pow(this.promien, 2);
    }

    @Override
    public double obliczObwod() {
        return Math.PI * (2 * this.promien);
    }
}

class Prostokat extends Figura{
    protected int szer, wys;

    public Prostokat(int x, int y, int s, int w) {
        super(x, y);
        this.szer = s;
        this.wys = w;
    }

    @Override
    public String fig() { return "Prostokat"; }

    @Override
    public void pozycja(int x, int y) {
        boolean flag=true;
        if(!(x < super.x || y > super.y)) {
           if(y < super.y - wys)
               flag=false;
           if(x > super.x + szer)
               flag=false;
        } else
            flag = false;

        String pozycja = flag ? "wewnatrz" : "zewnatrz";
        System.out.println("Punkt (" + x + "," + y + ") znajduje sie " + pozycja + " Prostokąta");
    }

    @Override
    public String toString() {
        return super.toString() + "\nLewy górny - (" + x + ',' + y + ")" + "\nSzerokość: " + szer + ", " + "Wysokość: " + wys + "\n";
    }

    @Override
    public double obliczPole() {
        return this.wys * this.szer;
    }

    @Override
    public double obliczObwod() {
        return 2 * this.wys + 2 * this.szer;
    }
}

class Prostokat2 extends Prostokat implements Rysowanie{
    private final char znak;

    public Prostokat2(int x, int y, int s, int w, char znak) {
        super(x, y, s, w);
        this.znak = znak;
    }

    @Override
    public void rysuj() {
        for(int i = 0; i < wys; i++) {
            for(int j = 0; j < szer; j++) {
                System.out.print(znak);
            }
            System.out.println();
        }
    }
}

class Kolo2 extends Kolo implements Przesuniecie {
    private int xBefore;
    private int yBefore;

    public Kolo2(int x, int y, int r) {
        super(x, y, r);
    }

    @Override
    public void przesunDo(int x, int y) {
        this.xBefore = this.x;
        this.yBefore = this.y;
        this.x = x;
        this.y = y;
    }

    @Override
    public void powrot() {
        this.x = this.xBefore;
        this.y = this.yBefore;
    }
}
