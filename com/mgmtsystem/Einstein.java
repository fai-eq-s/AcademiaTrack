package com.mgmtsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Einstein extends JFrame implements KeyListener {
    JLabel label;
    ImageIcon icon;
    Einstein(){

        setLocation(450, 200);
        setSize(600, 600);
        setLayout(null);
        addKeyListener(this);


        icon = new ImageIcon("/Users/faisalshaikh/IdeaProjects/JProject/src/icons/einstein.png");
        label = new JLabel();
        label.setBounds(270, 500, 70, 70);
        getContentPane().setBackground(Color.BLACK);
        label.setIcon(icon);
        add(label);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }


    @Override
    public void keyTyped(KeyEvent e) {
//        switch (e.getKeyChar()){
//            case 'a': label.setLocation(label.getX()-1, label.getY());
//        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case 37: label.setLocation(label.getX()-10, label.getY());
                break;
            case 38: label.setLocation(label.getX(), label.getY()-10);
                break;
            case 39: label.setLocation(label.getX()+10, label.getY());
                break;
            case 40: label.setLocation(label.getX(), label.getY()+10);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        System.out.println("You pressed " + e.getKeyChar());
    }

    public static void main(String[] args) {
        new Einstein();
    }

}
