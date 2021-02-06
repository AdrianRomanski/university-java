package basics_of_programming.projects.project_1_normal.kontener;

import basics_of_programming.projects.project_1_normal.enums.reefer.MiesoEnum;
import basics_of_programming.projects.project_1_normal.enums.reefer.RybyEnum;
import basics_of_programming.projects.project_1_normal.enums.reefer.WarzywaEnum;
import basics_of_programming.projects.project_1_normal.enums.standard.AloholeEnum;
import basics_of_programming.projects.project_1_normal.enums.standard.MotoryzacjaEnum;
import basics_of_programming.projects.project_1_normal.enums.standard.PrzyprawyEnum;
import basics_of_programming.projects.project_1_normal.enums.standard.UbraniaEnum;
import basics_of_programming.projects.project_1_normal.produkt.Produkt;
import basics_of_programming.projects.project_1_normal.enums.reefer.OwoceEnum;
import basics_of_programming.projects.project_1_normal.paleta.Paleta;

public class Kontener {

    private static final String EUROPALETA = "Europaleta";
    private static final String PALETAPA_PRZEMYSLOWA = "PaletaPrzemyslowa";

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
        this.mozliweProduktyDoZaladunku = new Produkt[5];
    }

    public Kontener() { }


    public String getRodzajKontenera() { return ""; }
    public boolean isPelnyKontener() { return pelnyKontener; }
    public double getWagaCalkowita() { return this.aktualnaWagaLadunku + this.wagaKontenera; }
    public void setManifest(String manifest) { this.manifest = manifest; }
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


    public void dodajPalete(Paleta paleta) {
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
                throw new RuntimeException("Typ palety nie jest zgodny z wczesniej zadeklorwanym");
        }
    }

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
