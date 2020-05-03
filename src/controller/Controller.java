package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.*;
import javafx.stage.*;
import model.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The class is responsible for the connection between
 * the view and the model classes
 * @author Andreas von Uthmann
 */
public class Controller {

    private Tournament tournament = new Tournament(this);
    private GroupStageController groupStageController = new GroupStageController(this);
    private PlayoffsController playoffsController = new PlayoffsController(this);

    private AmountOfTeams amountOfTeams;
    @FXML
    private TableView  tblTeams = new TableView<>();

    @FXML
    private CheckBox cbGroupStage;
    @FXML
    private CheckBox cbPlayoffs;
    @FXML
    private TextField tfPlayerName;
    @FXML
    private ListView listAddedPlayers = new ListView();

    private final ArrayList<Player> playerSave = new ArrayList();
    @FXML
    private ListView listOverview = new ListView();
    @FXML
    private ListView listTeamsPlayer = new ListView();
    private ObservableList<String> tableDragDrop = FXCollections.observableArrayList();

    private  ObservableList<String> tableContent = FXCollections.observableArrayList();

    private TableColumn <Player, String> column = new TableColumn("Players");
    private final TableColumn<Player, String> column1 = new TableColumn("Team 1");
    private final TableColumn<Player, String> column2 = new TableColumn("Team 2");
    private final TableColumn<Player, String> column3 = new TableColumn("Team 3");
    private final TableColumn<Player, String> column4 = new TableColumn("Team 4");
    private final TableColumn<Player, String> column5 = new TableColumn("Team 5");
    private final TableColumn<Player, String> column6 = new TableColumn("Team 6");
    private final TableColumn<Player, String> column7 = new TableColumn("Team 7");
    private final TableColumn<Player, String> column8 = new TableColumn("Team 8");
    private final TableColumn<Player, String> column9 = new TableColumn("Team 9");
    private final TableColumn<Player, String> column10 = new TableColumn("Team 10");

    @FXML
    private ChoiceBox<AmountOfTeams> teamsBox = new ChoiceBox();


    @FXML
    private TextField tfQual1 = new TextField();
    @FXML
    private TextField tfQual2 = new TextField();
    @FXML
    private TextField tfQual3 = new TextField();
    @FXML
    private TextField tfQual4 = new TextField();
    @FXML
    private TextField tfTeam1 = new TextField();
    @FXML
    private TextField tfTeam2 = new TextField();
    @FXML
    private TextField tfTeam3 = new TextField();
    @FXML
    private TextField tfTeam4 = new TextField();
    @FXML
    private TextField tfTeam5 = new TextField();
    @FXML
    private TextField tfTeam6 = new TextField();
    @FXML
    private TextField tfTeam7 = new TextField();
    @FXML
    private TextField tfTeam8 = new TextField();
    @FXML
    private TextField tfSemifinal1Home = new TextField();
    @FXML
    private TextField tfSemifinal1Away = new TextField();
    @FXML
    private TextField tfSemifinal2Home = new TextField();
    @FXML
    private TextField tfSemifinal2Away = new TextField();
    @FXML
    private TextField tfFinalHome = new TextField();
    @FXML
    private TextField tfFinalAway = new TextField();
    @FXML
    private Label lblTeam1 = new Label();
    @FXML
    private Label lblSemifinal1Home = new Label();
    @FXML
    private Label lblSemifinal1Away = new Label();
    @FXML
    private Label lblSemifinal2Home = new Label();
    @FXML
    private Label lblSemifinal2Away = new Label();
    @FXML
    private Label lblFinalHome = new Label();
    @FXML
    private Label lblFinalAway = new Label();
    @FXML
    private Label lblWinner = new Label();
    @FXML
    private Label lblQfHome = new Label();
    @FXML
    private Label lblQf2 = new Label();







    public Controller() {
        setEditable();
    }

