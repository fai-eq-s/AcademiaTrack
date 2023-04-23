package com.mgmtsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class studentLeaveDetails extends JFrame implements ActionListener {
    JTable table;
    Choice crollno;
    JButton search;
    JButton cancel;
    JButton print;
    studentLeaveDetails(){

        setSize(1000, 700);
        setLocation(350, 200);
        setLayout(null);

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
            ResultSet rs = conn.s.executeQuery("select distinct rollno from studentLeaveDetails");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
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
        cancel = new JButton("Cancel");
        cancel.setBounds(220, 70, 80, 20);
        cancel.setFont(new Font("Courier New", Font.PLAIN, 13));
        cancel.addActionListener(this);
        add(cancel);
        table = new JTable();

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 1000, 600);
        add(jsp);
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from studentLeaveDetails");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource()==cancel){
            setVisible(false);
        } else if (ae.getSource()==search) {
            String query = "select * from studentLeaveDetails where rollno= '"+crollno.getSelectedItem()+"'";
            try{
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==print) {
            try {
                table.print();
            } catch (PrinterException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void main(String[] args) {
        new studentLeaveDetails();
    }
}
