package com.example.trainrevsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private Connection connection;
    public Connection getConnection(){
        String dbRoot = "jdbc.mysql://";
        String hostName = "localhost:3306";
        String dbName = "javafx-login";
        String dbUrl = dbRoot+hostName+dbName;

        String hostUsername = "root";
        String hostPassword = "Ansari";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, hostUsername, hostPassword);
            System.out.println("Connection successful");
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("Connection failed");
        }
        return connection;
}
    public static void changeScene(ActionEvent event, String fxmlFile, String title, String username){
        Parent root =null;

        if(username!=null){
            try {
                FXMLLoader loader = new FXMLLoader(DBConnection.class.getResource(fxmlFile));
                root = loader.load();
                HomeController homeController = loader.getController();
                homeController.setUserInfo(username);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        else{
            try{
                root = FXMLLoader.load(DBConnection.class.getResource(fxmlFile));
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root,600,400));
        stage.show();

    }
}
