package com.sabhari;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.*;

class ImpLogin{
     public static void main(String[] args) {
         Login login = new Login();

     }
}
public class Login implements ActionListener {

    JFrame frame1 = new JFrame("LOGIN PAGE");
    JButton signup = null;
    JButton login = null;
    Connection con = null;
    private JTextField tf1;
    private JPasswordField tf2;

    public Login(){
      frame1.setLayout(new BorderLayout());

        frame1.setContentPane(new JLabel(new ImageIcon("G:\\java\\OOAD\\src\\com\\sabhari\\webdes-1.jpg")));
        frame1.setLayout(null);
        JLabel lab1 = new JLabel("Enter Your Registration Number");
        lab1.setFont(new Font("Robot",Font.BOLD,25));
       // JPanel pan1 = new JPanel();
        //pan1.setBackground(Color.white);
        //pan1.add(lab1);
        lab1.setBounds(780,280,450,50);
        frame1.add(lab1);
        tf1 = new JTextField();
        tf1.setBounds(750,350,450,50);
        tf1.setBackground(Color.lightGray);
        tf1.setFont(new Font("Sans Serif",Font.BOLD,20));
        frame1.add(tf1);

        JLabel lab2 = new JLabel("Enter Your Password");
        lab2.setFont(new Font("Robot",Font.BOLD,25));
       // JPanel pan2 = new JPanel();
        //pan2.setBackground(Color.white);
        //pan2.add(lab2);
        lab2.setBounds(850,420,450,50);
        frame1.add(lab2);
        tf2 = new JPasswordField();
        tf2.setBounds(750,490,450,50);
        tf2.setBackground(Color.lightGray);
        tf2.setFont(new Font("Sans Serif",Font.BOLD,20));
        frame1.add(tf2);

        login = new JButton("LOGIN");
        login.setFont(new Font("Robot",Font.BOLD,25));
        login.setBounds(750,630,200,40);
       // login.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        //login.setBorder(new RoundedBorder(10));
        //login.setBackground(new JLabel(new ImageIcon("G:\\java\\OOAD\\src\\com\\sabhari\\Untitled.png")));
        login.setBackground(Color.cyan);
        frame1.add(login);
        login.addActionListener(this::actionPerformed);

        signup = new JButton("SIGNUP");
        signup.setFont(new Font("Robot",Font.BOLD,25));
        signup.setBounds(1000,630,200,40);
        signup.setBackground(Color.cyan);
        frame1.add(signup);
        signup.addActionListener(this::actionPerformed);

        frame1.setVisible(true);
        frame1.setSize(1920,1080);

        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signup){
            frame1.setVisible(false);
            ImpSignup signup = new ImpSignup();
        }
        else if (e.getSource() == login){

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
            Statement st = null;
            String RegNo = tf1.getText();
            String query = "SELECT * FROM `login` WHERE `RegistrationNO` = \""+RegNo+"\"";

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
                JOptionPane.showMessageDialog(null,"You must Signup before First Login!!","ERROR",JOptionPane.ERROR_MESSAGE);
                tf1.setText("");
                tf2.setText("");
            }
            try {
                rs.next();
                String pass = rs.getString(2);
                String usrpass = String.valueOf(tf2.getPassword());
                if (pass.equalsIgnoreCase(usrpass)){
                    frame1.setVisible(false);
                    JOptionPane.showMessageDialog(null,"CORRECT REGISTRATION NO AND PASSWORD","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                    tf1.setText("");
                    tf2.setText("");
                    ImpMainPage mainPage = new ImpMainPage(RegNo);
                }
                if (!(pass.equalsIgnoreCase(usrpass))){
                    JOptionPane.showMessageDialog(null,"INCORRECT PASSWORD","PASSWORD ERROR!!",JOptionPane.ERROR_MESSAGE);
                    tf2.setText("");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                JOptionPane.showMessageDialog(null,"You must Signup before First Login!!","ERROR",JOptionPane.ERROR_MESSAGE);
                tf1.setText("");
                tf2.setText("");
            }

        }
    }
}
