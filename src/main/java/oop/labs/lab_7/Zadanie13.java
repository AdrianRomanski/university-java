package oop.labs.lab_7;

import javax.swing.*;
import java.awt.*;

public class Zadanie13 {


    public static void main(String[] args)
    {
        new Zadanie13();
    }

    public Zadanie13()
    {
        SwingUtilities.invokeLater(
                () -> createGUI()
        );
    }

    protected void createGUI()
    {
        // utworzenie okna
        JFrame jf = new JFrame();

        // określenie tytułu okna
        jf.setTitle("Simple Swing App");

        // obsługa zamknięcia okna JFrame
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String x = JOptionPane.showInputDialog("Podaj położenie x okna");
        String y = JOptionPane.showInputDialog("Podaj położenie y okna");

        // określenie położenia okna
        jf.setLocation(Integer.parseInt(x), Integer.parseInt(y));

        // dodatkowy panel do grupowania komponentów
        JPanel jp = new JPanel();

        // ustawianie zarządcy rozkładu dla panelu
        jp.setLayout(new GridLayout(2, 3, 2, 2));

        // dodawanie komponentów do panelu
        for (int i = 0; i < 6; i++)
            jp.add(new JButton(""+i));

        // ustawianie zarządcy rozkladu dla okna
        jf.setLayout(new FlowLayout(FlowLayout.CENTER));

        // dodawanie komponentów do okna
        jf.add(jp);
        jf.add(new JButton("7"));

        String colorString = JOptionPane.showInputDialog("Wybierz jeden z kolorów tla: Czerwony, Niebieski, Zielony");

        Color color = getColor(colorString);

        jf.getContentPane().setBackground(color);


        String tekst = JOptionPane.showInputDialog("Wprowadz Tekst dla komponentu");
        String kolorCzcionki = JOptionPane.showInputDialog("Wybierz jeden z kolorów czcionki: Czerwony, Niebieski, Zielony");

        Color colorCzcionki = getColor(kolorCzcionki);

        String stylCzcionkiString = JOptionPane.showInputDialog("Wybierz styl czcionki: Zwykla, Pogrubiona, Italic");
        String rozmiarCzcionki = JOptionPane.showInputDialog("Wybierz rozmiar czcionki");
        Font font;

        font = getFont(stylCzcionkiString, rozmiarCzcionki);

        JLabel title = new JLabel(tekst, JLabel.CENTER);
        title.setFont(font);
        title.setForeground(colorCzcionki);

        jf.add(title);

        // ustawianie możliwości zmiany rozmiarów okna
        jf.setResizable(true);

        // upakowanie okna
        jf.pack();

        // wyświetlenie okna
        jf.setVisible(true);
    }

    private Font getFont(String stylCzcionkiString, String rozmiarCzcionki) {
        Font font;
        switch (stylCzcionkiString.toLowerCase()) {
            case "pogrubiona" -> font = new Font("Serif", Font.BOLD, Integer.parseInt(rozmiarCzcionki));
            case "zwykla" -> font = new Font("Serif", Font.PLAIN, Integer.parseInt(rozmiarCzcionki));
            case "italic" -> font = new Font("Serif", Font.ITALIC, Integer.parseInt(rozmiarCzcionki));
            default -> font = new Font("Serif", Font.BOLD, Integer.parseInt(rozmiarCzcionki));
        }
        return font;
    }

    private Color getColor(String colorString) {
        return switch (colorString.toLowerCase()) {
            case "czerwony" -> Color.RED;
            case "niebieski" -> Color.BLUE;
            case "zielony" -> Color.GREEN;
            default -> Color.LIGHT_GRAY;
        };
    }


}
