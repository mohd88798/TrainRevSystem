package com.example.trainrevsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private TextField tx_fullname;

    @FXML
    private TextField tx_email;

    @FXML
    private TextField tx_password;

    @FXML
    private Button sign_up_btn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void signUpAction(ActionEvent e){
        System.out.println("Sign Up button clicked");
    }
}

