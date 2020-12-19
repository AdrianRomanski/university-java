package basics_of_programming.labs.lab_9;

public class Donkey {

    private double mass;
    private  double balloonLoad;
    private static int index;
    private Balloon[] balloons;

    public Donkey(double mass) {
        this.mass = mass;
        this.balloons = new Balloon[500];
    }

    public boolean addBalloon(Balloon balloon) {
        if(!isFlying()) {
            this.balloonLoad+=balloon.getLoad();
            this.balloons[index++]=balloon;
        } else {
            System.out.println("Nie można dodać więcej balonów ja juz Latam!");
            return false;
        }
        return true;
    }

    public boolean isFlying() {
        if(balloonLoad / 1000 >= mass) {
            System.out.println("Ja Latam");
            return true;
        } else {
            return false;
        }
    }

}
