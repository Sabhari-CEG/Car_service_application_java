package com.sabhari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ImpInfo1{
    public ImpInfo1(String RegNo){
        Info1 info = new Info1(RegNo);
    }
}
public class Info1 implements ActionListener {
    String RegNo;
    JFrame frame11;
    JButton next,home;
    public Info1(String regNo){
        RegNo = regNo;
        frame11 = new JFrame("SERVICE STATION INFO");
        frame11.setContentPane(new JLabel(new ImageIcon("G:\\java\\OOAD\\src\\com\\sabhari\\3.jpg")));
        frame11.setLayout(null);
        ImageIcon icon = new ImageIcon("G:\\java\\OOAD\\src\\com\\sabhari\\manchester-honda.jpg");
        JLabel lab1 = new JLabel(icon);
        lab1.setBounds(250,350,300,300);
        frame11.add(lab1);

        JLabel lab2 = new JLabel("MANCHESTER HONDA COIMBATORE");
        lab2.setFont(new Font("Robot",Font.BOLD,37));
        lab2.setBounds(500,200,800,50);
        frame11.add(lab2);

        JLabel lab3 = new JLabel("ADDRESS  :  ESI Hospital road,Singanallur");
        lab3.setFont(new Font("Sans Serif",Font.BOLD,25));
        lab3.setBounds(650,300,700,40);
        frame11.add(lab3);

        JLabel lab4 = new JLabel("CONTACT  :  9500288488");
        lab4.setFont(new Font("Sans Serif",Font.BOLD,25));
        lab4.setBounds(650,360,700,40);
        frame11.add(lab4);

        JLabel lab5 = new JLabel("TIMINGS  :  09:00AM - 06:00PM");
        lab5.setFont(new Font("Sans Serif",Font.BOLD,25));
        lab5.setBounds(650,420,700,40);
        frame11.add(lab5);

        JLabel lab6 = new JLabel("SERVICES  :  Accident services, Repair services");
        lab6.setFont(new Font("Sans Serif",Font.BOLD,25));
        lab6.setBounds(650,480,700,40);
        frame11.add(lab6);

        JLabel lab7 = new JLabel("VEHICLES  :  All Honda Cars");
        lab7.setFont(new Font("Sans Serif",Font.BOLD,25));
        lab7.setBounds(650,540,700,40);
        frame11.add(lab7);

        JLabel lab8 = new JLabel("RATING  :  4.5 / 5");
        lab8.setFont(new Font("Sans Serif",Font.BOLD,25));
        lab8.setBounds(650,600,700,40);
        frame11.add(lab8);

        next = new JButton("NEXT");
        next.setFont(new Font("Robot",Font.BOLD,25));
        next.setBounds(1000,660,200,40);
        next.setBackground(Color.cyan);
        frame11.add(next);
        next.addActionListener(this::actionPerformed);

        home = new JButton("GO TO HOME");
        home.setFont(new Font("Robot",Font.BOLD,25));
        home.setBounds(600,660,200,40);
        home.setBackground(Color.cyan);
        frame11.add(home);
        home.addActionListener(this::actionPerformed);



        frame11.setVisible(true);
        frame11.setSize(1920,1080);
       // frame11.setDefaultCloseOperation(3);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==home){
            frame11.setVisible(false);
            ImpMainPage mp = new ImpMainPage(RegNo);
        }
        else if (e.getSource()==next){
            frame11.setVisible(false);
            ImpInfo2 info = new ImpInfo2(RegNo);
        }

    }
}
