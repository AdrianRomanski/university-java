package oop.labs.lab_7;

import javax.naming.OperationNotSupportedException;
import javax.swing.*;
import java.awt.*;

public class Zadanie14 {
    public static void main(String[] args) throws OperationNotSupportedException {
        new Zadanie14();
    }
    public Zadanie14()  {
        SwingUtilities.invokeLater(
                this::createGui
        );
    }
    protected void createGui() {
        var jf = new JFrame();
        var jp = new JPanel();
        jf.pack();
        jf.setSize(640, 400);
        jf.setLocation(850, 450);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(true);

        var button1 = new JButton("Przycisk 1");
        jp.add(button1);
        var button2 = new JButton("P 2");
        jp.add(button2);
        var button3 = new JButton("Większy przycisk numer 3");
        jp.add(button3);
        var button4 = new JButton("Przycisk 4");
        jp.add(button4);
        var button5 = new JButton("P5");
        jp.add(button5);
        jf.add(jp);

        var choice = JOptionPane.showInputDialog("""
                Wybierz swój ulubiony Layout:\s
                1 - BorderLayout\s
                2 - FlowLayout standardowy\s
                3 - FlowLayout z wyrównaniem do lewej\s
                4 - FlowLayout z wyrównaniem do prawej\s
                5 - GridLayout jako jeden wiersz\s
                6 - GridLayout jako jedną kolumnę\s
                7 - GridLayout jako tablice (3, 2)\s""");
        LayoutManager lm;
        switch (choice) {
            case "1" -> lm = new BorderLayout();
            case "2" -> lm = new FlowLayout();
            case "3" -> lm = new FlowLayout(FlowLayout.LEFT);
            case "4" -> lm = new FlowLayout(FlowLayout.RIGHT);
            case "5" -> lm = new GridLayout(1, 0, 0, 0);
            case "6" -> lm = new GridLayout(0, 1, 0, 0);
            case "7" -> lm = new GridLayout(3, 2, 1, 1);
            default -> {
                System.out.println("Wprowadzono błedne dane zostanie wybrany BorderLayout");
                lm = new BorderLayout();
            }
        }
        jp.setLayout(lm);
        jf.setVisible(true);
    }
}