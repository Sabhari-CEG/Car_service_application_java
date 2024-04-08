package com.sabhari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class ImpTowingBook{
    public ImpTowingBook(String RegNo){
        TowingBook towing = new TowingBook(RegNo);
    }
}
public class TowingBook implements ActionListener {
    JFrame frame7;
    String RegNo;
    JComboBox cb1;
    JTextField tf1,tf2,tf3;
    JButton book,home;
    Connection con = null;

    public TowingBook(String regNo){
        RegNo = regNo;
        frame7 = new JFrame("TOWING BOOKING");
        frame7.setContentPane(new JLabel(new ImageIcon("G:\\java\\OOAD\\src\\com\\sabhari\\3.jpg")));
        frame7.setLayout(null);

        JLabel lab1 = new JLabel("Reason for Towing");
        lab1.setFont(new Font("Robot",Font.BOLD,25));
        lab1.setBounds(380,200,450,50);
        frame7.add(lab1);
        String[] reason = {"Breakdown","Accident","Blocking traffic","Serious repair","Expired registration"};
        cb1 = new JComboBox(reason);
        cb1.setFont(new Font("Robot",Font.BOLD,25));
        cb1.setBounds(300,280,450,50);
        cb1.setBackground(Color.lightGray);
        frame7.add(cb1);

        JLabel lab2 = new JLabel("Enter the Location");
        lab2.setFont(new Font("Robot",Font.BOLD,25));
        lab2.setBounds(900,200,450,50);
        frame7.add(lab2);
        tf1 = new JTextField();
        tf1.setBounds(800,280,450,50);
        tf1.setBackground(Color.lightGray);
        tf1.setFont(new Font("Sans Serif",Font.BOLD,20));
        frame7.add(tf1);

        JLabel lab3 = new JLabel("Enter the contact number");
        lab3.setFont(new Font("Robot",Font.BOLD,25));
        lab3.setBounds(380,400,450,50);
        frame7.add(lab3);
        tf2 = new JTextField();
        tf2.setBounds(300,480,450,50);
        tf2.setBackground(Color.lightGray);
        tf2.setFont(new Font("Sans Serif",Font.BOLD,20));
        frame7.add(tf2);

        JLabel lab4 = new JLabel("Enter the Desired station");
        lab4.setFont(new Font("Robot",Font.BOLD,25));
        lab4.setBounds(900,400,450,50);
        frame7.add(lab4);
        tf3 = new JTextField();
        tf3.setBounds(800,480,450,50);
        tf3.setBackground(Color.lightGray);
        tf3.setFont(new Font("Sans Serif",Font.BOLD,20));
        frame7.add(tf3);

        book = new JButton("BOOK PICKUP");
        book.setFont(new Font("Robot",Font.BOLD,25));
        book.setBounds(350,630,300,40);
        book.setBackground(Color.cyan);
        frame7.add(book);
        book.addActionListener(this::actionPerformed);

        home = new JButton("GO TO HOME");
        home.setFont(new Font("Robot",Font.BOLD,25));
        home.setBounds(850,630,300,40);
        home.setBackground(Color.cyan);
        frame7.add(home);
        home.addActionListener(this::actionPerformed);






        frame7.setVisible(true);
        //frame7.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame7.setSize(1920,1080);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==book){
            String url = "jdbc:mysql://localhost/carservicemanagement?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String UserName = "sabhari";
            String PassWord = "2000";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
                System.out.println("Error in Registering jdbc");
            }


            try {
                con = DriverManager.getConnection(url, UserName, PassWord);
                System.out.println("Successfully connected to JDBC");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("Error in connecting to jdbc");
            }

            String TowingReason = String.valueOf(cb1.getSelectedItem());
            String location = tf1.getText();
            String contact = tf2.getText();
            String station = tf3.getText();

            String query = "INSERT INTO `towing`(`RegistrationNO`, `TowingReason`, `Location`, `ContactNumber`, `station`) VALUES (\"" + RegNo + "\",\"" + TowingReason + "\",\"" + location + "\",\"" + contact + "\",\"" + station + "\");";

            Statement st = null;
            try {
                st = con.createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("Error in statement");
            }
            int affected = 0;
            try {
                affected = st.executeUpdate(query);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("Error in entering into table");
            }

            if (affected == 1){
                JOptionPane.showMessageDialog(null,"SUCCESSFULLY BOOKED FOR TOWING","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");


            }
            String nofification = "Towing to " + location + " from " + location + " because of " + TowingReason;
            query = "INSERT INTO `notification`(`RegistrationNO`, `notification`) VALUES (\"" + RegNo + "\",\"" + nofification +"\");";
            affected = 0;
            try {
                affected = st.executeUpdate(query);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("Error in entering into table");
            }
            if (affected == 1)
                System.out.println("Notification added");

        }

        else if (e.getSource()==home){
            frame7.setVisible(false);
            ImpMainPage mp = new ImpMainPage(RegNo);
        }

    }
}
