package com.sabhari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

class ImpMainPage {
    public ImpMainPage(String regNo) {
            MainPage mp = new MainPage(regNo);
        }


}
public class MainPage implements ActionListener {
    JFrame frame4;
    Connection con = null;
    String RegNo;
    String wel1,wel2;
    JButton ServiceBook,TowingBook,PickupBook,notification,ServiceRecords,helper,StationInfo,CustomerCare,logout;
    public MainPage(String regNo){
        frame4 = new JFrame("WELCOME TO OUR CUSTOMER");
        frame4.setContentPane(new JLabel(new ImageIcon("G:\\java\\OOAD\\src\\com\\sabhari\\3.jpg")));
        frame4.setLayout(null);
        RegNo = regNo;


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
        String query = "SELECT * FROM `login`";


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
                rs.next();
                String name = rs.getString(3);
                String company = rs.getString(4);
                String model = rs.getString(5);
                int year = rs.getInt(6);
                wel1 = "Welcome to our service "+ name +" ";
                wel2 = "    Car Info ::  Company Name ->" + company + "   Model ->" + model + "   Year of Manufacturing ->" + year +" ";
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            JLabel welcome1 = new JLabel();
            welcome1.setText(wel1);
        welcome1.setFont(new Font("Sans Serif",Font.BOLD,25));
        welcome1.setForeground(Color.white);

       // JPanel welpan1 = new JPanel();
        //    welpan1.add(welcome1);
         //   welpan1.setBackground(Color.cyan);
            welcome1.setBounds(600,10,600,30);
            frame4.add(welcome1);

        JLabel welcome2 = new JLabel();
        welcome2.setText(wel2);
        welcome2.setFont(new Font("Sans Serif",Font.BOLD,25));
        welcome2.setForeground(Color.white);

        //JPanel welpan2 = new JPanel();
        //welpan2.add(welcome2);
        //welpan2.setBackground(Color.cyan);
        welcome2.setBounds(300,50,1100,30);
        frame4.add(welcome2);


            ServiceBook = new JButton("Book Service");
        ServiceBook.setFont(new Font("Robot",Font.BOLD,25));
        ServiceBook.setBackground(Color.cyan);
        ServiceBook.setBounds(350,260,200,40);
        frame4.add(ServiceBook);
        ServiceBook.addActionListener(this::actionPerformed);

        PickupBook = new JButton("Book Pickup");
        PickupBook.setFont(new Font("Robot",Font.BOLD,25));
        PickupBook.setBackground(Color.cyan);
        PickupBook.setBounds(650,260,200,40);
        frame4.add(PickupBook);
        PickupBook.addActionListener(this::actionPerformed);

        TowingBook = new JButton("Book Towing");
        TowingBook.setFont(new Font("Robot",Font.BOLD,25));
        TowingBook.setBackground(Color.cyan);
        TowingBook.setBounds(950,260,200,40);
        frame4.add(TowingBook);
        TowingBook.addActionListener(this::actionPerformed);

        notification = new JButton("Notifications");
        notification.setFont(new Font("Robot",Font.BOLD,25));
        notification.setBackground(Color.cyan);
        notification.setBounds(350,400,200,40);
        frame4.add(notification);
        notification.addActionListener(this::actionPerformed);

        ServiceRecords = new JButton("Service Records");
        ServiceRecords.setFont(new Font("Robot",Font.BOLD,20));
        ServiceRecords.setBackground(Color.cyan);
        ServiceRecords.setBounds(650,400,200,40);
        frame4.add(ServiceRecords);
        ServiceRecords.addActionListener(this::actionPerformed);

        helper = new JButton("Helper");
        helper.setFont(new Font("Robot",Font.BOLD,25));
        helper.setBackground(Color.cyan);
        helper.setBounds(950,400,200,40);
        frame4.add(helper);
        helper.addActionListener(this::actionPerformed);

        StationInfo = new JButton("Service Station Info");
        StationInfo.setFont(new Font("Robot",Font.BOLD,22));
        StationInfo.setBackground(Color.cyan);
        StationInfo.setBounds(450,540,250,40);
        frame4.add(StationInfo);
        StationInfo.addActionListener(this::actionPerformed);

        CustomerCare = new JButton("Customer Care");
        CustomerCare.setFont(new Font("Robot",Font.BOLD,25));
        CustomerCare.setBackground(Color.cyan);
        CustomerCare.setBounds(800,540,250,40);
        frame4.add(CustomerCare);
        CustomerCare.addActionListener(this::actionPerformed);

        frame4.setLayout(null);

        logout = new JButton("Logout");
        logout.setFont(new Font("Robot",Font.BOLD,25));
        logout.setBackground(Color.white);
        logout.setBounds(1300,780,200,40);
        logout.addActionListener(this::actionPerformed);
        frame4.add(logout);







        frame4.setVisible(true);
        frame4.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame4.setSize(1920,1080);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==logout){
            frame4.setVisible(false);
            Login logout = new Login();
        }
        else if (e.getSource()==ServiceBook){
            frame4.setVisible(false);
            ImpServiceBook sb = new ImpServiceBook(RegNo);
        }
        else if (e.getSource()==PickupBook){
            frame4.setVisible(false);
            ImpPickupBook pickupBook = new ImpPickupBook(RegNo);
        }
        else if (e.getSource()==TowingBook){
            frame4.setVisible(false);
            ImpTowingBook towingBook = new ImpTowingBook(RegNo);
        }
        else if (e.getSource()==notification){
            frame4.setVisible(false);
            ImpNotification notification = new ImpNotification(RegNo);
        }
        else if (e.getSource()==ServiceRecords){
            frame4.setVisible(false);
            ImpServiceRecords serviceRecords = new ImpServiceRecords(RegNo);
        }
        else if (e.getSource()==helper){
            frame4.setVisible(false);
            ImpHelper help = new ImpHelper(RegNo);
        }
        else if (e.getSource()==StationInfo){
            frame4.setVisible(false);
            ImpInfo1 info = new ImpInfo1(RegNo);
        }
        else if (e.getSource()==CustomerCare){
            frame4.setVisible(false);
            ImpCustomerCare cc = new ImpCustomerCare(RegNo);
        }
    }
}
