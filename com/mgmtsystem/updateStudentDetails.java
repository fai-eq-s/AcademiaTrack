package com.mgmtsystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class updateStudentDetails extends JFrame implements ActionListener{
    JDateChooser dcdob;
    JTextField tfname;
    JTextField tfRollno;
    JLabel lblrollno;
    JTextField tfaddress;
    JTextField tfemailid;
    JTextField tfsyjc;
    JTextField tfcourse;
    JTextField tffathername;

    JTextField tfphone, tfbranch;
    JTextField tfmetric;
    JTextField tfAadharNo;
    JComboBox cbcourse;
    JComboBox cbbranch;

    JButton update, cancel;
    Choice crollno;
    updateStudentDetails(){

        setSize(900, 700);
        setLocation(350, 50);

        setLayout(null);

        JLabel heading = new JLabel("UPDATE STUDENT DETAILS");
        heading.setBounds(260, 40, 500, 50);
        heading.setFont(new Font("Courier New", Font.PLAIN, 32));
        add(heading);

        JLabel heading1 = new JLabel("Search by Roll Number");
        heading1.setBounds(300, 100, 200, 20);
        heading1.setFont(new Font("Courier New", Font.PLAIN, 15 ));
        add(heading1);
        crollno = new Choice();
        crollno.setBounds(510, 98, 140, 25);
        crollno.setFont(new Font("Courier New", Font.PLAIN, 13));

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


        JLabel studentName = new JLabel("Name");
        studentName.setBounds(40, 140, 100, 30);
        studentName.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(studentName);
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 140, 250, 30);
        lblname.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(lblname);

        JLabel studentRollNo = new JLabel("Roll No.");
        studentRollNo.setBounds(40, 210, 100, 30);
        studentRollNo.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(studentRollNo);
        lblrollno = new JLabel();
        lblrollno.setBounds(200, 210, 170, 30);
        lblrollno.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(lblrollno);

        JLabel studentAddress = new JLabel("Address");
        studentAddress.setBounds(40, 280, 100, 30);
        studentAddress.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(studentAddress);
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 280, 170, 30);
        tfaddress.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(tfaddress);

        JLabel studentEmailID = new JLabel("Email ID");
        studentEmailID.setBounds(40, 350, 100, 30);
        studentEmailID.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(studentEmailID);
        tfemailid = new JTextField();
        tfemailid.setBounds(200, 350, 170, 30);
        tfemailid.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(tfemailid);

        JLabel studentMarks12 = new JLabel("Class XII(%)");
        studentMarks12.setBounds(40, 420, 200, 30);
        studentMarks12.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(studentMarks12);
        JLabel lblsyjc = new JLabel();
        lblsyjc.setBounds(200, 420, 170, 30);
        lblsyjc.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(lblsyjc);

        JLabel studentCourse = new JLabel("Course");
        studentCourse.setBounds(40, 490, 100, 30);
        studentCourse.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(studentCourse);
        tfcourse = new JTextField();
        tfcourse.setBounds(200, 490, 170, 30);
        tfcourse.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(tfcourse);

        ///////////////////

        JLabel studentFatherName = new JLabel("Father's Name");
        studentFatherName.setBounds(450, 140, 200, 30);
        studentFatherName.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(studentFatherName);
        JLabel lblfathername = new JLabel();
        lblfathername.setBounds(660, 140, 170, 30);
        lblfathername.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(lblfathername);

        JLabel studentDOB = new JLabel("Date of Birth");
        studentDOB.setBounds(450, 210, 200, 30);
        studentDOB.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(studentDOB);
        JLabel lbldob = new JLabel();
        lbldob.setBounds(660, 210, 170, 30);
        lbldob.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(lbldob);

        JLabel studentPhone = new JLabel("Phone");
        studentPhone.setBounds(450, 280, 100, 30);
        studentPhone.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(studentPhone);
        tfphone = new JTextField();
        tfphone.setBounds(660, 280, 170, 30);
        tfphone.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(tfphone);

        JLabel studentmetric = new JLabel("Class X(%)");
        studentmetric.setBounds(450, 350, 150, 30);
        studentmetric.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(studentmetric);
        JLabel lblmarksx = new JLabel();
        lblmarksx.setBounds(660, 350, 170, 30);
        lblmarksx.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(lblmarksx);

        JLabel studentAadhar = new JLabel("Aadhar No");
        studentAadhar.setBounds(450, 420, 120, 30);
        studentAadhar.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(studentAadhar);
        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(660, 420, 170, 30);
        lblaadhar.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(lblaadhar);

        JLabel studentBranch = new JLabel("Branch");
        studentBranch.setBounds(450, 490, 100, 30);
        studentBranch.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(studentBranch);
        tfbranch = new JTextField();
        tfbranch.setBounds(660, 490, 170, 30);
        tfbranch.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(tfbranch);



        crollno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn conn = new Conn();
                    String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
                    ResultSet rs = conn.s.executeQuery(query);
                    while(rs.next()){
                        lblname.setText(rs.getString("name"));
                        lblfathername.setText(rs.getString("fathername"));
                        lblaadhar.setText(rs.getString("aadhar"));
                        lbldob.setText(rs.getString("dob"));
                        lblmarksx.setText(rs.getString("classx"));
                        lblsyjc.setText(rs.getString("classxii"));
                        lblrollno.setText(rs.getString("rollno"));
                        tfcourse.setText(rs.getString("course"));
                        tfaddress.setText(rs.getString("address"));
                        tfemailid.setText(rs.getString("email"));
                        tfbranch.setText(rs.getString("branch"));
                        tfphone.setText(rs.getString("phone"));
                    }
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });


        update = new JButton("Update");
        update.setBounds(300, 570, 100, 40);

        update.setFont(new Font("Courier New", Font.PLAIN, 19));
        update.addActionListener(this);
        add(update);
        cancel = new JButton("Cancel");
        cancel.setBounds(550, 570, 100, 40);
        cancel.setFont(new Font("Courier New", Font.PLAIN, 19));
        cancel.addActionListener(this);
        add(cancel);


        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==update){
            String rollno = lblrollno.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemailid.getText();
            String course = (String) tfcourse.getText() ;
            String branch = (String) tfbranch.getText() ;

            try {
                String query = "update student set address= '"+address+"', phone = '"+phone+"', email = '"+email+"', course = '"+course+"', branch = '"+branch+"' where rollno = '"+rollno+"'";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student details updated successfully!");
                setVisible(false);
                new StudentDetails();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if (ae.getSource()==cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new updateStudentDetails();
    }
}

