package com.example.lifemanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import java.io.*;

public class NotePad extends moveBack{
@FXML
private TextArea txtarea;
@FXML
private TextField title;
File file;

    public void moveToMainMenu(ActionEvent e) throws IOException {
        super.back(e);
    }
    public void saveToFile(ActionEvent actionEvent){
        if ((title.getText()).equals("")) {
            throwError("Enter title of notes first");
        }
        else {
            String name = title.getText() + ".txt";
            file = new File(name);
            try {
                if(file.exists()){
                    throwError("Enter a different file name! this one already exists");
                }
                else{
                    file.createNewFile();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                String line = txtarea.getText();
                bw.write(line);


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void clear(ActionEvent e){
        txtarea.clear();


    }
    public void delete(ActionEvent e){
        txtarea.clear();
        file.delete();

    }
    public void throwError(String m){

            txtarea.setPromptText(m);
            Alert alert=new Alert(Alert.AlertType.ERROR);
         alert.setTitle(m);
        alert.setContentText("this will help save file properly");
        alert.showAndWait();

    }


}
