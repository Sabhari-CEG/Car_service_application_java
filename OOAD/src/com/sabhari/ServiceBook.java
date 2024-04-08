package com.sabhari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class ImpServiceBook{
    public ImpServiceBook(String RegNo) {
        ServiceBook sb = new ServiceBook(RegNo);
    }
}
public class ServiceBook implements ActionListener {
    JFrame frame5;
    JTextField tf1,tf2,tf3,tf4;
    JButton book,home;
    String regNo;
    Connection con = null;
    JComboBox cb = null;
    public ServiceBook(String RegNo){
        frame5 = new JFrame("SERVICE BOOKING");
        frame5.setContentPane(new JLabel(new ImageIcon("G:\\java\\OOAD\\src\\com\\sabhari\\3.jpg")));
        frame5.setLayout(null);
        regNo = RegNo;

        JLabel lab1 = new JLabel("Enter the Contact Number");
        lab1.setFont(new Font("Robot",Font.BOLD,25));
        lab1.setBounds(380,180,450,50);
        frame5.add(lab1);
        tf1 = new JTextField();
        tf1.setBounds(300,230,450,50);
        tf1.setBackground(Color.lightGray);
        tf1.setFont(new Font("Sans Serif",Font.BOLD,20));
        frame5.add(tf1);

        JLabel lab2 = new JLabel("Enter the Mail id");
        lab2.setFont(new Font("Robot",Font.BOLD,25));
        lab2.setBounds(900,180,450,50);
        frame5.add(lab2);
        tf2 = new JTextField();
        tf2.setBounds(800,230,450,50);
        tf2.setBackground(Color.lightGray);
        tf2.setFont(new Font("Sans Serif",Font.BOLD,20));
        frame5.add(tf2);

        JLabel lab3 = new JLabel("Select the Service Type");
        lab3.setFont(new Font("Robot",Font.BOLD,25));
        lab3.setBounds(380,350,450,50);
        frame5.add(lab3);
        String[] service = {"Periodic Maintenance","Running Repair","Body and Paints","Accessories Fitments","Breakdown","Value Added Services","others"};
        cb = new JComboBox(service);
        cb.setFont(new Font("Robot",Font.BOLD,25));
        cb.setBounds(300,400,450,50);
        cb.setBackground(Color.lightGray);
        frame5.add(cb);

        JLabel lab4 = new JLabel("Enter Desired Service Station ");
        lab4.setFont(new Font("Robot",Font.BOLD,25));
        lab4.setBounds(840,350,450,50);
        frame5.add(lab4);
        tf3 = new JTextField();
        tf3.setBounds(800,400,450,50);
        tf3.setBackground(Color.lightGray);
        tf3.setFont(new Font("Sans Serif",Font.BOLD,20));
        frame5.add(tf3);

        JLabel lab5 = new JLabel("Additional Information");
        lab5.setFont(new Font("Robot",Font.BOLD,25));
        lab5.setBounds(650,500,450,50);
        frame5.add(lab5);
        tf4 = new JTextField();
        tf4.setBounds(300,550,900,50);
        tf4.setBackground(Color.lightGray);
        tf4.setFont(new Font("Sans Serif",Font.BOLD,20));
        frame5.add(tf4);

        book = new JButton("BOOK SERVICE");
        book.setFont(new Font("Robot",Font.BOLD,25));
        book.setBounds(350,630,300,40);
        book.setBackground(Color.cyan);
        frame5.add(book);
        book.addActionListener(this::actionPerformed);

        home = new JButton("GO TO HOME");
        home.setFont(new Font("Robot",Font.BOLD,25));
        home.setBounds(850,630,300,40);
        home.setBackground(Color.cyan);
        frame5.add(home);
        home.addActionListener(this::actionPerformed);

        frame5.setVisible(true);
       // frame5.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame5.setSize(1920,1080);
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

            String contact = tf1.getText();
            String mail = tf2.getText();
            String ServiceType = String.valueOf(cb.getSelectedItem());
            String station = tf3.getText();
            String Additional = tf4.getText();
            String query = "INSERT INTO `service`(`RegistrationNO`, `ContactNumber`, `MailId`, `ServiceType`, `Station`, `Additional`) VALUES (\"" + regNo + "\",\"" + contact + "\",\"" + mail + "\",\"" + ServiceType + "\",\"" + station + "\",\"" + Additional + "\");";

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
                JOptionPane.showMessageDialog(null,"SUCCESSFULLY BOOKED FOR SERVICE","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");

            }
            String nofification = ServiceType + " type of service is booked at " + station;
            query = "INSERT INTO `notification`(`RegistrationNO`, `notification`) VALUES (\"" + regNo + "\",\"" + nofification +"\");";
            affected = 0;
            try {
                affected = st.executeUpdate(query);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("Error in entering into table");
            }
            if (affected == 1)
                System.out.println("Notification added");

            query = "INSERT INTO `servicerecord`(`RegistrationNO`, `ServiceInfo`) VALUES (\"" + regNo + "\",\"" + nofification +"\");";

            affected = 0;
            try {
                affected = st.executeUpdate(query);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("Error in entering into table");
            }
            if (affected == 1)
                System.out.println("Service record added");

        }
        else if (e.getSource()==home){
            frame5.setVisible(false);
            ImpMainPage mp = new ImpMainPage(regNo);
        }



    }
}
