package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

public class electricitybill {
    private JTextField txtcid;
    private JTextField txtcname;
    private JTextField txtunit;
    private JButton calculateButton;
    private JTextArea txtprint;
    private JButton printButton;
    private JPanel panel;
    JFrame frame=new JFrame();
    public electricitybill() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        calculateButton.addActionListener(new ActionListener() {
             String cid;
            double charge,gramount;
            int count;
            public void actionPerformed(ActionEvent e) {
                cid=txtcid.getText();
                count=Integer.parseInt(txtunit.getText());
                if(count<500) {
                    charge=1.00;
                }
                else if(count<500 && count<600) {
                    charge=1.80;
                }
                else if(count<600 && count<800) {
                    charge=2.80;
                }else {
                    charge=3.00;
                }
                gramount=charge*count;
                print();

            }

           public void print() {
               String billid = txtcid.getText();
               String customer = txtcname.getText();
               count = Integer.parseInt(txtunit.getText());

               txtprint.setText(txtprint.getText() + "\n");
               txtprint.setText( txtprint.getText() + "Electricity Billing System" + "\n");
               txtprint.setText( txtprint.getText() + "\n");
               txtprint.setText( txtprint.getText() + "Bill No : - "  + billid + "\n");
               txtprint.setText( txtprint.getText() + "Customer : - " + customer + "\n");
               txtprint.setText( txtprint.getText() + "Unit  : - " + count + "\n");
               txtprint.setText( txtprint.getText() + "Amount  : - " + gramount + "\n");
               txtprint.setText(txtprint.getText() + "Thank you Come Again \n");
           }
        });
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    txtprint.print();
                } catch (PrinterException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }


}