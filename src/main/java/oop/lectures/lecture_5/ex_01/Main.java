package oop.lectures.lecture_5.ex_01;

import java.awt.*;
import java.util.ArrayList;

public class Main extends Frame implements Runnable{

    protected ArrayList<Circle> al;

    public static void main(String[] args) {

        new Main();

    }

    public Main() {

        al = new ArrayList<>();

        for(int i =0; i<6; i++) {
            al.add(new Circle(20 + (i * 50), 20) {
                @Override
                public void run() {
                    do {
                        if (y + vy > getHeight() || y + vy < 0)
                            vy *= -1;
                        y += vy;
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } while (!Thread.currentThread().isInterrupted());
                }
            });
        }
        setSize(640, 480);
        setVisible(true);

        new Thread(this).start();
    }


    public void paint(Graphics g) {
        for(Circle circle: al) {
            circle.draw(g);
        }
    }



    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000/30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }
}
