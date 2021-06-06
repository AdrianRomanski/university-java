package oop.exam;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        Informatyk informatyk1 = new Informatyk("Agrafka", 4);
        Informatyk informatyk2 = new Informatyk("Domino", 2);
        Informatyk informatyk3 = new Informatyk("Sztylet", 2);
        Administrator administrator1 = new Administrator("Poziomka", 4, "Unikatowa");
        Administrator administrator2 = new Administrator("Truskawka", 12, "Normalna");
        Administrator administrator3 = new Administrator("Banan", 14, "Zjawiskowa");
        Kierownik kierownik1 = new Kierownik("Kawa", 14, 22);
        Kierownik kierownik2 = new Kierownik("Herbata", 8, 13);
        Kierownik kierownik3 = new Kierownik("Woda", 13, 8);


        Informatyk[] informatycy = {informatyk1, informatyk2, informatyk3};
        Administrator[] administrators = {administrator1, administrator2, administrator3};
        Kierownik[] kierowniks = {kierownik1, kierownik2, kierownik3};
        Informatyk[] wszyscy = {informatyk1, informatyk2, informatyk3,
                                administrator1, administrator2, administrator3,
                                kierownik1, kierownik2, kierownik3};

        System.out.println("Przed sortowaniem informatykow, administratorow oraz kierownikow");
        System.out.println("**********************************************************************");
        print(informatycy, administrators, kierowniks);
        Arrays.sort(informatycy);
        Arrays.sort(administrators);
        Arrays.sort(kierowniks);

        System.out.println("**********************************************************************");
        System.out.println("Po sortowaniu informatykow, administratorow oraz kierownikow");
        print(informatycy, administrators, kierowniks);

        System.out.println("Przed sortowaniem wszystkich");
        System.out.println("**********************************************************************");

        Arrays.sort(wszyscy);

        System.out.println("Po sortowaniu wszystkich");
        System.out.println("**********************************************************************");
        for (Informatyk i : wszyscy) {
            System.out.println(i);
        }
        System.out.println("**********************************************************************");

    }

    private static void print(Informatyk[] informatycy, Administrator[] administrators, Kierownik[] kierowniks) {
        for (Informatyk i: informatycy) {
            System.out.println(i);
        }
        for (Administrator a: administrators) {
            System.out.println(a);
        }
        for (Kierownik k: kierowniks) {
            System.out.println(k);
        }
    }

}
