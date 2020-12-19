package basics_of_programming.labs.lab_9;

import java.util.Random;

public class Balloon {

    private final double ratio = 6 / 0.007;

    private double capacity;
    private double load;

    public Balloon() {
        Random random = new Random();
        float number = 0;
        while(number < 5) {
            number = random.nextInt(10);
        }
        this.capacity=number/1000;
        this.load=capacity*ratio;
    }


    public double getLoad() {
        return this.load;
    }
}
