package com.example.trainrevsystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHandler extends Configs{

    Connection dbconnection;

    public Connection getConnection(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://jblminiproject-do-user-10209104-0.b.db.ondigitalocean.com:25060/RailwayReservationSystem";
            String username = "MohammadZaid";
            String password = "1gjtwVrq4VhSkmDa";
            dbconnection = DriverManager.getConnection(connectionString,username,password);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    return dbconnection;

    }
}
