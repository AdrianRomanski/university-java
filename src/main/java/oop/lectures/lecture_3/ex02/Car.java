package oop.lectures.lecture_3.ex02;

public class Car implements Vehicle {


    private int currentRange;

    public Car() {
        this.currentRange = 0;
    }

    @Override
    public void startEngine() {
        if(engineCheckTime(currentRange)) {
            System.out.println("pora na wizyte");
        }
    }

    @Override
    public void move() {
        currentRange++;
    }
}
