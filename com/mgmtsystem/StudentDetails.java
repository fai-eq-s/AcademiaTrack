package com.mgmtsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class StudentDetails extends JFrame implements ActionListener{

    Choice crollno;
    JTable table;
    JButton search, print, add, update, cancel;
    StudentDetails(){

        setLayout(null);
//        getContentPane().setBackground(Color.white);

        setSize(1500, 700);
        setLocation(100, 100);

        // Adding dropdown using choice class
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20, 20, 200, 20);
        heading.setFont(new Font("Courier New", Font.PLAIN, 14));
        add(heading);
        crollno = new Choice();
        crollno.setBounds(230, 18, 140, 25);
        crollno.setFont(new Font("Courier New", Font.PLAIN, 13));
        crollno.add("");
        add(crollno);
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        table = new JTable();

        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }


        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 1500, 650);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.setFont(new Font("Courier New", Font.PLAIN, 13));
        search.addActionListener(this);
        add(search);
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.setFont(new Font("Courier New", Font.PLAIN, 13));
        print.addActionListener(this);
        add(print);
        add = new JButton("Add");
        add.setBounds(220, 70, 80, 20);
        add.setFont(new Font("Courier New", Font.PLAIN, 13));
        add.addActionListener(this);
        add(add);
        update = new JButton("Update");
        update.setBounds(320, 70, 80, 20);
        update.setFont(new Font("Courier New", Font.PLAIN, 13));
        update.addActionListener(this);
        add(update);
        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        cancel.setFont(new Font("Courier New", Font.PLAIN, 13));
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==search){
            String query = "select * from student where rollno= '"+crollno.getSelectedItem()+"'";
            try{
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==print) {
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==add) {
            setVisible(false);
            new AddStudent();
        }
        else if (ae.getSource()==update) {
            setVisible(false);
            new updateStudentDetails();
        }
        else{
            setVisible(false);
        }

    }
    
    public static void main(String[] args) {
        new StudentDetails();
    }
}
