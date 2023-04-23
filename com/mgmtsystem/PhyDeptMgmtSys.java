package com.mgmtsystem;
import javax.swing.*;
import java.awt.*;


public class PhyDeptMgmtSys extends JFrame implements Runnable {
    Thread t;
    PhyDeptMgmtSys(){
        t = new Thread(this);
        t.start();

        ImageIcon i1 = new ImageIcon(getClass().getResource("icons/phy_dept.png"));
        Image i2 = i1.getImage().getScaledInstance(1000, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        setTitle("Physics Department Management System");
        setVisible(true);
        setSize(1000, 750);
        setLocation(300,150);
    }
    public void run(){
        try{

            Thread.sleep(3000);
            new Login();
            setVisible(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new PhyDeptMgmtSys();
    }

}
