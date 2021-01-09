package basics_of_programming.labs.lab_11;

public class PPJWin {


    public static void main(String[] args) {


        Cake eklerka = new Cake("grzybki", 0.21, 232412);

        System.out.println(eklerka);


        Punkt2D punkt2D_1 = new Punkt2D(2,4);
        Punkt2D punkt2D_2 = new Punkt2D(2,6);

        System.out.println(punkt2D_1.odleglosc(punkt2D_2));


        Telefon telefon = new Telefon("--", "niebieski");

        telefon.zadzwon("22-042-421");


        Komórka komorka = new Komórka("--", "niebieski");

        komorka.zadzwon("11-042-421");
        komorka.zadzwon("22-042-421");
        komorka.zadzwon("33-042-421");
        komorka.zadzwon("44-042-421");
        komorka.zadzwon("55-042-421");
        komorka.zadzwon("66-042-421");
        komorka.zadzwon("77-042-421");
        komorka.zadzwon("88-042-421");
        komorka.zadzwon("99-042-421");
        komorka.zadzwon("00-042-421");
        komorka.zadzwon("01-042-421");

        komorka.wyswietlHistoriePolaczen();

        Smartfon smartfon = new Smartfon("--", "niebieski");

        Osoba adrian = new Osoba("Adrian", "Romanski", "11-042-421");
        Osoba piotrek = new Osoba("Piotrek", "Romanski", "44-042-421");
        Osoba domonik = new Osoba("Dominik", "Romanski", "88-042-421");
        Osoba adrian2 = new Osoba("Adrian2", "Romanski", "211-042-421");
        Osoba piotrek2 = new Osoba("Piotrek2", "Romanski", "244-042-421");
        Osoba domonik2 = new Osoba("Dominik2", "Romanski", "288-042-421");

        smartfon.dodajZnajomego(adrian);
        smartfon.dodajZnajomego(piotrek);
        smartfon.dodajZnajomego(domonik);
        smartfon.dodajZnajomego(adrian2);
        smartfon.dodajZnajomego(piotrek2);
        smartfon.dodajZnajomego(domonik2);


        smartfon.zadzwon("11-042-421");
        smartfon.zadzwon("22-042-421");
        smartfon.zadzwon("33-042-421");
        smartfon.zadzwon("44-042-421");
        smartfon.zadzwon("55-042-421");
        smartfon.zadzwon("66-042-421");
        smartfon.zadzwon("77-042-421");
        smartfon.zadzwon("88-042-421");
        smartfon.zadzwon("99-042-421");

        smartfon.wyswietlHistoriePolaczen();


        System.out.println("Zadanie 7");
        System.out.println("*****************************************");

        // Zadanie 7
        Telefon[] telefony = {telefon, komorka, smartfon};
        Osoba[] kontakty = smartfon.getZnajomi();
        int counter;

        for(Telefon t: telefony) {
            counter = 0;
            for(int j = 1; j <= 11; j++) {
                if(j % 2 == 0) {
                    if(kontakty[counter+1] != null) {
                        t.zadzwon(kontakty[counter++].getNumer());
                    } else {
                        counter=0;
                        t.zadzwon(kontakty[counter].getNumer());
                    }
                } else {
                    t.zadzwon("111-222-333");
                }
            }
            t.wyswietlHistoriePolaczen();
        }













    }

}
