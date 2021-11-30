package com.example.trainrevsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignInController implements Initializable {

    @FXML
    private TextField tx_email;

    @FXML
    private PasswordField tx_password;

    @FXML
    private Label error;

    @FXML
    private Button sign_in_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void loginInAction(ActionEvent e){
        System.out.println("LogIn button clicked");
    }
}
