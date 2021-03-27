package oop.lectures.lecture_3.ex03;

public class C implements A, B{


    public C() {
        xxx();
    }

    @Override
    public void xxx() {
        A.super.xxx();
    }

    public static void main(String[] args) {
        new C().xxx();
    }
}
