package com.example.trainrevsystem;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {


    @FXML
    private Label l_welc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//    public void setUserInfo(String fullname){
//            l_welc.setText("Welcome "+fullname);
//        }

    }

    public void setUserInfo(String username) {
    }
}
