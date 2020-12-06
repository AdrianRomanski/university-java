package basics_of_programming.labs.lab_8;

public class Cplx {

    private double rzeczywista;
    private double urojona;

    public Cplx(double rzeczywista, double urojna) {
        this.rzeczywista = rzeczywista;
        this.urojona = urojna;
    }

    public double getRzeczywista() {
        return rzeczywista;
    }

    public double getUrojona() {
        return urojona;
    }

    public Cplx add(Cplx second) {
        this.rzeczywista+=second.getRzeczywista();
        this.urojona+=second.getUrojona();
        return this;
    }

    public Cplx sub(Cplx second) {
        this.rzeczywista-=second.getRzeczywista();
        this.urojona-=second.getUrojona();
        return this;
    }

    public Cplx mul(Cplx second) {
        this.rzeczywista*=second.getRzeczywista();
        this.urojona*=second.getUrojona();
        return this;
    }

    public Cplx inc() {
        this.rzeczywista+=1;
        return this;
    }

    public void show() {
        System.out.println(this.rzeczywista + " + "  + this.urojona + "i");
    }

}
