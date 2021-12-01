package com.example.trainrevsystem;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class HomeController implements Initializable {


    @FXML
    private TableView<HomeModel> homeModelTableView;

    @FXML
    private TableColumn<HomeModel, String> homeModelTrainNameTableColumn;

    @FXML
    private TableColumn<HomeModel, Integer> homeModelTrainNoTableColumn;

    @FXML
    private TableColumn<HomeModel, String> homeModelSourceTableColumn;

    @FXML
    private TableColumn<HomeModel, String> homeModelDestinationTableColumn;

    @FXML
    private TableColumn<HomeModel, String> homeModelDateTableColumn;

    @FXML
    private TableColumn<HomeModel, String> homeModelTimeTableColumn;

    @FXML
    private TableColumn<HomeModel, String> homeModelACTableColumn;

    @FXML
    private TableColumn<HomeModel, String> homeModelNonACTableColumn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DBHandler handler = new DBHandler();
        Connection connection = handler.getConnection();

    }
}
