package com.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, multiplyButton, divideButton;
    JButton negativeButton, decimalButton, equalsButton, deleteButton, clearButton;
    JPanel panel;
    Font calculatorFont = new Font("Consolas", Font.BOLD, 30);
    double number1 = 0, number2 = 0, results = 0;
    char operator;

    //constructor
    Calculator() {
        //frame
        frame = new JFrame("Java Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        //textfield
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(calculatorFont);
        textField.setEditable(false);

        //buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        decimalButton = new JButton(".");
        equalsButton = new JButton("=");
        deleteButton = new JButton("Del");
        clearButton = new JButton("Clr");
        negativeButton = new JButton("Neg");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multiplyButton;
        functionButtons[3] = divideButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalsButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = clearButton;
        functionButtons[8] = negativeButton;

        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(calculatorFont);
            functionButtons[i].setFocusable(false);
        }

        //number buttons
        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(calculatorFont);
            numberButtons[i].setFocusable(false);
        }

        //delete, clear, negative
        negativeButton.setBounds(50, 430, 100, 50);
        deleteButton.setBounds(150, 430, 100, 50);
        clearButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplyButton);
        panel.add(numberButtons[0]);
        panel.add(decimalButton);
        panel.add(equalsButton);
        panel.add(divideButton);

        frame.add(negativeButton);
        frame.add(panel);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(textField);
        frame.setVisible(true);

    }


    public static void main(String[] args) {
        Calculator calc = new Calculator(); //instantiate calculator

    }


    //implemented methods
    @Override
    public void actionPerformed(ActionEvent e) {
        //get input from number buttons
        for (int i = 0; i < numberButtons.length; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        //get functionality of decimal button
        if (e.getSource() == decimalButton) {
            textField.setText(textField.getText().concat("."));
        }
        //add button
        if (e.getSource() == addButton) {
            number1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        //subtract button
        if (e.getSource() == subButton) {
            number1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        //multiply button
        if (e.getSource() == multiplyButton) {
            number1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        //divide button
        if (e.getSource() == divideButton) {
            number1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        //equals button
        if (e.getSource() == equalsButton) {
            number2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    results = number1 + number2;
                    break;
                case '-':
                    results = number1 - number2;
                    break;
                case '*':
                    results = number1 * number2;
                    break;
                case '/':
                    results = number1 / number2;
                    break;
            }
            textField.setText(String.valueOf(results));
            number1 = results; //if continuing using result number
        }
        //clear button
        if (e.getSource() == clearButton) {
           textField.setText("");
        }
        //delete button
        if (e.getSource() == deleteButton) {
            String st = textField.getText();
            textField.setText("");
            for (int i = 0; i < st.length() -1; i++) {
                textField.setText(textField.getText() + st.charAt(i));
            }
        }
        //negative button
        if (e.getSource() == negativeButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}
