package com.example.trainrevsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
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
    private Label error;

    @FXML
    private Button sign_up_btn;

    private Parent fxml;
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        handler = new DBHandler();

    }

    public void signUpAction(ActionEvent e) throws SQLException {
        System.out.println("Sign Up button clicked");

        String insert = "insert into user (fullname,email,mobile,username,password) values(?,?,?,?,?)";

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
            if (!tx_fullname.getText().isEmpty() && !tx_email.getText().isEmpty() && !tx_mobile.getText().isEmpty() && !tx_username.getText().isEmpty() && !tx_password.getText().isEmpty() ) {
                pst.executeUpdate();
                changeToHome(e);
            }

            else{
                error.setText("Please fill in all the credentials ");
            }
        }catch (SQLException | IOException ex){
            ex.printStackTrace();
        }

    }

    Stage stage =new Stage();
    public void changeToHome(ActionEvent event) throws IOException {
        fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomePage.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxml));
        stage.show();
    }
}

