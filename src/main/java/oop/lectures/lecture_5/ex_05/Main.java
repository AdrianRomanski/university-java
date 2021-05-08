package oop.lectures.lecture_5.ex_05;

import java.awt.*;
import java.awt.event.*;

public class Main extends Frame {

    public static void main(String[] args) {

        new Main();

    }

    public Main() {

        Button button = new Button("Click me");

        button.addActionListener(
                e -> System.out.println("click")
        );

        this.addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowOpened(WindowEvent e) {

                    }

                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        System.exit(0);
                    }

                    @Override
                    public void windowClosed(WindowEvent e) {
                    }

                    @Override
                    public void windowIconified(WindowEvent e) {

                    }

                    @Override
                    public void windowDeiconified(WindowEvent e) {

                    }

                    @Override
                    public void windowActivated(WindowEvent e) {

                    }

                    @Override
                    public void windowDeactivated(WindowEvent e) {

                    }
                }
        );

        setLayout(new FlowLayout());
        add(button);

        setSize(640, 480);
        setVisible(true);
    }
}
