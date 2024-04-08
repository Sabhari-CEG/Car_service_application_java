package com.sabhari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class ImpSignup2{


    public ImpSignup2(String RegNo, String pass) {
            Signup2 signup2 = new Signup2(RegNo, pass);
        }
    }

public class Signup2 implements ActionListener {
    JFrame frame3;
    JTextField tf1, tf2, tf3, tf4;
    Connection con = null;
    String RegistrationNo, Password;
    JButton signup,login;

    public Signup2(String RegNo, String pass) {
        frame3 = new JFrame("PERSONAL DETAILS");
        RegistrationNo = RegNo;
        Password = pass;
        frame3.setContentPane(new JLabel(new ImageIcon("G:\\java\\OOAD\\src\\com\\sabhari\\webdes-5.jpg")));
        frame3.setLayout(null);

        JLabel lab1 = new JLabel("Enter Your Name");
        lab1.setFont(new Font("Robot", Font.BOLD, 25));
        //JPanel pan1 = new JPanel();
        //pan1.setBackground(Color.white);
        //pan1.add(lab1);
        lab1.setBounds(860, 250, 450, 35);
        frame3.add(lab1);
        tf1 = new JTextField();
        tf1.setBounds(750, 300, 450, 45);
        tf1.setBackground(Color.lightGray);
        tf1.setFont(new Font("Sans Serif", Font.BOLD, 20));
        frame3.add(tf1);

        JLabel lab2 = new JLabel("Car Company");
        lab2.setFont(new Font("Robot", Font.BOLD, 25));
        //JPanel pan2 = new JPanel();
        //pan2.setBackground(Color.white);
        //pan2.add(lab2);
        lab2.setBounds(900, 350, 450, 35);
        frame3.add(lab2);
        tf2 = new JTextField();
        tf2.setBounds(750, 400, 450, 45);
        tf2.setBackground(Color.lightGray);
        tf2.setFont(new Font("Sans Serif", Font.BOLD, 20));
        frame3.add(tf2);

        JLabel lab3 = new JLabel("Car Model");
        lab3.setFont(new Font("Robot", Font.BOLD, 25));
        //JPanel pan3 = new JPanel();
        //pan3.setBackground(Color.white);
        //pan3.add(lab3);
        lab3.setBounds(930, 450, 450, 35);
        frame3.add(lab3);
        tf3 = new JTextField();
        tf3.setBounds(750, 500, 450, 45);
        tf3.setBackground(Color.lightGray);
        tf3.setFont(new Font("Sans Serif", Font.BOLD, 20));
        frame3.add(tf3);

        JLabel lab4 = new JLabel("Year Of Manufacture");
        lab4.setFont(new Font("Robot", Font.BOLD, 25));
        //JPanel pan4 = new JPanel();
        //pan4.setBackground(Color.white);
        //pan4.add(lab4);
        lab4.setBounds(880, 550, 450, 35);
        frame3.add(lab4);
        tf4 = new JTextField();
        tf4.setBounds(750, 600, 450, 45);
        tf4.setBackground(Color.lightGray);
        tf4.setFont(new Font("Sans Serif", Font.BOLD, 20));
        frame3.add(tf4);

        signup = new JButton("SIGNUP");
        signup.setFont(new Font("Robot", Font.BOLD, 25));
        signup.setBounds(750, 660, 200, 40);
        signup.setBackground(Color.cyan);
        frame3.add(signup);
        signup.addActionListener(this::actionPerformed);

        login = new JButton("LOGIN");
        login.setFont(new Font("Robot", Font.BOLD, 25));
        login.setBounds(1000, 660, 200, 40);
        login.setBackground(Color.cyan);
        frame3.add(login);
        login.addActionListener(this::actionPerformed);


        frame3.setLayout(null);
        frame3.setVisible(true);
        frame3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame3.setSize(1920, 1080);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signup) {
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
            String name = tf1.getText();
            String company = tf2.getText();
            String model = tf3.getText();
            int year = Integer.parseInt(tf4.getText());
            String query = "INSERT INTO `login` (`RegistrationNO`, `Password`, `Name`, `CarCompany`, `CarModel`, `ModelYear`) VALUES (\"" + RegistrationNo + "\",\"" + Password + "\",\"" + name + "\",\"" + company + "\",\"" + model + "\",\"" + year +"\");";

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
                JOptionPane.showMessageDialog(null,"SUCCESSFULLY SIGNED UP","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");

            }
        }
        else if (e.getSource()==login){
            frame3.setVisible(false);
            Login login = new Login();
        }
    }
}
