package oop.exam;

public class Administrator extends Informatyk{

    private String architekturaSieci;

    public Administrator(String nazwisko, int staz, String architekturaSieci) {
        super(nazwisko, staz);
        this.architekturaSieci = architekturaSieci;
    }

    public String getArchitekturaSieci() {
        return architekturaSieci;
    }

    public void setArchitekturaSieci(String architekturaSieci) {
        this.architekturaSieci = architekturaSieci;
    }

    @Override
    public String toString() {
        return super.toString().replace("Informatyk", "Administrator") + " " +
                "architekturaSieci='" + architekturaSieci + '\'' +
                '}';
    }

    @Override
    public int compareTo(Informatyk o) {
        if(o.getClass().getSimpleName().equals("Administrator")) {
            Administrator administrator = (Administrator) o;
            if(super.getStaz() == administrator.getStaz()) {
                if(this.getNazwisko().equals(administrator.getNazwisko())) {
                    if(this.architekturaSieci.equals(administrator.architekturaSieci)) {
                        if(this.getIndex() == administrator.getIndex()) {
                            return 0;
                        }else {
                            return this.getIndex() > administrator.getIndex() ? 1 : -1;
                        }
                    } else {
                        return this.architekturaSieci.compareTo(administrator.architekturaSieci);
                    }
                } else {
                    return this.getNazwisko().compareTo(administrator.getNazwisko());
                }
            } else {
                return this.getStaz() > administrator.getStaz() ? 1 : -1;
            }
        } else if (o.getClass().getSimpleName().equals("Informatyk")) {
            return super.compareTo(o);
        }
        return 0;
    }
}
