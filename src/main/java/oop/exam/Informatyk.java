package oop.exam;

public class Informatyk implements Comparable<Informatyk>{

   private String nazwisko;
   private int staz;
   private int index;
   private static int indexStatyczny;

    public Informatyk(String nazwisko, int staz) {
        index = indexStatyczny++;
        this.nazwisko = nazwisko;
        this.staz = staz;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getStaz() {
        return staz;
    }

    public void setStaz(int staz) {
        this.staz = staz;
    }

    public int getIndex() {
        return this.index;
    }

    @Override
    public String toString() {
        return "Informatyk{" +
                "nazwisko='" + nazwisko + '\'' +
                ", staz=" + staz +
                '}';
    }

    @Override
    public int compareTo(Informatyk i) {
        if(this.staz == i.staz) {
            if(this.nazwisko.equals(i.nazwisko)) {
                if(index == i.getStaz()) {
                    return 0;
                } else {
                    return this.staz > i.staz ? 1 : -1;
                }
            } else {
                return this.nazwisko.compareTo(i.nazwisko);
            }
        } else {
            return this.staz > i.staz ? 1 : -1;
        }
    }
}
