package oop.lectures.lecture_5.ex_06;

import java.awt.*;
import java.util.ArrayList;

public class MyGeneratorPanel extends MyPanel implements Runnable{
    private Thread thread;
    private Color color;

    public MyGeneratorPanel(Color color) {
        super(color);
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            this.color  = new Color(
                    (int)(Math.random()*255),
                    (int)(Math.random()*255),
                    (int)(Math.random()*255)
            );

            fireColorChange(
                    new ColorEvent(this, this.color)
            );

            this.setBackground(this.color);
            this.repaint();
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private ArrayList<ColorListener> al = new ArrayList<>();

    public void addColorListener(ColorListener cl) {
        al.add(cl);
    }

    private void fireColorChange(ColorEvent ce) {
        synchronized (thread) {
            for(ColorListener cl : al) {
                cl.colorChange(ce);
            }
        }
    }
}
