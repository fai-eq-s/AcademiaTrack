package com.mgmtsystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class FacultyLeave extends JFrame implements ActionListener {
    Choice cempid;
    byte[] userpdf;
    JDateChooser dcfrom;
    JDateChooser dcto;
    JButton upload;
    JButton cancel;
    PreparedStatement ps;
    FacultyLeave(){

        setLayout(null);
        setSize(500, 400);
        setLocation(500, 300);

        JLabel heading = new JLabel("Apply Leave (Faculty)");
        heading.setLocation(100, 20);
        heading.setSize(400, 25);
        heading.setFont(new Font("Courier New", 1, 25));
        add(heading);

        JLabel lblempId = new JLabel("Search By Employee ID");
        lblempId.setLocation(100, 100);
        lblempId.setSize(190, 15);
        lblempId.setFont(new Font("Courier New", 0, 15));
        add(lblempId);

        cempid = new Choice();
        cempid.setBounds(300, 95, 130, 25);
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


        JLabel date = new JLabel("Date of leave");
        date.setLocation(100, 145);
        date.setSize(180, 15);
        date.setFont(new Font("Courier New", 0, 15));
        add(date);
        JLabel from = new JLabel("From");
        from.setLocation(100, 185);
        from.setSize(180, 15);
        from.setFont(new Font("Courier New", 0, 15));
        add(from);
        dcfrom = new JDateChooser();
        dcfrom.setBounds(160, 180, 150, 25);
        dcfrom.setFont(new Font("Courier New", Font.PLAIN, 13));
        add(dcfrom);
        JLabel to = new JLabel("To");
        to.setLocation(100, 215);
        to.setSize(180, 15);
        to.setFont(new Font("Courier New", 0, 15));
        add(to);
        dcto = new JDateChooser();
        dcto.setBounds(160, 210, 150, 25);
        dcto.setFont(new Font("Courier New", Font.PLAIN, 13));
        add(dcto);


        upload = new JButton("Upload Application");
        upload.setBounds(70, 270, 170, 30);
        upload.setFont(new Font("Courier New", Font.PLAIN, 13));
        upload.addActionListener(this);
        add(upload);

        cancel = new JButton("Cancel");
        cancel.setBounds(280, 270, 170, 30);
        cancel.setFont(new Font("Courier New", Font.PLAIN, 13));
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==upload){
            String empID = cempid.getSelectedItem();
            String datefrom = ((JTextField) dcfrom.getDateEditor().getUiComponent()).getText() ;
            String dateto = ((JTextField) dcto.getDateEditor().getUiComponent()).getText() ;
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            String path = f.getAbsolutePath();
            String newpath = path.replace('\\', '/');


            try{
                File newpdf = new File(newpath);
                FileInputStream fis = new FileInputStream(newpdf);
                ByteArrayOutputStream baos= new ByteArrayOutputStream();
                byte[] buff = new byte[2048000];
                for(int readNum; (readNum=fis.read(buff)) !=-1 ; ){
                    baos.write(buff,0,readNum);
                }

                userpdf=baos.toByteArray();


            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }

            try{

                String query = "INSERT INTO facultyLeaveDetails VALUES (?, ?, ?, ?)";

                Conn conn = new Conn();

                ps = conn.c.prepareStatement(query);
                ps.setString(1, empID);
                ps.setString(2, datefrom);
                ps.setString(3, dateto);
                ByteArrayInputStream bais = new ByteArrayInputStream(userpdf);
                ps.setBlob(4, bais);
                ps.executeUpdate();


                JOptionPane.showMessageDialog(null, "Leave Applied");
                setVisible(false);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        } else if (ae.getSource()==cancel) {
            setVisible(false);
        }


    }

    public static void main(String[] args) {
        new FacultyLeave();
    }
}
