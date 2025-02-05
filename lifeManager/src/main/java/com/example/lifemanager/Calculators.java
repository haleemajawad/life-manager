package com.example.lifemanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Calculators {
    @FXML
    Stage stage;
    @FXML
    Scene scene;
    @FXML
    Parent root;



    public void switchScene(ActionEvent actionEvent,String fxmlFile) throws IOException {
        root= FXMLLoader.load(Calculators.class.getResource(fxmlFile));

        stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();




    }


    public void switchToSimpCalc(ActionEvent event) throws IOException {
        switchScene(event,"SimpCalc.fxml");
    }public void switchToCgpaCalc(ActionEvent event) throws IOException {
        switchScene(event,"CgpaCalc.fxml");
    }
}
