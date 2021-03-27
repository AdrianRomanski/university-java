package oop.lectures.lecture_3.ex01;

public class Mouse implements USB{
    @Override
    public void send() {
        System.out.println("Connecting mouse");
    }
}
