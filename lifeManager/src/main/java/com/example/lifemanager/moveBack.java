package com.example.lifemanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class moveBack {
   void back(ActionEvent e) throws IOException{
       //moves to mainmenu
       Parent root= FXMLLoader.load(getClass().getResource("mainmenu.fxml"));

       Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
       Scene scene=new Scene(root);
       stage.setScene(scene);
       stage.show();

   }
}
