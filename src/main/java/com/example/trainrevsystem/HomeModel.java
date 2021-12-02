package com.example.trainrevsystem;

import javafx.scene.control.Button;

public class HomeModel {
    Integer Train_No,AC_Seats,NonAC_Seats;
    String TrainName,Source,Destination,Date,Time,Route;
    Button button;

    public HomeModel(String TrainName, Integer Train_No, String Source, String Destination, String Route, String Date, String Time, Integer AC_Seats, Integer NonAC_Seats){
        this.TrainName=TrainName;
        this.Train_No=Train_No;
        this.Source=Source;
        this.Destination=Destination;
        this.Route=Route;
        this.Date=Date;
        this.Time=Time;
        this.AC_Seats=AC_Seats;
        this.NonAC_Seats=NonAC_Seats;
//        this.button = new Button("Book");
    }

    public Integer getTrain_No() {
        return Train_No;
    }

    public Integer getAC_Seats() {
        return AC_Seats;
    }

    public Integer getNonAC_Seats() {
        return NonAC_Seats;
    }

    public String getTrainName() {
        return TrainName;
    }

    public String getSource() {
        return Source;
    }

    public String getDestination() {
        return Destination;
    }

    public String getRoute() {
        return Route;
    }

    public String getDate() {
        return Date;
    }

    public String getTime() {
        return Time;
    }

    public Button getButton(){
        return button;
    }

    public void setTrain_No(Integer Train_No) {
        this.Train_No = Train_No;
    }

    public void setAC_Seats(Integer AC_Seats) {
        this.AC_Seats = AC_Seats;
    }

    public void setNonAC_Seats(Integer NonAC_Seats) {
        this.NonAC_Seats=NonAC_Seats;
    }

    public void setTrainName(String TrainName) {
        this.TrainName=TrainName;
    }

    public void setSource(String Source) {
        this.Source = Source;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public void setRoute(String route) {
        this.Route = Route;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
