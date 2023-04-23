package com.mgmtsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainPage extends JFrame implements ActionListener{

    MainPage(){

        ImageIcon i1 = new ImageIcon(getClass().getResource("icons/phy_dept.png"));
        Image i2 = i1.getImage().getScaledInstance(1050 , 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);


        // Adding menubar
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        // Adding menu in menubar
        JMenu newInformation = new JMenu("Add People");
        newInformation.setFont(new Font("Courier New", 0, 15));
        mb.add(newInformation);
        // Adding menuitem in menu
        JMenuItem facultyInfo = new JMenuItem("Add New Faculty");
        facultyInfo.setFont(new Font("Courier New", 0, 15));
        newInformation.add(facultyInfo);
        facultyInfo.addActionListener(this);
        JMenuItem studentInfo = new JMenuItem("Add New Student");
        studentInfo.setFont(new Font("Courier New", 0, 15));
        newInformation.add(studentInfo);
        studentInfo.addActionListener(this);

        JMenu viewDetails = new JMenu("View People");
        viewDetails.setFont(new Font("Courier New", 0, 15));
        mb.add(viewDetails);
        JMenuItem facultyDetails = new JMenuItem("Faculty Details");
        facultyDetails.setFont(new Font("Courier New", 0, 15));
        viewDetails.add(facultyDetails);
        facultyDetails.addActionListener(this);
        JMenuItem studentDetails = new JMenuItem("Student Details");
        studentDetails.setFont(new Font("Courier New", 0, 15));
        viewDetails.add(studentDetails);
        studentDetails.addActionListener(this);

        JMenu updateInfo = new JMenu("Update People");
        updateInfo.setFont(new Font("Courier New", 0, 15));
        mb.add(updateInfo);
        JMenuItem updateFacultyInfo = new JMenuItem("Update Faculty Details");
        updateFacultyInfo.setFont(new Font("Courier New", 0, 15));
        updateInfo.add(updateFacultyInfo);
        updateFacultyInfo.addActionListener(this);
        JMenuItem updateStudentInfo = new JMenuItem("Update Student Details");
        updateStudentInfo.setFont(new Font("Courier New", 0, 15));
        updateInfo.add(updateStudentInfo);
        updateStudentInfo.addActionListener(this);

        JMenu applyLeave = new JMenu("Apply Leave");
        applyLeave.setFont(new Font("Courier New", 0, 15));
        mb.add(applyLeave);
        JMenuItem facultyLeave = new JMenuItem("For Faculties");
        facultyLeave.setFont(new Font("Courier New", 0, 15));
        applyLeave.add(facultyLeave);
        facultyLeave.addActionListener(this);
        JMenuItem studentLeave = new JMenuItem("For Students");
        studentLeave.setFont(new Font("Courier New", 0, 15));
        applyLeave.add(studentLeave);
        studentLeave.addActionListener(this);

        JMenu leaveDetails = new JMenu("Leave Record");
        leaveDetails.setFont(new Font("Courier New", 0, 15));
        mb.add(leaveDetails);

        JMenuItem facultyLeaveDetails = new JMenuItem("Of Faculties");
        facultyLeaveDetails.setFont(new Font("Courier New", 0, 15));
        leaveDetails.add(facultyLeaveDetails);
        facultyLeaveDetails.addActionListener(this);
        JMenuItem studentLeaveDetails = new JMenuItem("Of Students");
        studentLeaveDetails.setFont(new Font("Courier New", 0, 15));
        leaveDetails.add(studentLeaveDetails);
        studentLeaveDetails.addActionListener(this);

        JMenu examination = new JMenu("Examination");
        examination.setFont(new Font("Courier New", 0, 15));
        mb.add(examination);
        JMenuItem examinationDetails = new JMenuItem("Examination Results");
        examinationDetails.setFont(new Font("Courier New", 0, 15));
        examination.add(examinationDetails);
        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        enterMarks.setFont(new Font("Courier New", 0, 15));
        examination.add(enterMarks);




        JMenu fee = new JMenu("Fee Details");
        fee.setFont(new Font("Courier New", 0, 15));
        mb.add(fee);
        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.setFont(new Font("Courier New", 0, 15));
        fee.add(feeStructure);
        JMenuItem feeform  = new JMenuItem("Student Fee Form");
        feeform.setFont(new Font("Courier New", 0, 15));
        fee.add(feeform);

        JMenu einstein = new JMenu("Move Einstein");
        einstein.setFont(new Font("Courier New", 0, 15));
        mb.add(einstein);
        JMenuItem Einstein = new JMenuItem("Move Einstein");
        Einstein.setFont(new Font("Courier New", 0, 15));
        einstein.add(Einstein);
        Einstein.addActionListener(this);

        JMenu exit = new JMenu("Exit");
        exit.setFont(new Font("Courier New", 0, 15));
        mb.add(exit);
        JMenuItem ex = new JMenuItem("Exit");
        ex.setFont(new Font("Courier New", 0, 15));
        exit.add(ex);
        ex.addActionListener(this);
        setTitle("Physics Department Management System");
        setBounds(300, 150, 1050, 750);
        setSize(1050, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("Exit")) {
            setVisible(false);
        } else if (msg.equals("Add New Faculty")) {
            new AddFaculty();
        } else if (msg.equals("Add New Student")) {
            new AddStudent();
        } else if (msg.equals("Faculty Details")) {
            new FacultyDetails();
        } else if (msg.equals("Student Details")) {
            new StudentDetails();
        } else if (msg.equals("For Students")) {
            new StudentLeave();
        } else if (msg.equals("For Faculties")) {
            new FacultyLeave();
        } else if (msg.equals("Of Faculties")) {
            new facultyLeaveDetails();
        } else if (msg.equals("Of Students")) {
            new studentLeaveDetails();
        } else if (msg.equals("Update Student Details")) {
            new updateStudentDetails();
        } else if (msg.equals("Update Faculty Details")) {
            new updateFacultyDetails();
        } else if (msg.equals("Move Einstein")){
            new Einstein();
        }
    }
    public static void main(String[] args){
        new MainPage();
    }
}
