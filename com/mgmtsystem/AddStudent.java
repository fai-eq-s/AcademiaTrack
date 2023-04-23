package com.mgmtsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.toedter.calendar.JDateChooser;
public class AddStudent extends JFrame implements ActionListener{

    JDateChooser dcdob;
    JTextField tfname;
    JTextField tfRollno;
    JTextField tfaddress;
    JTextField tfemailid;
    JTextField tfsyjc;
    JTextField tfcourse;
    JTextField tffathername;

    JTextField tfphone;
    JTextField tfmetric;
    JTextField tfAadharNo;
    JComboBox cbcourse;
    JComboBox cbbranch;

    JButton submit, cancel;
    AddStudent(){
        setSize(900, 700);
        setLocation(350, 50);

        setLayout(null);

        JLabel heading = new JLabel("NEW STUDENT DETAILS");
        heading.setBounds(280, 40, 500, 50);
        heading.setFont(new Font("Courier New", Font.PLAIN, 32));
        add(heading);

        JLabel studentName = new JLabel("Name");
        studentName.setBounds(40, 140, 100, 30);
        studentName.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(studentName);
        tfname = new JTextField();
        tfname.setBounds(200, 140, 170, 30);
        tfname.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(tfname);

        JLabel studentRollNo = new JLabel("Roll No.");
        studentRollNo.setBounds(40, 210, 100, 30);
        studentRollNo.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(studentRollNo);
        tfRollno = new JTextField();
        tfRollno.setBounds(200, 210, 170, 30);
        tfRollno.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(tfRollno);

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
        tfsyjc = new JTextField();
        tfsyjc.setBounds(200, 420, 170, 30);
        tfsyjc.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(tfsyjc);

        JLabel studentCourse = new JLabel("Course");
        studentCourse.setBounds(40, 490, 100, 30);
        studentCourse.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(studentCourse);
        String[] courses = {"Select Course", "BCA", "B.Tech", "MBA", "MCA", "MSc", "M.Tech", "PhD"};
        cbcourse = new JComboBox<String>(courses);
        cbcourse.setBounds(200, 490, 170, 30);
        cbcourse.setFont(new Font("Courier New", Font.PLAIN, 13));
        cbcourse.setBackground(Color.LIGHT_GRAY);
        add(cbcourse);

        ///////////////////

        JLabel studentFatherName = new JLabel("Father's Name");
        studentFatherName.setBounds(450, 140, 200, 30);
        studentFatherName.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(studentFatherName);
        tffathername = new JTextField();
        tffathername.setBounds(660, 140, 170, 30);
        tffathername.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(tffathername);

        JLabel studentDOB = new JLabel("Date of Birth");
        studentDOB.setBounds(450, 210, 200, 30);
        studentDOB.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(studentDOB);
        dcdob = new JDateChooser();
        dcdob.setBounds(660, 210, 200, 30);
        dcdob.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(dcdob);

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
        tfmetric = new JTextField();
        tfmetric.setBounds(660, 350, 170, 30);
        tfmetric.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(tfmetric);

        JLabel studentAadhar = new JLabel("Aadhar No");
        studentAadhar.setBounds(450, 420, 120, 30);
        studentAadhar.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(studentAadhar);
        tfAadharNo = new JTextField();
        tfAadharNo.setBounds(660, 420, 170, 30);
        tfAadharNo.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(tfAadharNo);

        JLabel studentBranch = new JLabel("Branch");
        studentBranch.setBounds(450, 490, 100, 30);
        studentBranch.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(studentBranch);
        String[] Branches = {"Select Branch", "CH", "CE", "CSE", "ECE", "EEE", "EP", "ME", "MTSC", "PE"};
        cbbranch = new JComboBox<String>(Branches);
        cbbranch.setBounds(660, 490, 170, 30);
        cbbranch.setFont(new Font("Courier New", Font.PLAIN, 13));
        cbbranch.setBackground(Color.LIGHT_GRAY);
        add(cbbranch);

        submit = new JButton("Submit");
        submit.setBounds(300, 570, 100, 40);

        submit.setFont(new Font("Courier New", Font.PLAIN, 19));
        submit.addActionListener(this);
        add(submit);
        cancel = new JButton("Cancel");
        cancel.setBounds(550, 570, 100, 40);
        cancel.setFont(new Font("Courier New", Font.PLAIN, 19));
        cancel.addActionListener(this);
        add(cancel);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==submit){
            String name = tfname.getText();
            String fathername = tffathername.getText();
            String rollno = tfRollno.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemailid.getText();
            String classx = tfmetric.getText();
            String classxii = tfsyjc.getText();
            String aadhar = tfAadharNo.getText();
            String course = (String) cbcourse.getSelectedItem() ;
            String branch = (String) cbbranch.getSelectedItem();

            try {
                String query = "insert into student values ('"+name+"', '"+fathername+"', '"+rollno+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+classx+"', '"+classxii+"', '"+aadhar+"', '"+course+"', '"+branch+"')";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student details inserted successfully!");
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
        new AddStudent();
    }
}
