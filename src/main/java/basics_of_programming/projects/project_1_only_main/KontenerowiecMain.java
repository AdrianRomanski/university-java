package basics_of_programming.projects.project_1_only_main;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class KontenerowiecMain {

    private final static Random random = new Random();
    private static final Kontener[] kontenery = new Kontener[15000];
    private static int index;
    private final static String konteneryFile = "kontenery.txt";
    private final static String manifestFile = "manifest.txt";

    public static void main(String[] args) {

        Kontener kontener = new Kontener();
        Paleta paleta = new Paleta();
        Kontenerowiec kontenerowiec = new Kontenerowiec(15010, 397.7, "Czarna_Perla",
                18, 25, 35);

        for (int i = 0; i < 15000; i++) {
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
                    case 0 -> kontener.ustawRodzajTowaru(RodzajeLadunkuStandardEnum.MOTORYZACJA.toString());
                    case 1 -> kontener.ustawRodzajTowaru(RodzajeLadunkuStandardEnum.PRZYPRAWY.toString());
                    case 2 -> kontener.ustawRodzajTowaru(RodzajeLadunkuStandardEnum.ALKOHOLE.toString());
                    case 3 -> kontener.ustawRodzajTowaru(RodzajeLadunkuStandardEnum.UBRANIA.toString());

                }
            } else if ("Reefer".equals(rodzajKontenera)) {
                switch (randomNumber) {
                    case 0 -> kontener.ustawRodzajTowaru(RodzajeLadunkuReeferEnum.OWOCE.toString());
                    case 1 -> kontener.ustawRodzajTowaru(RodzajeLadunkuReeferEnum.WARZYWA.toString());
                    case 2 -> kontener.ustawRodzajTowaru(RodzajeLadunkuReeferEnum.MIESO.toString());
                    case 3 -> kontener.ustawRodzajTowaru(RodzajeLadunkuReeferEnum.RYBY.toString());
                }
            }

            Produkt[] produkty = kontener.getMozliweProduktyDoZaladunku();
            while (!kontener.isPelnyKontener()) {
                randomNumber = random.nextInt(4);
                paleta.setProdukt(produkty[randomNumber]);
                try {
                    kontener.dodajPalete(paleta);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            try (FileWriter fileWriter = new FileWriter(konteneryFile, true);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                 PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
                 printWriter.println(kontener);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        try {
            File file = new File(konteneryFile);
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
                try {
                    kontenerowiec.dodajKontener(kont);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }

        for(Kontener kont: kontenery) {
            try (FileWriter fileWriter = new FileWriter(manifestFile, true);
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


// Aby ulatwic czytanie posortowalem klasy od "najwiekszego" obiektu gabarytami do najmniejszego
// Na ten moment jak, to robilem wydawalo mi sie, to logiczne
class Kontenerowiec {

    private double dlugosc;
    private double szerokosc;
    private String nazwa;
    private int iloscRzedowKontenerow;
    private int iloscKontenerowWRzedzie;
    private int maksymalnaIloscPieter;
    private Kontener[][][] kontenery;
    private int indexGlowny = 0;
    private int indexPietra = 0;
    private int indexKontenera = 0;
    private boolean malejacy = true;

    public Kontenerowiec(double dlugosc, double szerokosc, String nazwa,
                         int iloscRzedowKontenerow, int iloscKontenerowWRzedzie,int maksymalnaIloscPieter) {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.nazwa = nazwa;
        this.iloscRzedowKontenerow = iloscRzedowKontenerow;
        this.iloscKontenerowWRzedzie = iloscKontenerowWRzedzie;
        this.maksymalnaIloscPieter = maksymalnaIloscPieter;
        this.kontenery = new Kontener[iloscRzedowKontenerow][maksymalnaIloscPieter][iloscKontenerowWRzedzie];
    }


    // Wkradl mi jakis jakis blad do tej metody
    // Blad jest w sortowaniu bez niego wszystko dziala tak jak powinno
    public void dodajKontener(Kontener kontener) throws PelnyKonterException {
        if(indexKontenera < iloscKontenerowWRzedzie-1) {
            kontener.setManifest(indexGlowny + "|" + indexPietra + "|" + indexKontenera + "|" + nazwa);
            this.kontenery[indexGlowny][indexPietra][indexKontenera++] = kontener;
        } else if(indexKontenera == iloscKontenerowWRzedzie-1 && indexPietra < maksymalnaIloscPieter-1) {
            indexKontenera=0;
            this.kontenery[indexGlowny][++indexPietra][indexKontenera++] = kontener;

            // Pomysl jest taki, ze bede sortowal rzedy na zmiane na wszystkich pietrach aby uzyskac stabilizacje
            // 9 8 7 6 5 4 3 2 1
            // 1 2 3 4 5 6 7 8 9
            // 9 8 7 6 5 4 3 2 1
            // 1 2 3 4 5 6 7 8 9
            // 9 8 7 6 5 4 3 2 1

            if(malejacy) {
                bubbleSortMalejacy(this.kontenery, indexGlowny, indexPietra-1);
                malejacy=false;
            }
            else {
                bubbleSortWzrastajacy(this.kontenery, indexGlowny, indexPietra-1);
                malejacy=true;
            }

            // Ta czesc kodu miala zmieniac pozycje w manifescie po sortowaniu, ale cos nie dziala tak
            // jak powinno niestety nie dalem rady rozwiazac problemu w zwiazku z tym musialem go zakomentowac

//            for(int i = 0; i < iloscKontenerowWRzedzie; i++) {
//                Kontener kontenerDoManifestu = kontenery[indexGlowny][indexPietra-1][i];
//                int temp = indexPietra - 1;
//                kontenerDoManifestu.setManifest(indexGlowny + "|" + temp + "|" + indexKontenera + "|" + nazwa);
//                kontenery[indexGlowny][indexPietra-1][i] = kontenerDoManifestu;
//            }

            kontener.setManifest(indexGlowny + "|" + (indexPietra-1) + "|" + indexKontenera + "|" + nazwa);
        } else if(indexPietra == maksymalnaIloscPieter-1 && indexGlowny < iloscRzedowKontenerow-1) {
            indexPietra=0;
            indexKontenera=0;
            this.kontenery[++indexGlowny][indexPietra][indexKontenera] = kontener;
            kontener.setManifest(indexGlowny + "|" + indexPietra + "|" + indexKontenera + "|" + nazwa);
        } else if(indexGlowny > iloscRzedowKontenerow) {
            throw new PelnyKonterException();
        }
    }


    // Mozliwe, ze blad znajduje sie w metodach sortujacych, ale nie moge go odnalezc
    // Jesli Profesor moglbym mi go wskazac w momemncie obrony projektu bylbym wdzieczny
    // , poniewaz nie mam juz wiecej pomyslow gdzie sie zepsulo

    // Sortuje od najwiekszej wagi do najmniejszej
    public void bubbleSortMalejacy(Kontener[][][] array, int indexGlowny, int indexPietra) {
        boolean sorted = false;
        Kontener temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < this.iloscKontenerowWRzedzie - 1; i++) {
                if ((array[indexGlowny][indexPietra][i] != null && array[indexGlowny][indexPietra][i+1] != null) &&
                        (array[indexGlowny][indexPietra][i].getWagaCalkowita() > array[indexGlowny][indexPietra][i+1].getWagaCalkowita())) {
                    temp = array[indexGlowny][indexPietra][i];
                    array[indexGlowny][indexPietra][i] = array[indexGlowny][indexPietra][i+1];
                    array[indexGlowny][indexPietra][i+1] = temp;
                    sorted = false;
                }
            }
        }
    }
    // Sortuje od najmniejszej wagi do najwiekszej
    public void bubbleSortWzrastajacy(Kontener[][][] array, int indexGlowny, int indexPietra) {
        boolean sorted = false;
        Kontener temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < this.iloscKontenerowWRzedzie - 1; i++) {
                if ((array[indexGlowny][indexPietra][i] != null && array[indexGlowny][indexPietra][i+1] != null) &&
                        (array[indexGlowny][indexPietra][i].getWagaCalkowita() < array[indexGlowny][indexPietra][i+1].getWagaCalkowita())) {
                    temp = array[indexGlowny][indexPietra][i];
                    array[indexGlowny][indexPietra][i] = array[indexGlowny][indexPietra][i+1];
                    array[indexGlowny][indexPietra][i+1] = temp;
                    sorted = false;
                }
            }
        }
    }
}

class Kontener {
    private static final String EUROPALETA = "Europaleta";
    private static final String PALETAPA_PRZEMYSLOWA = "PaletaPrzemyslowa";

    // Dlaczego pozostawilem tyle nieuzytych pól?
    // Podszedlem zbyt ambitnie do tego projektu i niestety nie starczylo mi czasu aby wszystko zaimplementowac
    // Te pola sa pozostalosciami po tych planach
    // W skrócie chcialem obliczac ilosc kontenerow dla kazdego statku uzywajac tych wartosci
    // zamiast manualnie wpychac ilosc pieter i rzedow do konstruktora
    private Double dlugoscWnetrza;
    private Double szerokoscWnetrza;
    private Double wysokoscWnetrza;
    private Double szerokoscDrzwi;
    private Double wysokoscDrzwi;
    private Double pojemnoscKontenera;
    private Double wagaKontenera;
    private Double maksWagaLadunku;

    private int maksIloscEuroPalet;
    private int maksIloscPaletPrzemyslowych;
    private String typPalety;

    private boolean pustyKontener = true;
    private boolean pelnyKontener = false;

    private Paleta[] palety;
    private int maks;
    private int index;
    private String rodzajLadunku;
    private Produkt[] mozliweProduktyDoZaladunku;
    private double aktualnaWagaLadunku;
    private String manifest = "";

    public Kontener(Double dlugoscWnetrza, Double szerokoscWnetrza, Double wysokoscWnetrza,
                    Double szerokoscDrzwi, Double wysokoscDrzwi, Double pojemnoscKontenera,
                    Double wagaKontenera, Double maksWagaLadunku,
                    int maksIloscEuroPalet, int maksIloscPaletPrzemyslowych) {
        this.dlugoscWnetrza = dlugoscWnetrza;
        this.szerokoscWnetrza = szerokoscWnetrza;
        this.wysokoscWnetrza = wysokoscWnetrza;
        this.szerokoscDrzwi = szerokoscDrzwi;
        this.wysokoscDrzwi = wysokoscDrzwi;
        this.pojemnoscKontenera = pojemnoscKontenera;
        this.wagaKontenera = wagaKontenera;
        this.maksWagaLadunku = maksWagaLadunku;
        this.maksIloscEuroPalet = maksIloscEuroPalet;
        this.maksIloscPaletPrzemyslowych = maksIloscPaletPrzemyslowych;
        // Tutaj tez mialem plany aby mozna bylo losowac wiecej produktow finalnie
        // musialem skorzystac z prostszego rozwizania
        this.mozliweProduktyDoZaladunku = new Produkt[5];
    }

    public Kontener() { }

    public String getRodzajKontenera() { return ""; }
    public boolean isPelnyKontener() { return pelnyKontener; }
    public double getWagaCalkowita() { return this.aktualnaWagaLadunku + this.wagaKontenera; }
    public void setRodzajLadunku(String rodzajLadunku) { this.rodzajLadunku = rodzajLadunku; }
    public Produkt[] getMozliweProduktyDoZaladunku() {
        return mozliweProduktyDoZaladunku;
    }
    public void setAktualnaWagaLadunku(double aktualnaWagaLadunku) {
        this.aktualnaWagaLadunku = aktualnaWagaLadunku;
    }

    @Override
    public String toString() {
        return  this.rodzajLadunku + '\t' + this.aktualnaWagaLadunku + "\t" + getWagaCalkowita()  + "\t";
    }

    public String toStringWithManifest() {
        return  this.manifest + '\t' + this.rodzajLadunku + '\t' + this.aktualnaWagaLadunku + "\t" + getWagaCalkowita()  + "\t";
    }

    public void setManifest(String manifest) {
        this.manifest = manifest;
    }

    // W tej metodzie jest oblicza waga ladunku na podstawie wagi produktow z palety
    // Dodalem zabezpiecznie aby nie mozna bylo dodac palet roznego typu do jednego kontenera
    // Zdaje sobie sprawe, ze w mainie i tak do tego nie dopuszczam, ale na przyszlosc
    // mogloby sie,to okazac uzyteczne
    public void dodajPalete(Paleta paleta) throws ZlyTypPaletyException {
        Paleta[] palety = this.palety;
        if(this.pustyKontener) {
            if(paleta.zwrocNazweKlasy().equals(PALETAPA_PRZEMYSLOWA)) {
                this.maks = maksIloscPaletPrzemyslowych;
                this.typPalety = PALETAPA_PRZEMYSLOWA;
            }
            else {
                this.maks = maksIloscEuroPalet;
                this.typPalety = EUROPALETA;
            }
            this.palety = new Paleta[maks];
            palety = new Paleta[maks];
            palety[index++] = paleta;
            this.pustyKontener=false;
            this.aktualnaWagaLadunku+=paleta.getProdukt().getWaga();
        } else {
            if(paleta.zwrocNazweKlasy().equals(typPalety))
                if(index <= maks-1&& this.aktualnaWagaLadunku < this.maksWagaLadunku) {
                    palety[index++]=paleta;
                    this.aktualnaWagaLadunku+=paleta.getProdukt().getWaga();
                }
                else
                    this.pelnyKontener = true;
            else
                throw new ZlyTypPaletyException(paleta.zwrocNazweKlasy());
        }
    }

    // Ta metoda jest potrzebna tylko i wylacznie na potrzeby losowania wartosci
    public void ustawRodzajTowaru(String rodzaj) {
        switch (rodzaj) {
            case "OWOCE" -> {
                OwoceEnum[] values = OwoceEnum.values();
                for (int i = 0; i < 5; i++) {
                    OwoceEnum entry = values[i];
                    this.mozliweProduktyDoZaladunku[i] = new Produkt(entry.name(), entry.getWaga());
                }
                this.rodzajLadunku="Owoce";
            }
            case "WARZYWA" -> {
                WarzywaEnum[] values = WarzywaEnum.values();
                for (int i = 0; i < 5; i++) {
                    WarzywaEnum entry = values[i];
                    this.mozliweProduktyDoZaladunku[i] = new Produkt(entry.name(), entry.getWaga());
                }
                this.rodzajLadunku="Warzywa";
            }
            case "RYBY" -> {
                RybyEnum[] values = RybyEnum.values();
                for (int i = 0; i < 5; i++) {
                    RybyEnum entry = values[i];
                    this.mozliweProduktyDoZaladunku[i] = new Produkt(entry.name(), entry.getWaga());
                }
                this.rodzajLadunku="Ryby";
            }
            case "MIESO" -> {
                MiesoEnum[] values = MiesoEnum.values();
                for (int i = 0; i < 5; i++) {
                    MiesoEnum entry = values[i];
                    this.mozliweProduktyDoZaladunku[i] = new Produkt(entry.name(), entry.getWaga());
                }
                this.rodzajLadunku="Mieso";
            }
            case "MOTORYZACJA" -> {
                MotoryzacjaEnum[] values = MotoryzacjaEnum.values();
                for (int i = 0; i < 5; i++) {
                    MotoryzacjaEnum entry = values[i];
                    this.mozliweProduktyDoZaladunku[i] = new Produkt(entry.name(), entry.getWaga());
                }
                this.rodzajLadunku="Motoryzacja";
            }
            case "UBRANIA" -> {
                UbraniaEnum[] values = UbraniaEnum.values();
                for (int i = 0; i < 5; i++) {
                    UbraniaEnum entry = values[i];
                    this.mozliweProduktyDoZaladunku[i] = new Produkt(entry.name(), entry.getWaga());
                }
                this.rodzajLadunku="Ubrania";
            }
            case "PRZYPRAWY" -> {
                PrzyprawyEnum[] values = PrzyprawyEnum.values();
                for (int i = 0; i < 5; i++) {
                    PrzyprawyEnum entry = values[i];
                    this.mozliweProduktyDoZaladunku[i] = new Produkt(entry.name(), entry.getWaga());
                }
                this.rodzajLadunku="Przyprawy";
            }
            case "ALKOHOLE" -> {
                AloholeEnum[] values = AloholeEnum.values();
                for (int i = 0; i < 5; i++) {
                    AloholeEnum entry = values[i];
                    this.mozliweProduktyDoZaladunku[i] = new Produkt(entry.name(), entry.getWaga());
                }
                this.rodzajLadunku="Alkohole";
            }
        }
    }
}

//Kontenery Standardowe
// Niestety brak statycznych importow dla enumow sprawia, ze kod nie wyglada tak ladnie jak bym tego chcial
class Standard20 extends Kontener {

    public Standard20() {
            super(KontenerEnum.STANDARD_20.dlugoscWnetrza, KontenerEnum.STANDARD_20.szerokoscWnetrza, KontenerEnum.STANDARD_20.wysokoscWnetrza,
                    KontenerEnum.STANDARD_20.szerokoscDrzwi, KontenerEnum.STANDARD_20.wysokoscDrzwi, KontenerEnum.STANDARD_20.pojemnoscKontenera,
                    KontenerEnum.STANDARD_20.wagaKontenera, KontenerEnum.STANDARD_20.maksWagaLadunku,
                    KontenerEnum.STANDARD_20.maksymalnaIloscEuroPalet, KontenerEnum.STANDARD_20.maksymalnaIloscPaletPrzemyslowych);
    }

    public Standard20(String rodzajTowaru, Double wagaTowaru) {
            this();
            this.setAktualnaWagaLadunku(wagaTowaru);
            this.setRodzajLadunku(rodzajTowaru);
    }


    @Override
    public String toString() {
            return this.getClass().getSimpleName() + "\t" + super.toString();
    }

    public String getRodzajKontenera() {
            return "Standard";
    }
}

class Standard40 extends Kontener {

    public Standard40() {
        super(KontenerEnum.STANDARD_40.dlugoscWnetrza, KontenerEnum.STANDARD_40.szerokoscWnetrza, KontenerEnum.STANDARD_40.wysokoscWnetrza,
                KontenerEnum.STANDARD_40.szerokoscDrzwi, KontenerEnum.STANDARD_40.wysokoscDrzwi, KontenerEnum.STANDARD_40.pojemnoscKontenera,
                KontenerEnum.STANDARD_40.wagaKontenera, KontenerEnum.STANDARD_40.maksWagaLadunku,
                KontenerEnum.STANDARD_40.maksymalnaIloscEuroPalet, KontenerEnum.STANDARD_40.maksymalnaIloscPaletPrzemyslowych);
    }

    public Standard40(String rodzajTowaru, Double wagaTowaru) {
        this();
        this.setAktualnaWagaLadunku(wagaTowaru);
        this.setRodzajLadunku(rodzajTowaru);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "\t" + super.toString();
    }

    public String getRodzajKontenera() {
        return "Standard";
    }
}

// Enumy Kontenerow Standardowych
enum RodzajeLadunkuStandardEnum {
    MOTORYZACJA, UBRANIA, PRZYPRAWY, ALKOHOLE
}

enum AloholeEnum {
    PIWO(40),
    WINO(60),
    WINO_MUSUJACE(55),
    WODKA(30),
    CYDR(35);

    private double waga;
    AloholeEnum(double waga) { this.waga = waga; }
    public double getWaga() { return waga; }
}

enum MotoryzacjaEnum {
    MOTOR(650),
    SAMOCHOD_MIEJSKI(1100),
    SAMOCHOD_RODZINMY(1500),
    SKUTER(450),
    QUAD(2000);

    private double waga;
    MotoryzacjaEnum(double waga) { this.waga = waga; }
    public double getWaga() { return waga; }
}

enum PrzyprawyEnum {
    PIEPRZ(120),
    SOL(80),
    PAPRYKA(140),
    KURKUMA(120),
    CYNAMON(100);

    private double waga;
    PrzyprawyEnum(double waga) { this.waga = waga; }
    public double getWaga() { return waga; }
}

enum UbraniaEnum {
    KOSZULKA(230),
    SPODNIE(340),
    BLUZA(420),
    KURTKA(315),
    SKARPETKI(180);

    private double waga;
    UbraniaEnum(double waga) { this.waga = waga; }
    public double getWaga() { return waga; }
}


//Kontenery typu Reefer
class Reefer20 extends Kontener {
    public Reefer20() {
        super(KontenerEnum.REEFER_20.dlugoscWnetrza, KontenerEnum.REEFER_20.szerokoscWnetrza, KontenerEnum.REEFER_20.wysokoscWnetrza,
                KontenerEnum.REEFER_20.szerokoscDrzwi, KontenerEnum.REEFER_20.wysokoscDrzwi, KontenerEnum.REEFER_20.pojemnoscKontenera,
                KontenerEnum.REEFER_20.wagaKontenera, KontenerEnum.REEFER_20.maksWagaLadunku,
                KontenerEnum.REEFER_20.maksymalnaIloscEuroPalet, KontenerEnum.REEFER_20.maksymalnaIloscPaletPrzemyslowych);
    }

    public Reefer20(String rodzajTowaru, Double wagaTowaru) {
        this();
        this.setAktualnaWagaLadunku(wagaTowaru);
        this.setRodzajLadunku(rodzajTowaru);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "\t" + super.toString();
    }

    public String getRodzajKontenera() {
        return "Reefer";
    }
}


class Reefer40 extends Kontener {
    public Reefer40() {
        super(KontenerEnum.REEFER_40.dlugoscWnetrza, KontenerEnum.REEFER_40.szerokoscWnetrza, KontenerEnum.REEFER_40.wysokoscWnetrza,
                KontenerEnum.REEFER_40.szerokoscDrzwi, KontenerEnum.REEFER_40.wysokoscDrzwi, KontenerEnum.REEFER_40.pojemnoscKontenera,
                KontenerEnum.REEFER_40.wagaKontenera, KontenerEnum.REEFER_40.maksWagaLadunku,
                KontenerEnum.REEFER_40.maksymalnaIloscEuroPalet, KontenerEnum.REEFER_40.maksymalnaIloscPaletPrzemyslowych
                );
    }

    public Reefer40(String rodzajTowaru, Double wagaTowaru) {
        this();
        this.setAktualnaWagaLadunku(wagaTowaru);
        this.setRodzajLadunku(rodzajTowaru);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "\t" + super.toString();
    }

    public String getRodzajKontenera() {
        return "Reefer";
    }
}

//Enumy Kontenerow typu Reefer
enum RodzajeLadunkuReeferEnum {
    OWOCE, WARZYWA, RYBY, MIESO
}

enum MiesoEnum {
    WOLOWINA(320),
    KURCZAK(450),
    WIEPRZOWINA(380),
    CIELECINA( 315),
    SARNINA(300);

    private double waga;
    MiesoEnum(int waga) {
        this.waga = waga;
    }
    public double getWaga() {
        return waga;
    }
}

enum OwoceEnum {
    BANAN(420),
    TRUSKAWKA(315),
    JABLKO(170),
    GRUSZKA(150),
    ARBUZ(230);

    private double waga;
    OwoceEnum(int waga) {
        this.waga = waga;
    }
    public double getWaga() {
        return waga;
    }
}

enum RybyEnum {
    DORSZ(420),
    LOSOS(370),
    SARDYNKA(250),
    DORADA( 315),
    PSTRAG(220);

    private double waga;
    RybyEnum(int waga) {
        this.waga = waga;
    }
    public double getWaga() {
        return waga;
    }
}

enum WarzywaEnum {
    ZIEMNIAK(240),
    PAPRYKA(180),
    CEBULA(140),
    CUKINIA( 165),
    POMIDOR(190);

    private double waga;
    WarzywaEnum(int waga) {
        this.waga = waga;
    }
    public double getWaga() {
        return waga;
    }
}

//Enumy dla Kontenerow
// Moj pomysl z enumami mial odseparowac stale wartosci od klas aby ulatwic czytanie kodu w momencie
// gdy doszloby wiecej metod do w/w klas, poniewaz wartosci te sa stale dla tych kontenerow
// aczkolwiek w momencie w ktorym przenioslem wszystko do jednej klasy nie widac efektu ktory chcialem uzyskac
enum KontenerEnum {
    STANDARD_20(5.900, 2.350, 2.393,
            2.342, 2.280, 33.2, 2230,
            21770, "Standard", 10, 11),
    STANDARD_40(12.036, 2.350, 2.392,
            2.340, 2.280, 67.7, 3700,
            26780, "Standard", 20, 24),
    REEFER_20(5.400, 2.350, 2.393,
            2.342, 2.280, 33.2, 2230,
            21770, "Reefer", 9, 10),
    REEFER_40(19.600, 2.330, 2.690,
            2.330, 2.560, 76.28, 3968,
            26512, "Reefer", 19, 23);

    public final double dlugoscWnetrza;
    public final double szerokoscWnetrza;
    public final double wysokoscWnetrza;
    public final double szerokoscDrzwi;
    public final double wysokoscDrzwi;
    public final double pojemnoscKontenera;
    public final double wagaKontenera;
    public final double maksWagaLadunku;
    public final String rodzajKontenera;
    public final int maksymalnaIloscEuroPalet;
    public final int maksymalnaIloscPaletPrzemyslowych;

    KontenerEnum(double dlugoscWnetrza, double szerokoscWnetrza, double wysokoscWnetrza, double szerokoscDrzwi,
                 double wysokoscDrzwi, double pojemnoscKontenera, double wagaKontenera, double maksWagaLadunku,
                 String rodzajKontenera, int maksymalnaIloscEuroPalet, int maksymalnaIloscPaletPrzemyslowych) {
        this.dlugoscWnetrza = dlugoscWnetrza;
        this.szerokoscWnetrza = szerokoscWnetrza;
        this.wysokoscWnetrza = wysokoscWnetrza;
        this.szerokoscDrzwi = szerokoscDrzwi;
        this.wysokoscDrzwi = wysokoscDrzwi;
        this.pojemnoscKontenera = pojemnoscKontenera;
        this.wagaKontenera = wagaKontenera;
        this.maksWagaLadunku = maksWagaLadunku;
        this.rodzajKontenera = rodzajKontenera;
        this.maksymalnaIloscEuroPalet = maksymalnaIloscEuroPalet;
        this.maksymalnaIloscPaletPrzemyslowych = maksymalnaIloscPaletPrzemyslowych;
    }
}

//Palety i jej klasy
class Paleta {
    private int wysokosc;
    private int dlugiBok;
    private int krótkiBok;
    private Produkt produkt;

    public Paleta(int wysokosc, int dlugiBok, int krótkiBok) {
        this.wysokosc = wysokosc;
        this.dlugiBok = dlugiBok;
        this.krótkiBok = krótkiBok;
    }
    public Paleta() { }
    public String zwrocNazweKlasy() { return this.getClass().getSimpleName(); }
    public Produkt getProdukt() {
        return produkt;
    }
    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }
}

// Tutaj nie zdecydowalem sie na enumy bo wartosci bylo zdecydowanie za malo
class Europaleta extends Paleta {
    public Europaleta() {
        super(120, 80, 25);
    }
}

class PaletaPrzemyslowa extends Paleta {
    public PaletaPrzemyslowa() {
        super(120, 100, 25);
    }
}

//Produkt
class Produkt {
    private String nazwa;
    private double waga;

    public Produkt(String nazwa, double waga) {
        this.nazwa = nazwa;
        this.waga = waga;
    }

    public double getWaga() {
        return waga;
    }
}

class PelnyKonterException extends Exception {
    public PelnyKonterException() {
        super("Kontenerowiec nie ma miejsca na wiecej kontenerow");
    }
}

class ZlyTypPaletyException extends Exception {
    public ZlyTypPaletyException(String paleta) {
        super("typ palety: " + paleta + " jest nieprawidlowy z wczesniej zadeklarowanym");
    }
}
