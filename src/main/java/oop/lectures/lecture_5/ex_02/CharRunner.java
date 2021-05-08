package oop.lectures.lecture_5.ex_02;

public class CharRunner implements Runnable{

    private char c;

    public CharRunner(char c) {
        this.c = c;
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {
            System.out.print(c);
        }
    }
}
