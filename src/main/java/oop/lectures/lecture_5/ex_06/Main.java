package oop.lectures.lecture_5.ex_06;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends Frame {


    public static void main(String[] args) {
        new Main();
    }

    public Main() {

        setLayout(new FlowLayout());

        MyGeneratorPanel mgp = new MyGeneratorPanel(Color.RED);
        MyColorListenerPanel mlp = new MyColorListenerPanel(Color.GREEN);

        mgp.addColorListener(mlp);

        add(mgp);
        add(mlp);

        for(int i = 0; i <5; i++) {
            MyColorListenerPanel myColorListenerPanel = new MyColorListenerPanel(Color.RED);
            mgp.addColorListener(myColorListenerPanel);

            add(myColorListenerPanel);
        }

        this.addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        System.exit(0);
                    }
                }
        );

        setSize(640, 480);
        setVisible(true);
    }
}
