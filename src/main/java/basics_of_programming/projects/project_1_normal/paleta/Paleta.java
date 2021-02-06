package basics_of_programming.projects.project_1_normal.paleta;

import basics_of_programming.projects.project_1_normal.produkt.Produkt;

public class Paleta {

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
