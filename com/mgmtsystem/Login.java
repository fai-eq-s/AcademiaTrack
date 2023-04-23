package com.mgmtsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class Login extends JFrame implements ActionListener{
    JButton login, cancel;
    JTextField tfusername, tfpassword;

    Login(){

        setLayout(null);
        setBounds(600, 400, 440, 300);
        // Adding "username" text to our JFrame

        JLabel heading = new JLabel("LOGIN");
        heading.setBounds(190, 20, 80, 20);
        heading.setFont(new Font("Courier New", 0, 19));
        add(heading);


        JLabel username = new JLabel("Username");
        username.setBounds(75, 90, 100, 20);         // Setting position and size of text
        username.setFont(new Font("Courier New", 0, 17));
        add(username);
        tfusername = new JTextField();
        tfusername.setBounds(190, 80, 150, 32);
        tfusername.setFont(new Font("Courier New", 0, 17));
        add(tfusername);

        // Adding "password" text to our JFrame

        JLabel password = new JLabel("Password");
        password.setBounds(75,130, 100, 20);
        password.setFont(new Font("Courier New", 0, 17));
        add(password);
        tfpassword = new JPasswordField();
        tfpassword.setBounds(190, 120, 150, 32);
        tfpassword.setFont(new Font("Courier New", 0, 17));
        add(tfpassword);

        // Adding buttons

        login = new JButton("Login");
        login.addActionListener(this);
        login.setBounds(75, 180, 70, 20);
        login.setFont(new Font("Courier New", 0, 17));
        add(login);

        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        cancel.setBounds(270, 180, 70, 20);
        cancel.setFont(new Font("Courier New", 0, 17));
        add(cancel);

        // Adding image in JFrame
        setTitle("Log into the system");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);



    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            String username = tfusername.getText();
            String password = tfpassword.getText();

            String query = "select * from login where username='"+username+"' and password ='"+password+"'";

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);

                    new MainPage();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Password");
                    setVisible(false);
                    new Login();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (ae.getSource()==cancel){
            setVisible(false) ;
        }
    }
    public static void main(String[] args){

        new Login();
    }
}