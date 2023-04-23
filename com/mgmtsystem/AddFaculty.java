package com.mgmtsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.toedter.calendar.JDateChooser;
public class AddFaculty extends JFrame implements ActionListener{

    JDateChooser dcdob;
    JTextField tfname;
    JTextField tfEmpId;
    JTextField tfaddress;
    JTextField tfemailid;
    JTextField tfsyjc;
    JTextField tfcourse;
    JTextField tffathername;

    JTextField tfphone;
    JTextField tfmetric;
    JTextField tfAadharNo;
    JComboBox cbQualification;
    JComboBox cbDept;

    JButton submit, cancel;
    AddFaculty(){
        setSize(900, 700);
        setLocation(350, 50);

        setLayout(null);

        JLabel heading = new JLabel("NEW FACULTY DETAILS");
        heading.setBounds(280, 40, 500, 50);
        heading.setFont(new Font("Courier New", Font.PLAIN, 32));
        add(heading);

        JLabel facultyName = new JLabel("Name");
        facultyName.setBounds(40, 140, 100, 30);
        facultyName.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(facultyName);
        tfname = new JTextField();
        tfname.setBounds(200, 140, 170, 30);
        tfname.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(tfname);

        JLabel facultyEmpID = new JLabel("Employee ID");
        facultyEmpID.setBounds(40, 210, 150, 30);
        facultyEmpID.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(facultyEmpID);
        tfEmpId = new JTextField();
        tfEmpId.setBounds(200, 210, 170, 30);
        tfEmpId.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(tfEmpId);

        JLabel facultyAddress = new JLabel("Address");
        facultyAddress.setBounds(40, 280, 100, 30);
        facultyAddress.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(facultyAddress);
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 280, 170, 30);
        tfaddress.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(tfaddress);

        JLabel facultyEmailID = new JLabel("Email ID");
        facultyEmailID.setBounds(40, 350, 100, 30);
        facultyEmailID.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(facultyEmailID);
        tfemailid = new JTextField();
        tfemailid.setBounds(200, 350, 170, 30);
        tfemailid.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(tfemailid);

        JLabel facultyMarks12 = new JLabel("Class XII(%)");
        facultyMarks12.setBounds(40, 420, 200, 30);
        facultyMarks12.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(facultyMarks12);
        tfsyjc = new JTextField();
        tfsyjc.setBounds(200, 420, 170, 30);
        tfsyjc.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(tfsyjc);

        JLabel facultyQual = new JLabel("Qualification");
        facultyQual.setBounds(40, 490, 150, 30);
        facultyQual.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(facultyQual);
        String[] courses = {"Select Qualification", "BCA", "B.Tech", "MBA", "MCA", "MSc", "M.Tech", "PhD"};
        cbQualification = new JComboBox<String>(courses);
        cbQualification.setBounds(200, 490, 170, 30);
        cbQualification.setFont(new Font("Courier New", Font.PLAIN, 13));
        cbQualification.setBackground(Color.LIGHT_GRAY);
        add(cbQualification);

        ///////////////////

        JLabel facultyFatherName = new JLabel("Father's Name");
        facultyFatherName.setBounds(450, 140, 200, 30);
        facultyFatherName.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(facultyFatherName);
        tffathername = new JTextField();
        tffathername.setBounds(660, 140, 170, 30);
        tffathername.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(tffathername);

        JLabel facultyDOB = new JLabel("Date of Birth");
        facultyDOB.setBounds(450, 210, 200, 30);
        facultyDOB.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(facultyDOB);
        dcdob = new JDateChooser();
        dcdob.setBounds(660, 210, 200, 30);
        dcdob.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(dcdob);

        JLabel facultyPhone = new JLabel("Phone");
        facultyPhone.setBounds(450, 280, 100, 30);
        facultyPhone.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(facultyPhone);
        tfphone = new JTextField();
        tfphone.setBounds(660, 280, 170, 30);
        tfphone.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(tfphone);

        JLabel facultymetric = new JLabel("Class X(%)");
        facultymetric.setBounds(450, 350, 150, 30);
        facultymetric.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(facultymetric);
        tfmetric = new JTextField();
        tfmetric.setBounds(660, 350, 170, 30);
        tfmetric.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(tfmetric);

        JLabel facultyAadhar = new JLabel("Aadhar No");
        facultyAadhar.setBounds(450, 420, 120, 30);
        facultyAadhar.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(facultyAadhar);
        tfAadharNo = new JTextField();
        tfAadharNo.setBounds(660, 420, 170, 30);
        tfAadharNo.setFont(new Font("Courier New", Font.PLAIN, 17));
        add(tfAadharNo);

        JLabel facultyBranch = new JLabel("Branch");
        facultyBranch.setBounds(450, 490, 100, 30);
        facultyBranch.setFont(new Font("Courier New", Font.PLAIN, 19));
        add(facultyBranch);
        String[] Dept = {"Select Department", "Chemical", "Civil", "Computer Science", "Electronics & Communication", "Electrical & Electronics", "Physics", "Mechanical", "Material Science", "Production"};
        cbDept = new JComboBox<String>(Dept);
        cbDept.setBounds(660, 490, 170, 30);
        cbDept.setFont(new Font("Courier New", Font.PLAIN, 13));
        cbDept.setBackground(Color.LIGHT_GRAY);
        add(cbDept);

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
            String empId = tfEmpId.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemailid.getText();
            String classx = tfmetric.getText();
            String classxii = tfsyjc.getText();
            String aadhar = tfAadharNo.getText();
            String qual = (String) cbQualification.getSelectedItem() ;
            String dept = (String) cbDept.getSelectedItem();

            try {
                String query = "insert into faculty values ('"+name+"', '"+fathername+"', '"+empId+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+classx+"', '"+classxii+"', '"+aadhar+"', '"+qual+"', '"+dept+"')";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Faculty details inserted successfully!");
                setVisible(false);
                new FacultyDetails();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if (ae.getSource()==cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddFaculty();
    }
}