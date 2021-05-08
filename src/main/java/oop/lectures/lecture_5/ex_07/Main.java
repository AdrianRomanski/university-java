package oop.lectures.lecture_5.ex_07;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
//        EventQueue.invokeLater(
//                ()->{
//                    JFrame jFrame = new JFrame();
//                    jFrame.setVisible(true);
//                }
//        );

        SwingUtilities.invokeLater(
                    ()->{
                    JFrame jFrame = new JFrame();
                    jFrame.setTitle("My First Swing Frame");
                    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    jFrame.setVisible(true);
                }
        );
    }
}
