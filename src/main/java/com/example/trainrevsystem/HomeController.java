package com.example.trainrevsystem;

import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
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
    private TableColumn<HomeModel, String> homeModelRouteTableColumn;

    @FXML
    private TableColumn<HomeModel, String> homeModelDateTableColumn;

    @FXML
    private TableColumn<HomeModel, String> homeModelTimeTableColumn;

    @FXML
    private TableColumn<HomeModel, String> homeModelACTableColumn;

    @FXML
    private TableColumn<HomeModel, String> homeModelNonACTableColumn;
    
    @FXML
    private TextField tf_source,tf_destination;

    @FXML
    private TextField tf_date;

    @FXML
    private Button btnBook;

    @FXML
    private Label tx_welcome;



    ObservableList<HomeModel> homeModelObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


//        tx_welcome.setText("Welcome");

        DBHandler handler = new DBHandler();
        Connection connection = handler.getConnection();

        String viewData = "select * from train";
//        String getName = "select fullname from user where username = ?";

        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(viewData);

            while(rs.next()){
                String queryTrainName = rs.getString("trainname");
                Integer queryTrainNo = rs.getInt("trainno");
                String querySource = rs.getString("source");
                String queryDestination = rs.getString("destination");
                String queryRoute = rs.getString("route");
                String queryDate = rs.getString("date");
                String queryTime = rs.getString("time");
                Integer queryACSeats = rs.getInt("acseats");
                Integer queryNonACSeats = rs.getInt("nonacseats");

                homeModelObservableList.add(new HomeModel(queryTrainName,queryTrainNo,querySource,queryDestination,queryRoute,queryDate,queryTime,queryACSeats,queryNonACSeats));

            }

            homeModelTrainNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("TrainName"));
            homeModelTrainNoTableColumn.setCellValueFactory(new PropertyValueFactory<>("Train_No"));
            homeModelSourceTableColumn.setCellValueFactory(new PropertyValueFactory<>("Source"));
            homeModelDestinationTableColumn.setCellValueFactory(new PropertyValueFactory<>("Destination"));
            homeModelRouteTableColumn.setCellValueFactory(new PropertyValueFactory<>("Route"));
            homeModelDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
            homeModelTimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("Time"));
            homeModelACTableColumn.setCellValueFactory(new PropertyValueFactory<>("AC_Seats"));
            homeModelNonACTableColumn.setCellValueFactory(new PropertyValueFactory<>("NonAC_Seats"));

            homeModelTableView.setItems(homeModelObservableList);

            FilteredList<HomeModel> filteredData = new FilteredList<>(homeModelObservableList, b -> true);

            tf_source.textProperty().addListener((observable, oldValue, newValue) ->{
                String searchKeyword = newValue.toLowerCase();
                filteredData.setPredicate(homeModel -> {

                    if(newValue.isEmpty() || newValue.isBlank()){
                        return true;
                    }

                    if(homeModel.getSource().toLowerCase().contains(searchKeyword)){
                        return true;
                    }
                    else{
                        return false;
                    }

                });
            });

            tf_destination.textProperty().addListener((observable, oldValue, newValue) ->{
                filteredData.setPredicate(homeModel -> {

                    if(newValue.isEmpty() || newValue.isBlank()){
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if(homeModel.getDestination().toLowerCase().contains(searchKeyword)){
                        return true;
                    }
                    else{
                        return false;
                    }

                });
            });

            tf_date.textProperty().addListener((observable, oldValue, newValue) ->{
                filteredData.setPredicate(homeModel -> {

                    if(newValue.isEmpty() || newValue.isBlank()){
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if(homeModel.getDate().contains(searchKeyword)){
                        return true;
                    }
                    else{
                        return false;
                    }

                });
            });

            
            SortedList<HomeModel> sortedData = new SortedList<>(filteredData);

            sortedData.comparatorProperty().bind(homeModelTableView.comparatorProperty());

            homeModelTableView.setItems(sortedData);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    Parent fxml = null;
    Stage stage =new Stage();
    public void changeToMain(ActionEvent event) throws IOException {
        fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxml));
        stage.show();
    }

    public void changeToBook(ActionEvent event) throws IOException {
        fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Booking.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxml));
        stage.show();
    }

}
