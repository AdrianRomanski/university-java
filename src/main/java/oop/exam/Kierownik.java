package oop.exam;

public class Kierownik extends Informatyk{

    private int iloscProjektow;

    public Kierownik(String nazwisko, int staz, int iloscProjektow) {
        super(nazwisko, staz);
        this.iloscProjektow = iloscProjektow;
    }

    @Override
    public String toString() {
        return super.toString().replace("Informatyk", "Kierownik") + " " +
                "iloscProjektów=" + iloscProjektow +
                '}';
    }

    @Override
    public int compareTo(Informatyk o) {
        if(o.getClass().getSimpleName().equals("Kierownik")) {
            Kierownik kierownik = (Kierownik) o;
            if (super.getStaz() == kierownik.getStaz()) {
                if (this.getNazwisko().equals(kierownik.getNazwisko())) {
                    if (this.iloscProjektow == kierownik.iloscProjektow) {
                        if (this.getIndex() == kierownik.getIndex()) {
                            return 0;
                        } else {
                            return this.getIndex() > kierownik.getIndex() ? 1 : -1;
                        }
                    } else {
                        return this.iloscProjektow > kierownik.iloscProjektow ? 1 : -1;
                    }
                } else {
                    return this.getNazwisko().compareTo(kierownik.getNazwisko());
                }
            } else {
                return this.getStaz() > kierownik.getStaz() ? 1 : -1;
            }
        }
        else if ((o.getClass().getSimpleName().equals("Informatyk"))) {
                return super.compareTo(o);
        }
        return 0;
    }
}
