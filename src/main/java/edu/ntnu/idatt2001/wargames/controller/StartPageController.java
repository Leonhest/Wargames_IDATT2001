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

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.IOException;
import java.util.Objects;
import java.util.Timer;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TimerTask;

/**
 * Controller used for StartPage.fxml.
 */
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

    private static Image chosenMap;

    private ImageView[] maps;

    private Clip music;

    /**
     * {@inheritDoc}
     * Sets up layout of scene and binds elements to achieve dynamic scaling.
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        chosenMap = map1.getImage();
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


        try {
            music = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                    Main.class.getResourceAsStream("/edu/ntnu/idatt2001/wargames/audio/alexander-nakarada-behind-the-sword.wav"));
            music.open(inputStream);
            music.start();
            music.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Sets the background image for the front page.
     * Background image changes every 8 seconds between preset images.
     * Uses a Timer and TimeTask to loop through images.
     */
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

    /**
     * Selects a map and creates on click effects.
     * Uses onclick event to establish chosen map.
     *
     * @param event Onclick event
     */
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
                chosenMap = m.getImage();
                m.setEffect(highlight);
            }
            else m.setEffect(null);
        }
    }

    /**
     * Changes scene to BattleSim.fxml and {@link BattleSimController}.
     *
     * @param event Onclick event
     * @throws IOException  Wrong file path
     */
    @FXML
    public void startBattle(ActionEvent event) throws IOException {
        timer.cancel();
        music.stop();
        Parent viewPage = FXMLLoader.load(Objects.requireNonNull(StartPageController.class.getResource("/edu/ntnu/idatt2001/wargames/frontend/BattleSim.fxml")));
        Scene page = new Scene(viewPage, 800, 600);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(page);
        window.setMaximized(true);
        window.show();

    }

    /**
     * Gets chosenMap.
     * Used as background in BattleSim.fxml.
     * Each map corresponds to a terrain in a battle.
     * @return map as Image
     */
    public static Image getChosenMap(){
        return chosenMap;
    }

    /**
     * Exits program.
     */
    public void exit(){
        timer.cancel();
        Stage stage = (Stage) offButton.getScene().getWindow();
        stage.close();
        System.exit(0);
    }

}
