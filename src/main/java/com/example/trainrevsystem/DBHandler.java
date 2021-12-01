package com.example.trainrevsystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHandler extends Configs{

    Connection dbconnection;

    public Connection getConnection(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://localhost:3306/test";
            String username = "root";
            String password = "Ansari";
            dbconnection = DriverManager.getConnection(connectionString,username,password);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    return dbconnection;

    }
}
