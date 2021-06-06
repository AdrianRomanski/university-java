package oop.lectures.lecture_6.ex01;

import javax.swing.*;
import java.awt.*;

public class MyColorPanel extends JPanel {


    public MyColorPanel() {
        this.setPreferredSize(new Dimension(5000, 5000));
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        for (int i = 0; i < 5000; i+=10) {
            for (int j = 0; j < 5000; j+=10) {
                Color color = new Color(
                        (int) (Math.random() * 255),
                        (int) (Math.random() * 255),
                        (int) (Math.random() * 255)
                );
                g.setColor(color);
                g.fillRect(i, j, 10, 10);
            }
        }
    }
}
