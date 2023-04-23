package com.mgmtsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class facultyLeaveDetails extends JFrame implements ActionListener {
    JTable table;
    Choice cempId;
    JButton search;
    JButton cancel;
    JButton print;
    facultyLeaveDetails(){

        setSize(1000, 700);
        setLocation(350, 200);
        setLayout(null);

        JLabel heading = new JLabel("Search by Employee ID");
        heading.setBounds(20, 20, 200, 20);
        heading.setFont(new Font("Courier New", Font.PLAIN, 14));
        add(heading);

        cempId = new Choice();
        cempId.setBounds(230, 18, 140, 25);
        cempId.setFont(new Font("Courier New", Font.PLAIN, 13));
        add(cempId);

        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select distinct * from facultyLeaveDetails");
            while(rs.next()){
                cempId.add(rs.getString("empID"));
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
            ResultSet rs = conn.s.executeQuery("select * from facultyLeaveDetails");
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
            String query = "select * from facultyLeaveDetails where empID= '"+cempId.getSelectedItem()+"'";
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
        new facultyLeaveDetails();
    }
}
