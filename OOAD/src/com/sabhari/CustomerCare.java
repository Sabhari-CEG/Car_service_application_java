package com.sabhari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class ImpCustomerCare{
    public ImpCustomerCare(String RegNo){
        CustomerCare cc = new CustomerCare(RegNo);
    }
}
public class CustomerCare implements ActionListener {
    String RegNo;
    JFrame frame13;
    JTextField tf1;
    JButton home, submit;
    Connection con = null;
    public CustomerCare(String regNo){
      RegNo = regNo;
      frame13 = new JFrame("CUSTOMER CARE");
        frame13.setContentPane(new JLabel(new ImageIcon("G:\\java\\OOAD\\src\\com\\sabhari\\3.jpg")));
        frame13.setLayout(null);

        JLabel lab1 = new JLabel("Enter Your Feedback or Query or complaint");
        lab1.setFont(new Font("Robot",Font.BOLD,25));
        lab1.setBounds(550,200,600,50);
        frame13.add(lab1);
        tf1 = new JTextField();
        tf1.setBounds(470,300,700,50);
        tf1.setBackground(Color.lightGray);
        tf1.setFont(new Font("Sans Serif",Font.BOLD,20));
        frame13.add(tf1);

        JLabel lab2 = new JLabel("TOLL FREE   :   1800123123");
        lab2.setFont(new Font("Robot",Font.BOLD,35));
        lab2.setBounds(550,400,650,50);
        frame13.add(lab2);

        JLabel lab3 = new JLabel("MAIL US   :   carservicemanagement.customercare.com");
        lab3.setFont(new Font("Robot",Font.BOLD,35));
        lab3.setBounds(330,500,950,50);
        frame13.add(lab3);

        home = new JButton("GO TO HOME");
        home.setFont(new Font("Robot",Font.BOLD,25));
        home.setBounds(1000,660,200,40);
        home.setBackground(Color.cyan);
        frame13.add(home);
        home.addActionListener(this::actionPerformed);

        submit = new JButton("SUBMIT");
        submit.setFont(new Font("Robot",Font.BOLD,25));
        submit.setBounds(400,660,200,40);
        submit.setBackground(Color.cyan);
        frame13.add(submit);
        submit.addActionListener(this::actionPerformed);



        frame13.setVisible(true);
        frame13.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame13.setSize(1920,1080);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==home){
            frame13.setVisible(false);
            ImpMainPage mp = new ImpMainPage(RegNo);
        }
        else if (e.getSource()==submit){
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
            String feedback = tf1.getText();
            String query = "INSERT INTO `customercare`(`RegistrationNO`, `FeedBack`) VALUES (\"" + RegNo + "\",\"" + feedback +"\");";

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
                JOptionPane.showMessageDialog(null,"SUCCESSFULLY SUBMITTED OUR CUSTOMER CARE TEAM WILL CONNECT YOU SOON!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                tf1.setText("");


            }
            String nofification = feedback  + " is submitted ";
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

    }
}