    /**
     * The method reads a fxml-file and changes the current window to the new fxml-file
     */
    @FXML
    public void setEditable(){
        column.setEditable(true);
        column1.setEditable(true);
        column2.setEditable(true);
        column3.setEditable(true);
        column4.setEditable(true);
        column5.setEditable(true);
        column6.setEditable(true);
        column7.setEditable(true);
        column8.setEditable(true);
        column9.setEditable(true);
        column10.setEditable(true);

    }
    public void setPlayerGUI(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/PlayersGui.fxml"));
        Parent playerGUI = loader.load();
        //controller.Controller controller = loader.getController();
        //controller.initAddPlayersViewData();
        Scene playerScene = new Scene(playerGUI);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(playerScene);
        window.show();
    }

    /**
     * The method reads a fxml-file and changes the current window to the new fxml-file
     */
    @FXML
    public void setTeamsGUI(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/TeamsGUI.fxml"));
        Parent playerGUI = loader.load();
        Controller controller = loader.getController();
        //controller.initTeamsViewData(addedPlayers);
        controller.initTeamsTableData(teamsBox.getSelectionModel().getSelectedItem(), playerSave, tableContent);
        Scene playerScene = new Scene(playerGUI);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(playerScene);
        window.show();
    }

    @FXML
    public void startTournament(ActionEvent event) throws IOException{
        if(cbGroupStage.isSelected()){
            groupStageController.setGroupStageGUI(event, amountOfTeams);
        } else if (cbPlayoffs.isSelected()){
            playoffsController.setPlayoffsGUI(event, amountOfTeams);
        }else {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Error message");
            alert1.setHeaderText(null);
            alert1.setContentText("You have to choose either Groupstage or Playoffs");
            alert1.showAndWait();
        }
    }

    private void initTeamsTableData(AmountOfTeams selectedItem, ArrayList playerSave, ObservableList<String> tableContent) {
        this.amountOfTeams = selectedItem;
        this.tableDragDrop = tableContent;
        switch (selectedItem){
            case Three:
                tblTeams.getColumns().addAll(column, column1, column2,column3);
                tblTeams.setItems(getPlayer(playerSave));
                column.setCellValueFactory(new PropertyValueFactory<>("name"));
                break;
            case Four:
                tblTeams.getColumns().addAll(column, column1, column2,column3,column4);
                tblTeams.setItems(getPlayer(playerSave));
                column.setCellValueFactory(new PropertyValueFactory<>("name"));
                break;
            case Five:
                tblTeams.getColumns().addAll(column, column1, column2,column3, column4, column5);
                tblTeams.setItems(getPlayer(playerSave));
                column.setCellValueFactory(new PropertyValueFactory<>("name"));
                break;
            case Six:
                tblTeams.getColumns().addAll(column, column1, column2,column3, column4, column5, column6);
                tblTeams.setItems(getPlayer(playerSave));
                column.setCellValueFactory(new PropertyValueFactory<>("name"));
                break;
            case Seven:
                tblTeams.getColumns().addAll(column, column1, column2,column3, column4, column5, column6, column7);
                tblTeams.setItems(getPlayer(playerSave));
                column.setCellValueFactory(new PropertyValueFactory<>("name"));
                break;
            case Eight:
                tblTeams.getColumns().addAll(column, column1, column2,column3, column4, column5, column6, column7, column8);
                tblTeams.setItems(getPlayer(playerSave));
                column.setCellValueFactory(new PropertyValueFactory<>("name"));
                break;
            case Nine:
                tblTeams.getColumns().addAll(column, column1, column2,column3, column4, column5, column6, column7, column8, column9);
                tblTeams.setItems(getPlayer(playerSave));
                column.setCellValueFactory(new PropertyValueFactory<>("name"));
                break;
            case Ten:
                tblTeams.getColumns().addAll(column, column1, column2,column3, column4, column5, column6, column7, column8, column9, column10);
                tblTeams.setItems(getPlayer(playerSave));
                column.setCellValueFactory(new PropertyValueFactory<>("name"));
                break;
        }
    }

    public void playoffsResult(){
        playoffsController.results();
    }

