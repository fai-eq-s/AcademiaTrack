package com.mgmtsystem;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");    // 1. Registering the database
            c = DriverManager.getConnection("jdbc:mysql:///nitcManagementSystem", "root", "Faisal@7040");   // 2. Creating connection
            s = c.createStatement();     // 3. Creating statement -> helps in executing statements
//            System.out.println("Connection established successfully !");
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Conn();

    }
}
