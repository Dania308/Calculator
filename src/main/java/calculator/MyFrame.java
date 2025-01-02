package calculator;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    // componentele calculatorului
    private JFrame frame;
    private JTextField display;
    private JButton[] numButton = new RoundButton[10]; // butoanele de la 0 la 9
    private JButton[] funcButton = new RoundButton[9];  // +, -, x, / etc
    private RoundButton addButton, minusButton, multiplyButton, divideButton;
    private RoundButton clearButton, decimalButton, equalButton, percentButton, negativeButton;
    private JPanel panel;
    private ImageIcon icon;

    // variabile pentru operatii
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;    // +, -, x, /

    // constructor
    public MyFrame() {
        // setare fereastra
        setTitle("Calculator");
        setSize(360, 580);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        icon = new ImageIcon("APple.png");
        setIconImage(icon.getImage());

        getContentPane().setBackground(Color.BLACK);  // face frame-ul negru


        // initializare display
        display = new JTextField();
        display.setBounds(20, 10, 300, 120);
        display.setBorder(null);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
//        display.setCaretColor(Color.WHITE);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.PLAIN, 45));
        add(display);

        // initializare butoane pentru functii
        addButton = new RoundButton("+");
        minusButton = new RoundButton("-");
        multiplyButton = new RoundButton("x");
        divideButton = new RoundButton("/");
        equalButton = new RoundButton("=");
        negativeButton = new RoundButton("+/-");
        decimalButton = new RoundButton(".");
        clearButton = new RoundButton("C");
        percentButton = new RoundButton("%");


        // adaugare in array pt a le gestiona mai usor - funcButton
        funcButton[0] = addButton;
        funcButton[1] = minusButton;
        funcButton[2] = multiplyButton;
        funcButton[3] = divideButton;
        funcButton[4] = equalButton;
        funcButton[5] = clearButton;
        funcButton[6] = percentButton;
        funcButton[7] = decimalButton;
        funcButton[8] = negativeButton;


        // atribuire ActionListener pentru fiecare buton in functie
        for (int i = 0; i < 9; i++) {
            funcButton[i].addActionListener(this);
            funcButton[i].setFont(new Font("Arial", Font.BOLD, 24));
            funcButton[i].setFocusable(false);
        }

        // initializare butoanelor numerice si adaugare ActionListener
        for (int i = 0; i < 10; i++) {
            numButton[i] = new RoundButton(String.valueOf(i));
            numButton[i].addActionListener(this);
            numButton[i].setFont(new Font("Arial", Font.BOLD, 24));
            numButton[i].setFocusable(false);
        }

        // initializare panel pentru organizarea butoanelor
        panel = new JPanel();
        panel.setBounds(20, 150, 340, 380);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);

        // adaugare butoane numerice si functii in panel
        panel.add(clearButton);
        clearButton.setBounds(0, 0, 70, 70);
        clearButton.setBackground(Color.LIGHT_GRAY);
        clearButton.setForeground(Color.BLACK);
        clearButton.setBorder(null);

        panel.add(negativeButton);
        negativeButton.setBounds(75, 0, 70, 70);
        negativeButton.setBackground(Color.LIGHT_GRAY);
        negativeButton.setForeground(Color.BLACK);
        negativeButton.setFont(new Font("Arial", Font.BOLD, 26));
        negativeButton.setBorder(null);

        panel.add(percentButton);
        percentButton.setBounds(150, 0, 70, 70);
        percentButton.setBackground(Color.LIGHT_GRAY);
        percentButton.setForeground(Color.BLACK);
        percentButton.setBorder(null);

        panel.add(divideButton);
        divideButton.setBounds(225, 0, 70, 70);
        divideButton.setBackground(Color.ORANGE);
        divideButton.setForeground(Color.WHITE);
        divideButton.setBorder(null);

        panel.add(numButton[7]);
        numButton[7].setBounds(0, 75, 70, 70);
        numButton[7].setBackground(Color.DARK_GRAY);
        numButton[7].setForeground(Color.WHITE);
        numButton[7].setBorder(null);

        panel.add(numButton[8]);
        numButton[8].setBounds(75, 75, 70, 70);
        numButton[8].setBackground(Color.DARK_GRAY);
        numButton[8].setForeground(Color.WHITE);
        numButton[8].setBorder(null);

        panel.add(numButton[9]);
        numButton[9].setBounds(150, 75, 70, 70);
        numButton[9].setBackground(Color.DARK_GRAY);
        numButton[9].setForeground(Color.WHITE);
        numButton[9].setBorder(null);

        panel.add(multiplyButton);
        multiplyButton.setBounds(225, 75, 70, 70);
        multiplyButton.setBackground(Color.ORANGE);
        multiplyButton.setForeground(Color.WHITE);
        multiplyButton.setBorder(null);

        panel.add(numButton[4]);
        numButton[4].setBounds(0, 150, 70, 70);
        numButton[4].setBackground(Color.DARK_GRAY);
        numButton[4].setForeground(Color.WHITE);
        numButton[4].setBorder(null);

        panel.add(numButton[5]);
        numButton[5].setBounds(75, 150, 70, 70);
        numButton[5].setBackground(Color.DARK_GRAY);
        numButton[5].setForeground(Color.WHITE);
        numButton[5].setBorder(null);

        panel.add(numButton[6]);
        numButton[6].setBounds(150, 150, 70, 70);
        numButton[6].setBackground(Color.DARK_GRAY);
        numButton[6].setForeground(Color.WHITE);
        numButton[6].setBorder(null);

        panel.add(minusButton);
        minusButton.setBounds(225, 150, 70, 70);
        minusButton.setBackground(Color.ORANGE);
        minusButton.setForeground(Color.WHITE);
        minusButton.setBorder(null);

        panel.add(numButton[1]);
        numButton[1].setBounds(0, 225, 70, 70);
        numButton[1].setBackground(Color.DARK_GRAY);
        numButton[1].setForeground(Color.WHITE);
        numButton[1].setBorder(null);

        panel.add(numButton[2]);
        numButton[2].setBounds(75, 225, 70, 70);
        numButton[2].setBackground(Color.DARK_GRAY);
        numButton[2].setForeground(Color.WHITE);
        numButton[2].setBorder(null);

        panel.add(numButton[3]);
        numButton[3].setBounds(150, 225, 70, 70);
        numButton[3].setBackground(Color.DARK_GRAY);
        numButton[3].setForeground(Color.WHITE);
        numButton[3].setBorder(null);

        panel.add(addButton);
        addButton.setBounds(225, 225, 70, 70);
        addButton.setBackground(Color.ORANGE);
        addButton.setForeground(Color.WHITE);
        addButton.setBorder(null);

        panel.add(numButton[0]);
        numButton[0].setBounds(0, 300, 145, 70);
        numButton[0].setBackground(Color.DARK_GRAY);
        numButton[0].setForeground(Color.WHITE);

        panel.add(decimalButton);
        decimalButton.setBounds(150, 300, 70, 70);
        decimalButton.setBackground(Color.DARK_GRAY);
        decimalButton.setForeground(Color.WHITE);
        decimalButton.setBorder(null);

        panel.add(equalButton);
        equalButton.setBounds(225, 300, 70, 70);
        equalButton.setBackground(Color.ORANGE);
        equalButton.setForeground(Color.WHITE);
        equalButton.setBorder(null);

        // adaugare panel la fereastra
        add(panel);

        // afisare fereastra
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numButton[i]) {
                display.setText(display.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decimalButton) {
            display.setText(display.getText().concat("."));
        }

        if (e.getSource() == negativeButton) {
            String currentText = display.getText();

            if (!currentText.isEmpty()) {  // verifica daca exista un numar pe ecran
                double value = Double.parseDouble(display.getText());
                value *= (-1);  // schimba sensul din poz in neg si invers
                display.setText(String.valueOf(value));
            }
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        }

        if (e.getSource() == minusButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        }

        if (e.getSource() == multiplyButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        }

        if (e.getSource() == divideButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }

        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    result = num1 / num2;
                    break;

                default:
                    System.out.println("Error");
            }
            display.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clearButton) {
            display.setText("");
        }

        if (e.getSource() == percentButton) {
            double value = Double.parseDouble(display.getText());
            value /= 100;
            display.setText(String.format("%.2f", value));
        }
    }
}

