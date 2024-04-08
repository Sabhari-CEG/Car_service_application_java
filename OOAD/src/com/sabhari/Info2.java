package com.sabhari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ImpInfo2{
    public ImpInfo2(String RegNo){
        Info2 info = new Info2(RegNo);
    }
}
public class Info2 implements ActionListener {
    String RegNo;
    JFrame frame12;
    JButton home,previous;

    public Info2(String regNo){
        RegNo = regNo;
        frame12 = new JFrame("SERVICE STATION INFO");
        frame12.setContentPane(new JLabel(new ImageIcon("G:\\java\\OOAD\\src\\com\\sabhari\\3.jpg")));
        frame12.setLayout(null);
        ImageIcon icon = new ImageIcon("G:\\java\\OOAD\\src\\com\\sabhari\\maxresdefault.jpg");
        JLabel lab1 = new JLabel(icon);
        lab1.setBounds(250,350,300,300);
        frame12.add(lab1);

        JLabel lab2 = new JLabel("NEXA SERVICE CENTER");
        lab2.setFont(new Font("Robot",Font.BOLD,37));
        lab2.setBounds(500,200,800,50);
        frame12.add(lab2);

        JLabel lab3 = new JLabel("ADDRESS  :  Nava India Road,Peelamedu");
        lab3.setFont(new Font("Sans Serif",Font.BOLD,25));
        lab3.setBounds(650,300,700,40);
        frame12.add(lab3);

        JLabel lab4 = new JLabel("CONTACT  :  9600222538");
        lab4.setFont(new Font("Sans Serif",Font.BOLD,25));
        lab4.setBounds(650,360,700,40);
        frame12.add(lab4);

        JLabel lab5 = new JLabel("TIMINGS  :  08:30AM - 06:00PM");
        lab5.setFont(new Font("Sans Serif",Font.BOLD,25));
        lab5.setBounds(650,420,700,40);
        frame12.add(lab5);

        JLabel lab6 = new JLabel("SERVICES  :  Accident services, Repair services");
        lab6.setFont(new Font("Sans Serif",Font.BOLD,25));
        lab6.setBounds(650,480,700,40);
        frame12.add(lab6);

        JLabel lab7 = new JLabel("VEHICLES  :  Suzuki Hatchbacks, sedans ands XUV");
        lab7.setFont(new Font("Sans Serif",Font.BOLD,25));
        lab7.setBounds(650,540,700,40);
        frame12.add(lab7);

        JLabel lab8 = new JLabel("RATING  :  4.2 / 5");
        lab8.setFont(new Font("Sans Serif",Font.BOLD,25));
        lab8.setBounds(650,600,700,40);
        frame12.add(lab8);


        home = new JButton("GO TO HOME");
        home.setFont(new Font("Robot",Font.BOLD,25));
        home.setBounds(1000,660,200,40);
        home.setBackground(Color.cyan);
        frame12.add(home);
        home.addActionListener(this::actionPerformed);

        previous = new JButton("GO TO HOME");
        previous.setFont(new Font("Robot",Font.BOLD,25));
        previous.setBounds(600,660,200,40);
        previous.setBackground(Color.cyan);
        frame12.add(previous);
        previous.addActionListener(this::actionPerformed);




        frame12.setVisible(true);
        frame12.setSize(1920,1080);
       // frame12.setDefaultCloseOperation(3);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==home){
            frame12.setVisible(false);
            ImpMainPage mp = new ImpMainPage(RegNo);
        }
        if (e.getSource()==previous){
            frame12.setVisible(false);
            ImpInfo1 info = new ImpInfo1(RegNo);
        }

    }
}
