package oop.labs.lab_8.zadanie15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Logger;

public class Zadanie15 extends JFrame {
    static Logger logger = Logger.getLogger("logger");

    public static void main(String[] args) {
        new Zadanie15();
    }
    public Zadanie15() {
        SwingUtilities.invokeLater(
                this::initializeApp
        );
    }

    private void initializeApp() {
        logger.info("Initializing App");
        var frame = new JFrame();
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(600,500));
        frame.setSize(800,640);
        var jp = new JPanel();
        jp.setLayout(new BorderLayout());
        JTextArea textArea = addTextArea(jp);
        addHeader(jp, textArea);
        addFooter(jp, textArea);
        frame.add(jp);
        frame.pack();
        logger.info("App Ready!!!");
    }

    public void addHeader(JPanel jp, JTextArea textArea) {
        logger.info("Initializing Header");
        var header = new JPanel();
        header.setLayout(new BorderLayout());
        header.setBorder(BorderFactory.createEmptyBorder(2,12,2, 20));
        initializeLeftHeader(textArea, header);
        initializeRightHeader(textArea, header);
        jp.add(header, BorderLayout.NORTH);
        logger.info("Successfully initialized Header");
    }

    private void initializeRightHeader(JTextArea textArea, JPanel header) {
        logger.info("Initializing Right header");
        JPanel headerRight = new JPanel();
        headerRight.setLayout(new GridLayout(1, 3, 8, 8));
        headerRight.add(createLetterAppendingButton(textArea, "A"));
        headerRight.add(createLetterAppendingButton(textArea, "B"));
        headerRight.add(createLetterAppendingButton(textArea, "C"));
        header.add(headerRight, BorderLayout.EAST);
        logger.info("Successfully initialized right header with buttons");
    }

    private void initializeLeftHeader(JTextArea textArea, JPanel header) {
        logger.info("Initializing left header");
        var headerLeft = new JPanel();
        headerLeft.setLayout(new GridLayout(1, 3, 8, 8));
        headerLeft.add(createColorChangingButton(textArea, "FR", Color.RED));
        headerLeft.add(createColorChangingButton(textArea, "FG", Color.GREEN));
        headerLeft.add(createColorChangingButton(textArea, "FB", Color.BLUE));
        header.add(headerLeft, BorderLayout.WEST);
        logger.info("Successfully initialized left header with buttons");
    }

    private JButton createColorChangingButton(JTextArea textArea, String text, Color color) {
        logger.info("Creating Color Changing Button ");
        var but = new JButton(text);
        but.setForeground(color);
        but.addActionListener(e -> textArea.setForeground(color));
        return but;
    }

    private JButton createLetterAppendingButton(JTextArea textArea, String letter) {
        logger.info("Creating  " + letter + " Letter Appending Button ");
        var but = new JButton(letter);
        but.addActionListener(e -> textArea.append(letter));
        return but;
    }

    private JTextArea addTextArea(JPanel jp) {
        logger.info("Initializing Text Area");
        var center = new JPanel();
        var textArea = new JTextArea();
        var sp = new JScrollPane(textArea);
        center.setLayout(new BorderLayout());
        textArea.setPreferredSize(new Dimension(400,200));
        textArea.setText("Obszar tekstowy typu JTextArea");
        sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        center.add(sp);
        jp.add(center, BorderLayout.CENTER);
        logger.info("Successfully initialized Text Area");
        return textArea;
    }

    private void addFooter(JPanel jp, JTextArea textArea) {
        logger.info("Initializing Footer");
        var footer = new JPanel();
        footer.setLayout(new GridLayout(1, 2,2,2));
        footer.setBorder(BorderFactory.createEmptyBorder(2,2,2,0));
        initializingLeftFooter(textArea, footer);
        initializingRightFooter(textArea, footer);
        jp.add(footer, BorderLayout.SOUTH);
        logger.info("Successfully initialized Footer");
    }

    private void initializingRightFooter(JTextArea textArea, JPanel footer) {
        logger.info("Initializing Right Footer");
        var footerRight = new JPanel();
        footerRight.setLayout(new GridLayout(3, 0, 0, 2));
        for(int i = 1; i < 4; i++) {
            var textField = new JTextField();
            textField.setPreferredSize(new Dimension(350,15));
            textField.setText(getTextField(i));
            textField.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            textField.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if(textField.getText().contains("Pole tekstowe")) {
                        textField.setText("");
                    }
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                        var field = (JTextField) e.getSource();
                        textArea.append("\n" + field.getText());
                        textField.setText("");
                    }
                }
                @Override
                public void keyReleased(KeyEvent e) { }
            });
            footerRight.add(textField);
        }
        footer.add(footerRight);
        logger.info("Successfully initialized Right Footer");
    }

    private String getTextField(int i) {
        return String.format("Pole tekstowe %s typu %s", i, "JTextField");
    }

    private void initializingLeftFooter(JTextArea textArea, JPanel footer) {
        logger.info("Initializing Left Footer");
        var footerLeft = new JPanel();
        var numbers = new JPanel();
        footerLeft.setLayout(new FlowLayout(FlowLayout.LEADING));
        numbers.setLayout(new GridLayout(3, 3, 1, 1));
        for(int i = 1; i < 10; i++) {
            var numberButton = new JButton(String.valueOf(i));
            numberButton.addActionListener((e -> textArea.append(e.getActionCommand())));
            numbers.add(numberButton);
        }
        footerLeft.add(numbers);
        footer.add(footerLeft);
        logger.info("Successfully initialized Left Footer");
    }
}