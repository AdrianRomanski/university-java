package oop.lectures.lecture_5.ex_06;

import java.awt.*;
import java.util.EventObject;

public class ColorEvent extends EventObject {

    private Color color;

    public Color getColor() {
        return color;
    }

    public ColorEvent(Object source, Color color) {
        super(source);
        this.color = color;
    }
}
