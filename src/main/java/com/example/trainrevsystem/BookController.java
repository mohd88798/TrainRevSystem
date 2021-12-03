package com.example.trainrevsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DBHandler handler = new DBHandler();
        Connection connection = handler.getConnection();

        populateTrainNo();
        populateSource();
        populateDestination();

    }
    DBHandler handler = new DBHandler();
    Connection connection = handler.getConnection();

    private void populateTrainNo() {
        ObservableList<Integer> list = FXCollections.observableArrayList();
        try{
            ResultSet rs = connection.createStatement().executeQuery("select * from train");
            while ((rs.next())){
                list.add(rs.getInt("trainno"));
                trainNo.setItems(list);

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        trainNo.setItems(null);
        trainNo.setItems(list);

    }

    private void populateSource() {
        ObservableList<String> list = FXCollections.observableArrayList();
        try{
            ResultSet rs = connection.createStatement().executeQuery("select * from train");
            while ((rs.next())){
                list.add(rs.getString("source"));
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
            ResultSet rs = connection.createStatement().executeQuery("select * from train");
            while ((rs.next())){
                list.add(rs.getString("destination"));
                destination.setItems(list);

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        destination.setItems(null);
        destination.setItems(list);

    }
}
