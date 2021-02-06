package basics_of_programming.projects.project_1_normal;

import basics_of_programming.projects.project_1_normal.kontener.Kontener;
import basics_of_programming.projects.project_1_normal.kontener.reef.Reefer20;
import basics_of_programming.projects.project_1_normal.kontener.reef.Reefer40;
import basics_of_programming.projects.project_1_normal.kontener.standard.Standard20;
import basics_of_programming.projects.project_1_normal.kontener.standard.Standard40;
import basics_of_programming.projects.project_1_normal.paleta.Europaleta;
import basics_of_programming.projects.project_1_normal.paleta.Paleta;
import basics_of_programming.projects.project_1_normal.paleta.PaletaPrzemyslowa;
import basics_of_programming.projects.project_1_normal.produkt.Produkt;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

import static basics_of_programming.projects.project_1_normal.enums.reefer.RodzajeLadunkuReeferEnum.*;
import static basics_of_programming.projects.project_1_normal.enums.standard.RodzajeLadunkuStandardEnum.*;
import static java.lang.Double.*;

public class StatekMain {

    private final static Random random = new Random();
    private static String fileName = "";
    private static Kontener[] kontenery = new Kontener[150];
    private static int index;

    public static void main(String[] args) {

        Kontener kontener = new Kontener();
        Paleta paleta = new Paleta();
        Kontenerowiec kontenerowiec = new Kontenerowiec(15010, 397.7, "Dania",
                20, 15, 25);

        for (int i = 0; i < 300; i++) {
            int randomNumber = random.nextInt(2);
            switch (randomNumber) {
                case 0 -> paleta = new PaletaPrzemyslowa();
                case 1 -> paleta = new Europaleta();
            }

            randomNumber = random.nextInt(4);
            switch (randomNumber) {
                case 0 -> kontener = new Standard20();
                case 1 -> kontener = new Standard40();
                case 2 -> kontener = new Reefer20();
                case 3 -> kontener = new Reefer40();
            }

            randomNumber = random.nextInt(4);
            String rodzajKontenera = kontener.getRodzajKontenera();

            if ("Standard".equals(rodzajKontenera)) {
                switch (randomNumber) {
                    case 0 -> kontener.ustawRodzajTowaru(MOTORYZACJA.toString());
                    case 1 -> kontener.ustawRodzajTowaru(PRZYPRAWY.toString());
                    case 2 -> kontener.ustawRodzajTowaru(ALKOHOLE.toString());
                    case 3 -> kontener.ustawRodzajTowaru(UBRANIA.toString());

                }
            } else if ("Reefer".equals(rodzajKontenera)) {
                switch (randomNumber) {
                    case 0 -> kontener.ustawRodzajTowaru(OWOCE.toString());
                    case 1 -> kontener.ustawRodzajTowaru(WARZYWA.toString());
                    case 2 -> kontener.ustawRodzajTowaru(MIESO.toString());
                    case 3 -> kontener.ustawRodzajTowaru(RYBY.toString());
                }
            }

            Produkt[] produkty = kontener.getMozliweProduktyDoZaladunku();

            while (!kontener.isPelnyKontener()) {
                randomNumber = random.nextInt(4);
                paleta.setProdukt(produkty[randomNumber]);
                kontener.dodajPalete(paleta);
            }

            fileName = "Kontenery.txt";
            try (FileWriter fileWriter = new FileWriter(fileName, true);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                 PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
                 printWriter.println(kontener);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }


        try {
            File file = new File(fileName);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] stringInParts = line.split("\t");
                String typKontenera = stringInParts[0];
                Kontener kont;
                switch (typKontenera) {
                    case "Standard20" -> kont = new Standard20(stringInParts[1], parseDouble(stringInParts[2]));
                    case "Standard40" -> kont = new Standard40(stringInParts[1], parseDouble(stringInParts[2]));
                    case "Reefer20" -> kont = new Reefer20(stringInParts[1], parseDouble(stringInParts[2]));
                    case "Reefer40" -> kont = new Reefer40(stringInParts[1], parseDouble(stringInParts[2]));
                    default -> throw new IllegalStateException("Nieoczekiwana wartosc kontenera : " + typKontenera);
                }
                if(index +1 < kontenery.length)
                    kontenery[index++]=kont;
                else if(index + 1 == kontenery.length)
                    kontenery[index]=kont;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(Kontener kont: kontenery) {
            if(kont!=null)
                kontenerowiec.dodajKontener(kont);
        }
        for(Kontener kont: kontenery) {
            try (FileWriter fileWriter = new FileWriter("manifest.txt", true);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                 PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
                if(kont != null) {
                    printWriter.println(kont.toStringWithManifest());
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}




