package edu.ntnu.idatt2001.wargames.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.net.URL;
import java.util.ResourceBundle;

public class BattleSimController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private ImageView backgroundMap;
    @FXML
    private Button battle;
    @FXML
    private Button army1;
    @FXML
    private Button army2;
    @FXML
    private Button menu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backgroundMap.setImage(StartPageController.getChoosenMap());
        backgroundMap.setPreserveRatio(false);
        backgroundMap.fitHeightProperty().bind(root.heightProperty());
        backgroundMap.fitWidthProperty().bind(root.widthProperty());

        battle.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        HBox.setHgrow(battle, Priority.ALWAYS);
        army1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        HBox.setHgrow(army1, Priority.ALWAYS);
        army2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        HBox.setHgrow(army2, Priority.ALWAYS);
        menu.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        HBox.setHgrow(menu, Priority.ALWAYS);
    }
}
