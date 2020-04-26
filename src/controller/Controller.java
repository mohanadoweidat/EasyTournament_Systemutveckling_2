package controller;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.*;
import model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;

/**
 * The class is responsible for the connection between
 * the view and the model classes
 * @author Andreas von Uthmann
 */
public class Controller {

    private Tournament tournament = new Tournament(this);

    private Config config;
    private String[] columnNames = {"ID", "Name", "Age", "Gender", "Animal", "Category Info", "Extra info"};


    private AmountOfTeams amountOfTeams;
    @FXML
    private TableView <Player> tblTeams = new TableView<>();

    @FXML
    private CheckBox cbGroupStage;
    @FXML
    private CheckBox cbPlayoffs;


    @FXML
    private ComboBox<String> cbAmountOfTeams;

    private ComboBox<Config> cbConfig;
//    @FXML
//    private ComboBox<String> cbAmountOfTeams;

    @FXML
    private TextField tfAmountOfTeams;
    @FXML
    private TextField tfPlayerName;
    @FXML
    private ListView listAddedPlayers = new ListView();

    private final ListView addedPlayers = new ListView();
    @FXML
    private ListView listOverview = new ListView();
    @FXML
    private ListView listTeamsPlayer = new ListView();

    @FXML
    private Button btnRefresh;
    @FXML
    private Button btnPickTeams;

    private TableColumn <Player, String> column = new TableColumn("Players");
    private TableColumn column1 = new TableColumn("Team 1");
    private TableColumn column2 = new TableColumn("Team 2");
    private TableColumn column3 = new TableColumn("Team 3");
    private TableColumn column4 = new TableColumn("Team 4");
    private TableColumn column5 = new TableColumn("Team 5");
    private TableColumn column6 = new TableColumn("Team 6");
    private TableColumn column7 = new TableColumn("Team 7");
    private TableColumn column8 = new TableColumn("Team 8");
    private TableColumn column9 = new TableColumn("Team 9");
    private TableColumn column10 = new TableColumn("Team 10");

    @FXML
    private ChoiceBox<AmountOfTeams> teamsBox = new ChoiceBox();


    ObservableList<Object > amountOfTeamsStatusList = (FXCollections.observableArrayList(AmountOfTeams.values()));
    public Controller() {


    }

    /**
     * The method reads a fxml-file and changes the current window to the new fxml-file
     */
    @FXML
    public void setPlayerGUI(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/PlayersGui.fxml"));
        Parent playerGUI = loader.load();
       // controller.Controller controller = loader.getController();
        //controller.initAddPlayersViewData();
        Scene playerScene = new Scene(playerGUI);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(playerScene);
        window.show();
    }

    /**
     * Shows the data should be in the gui when it load
     */
    public void initAddPlayersViewData(){
        //cbAmountOfTeams.setValue("ThreeTeams");
       // cbAmountOfTeams.setItems(amountOfTeamsStatusList);
    }

    /**
     * The method reads a fxml-file and changes the current window to the new fxml-file
     */
    @FXML
    public void setTeamsGUI(ActionEvent event) throws IOException {
//        tournament.addPlayer(tournament.getPlayers());
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/TeamsGUI.fxml"));
        Parent playerGUI = loader.load();
        Controller controller = loader.getController();
//        teamsBox.getSelectionModel().getSelectedItem();
        controller.initTeamsViewData(addedPlayers);
        controller.initTeamsTableData(teamsBox.getSelectionModel().getSelectedItem());
        Scene playerScene = new Scene(playerGUI);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(playerScene);
        window.show();
    }

    private void initTeamsTableData(AmountOfTeams selectedItem) {
        switch (selectedItem){
            case Three:
                tblTeams.getColumns().addAll(column, column1, column2,column3);
                tblTeams.setItems(getPlayer());
                column.setCellValueFactory(new PropertyValueFactory<>("name"));


//            case Four:
//                tblTeams.getColumns().addAll(column, column1, column2,column3);
//            case Five:
//                tblTeams.getColumns().addAll(column, column1, column2,column3, column4, column5, column6);
//            case Six:
//                tblTeams.getColumns().addAll(column, column1, column2,column3, column4, column5, column6);
//            case Seven:
//                tblTeams.getColumns().addAll(column, column1, column2,column3);
//            case Eight:
//                tblTeams.getColumns().addAll(column, column1, column2,column3);
//            case Nine:
//                tblTeams.getColumns().addAll(column, column1, column2,column3);
//            case Ten:
//                tblTeams.getColumns().addAll(column, column1, column2,column3);
        }


//        tblTeams.getColumns().addAll(column, column1, column2, column3, column4, column5, column6);

    }

    /**
     * Shows the data should be in the gui when it loads
     * @param addedPlayers a list of the players that has been added
     */
    public void initTeamsViewData(ListView addedPlayers){
        listTeamsPlayer.getItems().add(addedPlayers);
    }

