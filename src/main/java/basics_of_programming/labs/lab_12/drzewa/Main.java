package basics_of_programming.labs.lab_12.drzewa;

public class Main {

    public static void main(String[] args){


        DrzewoIglaste sosna = new DrzewoIglaste(true, 4, "duzy", 400000, 2.5);
        DrzewoIglaste modrzew = new DrzewoIglaste(true, 6, "sredni", 620000, 3.3);
        DrzewoLisciaste dab = new DrzewoLisciaste(false, 6, "duzy", "uszate");
        DrzewoLisciaste topola = new DrzewoLisciaste(false, 4, "sredni", "sercowate");
        DrzewoOwocowe morelowce = new DrzewoOwocowe(false, 3, "maly", "okragle", "morela");
        DrzewoOwocowe sliwa = new DrzewoOwocowe(false, 5, "duzy", "trojkatne", "sliwka");


        Drzewo[] drzewa = {sosna, modrzew, dab, topola, morelowce, sliwa};

        for(Drzewo d: drzewa) {
            System.out.println(d.toString());
        }

        for(Drzewo d: drzewa) {
            try{
                System.out.println(d.zerwijOwoc());
            } catch (DrzewoBezOwocoweException exception) {
                System.out.println(exception.getMessage());
            }

        }



    }
}