    public void results() {
        boolean winner = true;

        int score1 = Integer.parseInt(tfTeam1.getText());
        int score2 = Integer.parseInt(tfTeam2.getText());

        int score3 = Integer.parseInt(tfTeam3.getText());
        int score4 = Integer.parseInt(tfTeam4.getText());

//        int score5 = Integer.parseInt(tfTeam5.getText());
//        int score6 = Integer.parseInt(tfTeam6.getText());
//
//        int score7 = Integer.parseInt(tfTeam7.getText());
//        int score8 = Integer.parseInt(tfTeam8.getText());
//
//        int score9 = Integer.parseInt(tfSemifinal1Home.getText());
//        int score10 = Integer.parseInt(tfSemifinal1Away.getText());
//
//        int score11 = Integer.parseInt(tfSemifinal2Home.getText());
//        int score12 = Integer.parseInt(tfSemifinal2Away.getText());
//
//        int score13 = Integer.parseInt(tfFinalHome.getText());
//        int score14 = Integer.parseInt(tfFinalAway.getText());


        if (score1 > score2) {
                tfSemifinal1Home.setPromptText("Team 1");
                lblSemifinal1Home.setText("Team 1");
            } else if (score1 < score2){
                tfSemifinal1Home.setPromptText("Team 2");
                lblSemifinal1Home.setText("Team 2");
            }
            if (score3 > score4){
                tfSemifinal1Away.setPromptText("Team 3");
                lblSemifinal1Away.setText("Team 3");
            }else {
                tfSemifinal1Away.setPromptText("Team 4");
                lblSemifinal1Away.setText("Team 4");
            }

    }

    public void qualificationGameOne(){
        int scoreQual1 = Integer.parseInt(tfQual1.getText());
        int scoreQual2 = Integer.parseInt(tfQual2.getText());

        if (scoreQual1 > scoreQual2){
            tfTeam5.setPromptText("Team 5");
            lblQfHome.setText("Team 5");
        } else {
            tfTeam5.setPromptText("Team 6");
            lblQfHome.setText("Team 6");
        }
    }
    public void qualificationGameTwo(){
        int scoreQual1 = Integer.parseInt(tfQual3.getText());
        int scoreQual2 = Integer.parseInt(tfQual4.getText());

        if (scoreQual1 > scoreQual2){
            tfTeam8.setPromptText("Team 9");
            lblQf2.setText("Team 9");
        } else {
            tfTeam8.setPromptText("Team 10");
            lblQf2.setText("Team 10");
        }
    }
    public void gameOne(){
        int score1 = Integer.parseInt(tfTeam1.getText());
        int score2 = Integer.parseInt(tfTeam2.getText());
        if (score1 > score2) {
            tfSemifinal1Home.setPromptText("Team 1");
            lblSemifinal1Home.setText("Team 1");
        } else if (score1 < score2){
            tfSemifinal1Home.setPromptText("Team 2");
            lblSemifinal1Home.setText("Team 2");
        }
    }

    public void gameTwo(){
        int score3 = Integer.parseInt(tfTeam3.getText());
        int score4 = Integer.parseInt(tfTeam4.getText());
        if (score3 > score4){
            tfSemifinal1Away.setPromptText("Team 3");
            lblSemifinal1Away.setText("Team 3");
        }else {
            tfSemifinal1Away.setPromptText("Team 4");
            lblSemifinal1Away.setText("Team 4");
        }
    }

    public void gameThree(){
        int score5 = Integer.parseInt(tfTeam5.getText());
        int score6 = Integer.parseInt(tfTeam6.getText());

        if (score5 > score6){
            tfSemifinal2Home.setPromptText("Team 5");
            lblSemifinal2Home.setText("Team 5");
        } else{
            tfSemifinal2Home.setPromptText("Team 6");
            lblSemifinal2Home.setText("Team 6");
        }
    }

