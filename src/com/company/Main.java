package com.company;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.*;



public class Main {
static int key = 0;
    public static void main(String[] args) {
        JFrame a = new JFrame("Cezar");
        JButton b = new JButton("Encrypt");
        JTextField c = new JTextField("Write Message");
        JLabel d = new JLabel("Message");
        ButtonGroup group = new ButtonGroup();
        JRadioButton smallButton = new JRadioButton("Encrypt", false);
        group.add(smallButton);
        JRadioButton mediumButton = new JRadioButton("Decrypt", true);
        group.add(mediumButton);

        String keys[] = { "key","1","2","3","4","5","6","7","8","9","10","11","12","13","14",
                "15","16","17","18","19","20","21","22","23","24","25","26","27"};

        JComboBox Box = new JComboBox(keys);
        Box.setBounds(50,24,200,20);
        c.setBounds(50,48,200,20);
        b.setBounds(100,130,85,20);
        d.setBounds(50,72,200,20);
        smallButton.setBounds(30,100,100,20);
        mediumButton.setBounds(160,100,100,20);
        a.add(b);
        a.add(c);
        a.add(d);
        a.add(Box);
        a.add(smallButton);
        a.add(mediumButton);
        a.setSize(300,200);
        a.setLayout(null);
        a.setVisible(true);
        ImageIcon icon = new ImageIcon("images/warning.png");

        Box.addActionListener(new ActionListener() {
                                  @Override
                                  public void actionPerformed(ActionEvent e) {
                                      key = Box.getSelectedIndex();
                                  }
                              });

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mes = c.getText();
                mes=mes.toLowerCase(Locale.ENGLISH);
                mes=mes.replaceAll(" ", "");
                          if (key < 1 || key > 26) {
                              JOptionPane.showMessageDialog(null,"The Key is not within permissible range");
                          }
            char[] encryptedmes = mes.toCharArray();
                for (int i = 0; i< mes.length(); i++ ){
                if(encryptedmes[i]<97 || encryptedmes[i]>122) {
                    JOptionPane.showMessageDialog(null,"Unacceptable symbols");
                System.out.println("Unacceptable symbols: "+ (int)encryptedmes[i]);
                break;
                }
            }
                if (smallButton.isSelected()){
                for (int i = 0; i< mes.length(); i++ ){
                encryptedmes[i]=(char)((mes.charAt(i)+key-96)%26+96);
                    if(encryptedmes[i]==96) {encryptedmes[i]=122;}
                 }
                }
                else {
                    for (int i = 0; i< mes.length(); i++ ){
                        encryptedmes[i]=(char)((mes.charAt(i)-96-key+26)%26+96);
                        if(encryptedmes[i]<97) {encryptedmes[i]=122;}
                    }
                }
                d.setText(String.valueOf(encryptedmes).toUpperCase(Locale.ROOT));
            }
        });
    }
}
