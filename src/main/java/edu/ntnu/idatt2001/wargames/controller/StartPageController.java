package edu.ntnu.idatt2001.wargames.controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


import java.awt.*;
import java.io.InputStream;
import java.util.Timer;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TimerTask;

public class StartPageController implements Initializable {

    @FXML
    private ImageView backgroundImage;
    @FXML
    private ImageView map1;
    @FXML
    private ImageView map2;
    @FXML
    private ImageView map3;
    @FXML
    private ImageView map4;
    @FXML
    private ImageView map5;
    @FXML
    private ImageView map6;
    @FXML
    private AnchorPane root;
    @FXML
    private Label doomText;
    @FXML
    private Pane mapRoot1;

    private int imageNumber = 1;

    private Timer timer = new Timer();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ImageView[] maps = {map1, map2, map3, map4, map5, map6};

        backgroundImage.fitHeightProperty().bind(root.heightProperty());
        backgroundImage.fitWidthProperty().bind(root.widthProperty());

        for(ImageView map: maps){
            map.fitHeightProperty().bind(mapRoot1.heightProperty());
            map.fitWidthProperty().bind(mapRoot1.widthProperty());
        }

        //GridPane.setHalignment(doomText, HPos.CENTER);
        //GridPane.setValignment(doomText, VPos.CENTER);
        InputStream fontStream = StartPageController.class.getResourceAsStream("/edu/ntnu/idatt2001/wargames/fonts/Doom2016Text-GOlBq.ttf");
        Font font = Font.loadFont(fontStream, 100);
        //doomText.setFont(font);
        setBackgroundImage();

    }
    public void setBackgroundImage(){
                timer.scheduleAtFixedRate(

                        new TimerTask() {
                            @Override
                            public void run() {
                                File file = new File("src/main/resources/edu/ntnu/idatt2001/wargames/images/background/wargames_intro"+ imageNumber +".jpeg");
                                Image image = new Image(file.toURI().toString());
                                backgroundImage.setImage(image);

                                if(imageNumber == 9){
                                    imageNumber = 1;
                                }
                                else imageNumber++;
                            }
                        },
                        0, 5000
                );
    }

}
