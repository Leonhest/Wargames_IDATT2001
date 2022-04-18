package edu.ntnu.idatt2001.wargames.controller;



import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
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
    private Pane mapRoot1;
    @FXML
    private Pane titlePane;
    @FXML
    private ImageView title;
    @FXML
    private ImageView start;
    @FXML
    private Button startButton;
    @FXML
    private Pane startSizePane;
    @FXML
    private ImageView map;
    @FXML
    private Pane mapPane;
    @FXML
    private Pane offButtonPane;
    @FXML
    private ImageView offButton;

    private int imageNumber = 1;

    private Timer timer = new Timer();

    private static Image choosenMap;

    private ImageView[] maps;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        choosenMap = map1.getImage();
        backgroundImage.fitHeightProperty().bind(root.heightProperty());
        backgroundImage.fitWidthProperty().bind(root.widthProperty());

        maps = new ImageView[]{map1, map2, map3, map4, map5, map6};
        for(ImageView map: maps){
            map.fitHeightProperty().bind(mapRoot1.heightProperty());
            map.fitWidthProperty().bind(mapRoot1.widthProperty());
        }

        offButton.fitHeightProperty().bind(offButtonPane.heightProperty());
        offButton.fitWidthProperty().bind(offButtonPane.widthProperty());
        offButton.setPreserveRatio(true);

        title.fitHeightProperty().bind(titlePane.heightProperty());
        title.fitWidthProperty().bind(titlePane.widthProperty());

        startButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        HBox.setHgrow(startButton, Priority.ALWAYS);
        startButton.setGraphic(start);

        start.fitWidthProperty().bind(startSizePane.widthProperty());
        start.fitHeightProperty().bind(startSizePane.heightProperty());

        map.fitWidthProperty().bind(mapPane.widthProperty());
        map.fitHeightProperty().bind(mapPane.heightProperty());
        setBackgroundImage();

    }
    @FXML
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
                        0, 8000
                );
    }

    @FXML
    public void mapClick(Event event){
        InnerShadow highlight = new InnerShadow();
        highlight.setBlurType(BlurType.GAUSSIAN);
        highlight.setChoke(1);
        highlight.setHeight(10);
        highlight.setWidth(10);
        highlight.setRadius(3);
        highlight.setColor(Color.web("#30C5FF"));
        ImageView temp = (ImageView) event.getTarget();
        for(ImageView m: maps){
            if(m.equals(temp)){
                choosenMap = m.getImage();
                m.setEffect(highlight);
            }
            else m.setEffect(null);
        }
    }

    @FXML
    public void startBattle(ActionEvent event) throws IOException {
        timer.cancel();
        Parent viewPage = FXMLLoader.load(Objects.requireNonNull(StartPageController.class.getResource("/edu/ntnu/idatt2001/wargames/frontend/BattleSim.fxml")));
        Scene page = new Scene(viewPage, 800, 600);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(page);
        window.setMaximized(true);
        window.show();

    }

    public static Image getChoosenMap(){
        return choosenMap;
    }

    public void exit(){
        timer.cancel();
        Stage stage = (Stage) offButton.getScene().getWindow();
        stage.close();
    }

}
