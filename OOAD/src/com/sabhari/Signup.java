package com.sabhari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class ImpSignup {


        Signup signup = new Signup();

}
public class Signup implements ActionListener {

    JFrame frame2;
    JTextField tf1;
    JPasswordField tf2,tf3;
    JButton next;

    public Signup(){
        frame2 = new JFrame("SIGNUP");
        frame2.setContentPane(new JLabel(new ImageIcon("G:\\java\\OOAD\\src\\com\\sabhari\\webdes-5.jpg")));
        frame2.setLayout(null);

        JLabel lab1 = new JLabel("Enter Your Registration Number");
        lab1.setFont(new Font("Robot",Font.BOLD,25));
        //JPanel pan1 = new JPanel();
        //pan1.setBackground(Color.white);
        //pan1.add(lab1);
        lab1.setBounds(780,250,450,35);
        frame2.add(lab1);
        tf1 = new JTextField();
        tf1.setBounds(750,320,450,45);
        tf1.setBackground(Color.lightGray);
        tf1.setFont(new Font("Sans Serif",Font.BOLD,20));
        frame2.add(tf1);

        JLabel lab2 = new JLabel("Enter Your New Password");
        lab2.setFont(new Font("Robot",Font.BOLD,25));
        //JPanel pan2 = new JPanel();
        //pan2.setBackground(Color.white);
        //pan2.add(lab2);
        lab2.setBounds(830,390,450,35);
        frame2.add(lab2);
        tf2 = new JPasswordField();
        tf2.setBounds(750,460,450,45);
        tf2.setBackground(Color.lightGray);
        tf2.setFont(new Font("Sans Serif",Font.BOLD,20));
        frame2.add(tf2);

        JLabel lab3 = new JLabel("Confirm Your New Password");
        lab3.setFont(new Font("Robot",Font.BOLD,25));
        //JPanel pan3 = new JPanel();
        //pan3.setBackground(Color.white);
        //pan3.add(lab3);
        lab3.setBounds(830,520,450,35);
        frame2.add(lab3);
        tf3 = new JPasswordField();
        tf3.setBounds(750,590,450,45);
        tf3.setBackground(Color.lightGray);
        tf3.setFont(new Font("Sans Serif",Font.BOLD,20));
        frame2.add(tf3);


        next = new JButton("NEXT");
        next.setFont(new Font("Robot",Font.BOLD,25));
        next.setBounds(1000,660,200,40);
        next.setBackground(Color.cyan);
        frame2.add(next);
        next.addActionListener(this::actionPerformed);


        frame2.setVisible(true);
        frame2.setSize(1920,1080);
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==next){

            String RegNo = tf1.getText();
            String pass = String.valueOf(tf2.getPassword());
            String passcon = String.valueOf(tf3.getPassword());

            if (!(pass.equalsIgnoreCase(passcon))){
                JOptionPane.showMessageDialog(null,"Password and confirm Password must be same!!","ERROR",JOptionPane.ERROR_MESSAGE);
            }


                frame2.setVisible(false);
                ImpSignup2 signup2 = new ImpSignup2(RegNo,pass);




        }
    }
}