    public void gameFour(){
        int score7 = Integer.parseInt(tfTeam7.getText());
        int score8 = Integer.parseInt(tfTeam8.getText());

        if (score7 > score8){
            tfSemifinal2Away.setPromptText("Team 7");
            lblSemifinal2Away.setText("Team 7");
        } else{
            tfSemifinal2Away.setPromptText("Team 8");
            lblSemifinal2Away.setText("Team 8");
        }
    }
    public void gameFive(){
        int score9 = Integer.parseInt(tfSemifinal1Home.getText());
        int score10 = Integer.parseInt(tfSemifinal1Away.getText());

        if (score9 > score10){
            lblFinalHome.setText(lblSemifinal1Home.getText());
            tfFinalHome.setPromptText(lblSemifinal1Home.getText());
        } else {
            lblFinalHome.setText(lblSemifinal1Away.getText());
            tfFinalHome.setPromptText(lblSemifinal1Away.getText());
        }
    }
    public void gameSix(){
        int score11 = Integer.parseInt(tfSemifinal2Home.getText());
        int score12 = Integer.parseInt(tfSemifinal2Away.getText());

        if (score11 > score12){
            lblFinalAway.setText(lblSemifinal2Home.getText());
            tfFinalAway.setPromptText(lblSemifinal2Home.getText());
        } else {
            lblFinalAway.setText(lblSemifinal2Away.getText());
            tfFinalAway.setPromptText(lblSemifinal2Away.getText());
        }
    }

    public void gameSeven(){
        int score13 = Integer.parseInt(tfFinalHome.getText());
        int score14 = Integer.parseInt(tfFinalAway.getText());

        if (score13 > score14){
            lblWinner.setText(lblFinalHome.getText());
        } else {
            lblWinner.setText(lblFinalAway.getText());
        }
    }

    /**
     * Shows the data that should be in the gui when it loads
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


    //sets the values to the choicebox in PlayersGUI through the AmountOfTeams Enum
    @FXML
    private void initialize() {
//        teamsBox.setItems(amountOfTeamsStatusList);
        teamsBox.getItems().addAll(AmountOfTeams.values());
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
            //addedPlayers.getItems().add(tfPlayerName.getText());
            addBtnClicked(tfPlayerName.getText());
        }
        tfPlayerName.setText("");
    }

    /**
     * Creats a new object of a player and adds it to the savedPlayers list
     * @param input the user input
     */
    public void addBtnClicked(String input){
        playerSave.add(new Player(input));
        tfPlayerName.clear();
    }

    /**
     *  Adds the saved players to the teamtable
     * @param input the saved players
     * @return returns the list of players for the table
     */
    public ObservableList<Player> getPlayer(ArrayList<Player> input){
        ObservableList<Player> observablePlayers = FXCollections.observableArrayList();
        for (Player p: input){
            observablePlayers.add(p);
        }
        return observablePlayers;
    }


    /**
     * Removes players from the "added players" list
     */
    public void removePlayerPlayersGui(){
        final int selectedIndex = listAddedPlayers.getSelectionModel().getSelectedIndex();
        if(selectedIndex!= -1){
            String removeSelected= String.valueOf(listAddedPlayers.getSelectionModel().getSelectedItem());
            listAddedPlayers.getItems().remove(selectedIndex);
           // addedPlayers.getItems().remove(selectedIndex);
            System.out.println(removeSelected);
            tournament.removePlayer(removeSelected);
        }
        else {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Error");
            alert1.setHeaderText(null);
            alert1.setContentText("Select a player");
            alert1.showAndWait();
        }
    }
   public void click(MouseEvent event) {
        if(event.getClickCount()==1){ // double click

            Player selected = (Player) tblTeams.getSelectionModel().getSelectedItem();
            if(selected !=null){
                System.out.println("select : "+selected.toString());

            }
        }
    }
    public void dragDetected(MouseEvent event) {
        // drag was detected, start drag-and-drop gesture
        Player selected = (Player) tblTeams.getSelectionModel().getSelectedItem();
        if(selected !=null){

            Dragboard db = tblTeams.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString(String.valueOf(selected));
            db.setContent(content);
            event.consume();
        }
    }
    public void dragOver(DragEvent event) {
        // data is dragged over the target
        Dragboard db = event.getDragboard();
        if (event.getDragboard().hasString()){
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }
    public void dragDropped(DragEvent event) {
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (event.getDragboard().hasString()) {

            String text = db.getString();
            System.out.println(tableDragDrop);
            playerSave.add(new Player(text));
            System.out.println(tableDragDrop);
            tblTeams.setItems(getPlayer(playerSave));
            success = true;
//            column1.setCellValueFactory(new PropertyValueFactory<>("name"));

        }
        event.setDropCompleted(success);
        event.consume();
    }

}
