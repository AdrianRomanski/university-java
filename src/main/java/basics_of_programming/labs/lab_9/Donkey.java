package basics_of_programming.labs.lab_9;

public class Donkey {

    private final double mass;
    private double balloonLoad;
    private static int index;
    private Balloon[] balloons;

    public Donkey(double mass) {
        if(mass <= 0) {
            System.out.println("Mass of donkey cant be negative or 0 - initialized to default");
            this.mass = 1;
        } else {
            this.mass = mass;
        }
        this.balloons = new Balloon[500000];
    }

    public void addBalloon(Balloon balloon) {
        if(!isFlying()) {
            this.balloonLoad+=balloon.getLoad();
            this.balloons[index++]=balloon;
        } else {
            System.out.println("Nie można dodać więcej balonów ja juz Latam!");
        }
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