    /**
     * The method reads a fxml-file and changes the current window to the new fxml-file
     */
    @FXML
    public void setFirstPageGUI(ActionEvent event) throws IOException {
        Parent playerGUI = FXMLLoader.load(getClass().getResource("../view/FirstPage.fxml"));
        Scene playerScene = new Scene(playerGUI);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(playerScene);
        window.show();
    }

    /**
     * Register that the user wants to add a groupstage to the tournament
     */
    @FXML
    public void handleGroupStageBox(ActionEvent actionEvent) {
        tournament.groupStage();
    }

    /**
     * Register that the user wants to add a playoffs to the tournament
     */
    @FXML
    public void handlePlayoffsBox(ActionEvent actionEvent) {
        tournament.playoffs();
    }

    /**
     * not used
     */
    @FXML
    public void handleConfig() {
        // tournament.playoffs();
    }

    //sets the values to the choicebox in PlayersGUI through the AmountOfTeams Enum
    @FXML
    private void initialize() {
//        teamsBox.setItems(amountOfTeamsStatusList);
        teamsBox.getItems().addAll(AmountOfTeams.values());
    }

    /**
     * Saves the amount of that the user wants in the tournament class
     */
    @FXML
    public void handleAmountOfTeams() {
        //tournament.setAmountOfTeams(tfAmountOfTeams.getText());
    }


    /**
     * Saves the player that the user added to the player list
     */
    public void addPlayersToList() {
        String test = tfPlayerName.getText();
        if (test.isBlank()) {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Name problems");
            alert1.setHeaderText(null);
            alert1.setContentText("The name can't be empty");
            alert1.showAndWait();
        } else if (Character.isDigit(test.charAt(0))) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Name problems");
            alert.setHeaderText(null);
            alert.setContentText("The name needs to start with a letter");
            alert.showAndWait();
        } else {
            listAddedPlayers.getItems().add(tfPlayerName.getText());
            listTeamsPlayer.getItems().add(tfPlayerName.getText());
            addedPlayers.getItems().add(tfPlayerName.getText());
            tournament.addPlayer(tfPlayerName.getText());
//            addBtnClicked();
        }
        tfPlayerName.setText("");
    }

    public void addBtnClicked(){
        System.out.println("HEjehjehejhej");
        Player player = new Player();
        player.setName(tfPlayerName.getText());

        tblTeams.getItems().add(player);
        tfPlayerName.clear();
    }

    public ObservableList<Player> getPlayer(){
        ObservableList<Player> players = FXCollections.observableArrayList();
        players.add(new Player("Rickard"));
        players.add(new Player("Sampi"));


        return players;
    }

    /**
     * Saves the player that the user added to the player list
     */
    public void overviewRefresh() {
        listOverview.getItems().add("hej mamma");
    }

    /**
     * Updates the ListGUI so that it shows the new players that has been added
     */
    public void updateListGUI() {
        for (int i=0; i<tournament.getPlayersList().size(); i++)
            System.out.println(i);
            listTeamsPlayer.getItems().add(tournament.getPlayersList());

        }

    /**
     * Removes players from the "added players" list
     */
    public void removePlayerPlayersGui(){
        final int selectedIndex = listAddedPlayers.getSelectionModel().getSelectedIndex();
        if(selectedIndex!= -1){
            String removeSelected= String.valueOf(listAddedPlayers.getSelectionModel().getSelectedItem());
            listAddedPlayers.getItems().remove(selectedIndex);
            addedPlayers.getItems().remove(selectedIndex);
            System.out.println(removeSelected);

            tournament.removePlayer(removeSelected);
        }

        }
        public void removePlayersTeamsGui(){
        final int selectedIndex2 = listTeamsPlayer.getSelectionModel().getSelectedIndex();
        if(selectedIndex2 != -1){
            String removeSelected2 = String.valueOf(listTeamsPlayer.getSelectionModel().getSelectedItem());
            listAddedPlayers.getItems().remove(selectedIndex2);
            listTeamsPlayer.getItems().remove(selectedIndex2);
            System.out.println(removeSelected2);
            tournament.removePlayer(removeSelected2);

        }
        }


//        for (int i = 0; i<temp.size(); i++) {
//            System.out.println(i);
//        }
//        for (Object p : temp) {
//            System.out.println(2);
//            System.out.println(p.toString() + " update");
//            List name = (List) p;
//            listTeamsPlayer.getItems().add(name);
//        }

//    public void teamsNext(ActionEvent event) throws IOException, InterruptedException {
//        setOverViewGUI(event);
//        Thread.sleep(2000);
//        overviewRefresh();
//    }

//    public void showGui(String showGui){
//        listOverview.getItems().add(showGui);
//    }

    }
