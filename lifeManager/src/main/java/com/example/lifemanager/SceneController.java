package com.example.lifemanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    @FXML
    Stage stage;
    @FXML
    Scene scene;
    @FXML
    Parent root;



    public void switchScene(ActionEvent actionEvent,String fxmlFile) throws IOException {
        root=FXMLLoader.load(getClass().getResource(fxmlFile));

        stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();




    }
    public void switchToTDL(ActionEvent event) throws IOException {
        switchScene(event,"tdl.fxml");
    }
    public void switchToTBR(ActionEvent event) throws IOException {
        switchScene(event,"tbr.fxml");
    }
 public void switchToDoodles(ActionEvent event) throws IOException {
        switchScene(event,"doodles.fxml");
    }
 public void switchToCalc(ActionEvent event) throws IOException {
        switchScene(event,"Calculators.fxml");
    }
 public void switchToNotePad(ActionEvent event) throws IOException {
        switchScene(event,"notepad.fxml");
    }
 public void switchToReminders(ActionEvent event) throws IOException {
        switchScene(event,"reminders.fxml");
    }   public void switchToWishList(ActionEvent event) throws IOException {
        switchScene(event,"wishlist.fxml");
    }  public void switchToMT(ActionEvent event) throws IOException {
        switchScene(event,"MovieTracker.fxml");
    }

}