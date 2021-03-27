package oop.lectures.lecture_3.ex02;

public interface Vehicle {

    int MAX_SPEED = 120;

    void startEngine();
    void move();


    default boolean engineCheckTime(int km) {
        return km >= 10000;
    }

}
