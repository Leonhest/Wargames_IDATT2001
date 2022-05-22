package edu.ntnu.idatt2001.wargames.controller;

import edu.ntnu.idatt2001.wargames.backend.army.*;
import edu.ntnu.idatt2001.wargames.backend.battle.Battle;
import edu.ntnu.idatt2001.wargames.backend.battle.Terrain;
import javafx.animation.PathTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
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
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;
import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

/**
 * Controller used for BattleSim.fxml.
 */
public class BattleSimController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private ImageView backgroundMap;
    @FXML
    private Button battleButton;
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
    @FXML
    private StackPane nodePaneLeft;
    @FXML
    private Group nodeGroupLeft;
    @FXML
    private StackPane nodePaneRight;
    @FXML
    private Group nodeGroupRight;


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


    private UnitNode[][] leftArmy;
    private UnitNode[][] rightArmy;

    private double unitSize;

    private Timer timer = new Timer();
    private Timer timer2 = new Timer();

    Army winner;

    /**
     * {@inheritDoc}
     * Sets up layout of scene.
     * Binds elements to achieve dynamic scaling.
     * Creates fonts.
     * Sets up tables with columns.
     * Sets chosenMap as background image.
     * Sets terrain based on map selection.
     *
     * @param url
     * @param resourceBundle
     */
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

        backgroundMap.setImage(StartPageController.getChosenMap());

        backgroundMap.setPreserveRatio(false);
        backgroundMap.fitHeightProperty().bind(root.heightProperty());
        backgroundMap.fitWidthProperty().bind(root.widthProperty());

        battleButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        HBox.setHgrow(battleButton, Priority.ALWAYS);
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
                new TableColumn<>("Health Left");

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

        unitSize = 1000;
    }


    /**
     * Represents popup menu when clicking menu button.
     * Sets scaling properties to ensure dynamic scaling.
     */
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

    /**
     * Represents menu button in popup menu.
     * Changes scene to StartPage.fxml and {@link StartPageController}.
     *
     * @param event Onclick event
     * @throws IOException  Wrong file path
     */
    @FXML
    public void toStartPage(ActionEvent event) throws IOException {
        Parent viewPage = FXMLLoader.load(Objects.requireNonNull(StartPageController.class.getResource("/edu/ntnu/idatt2001/wargames/frontend/StartPage.fxml")));
        Scene page = new Scene(viewPage, 800, 600);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(page);
        window.setMaximized(true);
        window.show();
        timer.cancel();
        timer2.cancel();

    }

    /**
     * Represents reset button in popup menu.
     * Resets stage to initial state.
     *
     * @param event Onclick event
     * @throws IOException  Wrong file path
     */
    @FXML
    public void resetBattleSim(ActionEvent event) throws IOException {
        Parent viewPage = FXMLLoader.load(Objects.requireNonNull(StartPageController.class.getResource("/edu/ntnu/idatt2001/wargames/frontend/BattleSim.fxml")));
        Scene page = new Scene(viewPage, 800, 600);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(page);
        window.setMaximized(true);
        window.show();
    }

    /**
     * Represents cancel button in popup menu.
     * Exits popup menu.
     */
    @FXML
    public void cancelMenu(){
        menuGrid.setVisible(false);
    }

    /**
     * Represents Army setup menu when clicking either Army button.
     * Sets up layout and binds elements to ensure dynamic scaling.
     * Creates red borders around elements on erroneous user activity.
     * Populates army tableView with army units.
     *
     * @param event Onclick event
     */
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
                    if(field.getTextFormatter().getValueConverter().fromString(newValue).equals(0)){
                        throw new NumberFormatException("stats cannot be zero");
                    }
                } catch (NumberFormatException e) {
                    field.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(3), new BorderWidths(2), new Insets(-2))));
                }
                  catch (Exception e){
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

    /**
     * Represents Add button in army setup.
     * Adds unit to chosen army.
     */
    @FXML
    public void addUnitToArmy(){
        UnitType type = (UnitType) typeChoice.getValue();
        String name = nameTextField.getText();
        String health = healthNumberField.getText();
        String qty = qtyNumberField.getText();
        String attack = attackNumberField.getText();
        String armor = armorNumberField.getText();
        if((type == null) || health.equals("") || qty.equals("")){
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

    /**
     * Represents Import button in army setup.
     * Imports army from file through a file selector.
     * Creates a red border if import does not succeed.
     */
    @FXML
    public void importArmy(){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(root.getScene().getWindow());
        try {
            if(armyCheck.equals(army1)){
                firstArmy = new Army(file);
                obsFirstArmy.setAll(firstArmy.getAllUnits());
            }
            else if(armyCheck.equals(army2)){
                secondArmy = new Army(file);
                obsSecondArmy.setAll(secondArmy.getAllUnits());
            }
            importButton.setBorder(null);

        }catch (Exception e){
            importButton.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(3), new BorderWidths(2), new Insets(-2))));

        }

    }

    /**
     * Represents Save button in army setup.
     * Saves army to file in a chosen directory through a directory selector.
     */
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

    /**
     * Represents Rename button in army setup.
     * Sets new name of chosen army.
     * Displays success text on completion.
     */
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

    /**
     * Represents Clear button in army setup.
     * Removes all units from chosen army and tableview.
     */
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

    /**
     * Represents Deploy button in army setup.
     * Deploys army to battlefield.
     * Uses {@link #battleVisualsLeft()} and {@link #battleVisualsRight()} to create
     * unit graphics and visuals.
     */
    @FXML
    public void deployArmy(){
        importButton.setBorder(null);
        addArmyGrid.setVisible(false);
        battleGrid.setVisible(true);
        successText.setVisible(false);
        if(armyCheck.equals(army1)){
            if(!firstArmy.getAllUnits().isEmpty()){
                battleVisualsLeft();
            }
            else {
                nodePaneLeft.getChildren().clear();
            }
        }
        else if(armyCheck.equals(army2)){
            if(!secondArmy.getAllUnits().isEmpty()){
                battleVisualsRight();
            }
            else {
                nodePaneRight.getChildren().clear();
            }
        }
    }

    /**
     * Represents Battle button.
     * Creates {@link Battle} and uses {@link Battle#simulate()}.
     * Sets terrain of all participating units.
     * Uses {@link Army#Army(Army)} to create deep copies used for restoring armies.
     * Uses {@link #animate()} to animate armies charging.
     * Creates winner screen at end of battle.
     */
    @FXML
    public void startBattle(){
        firsArmyCopy = new Army(firstArmy);
        secondArmyCopy = new Army(secondArmy);
        battleButton.setDisable(true);
        for(Unit unit: firstArmy.getAllUnits()){
            unit.setTerrain(terrain);
        }
        for(Unit unit: secondArmy.getAllUnits()){
            unit.setTerrain(terrain);
        }
        Battle battle = new Battle(firstArmy, secondArmy, terrain);

        winner = battle.simulate();
        if((leftArmy != null && firsArmyCopy.getAllUnits().size() != 0) && (rightArmy != null && secondArmyCopy.getAllUnits().size() != 0)){
            animate();
        }



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
        int delay = 10000;
        if(winner.getName().equals(firstArmy.getName())){
            delay = 5000 + secondArmyCopy.getAllUnits().size()*1000;
        }
        else if (winner.getName().equals(secondArmy.getName())){
            delay = 5000 + firsArmyCopy.getAllUnits().size()*1000;
        }
        if((leftArmy == null) || (rightArmy == null)){
            winnerBackground.setVisible(true);
            winnerGrid.setVisible(true);
            battleButton.setDisable(false);
        }
        else {
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            timer.cancel();
                            timer2.cancel();
                            timer.purge();
                            timer2.purge();
                            this.cancel();


                        }
                    },
                    delay-1000
            );
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            winnerBackground.setVisible(true);
                            winnerGrid.setVisible(true);
                            battleButton.setDisable(false);
                            this.cancel();

                        }
                    },
                    delay
            );
        }



    }

    /**
     * Represents Retry button on winner screen.
     * Resets battle to before simulation start.
     * Uses army deep copies to restore armies.
     */
    @FXML
    public void retryBattle(){
        firstArmy = new Army(firsArmyCopy);
        secondArmy = new Army(secondArmyCopy);

        winnerBackground.setVisible(false);
        winnerGrid.setVisible(false);
        nodePaneRight.getChildren().clear();
        nodePaneLeft.getChildren().clear();

        if(!firstArmy.getAllUnits().isEmpty()){
            battleVisualsLeft();
        }

        if(!secondArmy.getAllUnits().isEmpty()){
            battleVisualsRight();
        }


        unitSize = 1000;

    }

    /**
     * Represents Stats popup when clicking Stats button.
     * Sets up layout and fills in correct army info.
     */
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

    /**
     * Represents Exit button in stats popup.
     * Exits stats popup.
     */
    @FXML
    public void exitStats(){
        battleGrid.setVisible(true);
        statsGrid.setVisible(false);
        winnerBackground.setVisible(false);
    }

    int idx1 = 0;
    int max1 = 0;

    /**
     * Creates Graphics and visuals for each unit in left army.
     * Uses {@link UnitNode} to represent each unit in army.
     * Creates a multidimensional array where each unit is stored.
     */
    @FXML
    private void battleVisualsLeft(){
        int[] size1 = { firstArmy.getRangedUnits().size(),firstArmy.getInfantryUnits().size(), firstArmy.getCavalryUnits().size(), firstArmy.getCommanderUnits().size()};
        max1 = Arrays.stream(size1).max().getAsInt();
        idx1 = ArrayUtils.indexOf(size1, max1);

        nodePaneLeft.getChildren().clear();
        nodeGroupLeft = new Group();
        nodePaneLeft.getChildren().add(nodeGroupLeft);

        int m = firstArmy.getAllUnits().size();
        int commanders = firstArmy.getCommanderUnits().size();
        int cavalry = firstArmy.getCavalryUnits().size();
        int infantry = firstArmy.getInfantryUnits().size();
        int ranged = firstArmy.getRangedUnits().size();
        double newSize = root.getHeight()/(max1*1.5);
        if(newSize < unitSize){
            unitSize = newSize;
        }
        if(unitSize>80){
            unitSize = 80;
        }

        leftArmy = new UnitNode[4][m];
        m = ranged;

        Image commanderImage = new Image("/edu/ntnu/idatt2001/wargames/images/units/CommanderLeft.png");
        Image cavalryImage = new Image("/edu/ntnu/idatt2001/wargames/images/units/CavalryLeft.png");
        Image infantryImage = new Image("/edu/ntnu/idatt2001/wargames/images/units/InfantryLeft.png");
        Image rangedImage = new Image("/edu/ntnu/idatt2001/wargames/images/units/RangedLeft.png");
        Image blank = new Image("/edu/ntnu/idatt2001/wargames/images/units/Blank.png");

        Image chosenImage = rangedImage;

        for( int i=0; i < 4; i++) {

            int k = 0;
            for(k = 0; k<(max1-m)/2; k++){
                UnitNode node = new UnitNode(i * unitSize, k * unitSize, unitSize, unitSize, blank);
                nodeGroupLeft.getChildren().add(node);

            }

            for( int j=0; j < m; j++) {


                UnitNode node = new UnitNode(i * unitSize, (j+k) * unitSize, unitSize, unitSize, chosenImage);

                nodeGroupLeft.getChildren().add(node);

                leftArmy[i][j] = node;
            }
            if(i == 0){
                m = infantry;
                chosenImage = infantryImage;
            }
            else if(i == 1){
                m = cavalry;
                chosenImage = cavalryImage;
            }
            else if(i == 2){
                m = commanders;
                chosenImage = commanderImage;
            }
        }
        nodePaneLeft.setAlignment(Pos.CENTER_LEFT);

    }

    int idx2 = 0;
    int max2 = 0;
    /**
     * Creates Graphics and visuals for each unit in right army.
     * Uses {@link UnitNode} to represent each unit in army.
     * Creates a multidimensional array where each unit is stored.
     */
    @FXML
    private void battleVisualsRight(){
        int[] size2 = { secondArmy.getRangedUnits().size(),secondArmy.getInfantryUnits().size(), secondArmy.getCavalryUnits().size(), secondArmy.getCommanderUnits().size()};
        max2 = Arrays.stream(size2).max().getAsInt();
        idx2 = ArrayUtils.indexOf(size2, max2);


        nodePaneRight.getChildren().clear();
        nodeGroupRight = new Group();
        nodePaneRight.getChildren().add(nodeGroupRight);
        nodeGroupRight.getChildren().clear();
        int m = secondArmy.getAllUnits().size();
        int commanders = secondArmy.getCommanderUnits().size();
        int cavalry = secondArmy.getCavalryUnits().size();
        int infantry = secondArmy.getInfantryUnits().size();
        int ranged = secondArmy.getRangedUnits().size();
        double newSize = root.getHeight()/(max2*1.5);
        if(newSize < unitSize){
            unitSize = newSize;
        }
        if(unitSize>80){
            unitSize = 80;
        }

        rightArmy = new UnitNode[4][m];
        m = ranged;

        Image commanderImage = new Image("/edu/ntnu/idatt2001/wargames/images/units/CommanderRight.png");
        Image cavalryImage = new Image("/edu/ntnu/idatt2001/wargames/images/units/CavalryRight.png");
        Image infantryImage = new Image("/edu/ntnu/idatt2001/wargames/images/units/InfantryRight.png");
        Image rangedImage = new Image("/edu/ntnu/idatt2001/wargames/images/units/RangedRight.png");
        Image blank = new Image("/edu/ntnu/idatt2001/wargames/images/units/Blank.png");

        Image chosenImage = rangedImage;

        for( int i=0; i < 4; i++) {

            int k = 0;
            for(k = 0; k<(max2-m)/2; k++){
                UnitNode node = new UnitNode(i * unitSize, k * unitSize, unitSize, unitSize, blank);
                nodeGroupLeft.getChildren().add(node);

            }

            for( int j=0; j < m; j++) {

                UnitNode node = new UnitNode(i * unitSize, (j+k) * unitSize, unitSize, unitSize, chosenImage);

                nodeGroupRight.getChildren().add(node);

                rightArmy[i][j] = node;
            }
            if(i == 0){
                m = infantry;
                chosenImage = infantryImage;
            }
            else if(i == 1){
                m = cavalry;
                chosenImage = cavalryImage;
            }
            else if(i == 2){
                m = commanders;
                chosenImage = commanderImage;
            }

        }
        nodePaneRight.setAlignment(Pos.CENTER_RIGHT);

    }

    /**
     * Creates charging animation when starting battle.
     * Sets up pathTransition for each army group of {@link UnitNode}'s to follow
     */
    private void animate() {

        double nodeheightleft = 0;
        double nodeHeightRight = 0;
        UnitNode nodeLeft = leftArmy[idx1][max1/2];
        UnitNode nodeRight = rightArmy[idx2][max2/2];
        double groupWidthLeft = nodeGroupLeft.getBoundsInLocal().getWidth();
        double groupWidthRight = nodeGroupRight.getBoundsInLocal().getWidth();
        if(max1%2 == 0){
            nodeheightleft = nodeLeft.getHeight()/2;
        }
        if(max2%2 == 0){
            nodeHeightRight = nodeRight.getHeight()/2;
        }


        Path pathLeft = new Path();
        pathLeft.getElements().add (new MoveTo(groupWidthLeft/2, nodeLeft.getTranslateY() + nodeLeft.getBoundsInParent().getHeight() / 2.0 - nodeheightleft));
        pathLeft.getElements().add (new LineTo( root.getWidth()/2-groupWidthLeft/2, nodeLeft.getTranslateY() + nodeLeft.getBoundsInParent().getHeight() / 2.0 - nodeheightleft));

        PathTransition pathTransitionLeft = new PathTransition();
        pathTransitionLeft.setDuration(Duration.millis(4000));
        pathTransitionLeft.setNode(nodeGroupLeft);
        pathTransitionLeft.setPath(pathLeft);
        pathTransitionLeft.play();

        Path pathRight = new Path();
        pathRight.getElements().add (new MoveTo(groupWidthRight/2, nodeRight.getTranslateY() + nodeRight.getBoundsInParent().getHeight() / 2.0 - nodeHeightRight));
        pathRight.getElements().add (new LineTo( -(root.getWidth()/2-groupWidthRight-(groupWidthRight/2)), nodeRight.getTranslateY() + nodeRight.getBoundsInParent().getHeight() / 2.0 - nodeHeightRight));

        PathTransition pathTransitionRight = new PathTransition();
        pathTransitionRight.setDuration(Duration.millis(4000));
        pathTransitionRight.setNode(nodeGroupRight);
        pathTransitionRight.setPath(pathRight);
        pathTransitionRight.play();

        if(winner.getName().equals(secondArmy.getName())){
            timer = new Timer();
            int secondSize = firsArmyCopy.getAllUnits().size();
            final int[] roundCheck = {0};
            timer.scheduleAtFixedRate(
                    new TimerTask() {
                        @Override
                        public void run() {

                            boolean on = true;
                            while (on){
                                Random rand = new Random();
                                int collum = rand.nextInt(4);
                                int length = Arrays.stream(leftArmy[collum]).filter(Objects::nonNull).toArray().length;
                                if(!(length == 0)){
                                    int row = rand.nextInt(length);
                                    if(!(leftArmy[collum][row] == null) && leftArmy[collum][row].isVisible()){
                                        leftArmy[collum][row].setVisible(false);
                                        on = false;
                                        roundCheck[0]++;
                                    }

                                }
                                if (roundCheck[0] == secondSize){
                                    on = false;
                                    timer.cancel();
                                }
                            }
                        }
                    },
                    4000, 1000
            );
            int timeDelay = firsArmyCopy.getAllUnits().size()*2500/(secondArmyCopy.getAllUnits().size());
            timer2 = new Timer();
            timer2.scheduleAtFixedRate(
                    new TimerTask() {
                        @Override
                        public void run() {
                            boolean on = true;
                            while (on){
                                Random rand = new Random();
                                int collum = rand.nextInt(4);
                                int length = Arrays.stream(rightArmy[collum]).filter(Objects::nonNull).toArray().length;
                                if(!(length == 0)){
                                    int row = rand.nextInt(length);
                                    if(!(rightArmy[collum][row] == null) && rightArmy[collum][row].isVisible()){
                                        rightArmy[collum][row].setVisible(false);
                                        on = false;
                                    }

                                }
                            }

                        }
                    },
                    4000, timeDelay
            );
        }
        else if (winner.getName().equals(firstArmy.getName())){
            timer = new Timer();
            int secondSize = secondArmyCopy.getAllUnits().size();
            final int[] roundCheck = {0};
            timer.scheduleAtFixedRate(
                    new TimerTask() {
                        @Override
                        public void run() {
                            boolean on = true;

                            while (on){
                                Random rand = new Random();
                                int collum = rand.nextInt(4);
                                int length = Arrays.stream(rightArmy[collum]).filter(Objects::nonNull).toArray().length;
                                if(!(length == 0)){
                                    int row = rand.nextInt(length);
                                    if(!(rightArmy[collum][row] == null) && rightArmy[collum][row].isVisible()){
                                        rightArmy[collum][row].setVisible(false);
                                        on = false;
                                        roundCheck[0]++;
                                    }
                                    if (roundCheck[0] == secondSize){
                                        on = false;
                                        timer.cancel();
                                    }

                                }
                            }

                        }
                    },
                    4000, 1000
            );
            int timeDelay = secondArmyCopy.getAllUnits().size()*2500/(firsArmyCopy.getAllUnits().size());
            timer2 = new Timer();
            timer2.scheduleAtFixedRate(
                    new TimerTask() {
                        @Override
                        public void run() {
                            boolean on = true;
                            while (on){
                                Random rand = new Random();
                                int collum = rand.nextInt(4);
                                int length = Arrays.stream(leftArmy[collum]).filter(Objects::nonNull).toArray().length;
                                if(!(length == 0)){
                                    int row = rand.nextInt(length);
                                    if(!(leftArmy[collum][row] == null) && leftArmy[collum][row].isVisible()){
                                        leftArmy[collum][row].setVisible(false);
                                        on = false;
                                    }
                                }
                            }

                        }
                    },
                    4000, timeDelay
            );
        }







    }


    /**
     * Represent a Unit on the battlefield.
     * Sets different unit icons depending on unit type.
     * Stores x and y coordinates of unit.
     */
    public static class UnitNode extends StackPane {

        public UnitNode(double x, double y, double width, double height, Image image) {

            ImageView unitImage = new ImageView(image);
            Rectangle rectangle = new Rectangle( width, height);
            unitImage.fitWidthProperty().bind(rectangle.widthProperty());
            unitImage.fitHeightProperty().bind(rectangle.heightProperty());

            setTranslateX( x);
            setTranslateY( y);

            getChildren().add(unitImage);

        }

    }


}
