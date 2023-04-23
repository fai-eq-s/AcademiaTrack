package com.mgmtsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class FacultyDetails extends JFrame implements ActionListener{

    Choice cempid;
    JTable table;
    JButton search, print, add, update, all, cancel;
    FacultyDetails(){

        setLayout(null);
//        getContentPane().setBackground(Color.white);
        setSize(1500, 700);
        setLocation(100, 100);

        // Adding dropdown using choice class
        JLabel heading = new JLabel("Search by Employee ID");
        heading.setBounds(20, 20, 200, 20);
        heading.setFont(new Font("Courier New", Font.PLAIN, 15));
        add(heading);
        cempid = new Choice();
        cempid.setBounds(230, 18, 140, 25);
        cempid.setFont(new Font("Courier New", Font.PLAIN, 13));
        cempid.add("");
        add(cempid);
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from faculty");
            while(rs.next()){
                cempid.add(rs.getString("empId"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        table = new JTable();

        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from faculty");
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
            String query = "select * from faculty where empId= '"+cempid.getSelectedItem()+"'";
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
            new AddFaculty();
        }
        else if (ae.getSource()==update) {
            setVisible(false);
            new updateFacultyDetails();
        }
        else{
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new FacultyDetails();
    }
}
