package oop.lectures.lecture_5.ex_08;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                ()->{
                    JFrame jFrame = new JFrame();

//                    jFrame.setLayout(new FlowLayout());
//
//                    for(int i =0; i<10; i++) {
//                        JButton jb = new JButton("Button " + i);
//                        jFrame.add(jb);
//                    }

                    jFrame.setLayout(new BorderLayout());

                    jFrame.add(new JButton("North"), BorderLayout.NORTH);
                    jFrame.add(new JButton("SOUTH"), BorderLayout.SOUTH);
                    jFrame.add(new JButton("EAST"), BorderLayout.EAST);
                    jFrame.add(new JButton("WEST"), BorderLayout.WEST);

                    jFrame.setTitle("My First Swing Frame");
                    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    jFrame.setVisible(true);
                    jFrame.setSize(480, 640);

                    jFrame.pack();
                }
        );
    }
}
