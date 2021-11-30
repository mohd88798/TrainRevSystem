package com.example.trainrevsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignInController implements Initializable {

    @FXML
    private TextField tx_username;

    @FXML
    private PasswordField tx_password;

    @FXML
    private Label error;

    @FXML
    private Button sign_in_btn;

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        handler = new DBHandler();
    }

    public void loginInAction(ActionEvent e){
        System.out.println("LogIn button clicked");

        String retrieve = "select * from users where username=? and password=?";

        connection = handler.getConnection();
        try{
            pst = connection.prepareStatement(retrieve);
            pst.setString(1,tx_username.getText());
            pst.setString(2,tx_password.getText());
            ResultSet rs = pst.executeQuery();

            int count = 0;

            while(rs.next()){
                count=count+1;
            }

            if(count==1){
                System.out.println("login successful");
            }
            else{
                System.out.println("error");
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
