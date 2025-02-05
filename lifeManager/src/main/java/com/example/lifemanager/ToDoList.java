package com.example.lifemanager;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ToDoList {
    @FXML
    private Button addtolistbtn;
    @FXML
    private Button editlistbtn;
    @FXML
    private Button deletelistbtn;
    @FXML
    private TextArea tdltextarea;
    @FXML
    private ListView<String> tdllistview;
    @FXML
    private Label notelbl;

    private ObservableList<String> mytdl;

    public void initialize() {
        //initialising an observable list
        mytdl = FXCollections.observableArrayList();
        //connecting it with listview
        tdllistview.setItems(mytdl);


    }


    @FXML
    public void addtoList(ActionEvent event) {
        String input=tdltextarea.getText().trim();
        if (input == null || input.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("No text found to be added");
            alert.setContentText("Your to-do item has not been added successfully! Please try again");

            // Show the alert
            alert.showAndWait();
        }


        String line = tdltextarea.getText().trim();
        System.out.println(line);
        String[] tasks = line.split("[,\n]+");
        System.out.println(line);


        for (String s : tasks) {
            String trimmedItem = s.trim();
            if (!trimmedItem.isEmpty()) {
                mytdl.add(trimmedItem);
            }

        }

        tdltextarea.clear();

    }
    public void deleteList(ActionEvent e){
        mytdl.clear();

    }
    public void editList(ActionEvent e){

        tdllistview.setEditable(true);
        //making it editable
        //Before Editing: Items look like normal text.
        //When Editing: A text box (like an input field) appears to let you change the text.
        //After Editing: The new text is saved, and the text box disappears
        tdllistview.setCellFactory(TextFieldListCell.forListView());
notelbl.setText("Now you can edit the list! Double click on an item to edit it \nPress ESC or ENTER to stop editing.");

    }
}



