package basics_of_programming.labs.lab_9;

public class DonkeyBalloonsMain {

    public static void main(String[] args) {

        Balloon balloon = new Balloon();

        System.out.println(balloon.getLoad());

        Donkey donkey = new Donkey(3);

        while (!donkey.isFlying()) {
            donkey.addBalloon(new Balloon());
        }
        donkey.addBalloon(new Balloon());
    }
}
