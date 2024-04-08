package com.sabhari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class ImpPickupBook{
    public ImpPickupBook(String RegNo){
        PickupBook pickup = new PickupBook(RegNo);
    }
}
public class PickupBook implements ActionListener {
    JFrame frame6;
    String RegNo;
    JComboBox cb1,cb2;
    JTextField tf1,tf2;
    JButton book,home;
    Connection con = null;

    public PickupBook(String regNo){
        RegNo = regNo;
        frame6 = new JFrame("PICKUP BOOKING");
        frame6.setContentPane(new JLabel(new ImageIcon("G:\\java\\OOAD\\src\\com\\sabhari\\3.jpg")));
        frame6.setLayout(null);



        JLabel lab1 = new JLabel("Select any one of our services");
        lab1.setFont(new Font("Robot",Font.BOLD,25));
        lab1.setBounds(380,200,450,50);
        frame6.add(lab1);
        String[] service = {"Pickup and Drop","Pickup Only","Drop Only"};
        cb1 = new JComboBox(service);
        cb1.setFont(new Font("Robot",Font.BOLD,25));
        cb1.setBounds(300,280,450,50);
        cb1.setBackground(Color.lightGray);
        frame6.add(cb1);


        JLabel lab2 = new JLabel("Select the desired time slot");
        lab2.setFont(new Font("Robot",Font.BOLD,25));
        lab2.setBounds(900,200,450,50);
        frame6.add(lab2);
        String[] timing = {"8 AM - 10 AM","10 AM - 12 PM","12 PM - 2 PM","2 PM - 4 PM","4 PM - 6 PM"};
        cb2 = new JComboBox(timing);
        cb2.setFont(new Font("Robot",Font.BOLD,25));
        cb2.setBounds(800,280,450,50);
        cb2.setBackground(Color.lightGray);
        frame6.add(cb2);

        JLabel lab3 = new JLabel("Enter the Pickup address.");
        lab3.setFont(new Font("Robot",Font.BOLD,25));
        lab3.setBounds(380,400,450,80);
        frame6.add(lab3);
        tf1 = new JTextField();
        tf1.setBounds(300,480,450,50);
        tf1.setBackground(Color.lightGray);
        tf1.setFont(new Font("Sans Serif",Font.BOLD,20));
        frame6.add(tf1);

        JLabel lab4 = new JLabel("Enter Contact number");
        lab4.setFont(new Font("Robot",Font.BOLD,25));
        lab4.setBounds(900,400,450,80);
        frame6.add(lab4);
        tf2 = new JTextField();
        tf2.setBounds(800,480,450,50);
        tf2.setBackground(Color.lightGray);
        tf2.setFont(new Font("Sans Serif",Font.BOLD,20));
        frame6.add(tf2);

        book = new JButton("BOOK PICKUP");
        book.setFont(new Font("Robot",Font.BOLD,25));
        book.setBounds(350,630,300,40);
        book.setBackground(Color.cyan);
        frame6.add(book);
        book.addActionListener(this::actionPerformed);

        home = new JButton("GO TO HOME");
        home.setFont(new Font("Robot",Font.BOLD,25));
        home.setBounds(850,630,300,40);
        home.setBackground(Color.cyan);
        frame6.add(home);
        home.addActionListener(this::actionPerformed);





        frame6.setVisible(true);
        //frame6.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame6.setSize(1920,1080);
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

            String PickupType = String.valueOf(cb1.getSelectedItem());
            String time = String.valueOf(cb2.getSelectedItem());
            String address = tf1.getText();
            String contact = tf2.getText();

            String query = "INSERT INTO `pickup`(`RegistrationNO`, `PickupType`, `PickupTime`, `Address`, `ContactNumber`) VALUES (\"" + RegNo + "\",\"" + PickupType + "\",\"" + time + "\",\"" + address + "\",\"" + contact + "\");";

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
                JOptionPane.showMessageDialog(null,"SUCCESSFULLY BOOKED FOR PICKUP","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                tf1.setText("");
                tf2.setText("");


            }
            String nofification = PickupType + " is booked between " + time + " at " + address;
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
            frame6.setVisible(false);
            ImpMainPage mp = new ImpMainPage(RegNo);
        }

    }
}
