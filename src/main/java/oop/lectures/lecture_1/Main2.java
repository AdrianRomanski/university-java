package oop.lectures.lecture_1;

import java.awt.*;
import java.awt.event.*;

public class Main2 extends Frame {

    public static void main(String[] args) {

        new Main2();
    }

    public Main2() {
        setSize(640,480);
        setVisible(true);

        addWindowListener(
                new WindowAdapter() {
                  @Override
                  public void windowClosing(WindowEvent e) {
                      super.windowClosing(e);
                      System.exit(0);
                  }
                }
        );

        addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        System.out.println(
                                e.getX() + " " +  e.getY()
                        );
                    }
                }
        );

    }
}
