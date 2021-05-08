package oop.lectures.lecture_5.ex_06;

import java.awt.*;

public class MyColorListenerPanel extends MyPanel implements ColorListener{
    public MyColorListenerPanel(Color color) {
        super(color);
    }

    @Override
    public void colorChange(ColorEvent event) {
          this.setBackground(event.getColor());
    }
}
