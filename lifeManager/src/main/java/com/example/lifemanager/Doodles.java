package com.example.lifemanager;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

//back bhee move karna hai uske liye we have functional interface moveback
public class Doodles extends moveBack{
    @FXML
    //to change size of bar
    private ScrollBar sbar;
    @FXML
    //drawing surface
    private Canvas canvas;
//controls and functions related to drawing surface
    private GraphicsContext gc;
//choosing brush color
    @FXML
    private ColorPicker colorpicker;



    //default always runs
@FXML
    public void initialize(){

        gc=canvas.getGraphicsContext2D();
        //default width
        gc.setLineWidth(1);

    }
    //choosing color getting its value and setting value of stroke or brush with that color
    @FXML
    public void pickColor(){
        Color color=colorpicker.getValue();
        gc.setStroke(color);
    }

//for events where mouse is pressed path start hua
    @FXML
    public void startDrawing(MouseEvent event) {
    //starts a path(path is a simple shape extended from shape class)
        gc.beginPath();
        gc.setLineWidth(sbar.getValue());
        //path is moved to a specific coordinate
        gc.moveTo(event.getX(), event.getY());
        //path pe brush will be stroked and color will appear
        gc.stroke();
    }
//when mouse is dragged path is continued
    @FXML
    public void draw(MouseEvent event) {
        gc.setLineWidth(sbar.getValue());
        //draws line
        //Adds segments to the current path to make a line to the given x,y coordinate
        gc.lineTo(event.getX(), event.getY());
        gc.stroke();
    }
    @FXML
    public void delete (ActionEvent e){
//sab delete from 0x to width x and oy to heighty
        gc.clearRect(0,0, canvas.getWidth(), canvas.getHeight());

    }
    @FXML
    public void erase(ActionEvent e){
    gc.setStroke(Color.WHITE);
    gc.setLineWidth(5);
    }
    @FXML
    public void save() {
    // Creates an empty image with the same width and height as the Canvas.
        WritableImage image = new WritableImage((int) canvas.getWidth(), (int) canvas.getHeight());
        //Takes a "screenshot" of the Canvas and stores it in image.
        canvas.snapshot(null, image);

        File file = new File("drawing.png"); // Saves in the project folder
        //Converts the JavaFX image (image) into a format that Java’s ImageIO can understand.
//Saves it as a PNG file ("png") to the specified file.
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            System.out.println("Saved as: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void moveToMainMenu(ActionEvent e) throws IOException {
        super.back(e);
    }



}
