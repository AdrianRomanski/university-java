package oop.lectures.lecture_5.ex_02;

public class Main {

    public static void main(String[] args) {

        CharPrinter t1 = new CharPrinter('a');
        CharPrinter t2 = new CharPrinter('b');
        CharPrinter t3 = new CharPrinter('c');


//        CharRunner cr = new CharRunner('d');
//        new Thread(cr).start();

        t1.setNext(t2);
        t2.setNext(t3);
        t3.setNext(t1);

        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (t1) {
            t1.notify();
        }

    }
}
