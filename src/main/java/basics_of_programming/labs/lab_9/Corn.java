package basics_of_programming.labs.lab_9;

import java.util.Random;

public class Corn {

    private int cornCount;

    public Popcorn[] makePopcorn() {
        Random random = new Random();
        return new Popcorn[random.nextInt(cornCount+1)];
    }
}
