package basics_of_programming.projects.project_1_normal;

import basics_of_programming.projects.project_1_normal.kontener.Kontener;

public class Kontenerowiec {

    private double dlugosc;
    private double szerokosc;
    private String armator;
    private int iloscRzedowKontenerow;
    private int iloscKontenerowWRzedzie;
    private int maksymalnaIloscPieter;
    private Kontener[][][] kontenery;
    private int indexGlowny = 0;
    private int indexPietra = 0;
    private int indexKontenera = 0;
    private boolean malejacy = true;

    public Kontenerowiec(double dlugosc, double szerokosc, String armator,
                         int iloscRzedowKontenerow, int iloscKontenerowWRzedzie,int maksymalnaIloscPieter) {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.armator = armator;
        this.iloscRzedowKontenerow = iloscRzedowKontenerow;
        this.iloscKontenerowWRzedzie = iloscKontenerowWRzedzie;
        this.maksymalnaIloscPieter = maksymalnaIloscPieter;
        this.kontenery = new Kontener[iloscRzedowKontenerow][maksymalnaIloscPieter][iloscKontenerowWRzedzie];
    }

    public void dodajKontener(Kontener kontener) {
        if(indexKontenera < iloscKontenerowWRzedzie-1) {
            this.kontenery[indexGlowny][indexPietra][indexKontenera++] = kontener;
            kontener.setManifest(indexGlowny + "|" + indexPietra + "|" + indexKontenera + " " + this.armator);
        } else if(indexKontenera == iloscKontenerowWRzedzie-1 && indexPietra < maksymalnaIloscPieter-1) {
            // Pomysl jest taki, ze bede sortowal rzedy na zmiane na wszystkich pietrach aby uzyskac stabilizacje
            // 9 8 7 6 5 4 3 2 1
            // 1 2 3 4 5 6 7 8 9
            // 9 8 7 6 5 4 3 2 1
            // 1 2 3 4 5 6 7 8 9
            // 9 8 7 6 5 4 3 2 1
            indexKontenera=0;
            this.kontenery[indexGlowny][++indexPietra][indexKontenera++] = kontener;
            if(malejacy)
                bubbleSortMalejacy(this.kontenery, indexGlowny, indexPietra-1);
            else
                bubbleSortWzrastajacy(this.kontenery, indexGlowny, indexPietra-1);
            kontener.setManifest(indexGlowny + "|" + indexPietra + "|" + indexKontenera + " " + this.armator);
        } else if(indexPietra == maksymalnaIloscPieter-1 && indexGlowny < iloscRzedowKontenerow-1) {
            indexPietra=0;
            indexKontenera=0;
            this.kontenery[++indexGlowny][indexPietra][indexKontenera] = kontener;
            kontener.setManifest(indexGlowny + indexPietra + indexKontenera + " " + this.armator);
        } else if(indexGlowny > iloscRzedowKontenerow) {
            System.out.println("Kontenerowiec jest pelny!");
        }
    }

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
