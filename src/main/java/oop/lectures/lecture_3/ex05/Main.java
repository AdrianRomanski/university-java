package oop.lectures.lecture_3.ex05;

public class Main {

    public static void main(String[] args) {

        A a = System.out::println;

        a.fun(5);
        a.fun(7);

        B b = int[]::new;
        int[] tab = b.fun(10);
        System.out.println(tab.length);
    }
}

interface A {
    void fun(int x);
}

interface B {
    int[] fun(int size);
}