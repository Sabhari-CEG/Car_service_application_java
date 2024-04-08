package com.sabhari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ImpHelper{
    public ImpHelper(String RegNo) {
        Helper help = new Helper(RegNo);
    }
}
public class Helper implements ActionListener {
    JFrame frame10;
    JTextField tf1;
    JButton ask,home;
    JLabel lab2,lab3,lab4,lab5;
    String RegNo;

    public Helper(String regNo){
        frame10 = new JFrame("WELCOME TO HELPER");
        RegNo = regNo;
        frame10.setContentPane(new JLabel(new ImageIcon("G:\\java\\OOAD\\src\\com\\sabhari\\3.jpg")));
        frame10.setLayout(null);

        JLabel lab1 = new JLabel("Ask me your question, i will help you");
        lab1.setFont(new Font("Robot",Font.BOLD,25));
        lab1.setBounds(550,200,600,50);
        frame10.add(lab1);
        tf1 = new JTextField();
        tf1.setBounds(350,280,800,50);
        tf1.setBackground(Color.lightGray);
        tf1.setFont(new Font("Sans Serif",Font.BOLD,20));
        frame10.add(tf1);

        ask = new JButton("ASK ME");
        ask.setFont(new Font("Robot",Font.BOLD,25));
        ask.setBounds(650,350,200,40);
        ask.setBackground(Color.cyan);
        frame10.add(ask);
        ask.addActionListener(this::actionPerformed);

        lab2 = new JLabel("");
        lab2.setFont(new Font("Robot",Font.BOLD,25));
        lab2.setBounds(380,450,800,50);
        frame10.add(lab2);

        lab3 = new JLabel("");
        lab3.setFont(new Font("Robot",Font.BOLD,25));
        lab3.setBounds(380,520,900,50);
        frame10.add(lab3);

        lab4 = new JLabel("");
        lab4.setFont(new Font("Robot",Font.BOLD,25));
        lab4.setBounds(380,590,900,50);
        frame10.add(lab4);

        lab5 = new JLabel("");
        lab5.setFont(new Font("Robot",Font.BOLD,25));
        lab5.setBounds(380,660,900,50);
        frame10.add(lab5);

        home = new JButton("GO TO HOME");
        home.setFont(new Font("Robot",Font.BOLD,25));
        home.setBounds(850,720,300,40);
        home.setBackground(Color.white);
        frame10.add(home);
        home.addActionListener(this::actionPerformed);




        frame10.setVisible(true);
        frame10.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame10.setSize(1920,1080);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==ask){
            String req = tf1.getText();

            if (req.contains("Hi") || req.contains("hi")){
                lab2.setText("Hello!!!");
                lab3.setText("Welcome to help section");
                lab4.setText("");
                lab5.setText("");
                tf1.setText("");
            }
            else if (req.contains("book service")){
                lab2.setText("You will be directed to service booking page");
                lab3.setText("Return back soon!!");
                lab4.setText("Because I have more functions");
                lab5.setText("");
                tf1.setText("");
                ImpServiceBook serviceBook = new ImpServiceBook(RegNo);
            }
            else if (req.contains("book pickup")){
                lab2.setText("You will be directed to service booking page");
                lab3.setText("Return back soon!!");
                lab4.setText("Because I have more functions");
                lab5.setText("");
                tf1.setText("");
                ImpPickupBook pickupBook = new ImpPickupBook(RegNo);
            }
            else if (req.contains("book towing")){
                lab2.setText("You will be directed to service booking page");
                lab3.setText("Return back soon!!");
                lab4.setText("Because I have more functions");
                lab5.setText("");
                tf1.setText("");
                ImpTowingBook towingBook = new ImpTowingBook(RegNo);
            }
            else if (req.contains("notification")){
                lab2.setText("You will be directed to service booking page");
                lab3.setText("Return back soon!!");
                lab4.setText("Because I have more functions");
                lab5.setText("");
                tf1.setText("");
                ImpNotification notification = new ImpNotification(RegNo);
            }
            else if (req.contains("station info")){
                lab2.setText("You will be directed to service booking page");
                lab3.setText("Return back soon!!");
                lab4.setText("Because I have more functions");
                lab5.setText("");
                tf1.setText("");
                ImpInfo1 info = new ImpInfo1(RegNo);
            }
            else if (req.contains("service records")){
                lab2.setText("You will be directed to service booking page");
                lab3.setText("Return back soon!!");
                lab4.setText("Because I have more functions");
                lab5.setText("");
                tf1.setText("");
                ImpServiceRecords serviceRecords = new ImpServiceRecords(RegNo);
            }
            else if (req.contains("warning light")){
                if (req.contains("red")){
                    lab2.setText("Red warning light says that you should act quickly");
                    lab3.setText("The problem is serious");
                    lab4.setText("It may caused due to overheating of engine,low engine oil etc");
                    lab5.setText("You should stop driving immediately");
                    tf1.setText("");
                }
                if (req.contains("orange")){
                    lab2.setText("It means the engine management system, the computer that runs engine has dectected fault");
                    lab3.setText("You can continue driving but");
                    lab4.setText("Diagnose and repair your car as soon as possible");
                    lab5.setText("Don't relax!! Book your service now!");
                    tf1.setText("");
                }
            }
            else if (req.contains("puncture")){
                lab2.setText("Look for additional tyre and tools at the back of your car");
                lab3.setText("Find the appropriate tools and lift the car");
                lab4.setText("Replace the additional tyre and fix it well");
                lab5.setText("Always check for pressure on the additional tyre");
                tf1.setText("");

            }
            else if (req.contains("oil leak")){
                lab2.setText("It may be due to oil pan damage or oil drain plug or oil filter");
                lab3.setText("Find the mechanic as soon as possible");
                lab4.setText("Oil leak can reduce oil level which may cause serious engine problems");
                lab5.setText("Always check for leakage of oil whenever you start a ride");
                tf1.setText("");

            }
            else if (req.contains("car doesn't start")){
                lab2.setText("It is caused by dying or dead battery or even a spark plug problem");
                lab3.setText("If your car doesn't start on cold mornings and the jumpstarting works then it is due to dead battery");
                lab4.setText("If your jumpstarting doesn't work then it is a spark plug problem");
                lab5.setText("Avoid jumpstarting and charge the battery once you find battery is dead");
                tf1.setText("");

            }
            else if (req.contains("ac not working")){
                lab2.setText("It may be due to leaking of refrigerents in your car");
                lab3.setText("The condenser may be damaged or blocked");
                lab4.setText("There may be electrical issues, check the working of mp3 player");
                lab5.setText("There may be Faulty cooling fans or compressor problem");
                tf1.setText("");

            }
            else if (req.contains("overheating")){
                lab2.setText("Turn off AC because Ac puts a lot of load on engines");
                lab3.setText("Turn on heater which can drain some engine heat");
                lab4.setText("park the car and rev it, so the fans and water pump works faster");
                lab5.setText("Pull over and open the hood, which can release heat");
                tf1.setText("");

            }
            else {
                lab2.setText("Problem founds to be serious");
                lab3.setText("Approach service station today");
                lab4.setText("you can book service here");
                lab5.setText("");
                tf1.setText("");

            }

        }
        else if (e.getSource()==home){
            frame10.setVisible(false);
            ImpMainPage mp = new ImpMainPage(RegNo);
        }

    }
}
