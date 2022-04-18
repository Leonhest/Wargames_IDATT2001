package edu.ntnu.idatt2001.wargames.controller;

import edu.ntnu.idatt2001.wargames.backend.army.*;
import edu.ntnu.idatt2001.wargames.backend.battle.Battle;
import edu.ntnu.idatt2001.wargames.backend.battle.Terrain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

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
    private GridPane battleGrid;
    @FXML
    private Button menu;
    @FXML
    private Button home;
    @FXML
    private Button reset;
    @FXML
    private Button cancel;
    @FXML
    private GridPane menuGrid;
    @FXML
    private Pane addUnitPane;
    @FXML
    private Pane attributesPane;
    @FXML
    private ImageView addUnitAdd;
    @FXML
    private ImageView addUnitUnit;
    @FXML
    private ImageView type;
    @FXML
    private ImageView name;
    @FXML
    private ImageView health;
    @FXML
    private ImageView attack;
    @FXML
    private ImageView armor;
    @FXML
    private ImageView quantity;
    @FXML
    private GridPane addArmyGrid;
    @FXML
    private Button addButton;
    @FXML
    private Button importButton;
    @FXML
    private Button saveButton;
    @FXML
    private TextField nameTextField;
    @FXML
    private ChoiceBox typeChoice;
    @FXML
    private TextField healthNumberField;
    @FXML
    private TextField attackNumberField;
    @FXML
    private Text optional;
    @FXML
    private Text optional1;
    @FXML
    private VBox attackVBox;
    @FXML
    private HBox typeHBox;
    @FXML
    private HBox nameHBox;
    @FXML
    private HBox healthHBox;
    @FXML
    private VBox armorVBox;
    @FXML
    private VBox qtyVBox;
    @FXML
    private TextField armorNumberField;
    @FXML
    private TextField qtyNumberField;
    @FXML
    private ImageView armyViewTitle;
    @FXML
    private ImageView renameArmy;
    @FXML
    private Pane armyViewTitlePane;
    @FXML
    private Pane renameArmyPane;
    @FXML
    private Button renameArmyButton;
    @FXML
    private Button clearArmyButton;
    @FXML
    private Button deployArmyButton;
    @FXML
    private TableView armyTableView;
    @FXML
    private TextField renameArmyField;
    @FXML
    private Text successText;
    @FXML
    private ImageView winnerImage;
    @FXML
    private Pane winnerPane;
    @FXML
    private Text armyWinnerText;
    @FXML
    private HBox armyWinnerHBox;
    @FXML
    private Pane winnerBackground;
    @FXML
    private GridPane winnerGrid;
    @FXML
    private TableView armyWinnerTable;
    @FXML
    private Button retryButton;
    @FXML
    private Button exitToMenuButton;
    @FXML
    private Pane army1Pane;
    @FXML
    private ImageView army1Image;
    @FXML
    private Pane startBattlePane;
    @FXML
    private ImageView startBattleImage;
    @FXML
    private Pane army2Pane;
    @FXML
    private ImageView army2Image;
    @FXML
    private Pane menuPane;
    @FXML
    private ImageView menuImage;
    @FXML
    private Pane homePane;
    @FXML
    private ImageView menuButtonImage;
    @FXML
    private ImageView resetButtonImage;
    @FXML
    private ImageView cancelButtonImage;
    @FXML
    private Pane battleSumButtonPane;
    @FXML
    private ImageView retryButtonImage;
    @FXML
    private ImageView exitButtonImage;
    @FXML
    private Pane addUnitButtonsPane;
    @FXML
    private ImageView addImage;
    @FXML
    private ImageView importImage;
    @FXML
    private ImageView saveImage;
    @FXML
    private Pane armyOptionsPane;
    @FXML
    private ImageView clearImage;
    @FXML
    private ImageView deployImage;
    @FXML
    private ImageView okImage;
    @FXML
    private Pane statsButtonPane;
    @FXML
    private Button statsButton;
    @FXML
    private ImageView statsButtonImage;
    @FXML
    private HBox firstArmyTitleHBox;
    @FXML
    private HBox secondArmyTitleHBox;
    @FXML
    private Text firstArmyTitle;
    @FXML
    private Text secondArmyTitle;
    @FXML
    private TableView firstArmyStats;
    @FXML
    private TableView secondArmyStats;
    @FXML
    private TableView firstArmyInfo;
    @FXML
    private TableView secondArmyInfo;
    @FXML
    private Button statsExitButton;
    @FXML
    private ImageView statsExitImage;
    @FXML
    private Pane statsExitPane;
    @FXML
    private GridPane statsGrid;

    private Button armyCheck;

    private Army firstArmy;
    private Army secondArmy;

    private Army firsArmyCopy;
    private Army secondArmyCopy;

    private ObservableList<Unit> obsFirstArmy;
    private ObservableList<Unit> obsSecondArmy;

    private Font doomFont;
    private Font doomFontLarge;

    private double fontSize = 50;
    private double armyFontSize = 40;


    private Map<String, Terrain> mapToTerrain;
    private Terrain terrain;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstArmy = new Army("firstArmy");
        secondArmy = new Army("secondArmy");

        InputStream fontStream = BattleSimController.class.getResourceAsStream("/edu/ntnu/idatt2001/wargames/fonts/Doom2016Text-GOlBq.ttf");
        doomFont = Font.loadFont(fontStream, 20);
        InputStream fontStream2 = BattleSimController.class.getResourceAsStream("/edu/ntnu/idatt2001/wargames/fonts/Doom2016Text-GOlBq.ttf");
        doomFontLarge = Font.loadFont(fontStream2, 80);

        optional.setFont(doomFont);
        optional1.setFont(doomFont);

        obsFirstArmy = FXCollections.observableArrayList(firstArmy.getAllUnits());
        obsSecondArmy = FXCollections.observableArrayList(secondArmy.getAllUnits());

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
        statsButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        HBox.setHgrow(statsButton, Priority.ALWAYS);
        statsExitButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        HBox.setHgrow(statsExitButton, Priority.ALWAYS);


        typeChoice.getItems().add(UnitType.INFANTRY);
        typeChoice.getItems().add(UnitType.RANGED);
        typeChoice.getItems().add(UnitType.CAVALRY);
        typeChoice.getItems().add(UnitType.COMMANDER);


        Image throneRoom = new Image("/edu/ntnu/idatt2001/wargames/images/maps/throne_room_pic.png");
        Image lakeside = new Image("/edu/ntnu/idatt2001/wargames/images/maps/lakeside_ambush_pic.png");
        Image ruins = new Image("/edu/ntnu/idatt2001/wargames/images/maps/ruins_pic.png");
        Image mountain = new Image("/edu/ntnu/idatt2001/wargames/images/maps/Mountain_Pass_pic.png");
        Image iceLake = new Image("/edu/ntnu/idatt2001/wargames/images/maps/ice_pic.png");
        Image pumpkinFarm = new Image("/edu/ntnu/idatt2001/wargames/images/maps/pumpkin_farm_pic.png");

        mapToTerrain = new HashMap<>();
        mapToTerrain.put(throneRoom.getUrl(), Terrain.DEFAULT);
        mapToTerrain.put(lakeside.getUrl(), Terrain.PLAINS);
        mapToTerrain.put(ruins.getUrl(), Terrain.FORREST);
        mapToTerrain.put(mountain.getUrl(), Terrain.HILL);
        mapToTerrain.put(iceLake.getUrl(), Terrain.PLAINS);
        mapToTerrain.put(pumpkinFarm.getUrl(), Terrain.PLAINS);

        terrain = mapToTerrain.get(backgroundMap.getImage().getUrl());

        TableColumn<Unit, String> column1 =
                new TableColumn<>("Type");

        column1.setCellValueFactory(
                new PropertyValueFactory<>("type"));

        TableColumn<Unit, String> column2 =
                new TableColumn<>("Name");

        column2.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        TableColumn<Unit, Integer> column3 =
                new TableColumn<>("Health");

        column3.setCellValueFactory(
                new PropertyValueFactory<>("health"));

        TableColumn<Unit, Integer> column4 =
                new TableColumn<>("Attack");

        column4.setCellValueFactory(
                new PropertyValueFactory<>("attack"));

        TableColumn<Unit, Integer> column5 =
                new TableColumn<>("Armor");

        column5.setCellValueFactory(
                new PropertyValueFactory<>("armor"));

        armyTableView.getColumns().add(column1);
        armyTableView.getColumns().add(column2);
        armyTableView.getColumns().add(column3);
        armyTableView.getColumns().add(column4);
        armyTableView.getColumns().add(column5);



        column1.prefWidthProperty().bind(armyTableView.widthProperty().divide(5));
        column2.prefWidthProperty().bind(armyTableView.widthProperty().divide(5));
        column3.prefWidthProperty().bind(armyTableView.widthProperty().divide(5));
        column4.prefWidthProperty().bind(armyTableView.widthProperty().divide(5));
        column5.prefWidthProperty().bind(armyTableView.widthProperty().divide(5));

        TableColumn<Unit, String> firstArmyColumn1 =
                new TableColumn<>("Type");

        firstArmyColumn1.setCellValueFactory(
                new PropertyValueFactory<>("type"));

        TableColumn<Unit, String> firstArmyColumn2 =
                new TableColumn<>("Name");

        firstArmyColumn2.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        TableColumn<Unit, Integer> firstArmyColumn3 =
                new TableColumn<>("Health");

        firstArmyColumn3.setCellValueFactory(
                new PropertyValueFactory<>("health"));

        TableColumn<Unit, Integer> firstArmyColumn4 =
                new TableColumn<>("Attack");

        firstArmyColumn4.setCellValueFactory(
                new PropertyValueFactory<>("attack"));

        TableColumn<Unit, Integer> firstArmyColumn5 =
                new TableColumn<>("Armor");

        firstArmyColumn5.setCellValueFactory(
                new PropertyValueFactory<>("armor"));

        firstArmyStats.getColumns().add(firstArmyColumn1);
        firstArmyStats.getColumns().add(firstArmyColumn2);
        firstArmyStats.getColumns().add(firstArmyColumn3);
        firstArmyStats.getColumns().add(firstArmyColumn4);
        firstArmyStats.getColumns().add(firstArmyColumn5);

        firstArmyColumn1.prefWidthProperty().bind(firstArmyStats.widthProperty().divide(5));
        firstArmyColumn2.prefWidthProperty().bind(firstArmyStats.widthProperty().divide(5));
        firstArmyColumn3.prefWidthProperty().bind(firstArmyStats.widthProperty().divide(5));
        firstArmyColumn4.prefWidthProperty().bind(firstArmyStats.widthProperty().divide(5));
        firstArmyColumn5.prefWidthProperty().bind(firstArmyStats.widthProperty().divide(5));

        TableColumn<Unit, String> secondArmyColumn1 =
                new TableColumn<>("Type");

        secondArmyColumn1.setCellValueFactory(
                new PropertyValueFactory<>("type"));

        TableColumn<Unit, String> secondArmyColumn2 =
                new TableColumn<>("Name");

        secondArmyColumn2.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        TableColumn<Unit, Integer> secondArmyColumn3 =
                new TableColumn<>("Health");

        secondArmyColumn3.setCellValueFactory(
                new PropertyValueFactory<>("health"));

        TableColumn<Unit, Integer> secondArmyColumn4 =
                new TableColumn<>("Attack");

        secondArmyColumn4.setCellValueFactory(
                new PropertyValueFactory<>("attack"));

        TableColumn<Unit, Integer> secondArmyColumn5 =
                new TableColumn<>("Armor");

        secondArmyColumn5.setCellValueFactory(
                new PropertyValueFactory<>("armor"));

        secondArmyStats.getColumns().add(secondArmyColumn1);
        secondArmyStats.getColumns().add(secondArmyColumn2);
        secondArmyStats.getColumns().add(secondArmyColumn3);
        secondArmyStats.getColumns().add(secondArmyColumn4);
        secondArmyStats.getColumns().add(secondArmyColumn5);

        secondArmyColumn1.prefWidthProperty().bind(secondArmyStats.widthProperty().divide(5));
        secondArmyColumn2.prefWidthProperty().bind(secondArmyStats.widthProperty().divide(5));
        secondArmyColumn3.prefWidthProperty().bind(secondArmyStats.widthProperty().divide(5));
        secondArmyColumn4.prefWidthProperty().bind(secondArmyStats.widthProperty().divide(5));
        secondArmyColumn5.prefWidthProperty().bind(secondArmyStats.widthProperty().divide(5));

        TableColumn<Map, String> firstInfoColumn1 =
                new TableColumn<>("Info");
        firstInfoColumn1.setCellValueFactory(new MapValueFactory<>("info"));

        TableColumn<Map, Integer> firstInfoColumn2 =
                new TableColumn<>("Numbers");
        firstInfoColumn2.setCellValueFactory(new MapValueFactory<>("numbers"));


        firstArmyInfo.getColumns().add(firstInfoColumn1);
        firstArmyInfo.getColumns().add(firstInfoColumn2);
        firstInfoColumn1.prefWidthProperty().bind(firstArmyInfo.widthProperty().divide(2));
        firstInfoColumn2.prefWidthProperty().bind(firstArmyInfo.widthProperty().divide(2));

        TableColumn<Map, String> secondInfoColumn1 =
                new TableColumn<>("Info");
        secondInfoColumn1.setCellValueFactory(new MapValueFactory<>("info"));

        TableColumn<Map, Integer> secondInfoColumn2 =
                new TableColumn<>("Numbers");
        secondInfoColumn2.setCellValueFactory(new MapValueFactory<>("numbers"));


        secondArmyInfo.getColumns().add(secondInfoColumn1);
        secondArmyInfo.getColumns().add(secondInfoColumn2);
        secondInfoColumn1.prefWidthProperty().bind(secondArmyInfo.widthProperty().divide(2));
        secondInfoColumn2.prefWidthProperty().bind(secondArmyInfo.widthProperty().divide(2));




        TableColumn<Unit, String> winnerColumn1 =
                new TableColumn<>("Type");

        winnerColumn1.setCellValueFactory(
                new PropertyValueFactory<>("type"));

        TableColumn<Unit, String> winnerColumn2 =
                new TableColumn<>("Name");

        winnerColumn2.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        TableColumn<Unit, Integer> winnerColumn3 =
                new TableColumn<>("Health");

        winnerColumn3.setCellValueFactory(
                new PropertyValueFactory<>("health"));

        armyWinnerTable.getColumns().add(winnerColumn1);
        armyWinnerTable.getColumns().add(winnerColumn2);
        armyWinnerTable.getColumns().add(winnerColumn3);
        winnerColumn1.prefWidthProperty().bind(armyWinnerTable.widthProperty().divide(3));
        winnerColumn2.prefWidthProperty().bind(armyWinnerTable.widthProperty().divide(3));
        winnerColumn3.prefWidthProperty().bind(armyWinnerTable.widthProperty().divide(3));

        army1Image.fitWidthProperty().bind(army1Pane.widthProperty());
        army1Image.fitHeightProperty().bind(army1Pane.heightProperty());

        startBattleImage.fitWidthProperty().bind(startBattlePane.widthProperty());
        startBattleImage.fitHeightProperty().bind(startBattlePane.heightProperty());

        army2Image.fitWidthProperty().bind(army2Pane.widthProperty());
        army2Image.fitHeightProperty().bind(army2Pane.heightProperty());

        menuImage.fitWidthProperty().bind(menuPane.widthProperty());
        menuImage.fitHeightProperty().bind(menuPane.heightProperty());

        menuButtonImage.fitWidthProperty().bind(homePane.widthProperty());
        menuButtonImage.fitHeightProperty().bind(homePane.heightProperty());

        resetButtonImage.fitWidthProperty().bind(homePane.widthProperty());
        resetButtonImage.fitHeightProperty().bind(homePane.heightProperty());

        cancelButtonImage.fitWidthProperty().bind(homePane.widthProperty());
        cancelButtonImage.fitHeightProperty().bind(homePane.heightProperty());

        retryButtonImage.fitWidthProperty().bind(battleSumButtonPane.widthProperty());
        retryButtonImage.fitHeightProperty().bind(battleSumButtonPane.heightProperty());

        exitButtonImage.fitWidthProperty().bind(battleSumButtonPane.widthProperty());
        exitButtonImage.fitHeightProperty().bind(battleSumButtonPane.heightProperty());

        addImage.fitWidthProperty().bind(addUnitButtonsPane.widthProperty());
        addImage.fitHeightProperty().bind(addUnitButtonsPane.heightProperty());

        importImage.fitWidthProperty().bind(addUnitButtonsPane.widthProperty());
        importImage.fitHeightProperty().bind(addUnitButtonsPane.heightProperty());

        saveImage.fitWidthProperty().bind(addUnitButtonsPane.widthProperty());
        saveImage.fitHeightProperty().bind(addUnitButtonsPane.heightProperty());

        clearImage.fitWidthProperty().bind(armyOptionsPane.widthProperty());
        clearImage.fitHeightProperty().bind(armyOptionsPane.heightProperty());

        deployImage.fitWidthProperty().bind(armyOptionsPane.widthProperty());
        deployImage.fitHeightProperty().bind(armyOptionsPane.heightProperty());

        okImage.fitWidthProperty().bind(renameArmyField.widthProperty());
        okImage.fitHeightProperty().bind(renameArmyField.heightProperty());

        statsButtonImage.fitWidthProperty().bind(statsButtonPane.widthProperty());
        statsButtonImage.fitHeightProperty().bind(statsButtonPane.heightProperty());

        statsExitImage.fitWidthProperty().bind(statsExitPane.widthProperty());
        statsExitImage.fitHeightProperty().bind(statsExitPane.heightProperty());

    }


    @FXML
    public void menu(){
        home.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        HBox.setHgrow(home, Priority.ALWAYS);
        reset.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        HBox.setHgrow(reset, Priority.ALWAYS);
        cancel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        HBox.setHgrow(cancel, Priority.ALWAYS);
        menuGrid.setVisible(true);
    }

    @FXML
    public void toStartPage(ActionEvent event) throws IOException {
        Parent viewPage = FXMLLoader.load(Objects.requireNonNull(StartPageController.class.getResource("/edu/ntnu/idatt2001/wargames/frontend/StartPage.fxml")));
        Scene page = new Scene(viewPage, 800, 600);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(page);
        window.setMaximized(true);
        window.show();
    }

    @FXML
    public void resetBattleSim(ActionEvent event) throws IOException {
        Parent viewPage = FXMLLoader.load(Objects.requireNonNull(StartPageController.class.getResource("/edu/ntnu/idatt2001/wargames/frontend/BattleSim.fxml")));
        Scene page = new Scene(viewPage, 800, 600);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(page);
        window.setMaximized(true);
        window.show();
    }

    @FXML
    public void cancelMenu(){
        menuGrid.setVisible(false);
    }

    @FXML
    public void addArmy(ActionEvent event){

        addUnitAdd.fitWidthProperty().bind(addUnitPane.widthProperty());
        addUnitAdd.fitHeightProperty().bind(addUnitPane.heightProperty());
        addUnitUnit.fitWidthProperty().bind(addUnitPane.widthProperty());
        addUnitUnit.fitHeightProperty().bind(addUnitPane.heightProperty());
        addUnitAdd.setPreserveRatio(false);
        addUnitUnit.setPreserveRatio(false);
        ImageView[] attribute = {type, name, health, attack, armor, quantity};
        for(ImageView att: attribute){
            att.setPreserveRatio(false);
            att.fitWidthProperty().bind(attributesPane.widthProperty());
            att.fitHeightProperty().bind(attributesPane.heightProperty());
        }
        Button[] buttons = {addButton, importButton, saveButton};
        for(Button button: buttons){
            button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            HBox.setHgrow(button, Priority.ALWAYS);
        }



        TextField[] numberBoxes = {healthNumberField, attackNumberField, armorNumberField, qtyNumberField};

        for(TextField field: numberBoxes){
            field.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
            field.textProperty().addListener((obs,oldValue,newValue) -> {
                try {
                    field.getTextFormatter().getValueConverter().fromString(newValue);
                    field.setBorder(null);
                } catch (NumberFormatException e) {
                    field.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(3), new BorderWidths(2), new Insets(-2))));
                }
            });
        }

        attackVBox.setAlignment(Pos.CENTER);
        typeHBox.setAlignment(Pos.CENTER);
        nameHBox.setAlignment(Pos.CENTER);
        healthHBox.setAlignment(Pos.CENTER);
        armorVBox.setAlignment(Pos.CENTER);
        qtyVBox.setAlignment(Pos.CENTER);

        armyCheck = (Button) event.getTarget();

        armyViewTitle.fitWidthProperty().bind(armyViewTitlePane.widthProperty());
        armyViewTitle.fitHeightProperty().bind(armyViewTitlePane.heightProperty());
        armyViewTitle.setPreserveRatio(false);

        renameArmy.fitWidthProperty().bind(renameArmyPane.widthProperty());
        renameArmy.fitHeightProperty().bind(renameArmyPane.heightProperty());
        renameArmy.setPreserveRatio(false);

        renameArmyButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        HBox.setHgrow(renameArmyButton, Priority.ALWAYS);
        clearArmyButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        HBox.setHgrow(clearArmyButton, Priority.ALWAYS);
        deployArmyButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        HBox.setHgrow(deployArmyButton, Priority.ALWAYS);




        if(armyCheck.equals(army1)){
            armyTableView.setItems(obsFirstArmy);
        }
        else if(armyCheck.equals(army2)){
            armyTableView.setItems(obsSecondArmy);
        }

        battleGrid.setVisible(false);
        addArmyGrid.setVisible(true);
    }

    @FXML
    public void addUnitToArmy(){
        UnitType type = (UnitType) typeChoice.getValue();
        String name = nameTextField.getText();
        String health = healthNumberField.getText();
        String qty = qtyNumberField.getText();
        String attack = attackNumberField.getText();
        String armor = armorNumberField.getText();
        if(type == null || health.equals("") || qty.equals("")){
            return;
        }
        if(armyCheck.equals(army1)){
            if(attack.equals("") || armor.equals("")){
                firstArmy.addAll(UnitFactory.getListUnits(type, name, Integer.parseInt(health), Integer.parseInt(qty)));
            }
            else firstArmy.addAll(UnitFactory.getListComplexUnits(type, name, Integer.parseInt(health), Integer.parseInt(attack), Integer.parseInt(armor), Integer.parseInt(qty)));
            obsFirstArmy.setAll(firstArmy.getAllUnits());
        }
        else if(armyCheck.equals(army2)){
            if(attack.equals("") || armor.equals("")){
                secondArmy.addAll(UnitFactory.getListUnits(type, name, Integer.parseInt(health), Integer.parseInt(qty)));
            }
            else secondArmy.addAll(UnitFactory.getListComplexUnits(type, name, Integer.parseInt(health), Integer.parseInt(attack), Integer.parseInt(armor), Integer.parseInt(qty)));
            obsSecondArmy.setAll(secondArmy.getAllUnits());
        }
    }

    @FXML
    public void importArmy(){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(root.getScene().getWindow());
        if(armyCheck.equals(army1)){
            firstArmy = new Army(file);
            obsFirstArmy.setAll(firstArmy.getAllUnits());
        }
        else if(armyCheck.equals(army2)){
            secondArmy = new Army(file);
            obsSecondArmy.setAll(secondArmy.getAllUnits());
        }
    }

    @FXML
    public void saveArmy(){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File file = directoryChooser.showDialog(root.getScene().getWindow());
        if(armyCheck.equals(army1)){
            firstArmy.armyToCsv(file.getPath(), firstArmy.getName());
        }
        else if(armyCheck.equals(army2)){
            secondArmy.armyToCsv(file.getPath(), secondArmy.getName());
        }
    }

    @FXML
    public void renameArmy(){
        String newName = renameArmyField.getText();
        successText.setFont(doomFont);
        if(armyCheck.equals(army1)){
            firstArmy.setName(newName);
            successText.setVisible(true);
        }
        else if(armyCheck.equals(army2)){
            secondArmy.setName(newName);
            successText.setVisible(true);

        }
    }

    @FXML
    public void clearArmy(){
        if(armyCheck.equals(army1)){
            firstArmy.getAllUnits().clear();
            obsFirstArmy.setAll(firstArmy.getAllUnits());
        }
        else if(armyCheck.equals(army2)){
            secondArmy.getAllUnits().clear();
            obsSecondArmy.setAll(secondArmy.getAllUnits());
        }
    }

    @FXML
    public void deployArmy(){
        addArmyGrid.setVisible(false);
        battleGrid.setVisible(true);
        successText.setVisible(false);

    }

    @FXML
    public void startBattle(){
        for(Unit unit: firstArmy.getAllUnits()){
            unit.setTerrain(terrain);
        }
        for(Unit unit: secondArmy.getAllUnits()){
            unit.setTerrain(terrain);
        }
        Battle battle = new Battle(firstArmy, secondArmy, terrain);
        firsArmyCopy = new Army(firstArmy);
        secondArmyCopy = new Army(secondArmy);
        Army winner = battle.simulate();


        winnerImage.fitHeightProperty().bind(winnerPane.heightProperty());
        winnerImage.fitWidthProperty().bind(winnerPane.widthProperty());
        winnerImage.setPreserveRatio(false);

        HBox.setHgrow(armyWinnerText, Priority.ALWAYS);
        armyWinnerHBox.setAlignment(Pos.CENTER);
        armyWinnerText.setFont(doomFontLarge);
        armyWinnerText.setText(winner.getName().toUpperCase(Locale.ROOT));

        armyWinnerHBox.heightProperty().addListener((value, number, t1) -> {
            fontSize = armyWinnerHBox.getHeight()/1.5;

            armyWinnerText.setStyle("-fx-font-size: " + fontSize);
        });


        ObservableList<Unit> winnerArmy = FXCollections.observableArrayList(winner.getAllUnits());
        armyWinnerTable.setItems(winnerArmy);

        retryButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        HBox.setHgrow(retryButton, Priority.ALWAYS);
        exitToMenuButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        HBox.setHgrow(exitToMenuButton, Priority.ALWAYS);

        winnerBackground.setVisible(true);
        winnerGrid.setVisible(true);
    }

    @FXML
    public void retryBattle(){
        firstArmy = new Army(firsArmyCopy);
        secondArmy = new Army(secondArmyCopy);

        winnerBackground.setVisible(false);
        winnerGrid.setVisible(false);
    }

    @FXML
    public void seeStats(){
        HBox.setHgrow(firstArmyTitle, Priority.ALWAYS);
        HBox.setHgrow(secondArmyTitle, Priority.ALWAYS);
        firstArmyTitleHBox.setAlignment(Pos.CENTER);
        secondArmyTitleHBox.setAlignment(Pos.CENTER);
        firstArmyTitle.setFont(doomFontLarge);
        secondArmyTitle.setFont(doomFontLarge);
        firstArmyTitle.setText(firstArmy.getName().toUpperCase(Locale.ROOT));
        secondArmyTitle.setText(secondArmy.getName().toUpperCase(Locale.ROOT));

        firstArmyTitleHBox.heightProperty().addListener((value, number, t1) -> {
            armyFontSize = armyWinnerHBox.getHeight()/1.5;

            firstArmyTitle.setStyle("-fx-font-size: " + armyFontSize);
            secondArmyTitle.setStyle("-fx-font-size: " + armyFontSize);
        });
        ObservableList<Unit> firstArmyList = FXCollections.observableArrayList(firstArmy.getAllUnits());
        firstArmyStats.setItems(firstArmyList);

        ObservableList<Unit> secondArmyList = FXCollections.observableArrayList(secondArmy.getAllUnits());
        secondArmyStats.setItems(secondArmyList);

        ObservableList<Map<String, Object>> items =
                FXCollections.<Map<String, Object>>observableArrayList();

        Map<String, Object> totalUnits1 = new HashMap<>();
        totalUnits1.put("info", "Total units");
        totalUnits1.put("numbers" , firstArmy.getAllUnits().size());

        Map<String, Object> infantryUnits1 = new HashMap<>();
        infantryUnits1.put("info", "Total infantry");
        infantryUnits1.put("numbers" , firstArmy.getInfantryUnits().size());

        Map<String, Object> rangedUnits1 = new HashMap<>();
        rangedUnits1.put("info", "Total ranged");
        rangedUnits1.put("numbers" , firstArmy.getRangedUnits().size());

        Map<String, Object> cavalryUnits1 = new HashMap<>();
        cavalryUnits1.put("info", "Total cavalry");
        cavalryUnits1.put("numbers" , firstArmy.getCavalryUnits().size());

        Map<String, Object> commanderUnits1 = new HashMap<>();
        commanderUnits1.put("info", "Total commanders");
        commanderUnits1.put("numbers" , firstArmy.getCommanderUnits().size());

        items.add(totalUnits1);
        items.add(infantryUnits1);
        items.add(rangedUnits1);
        items.add(cavalryUnits1);
        items.add(commanderUnits1);
        firstArmyInfo.getItems().clear();

        firstArmyInfo.getItems().addAll(items);


        ObservableList<Map<String, Object>> items2 =
                FXCollections.<Map<String, Object>>observableArrayList();

        Map<String, Object> totalUnits2 = new HashMap<>();
        totalUnits2.put("info", "Total units");
        totalUnits2.put("numbers" , secondArmy.getAllUnits().size());

        Map<String, Object> infantryUnits2 = new HashMap<>();
        infantryUnits2.put("info", "Total infantry");
        infantryUnits2.put("numbers" , secondArmy.getInfantryUnits().size());

        Map<String, Object> rangedUnits2 = new HashMap<>();
        rangedUnits2.put("info", "Total ranged");
        rangedUnits2.put("numbers" , secondArmy.getRangedUnits().size());

        Map<String, Object> cavalryUnits2 = new HashMap<>();
        cavalryUnits2.put("info", "Total cavalry");
        cavalryUnits2.put("numbers" , secondArmy.getCavalryUnits().size());

        Map<String, Object> commanderUnits2 = new HashMap<>();
        commanderUnits2.put("info", "Total commanders");
        commanderUnits2.put("numbers" , secondArmy.getCommanderUnits().size());

        items2.add(totalUnits2);
        items2.add(infantryUnits2);
        items2.add(rangedUnits2);
        items2.add(cavalryUnits2);
        items2.add(commanderUnits2);
        secondArmyInfo.getItems().clear();

        secondArmyInfo.getItems().addAll(items2);

        battleGrid.setVisible(false);
        statsGrid.setVisible(true);
        winnerBackground.setVisible(true);
    }

    @FXML
    public void exitStats(){
        battleGrid.setVisible(true);
        statsGrid.setVisible(false);
        winnerBackground.setVisible(false);
    }
}
