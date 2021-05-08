package oop.lectures.lecture_5.ex_06;

import java.awt.*;

public class MyPanel extends Panel {

    private Color color;

    public MyPanel(Color color) {

        this.setPreferredSize(
                new Dimension(150, 150)
        );

        this.color = color;
        this.setBackground(color);
    }
}
