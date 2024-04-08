package com.sabhari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

class ImpServiceRecords{
    public ImpServiceRecords(String RegNo){
        ServiceRecords serviceRecords = new ServiceRecords(RegNo);
    }
}
public class ServiceRecords implements ActionListener {
    String RegNo;
    JFrame frame9;
    Connection con = null;
    JButton home;
    public ServiceRecords(String regNo){
        RegNo = regNo;

        frame9 = new JFrame("SERVICE RECORDS");
        frame9.setContentPane(new JLabel(new ImageIcon("G:\\java\\OOAD\\src\\com\\sabhari\\3.jpg")));
        frame9.setLayout(null);

        String url = "jdbc:mysql://localhost/carservicemanagement?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String UserName = "sabhari";
        String PassWord = "2000";

        home = new JButton("GO TO HOME");
        home.setFont(new Font("Robot",Font.BOLD,25));
        home.setBounds(850,720,300,40);
        home.setBackground(Color.white);
        frame9.add(home);
        home.addActionListener(this::actionPerformed);


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

        String query = "SELECT * FROM `servicerecord` WHERE `RegistrationNO` = \""+RegNo+"\"";

        Statement st = null;
        try {
            st = con.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error in statement");
        }
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            int NotificationNo = 0;
            while (rs.next()){
                NotificationNo++;
                String record = NotificationNo + " " + rs.getString(2) + " at " + rs.getDate(3) ;
                if (NotificationNo == 1){
                    JLabel lab1 = new JLabel();
                    lab1.setText(record);
                    lab1.setFont(new Font("Robot",Font.BOLD,25));
                    JPanel pan1 = new JPanel();
                    pan1.add(lab1);
                    pan1.setBackground(Color.yellow);
                    pan1.setBounds(280,200,1000,80);
                    frame9.add(pan1);
                }
                else if (NotificationNo == 2){
                    JLabel lab2 = new JLabel();
                    lab2.setText(record);
                    lab2.setFont(new Font("Robot",Font.BOLD,25));
                    JPanel pan2 = new JPanel();
                    pan2.add(lab2);
                    pan2.setBackground(Color.yellow);
                    pan2.setBounds(280,300,1000,80);
                    frame9.add(pan2);

                }
                else if (NotificationNo == 3){
                    JLabel lab3 = new JLabel();
                    lab3.setText(record);
                    lab3.setFont(new Font("Robot",Font.BOLD,25));
                    JPanel pan3 = new JPanel();
                    pan3.add(lab3);
                    pan3.setBackground(Color.yellow);
                    pan3.setBounds(280,400,1000,80);
                    frame9.add(pan3);

                }
                else if (NotificationNo == 4){
                    JLabel lab4 = new JLabel();
                    lab4.setText(record);
                    lab4.setFont(new Font("Robot",Font.BOLD,25));
                    JPanel pan4 = new JPanel();
                    pan4.add(lab4);
                    pan4.setBackground(Color.yellow);
                    pan4.setBounds(280,500,1000,80);
                    frame9.add(pan4);
                }
                else if (NotificationNo == 5){
                    JLabel lab5 = new JLabel();
                    lab5.setText(record);
                    lab5.setFont(new Font("Robot",Font.BOLD,25));
                    JPanel pan5 = new JPanel();
                    pan5.add(lab5);
                    pan5.setBackground(Color.yellow);
                    pan5.setBounds(280,600,1000,80);
                    frame9.add(pan5);
                }
                else if (NotificationNo == 6){
                    JLabel lab6 = new JLabel();
                    lab6.setText(record);
                    lab6.setFont(new Font("Robot",Font.BOLD,25));
                    JPanel pan6 = new JPanel();
                    pan6.add(lab6);
                    pan6.setBackground(Color.yellow);
                    pan6.setBounds(280,700,1000,80);
                    frame9.add(pan6);
                }

            }
        }catch (Exception exc){
            exc.printStackTrace();
        }



        frame9.setVisible(true);
        frame9.setSize(1920,1080);
        frame9.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==home){
            frame9.setVisible(false);
            ImpMainPage mp = new ImpMainPage(RegNo);
        }
    }
}
