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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
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

    private Parent fxml;
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        handler = new DBHandler();
    }

    public void loginInAction(ActionEvent e){
        System.out.println("LogIn button clicked");

        String retrieve = "select * from user where username=? and password=?";

        connection = handler.getConnection();
        try {
            pst = connection.prepareStatement(retrieve);
            pst.setString(1, tx_username.getText());
            pst.setString(2, tx_password.getText());
            if (!tx_username.getText().isEmpty() && !tx_password.getText().isEmpty()) {
                ResultSet rs = pst.executeQuery();
                int count = 0;

                while (rs.next()) {
                    count = count + 1;
                }

                if (count >= 1) {
                    changeToHome(e);
                    System.out.println("login successful");
                }
            }
            else{
                error.setText("Invalid Input");
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
