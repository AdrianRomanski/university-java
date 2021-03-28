package oop.labs.lab_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Zadanie5 {

    public static void main(String[] args) {

        List<Figura> figury = new ArrayList<Figura>();

        figury.add(new Kolo(10,5, 5));
        figury.add(new Kolo(10,5, 10));
        figury.add(new Prostokat(10,5, 4, 8));
        figury.add(new Prostokat(10,5, 4, 8));
        figury.add(new Prostokat(10,5, 2, 4));
        figury.add(new Prostokat(10,5, 2, 4));

        Collections.sort(figury);

        for(Figura f: figury) {
            System.out.println(f);
        }
    }
}

abstract class Figura implements Obliczanie, Comparable<Figura>{
    protected int x;
    protected int y;
    protected double pole;
    protected double obwod;
    protected static int globalIndex;
    protected int index;

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
        super.obwod = obliczObwod();
        super.pole = obliczPole();
        this.index = globalIndex++;
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
        return super.toString() + "\nPole - " + pole + "\nObwód - " + obwod + "\n" + "Index " + index;
    }

    @Override
    public double obliczPole() {
        return Math.PI * Math.pow(this.promien, 2);
    }

    @Override
    public double obliczObwod() {
        return Math.PI * (2 * this.promien);
    }

    @Override
    public int compareTo(Figura o) {
        return 0;
    }
}

class Prostokat extends Figura{
    protected int szer, wys;

    public Prostokat(int x, int y, int s, int w) {
        super(x, y);
        this.szer = s;
        this.wys = w;
        super.obwod = obliczObwod();
        super.pole = obliczPole();
        this.index = globalIndex++;
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
        return super.toString() + "\nPole - " + pole + "\nObwód - " + obwod + "\n" + "Index " + index;
    }

    @Override
    public double obliczPole() {
        return this.wys * this.szer;
    }

    @Override
    public double obliczObwod() {
        return 2 * this.wys + 2 * this.szer;
    }

    @Override
    public int compareTo(Figura figura) {
        if (!(this.obwod == figura.obwod)) {
            return (int) (this.obwod - figura.obwod);
        } else if (!(this.pole == figura.pole)) {
            return (int) (this.pole - figura.pole);
        } else {
            return this.index - figura.index;
        }
    }
}

interface Obliczanie {
    double obliczPole();
    double obliczObwod();
}



