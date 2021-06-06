package oop.lectures.lecture_6.ex01;

import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        MyColorPanel mcp = new MyColorPanel();

        JScrollPane jsp = new JScrollPane(mcp);

        this.add(jsp);
        this.setVisible(true);
    }

}
