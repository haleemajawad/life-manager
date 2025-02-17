package com.example.lifemanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainmenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Life Manager");
       Image image=new Image("C:\\Users\\Haleema Jawad\\Desktop\\project mera apna\\lifeManager\\src\\main\\java\\com\\example\\lifemanager\\images.png");
       stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}