package com.example.trainrevsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private TextField tx_fullname;

    @FXML
    private TextField tx_email;

    @FXML
    private TextField tx_mobile;

    @FXML
    private TextField tx_username;

    @FXML
    private PasswordField tx_password;

    @FXML
    private Button sign_up_btn;

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        handler = new DBHandler();

    }

    public void signUpAction(ActionEvent e) throws SQLException {
        System.out.println("Sign Up button clicked");

//        String insert = "insert into users(fullname, email, mobile, username, password)";
        String insert = "insert into users (fullname,email,mobile,username,password) values(?,?,?,?,?)";

        connection = handler.getConnection();
        try{
            pst = connection.prepareStatement(insert);
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        try {
            pst.setString(1,tx_fullname.getText());
            pst.setString(2,tx_email.getText());
            pst.setString(3,tx_mobile.getText());
            pst.setString(4,tx_username.getText());
            pst.setString(5,tx_password.getText());
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }
}

