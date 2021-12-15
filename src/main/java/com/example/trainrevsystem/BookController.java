package com.example.trainrevsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class BookController implements Initializable {

    @FXML
    private ComboBox<Integer> trainNo;

    @FXML
    private ComboBox<String> source;

    @FXML
    private ComboBox<String> destination;

    @FXML
    private ComboBox<String> type;

    @FXML
    private ComboBox<String> gender;

    Parent fxml = null;
    Stage stage =new Stage();
    public void changeToTest(ActionEvent event) throws IOException {
        fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Test.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxml));
        stage.show();
    }

    public void changeToHome(ActionEvent event) throws IOException {
        fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomePage.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxml));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DBHandler handler = new DBHandler();
        Connection connection = handler.getConnection();

//        populateTrainNo();
        populateSource();
        populateDestination();
        populateClass();
        populateGender();

    }
    DBHandler handler = new DBHandler();
    Connection connection = handler.getConnection();

//    private void populateTrainNo() {
//        ObservableList<Integer> list = FXCollections.observableArrayList();
//        try{
//            ResultSet rs = connection.createStatement().executeQuery("select * from station");
//            while ((rs.next())){
//                list.add(rs.getInt("stationname"));
//                trainNo.setItems(list);
//
//            }
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//
//        trainNo.setItems(null);
//        trainNo.setItems(list);
//
//    }

    private void populateSource() {
        ObservableList<String> list = FXCollections.observableArrayList();
        try{
            ResultSet rs = connection.createStatement().executeQuery("select * from station");
            while ((rs.next())){
                list.add(rs.getString("stationname"));
                source.setItems(list);

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        source.setItems(null);
        source.setItems(list);

    }

    private void populateDestination() {
        ObservableList<String> list = FXCollections.observableArrayList();
        try{
            ResultSet rs = connection.createStatement().executeQuery("select * from station");
            while ((rs.next())){
                list.add(rs.getString("stationname"));
                destination.setItems(list);

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        destination.setItems(null);
        destination.setItems(list);

    }

    private void populateClass() {
        ObservableList<String> list = FXCollections.observableArrayList();
        try{
//            ResultSet rs = connection.createStatement().executeQuery("select * from train");
//            while ((rs.next())){
                list.add("AC");
                list.add("Non-AC");
                type.setItems(list);

        }catch (Exception ex){
            ex.printStackTrace();
        }

        type.setItems(null);
        type.setItems(list);

    }

    private void populateGender() {
        ObservableList<String> list = FXCollections.observableArrayList();
        try{
//            ResultSet rs = connection.createStatement().executeQuery("select * from train");
//            while ((rs.next())){
            list.add("Male");
            list.add("Female");
            list.add("Other");
            gender.setItems(list);

        }catch (Exception ex){
            ex.printStackTrace();
        }

        gender.setItems(null);
        gender.setItems(list);

    }
}