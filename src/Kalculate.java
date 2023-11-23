//package com.test.java1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kalculate implements ActionListener {
    JFrame frame = new JFrame("Калькулятор");
    JTextField text = new JTextField();
    JButton button_1,button_2,button_3,button_4,button_5,button_6,button_7,button_8,button_9,button_10,button_11,button_12,button_13,button_14,button_15,button_16;
    int oper = 0,sum = 0 ,number_1 = 0, number_2 = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Kalculate();
            }
        });
    }
    Kalculate(){
        frame.setSize(240,270);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

        button_1 = new JButton("1");
        button_2 = new JButton("2");
        button_3 = new JButton("3");
        button_4 = new JButton("4");
        button_5 = new JButton("5");
        button_6 = new JButton("6");
        button_7 = new JButton("7");
        button_8 = new JButton("8");
        button_9 = new JButton("9");
        button_10 = new JButton("0");
        button_11 = new JButton("+");
        button_12 = new JButton("-");
        button_13 = new JButton("*");
        button_14 = new JButton("/");
        button_15 = new JButton("=");
        button_16 = new JButton("C");


        text.setBounds(5, 10, 215,40);

        button_7.setBounds(5,50,50,40);
        button_8.setBounds(60,50,50,40);
        button_9.setBounds(115,50,50,40);
        button_14.setBounds(170,50,50,40);

        button_4.setBounds(5,95,50,40);
        button_5.setBounds(60,95,50,40 );
        button_6.setBounds(115,95,50,40);
        button_13.setBounds(170,95,50,40);

        button_1.setBounds(5,140,50,40);
        button_2.setBounds(60,140,50,40);
        button_3.setBounds(115,140,50,40);
        button_11.setBounds(170,140,50,40);

        button_10.setBounds(5,185,50,40);
        button_12.setBounds(60,185,50,40);
        button_15.setBounds(115,185,50,40);
        button_16.setBounds(170,185,50,40);

        frame.add(text);
        frame.add(button_7);
        frame.add(button_8);
        frame.add(button_9);
        frame.add(button_14);
        frame.add(button_4);
        frame.add(button_5);
        frame.add(button_6);
        frame.add(button_13);
        frame.add(button_1);
        frame.add(button_2);
        frame.add(button_3);
        frame.add(button_11);
        frame.add(button_10);
        frame.add(button_12);
        frame.add(button_15);
        frame.add(button_16);

        button_1.addActionListener(this);
        button_2.addActionListener(this);
        button_3.addActionListener(this);
        button_4.addActionListener(this);
        button_5.addActionListener(this);
        button_6.addActionListener(this);
        button_7.addActionListener(this);
        button_8.addActionListener(this);
        button_9.addActionListener(this);
        button_10.addActionListener(this);
        button_11.addActionListener(this);
        button_12.addActionListener(this);
        button_13.addActionListener(this);
        button_14.addActionListener(this);
        button_16.addActionListener(this);
        button_15.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent q) {
        if (q.getSource() == button_1)
            text.setText("1");
        if (q.getSource() == button_2)
            text.setText("2");
        if (q.getSource() == button_3)
            text.setText("3");
        if (q.getSource() == button_4)
            text.setText("4");
        if (q.getSource() == button_5)
            text.setText("5");
        if (q.getSource() == button_6)
            text.setText("6");
        if (q.getSource() == button_7)
            text.setText("7");
        if (q.getSource() == button_8)
            text.setText("8");
        if (q.getSource() == button_9)
            text.setText("9");
        if (q.getSource() == button_10)
            text.setText("0");
        if(q.getSource()== button_11)
        {
            number_1=Integer.parseInt(text.getText());
            oper=1;
            text.setText("+");
        }
        if(q.getSource()== button_12)
        {
            number_1 =  Integer.parseInt(text.getText());
            oper = 2;
            text.setText("-");
        }
        if(q.getSource()== button_13)
        {
            number_1=  Integer.parseInt(text.getText());
            oper=3;
            text.setText("*");
        }
        if(q.getSource()== button_14)
        {
            number_1=  Integer.parseInt(text.getText());
            oper=4;
            text.setText("/");
        }
        if (q.getSource() == button_16)
            text.setText(" ");

        if (q.getSource() == button_15){

            number_2=Integer.parseInt(text.getText());

            switch (oper) {
                case 1:
                    sum = number_1 + number_2;break;
                case 2:
                    sum = number_1 - number_2;break;
                case 3:
                    sum = number_1 * number_2;break;
                case 4:
                    sum = number_1 / number_2;break;
                default: sum = 0;
            }
            text.setText("" + sum);
        }
    }
}
