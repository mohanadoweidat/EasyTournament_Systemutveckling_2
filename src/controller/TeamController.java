package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.*;
import model.*;

public class TeamController extends SceneControllerParent {

    private AmountOfTeams amountOfTeams;
    @FXML
    private TableView tblTeams = new TableView<>();
    @FXML
    private CheckBox cbGroupStage;
    @FXML
    private CheckBox cbPlayoffs;
    @FXML
    private Button btnAdd;
    @FXML
    private ListView<String> listTeamsPlayer = new ListView<>();
    @FXML
    private ChoiceBox<AmountOfTeams> teamsBox = new ChoiceBox();
    @FXML
    private ChoiceBox<String> playersBox = new ChoiceBox();
    @FXML
    private ChoiceBox<String> selectTeamBox = new ChoiceBox();
    @FXML
    private ChoiceBox<String> spotBox = new ChoiceBox();

    private ObservableList<String> tableContent = FXCollections.observableArrayList();

    private Team team1 = new Team();
    private Team team2 = new Team();
    private Team team3 = new Team();
    private Team team4 = new Team();
    private Team team5 = new Team();
    private Team team6 = new Team();
    private Team team7 = new Team();
    private Team team8 = new Team();
    private Team team9 = new Team();
    private Team team10 = new Team();

    private TableColumn<Team, String> column = new TableColumn("Team");
    private TableColumn<Team, String> column1 = new TableColumn("Player 1");
    private TableColumn<Team, String> column2 = new TableColumn("Player 2");
    private TableColumn<Team, String> column3 = new TableColumn("Player 3");
    private TableColumn<Team, String> column4 = new TableColumn("Player 4");
    private TableColumn<Team, String> column5 = new TableColumn("Player 5");
    private TableColumn<Team, String> column6 = new TableColumn("Player 6");
    private TableColumn<Team, String> column7 = new TableColumn("Player 7");
    private TableColumn<Team, String> column8 = new TableColumn("Player 8");
    private TableColumn<Team, String> column9 = new TableColumn("Player 9");
    private TableColumn<Team, String> column10 = new TableColumn("Player 10");

    private ObservableList<Team> observablePlayers = FXCollections.observableArrayList();

    @FXML
    public void setFirstPageGUI(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.FirstPage);
    }

    @FXML
    public void setPlayerGUI(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.Player);
    }

    @FXML
    public void startTournamentClicked(ActionEvent actionEvent) {
        if (cbGroupStage.isSelected()) {
            mainController.setScene(ScenesEnum.GroupStage);
        } else if (cbPlayoffs.isSelected()) {

        } else {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Error message");
            alert1.setHeaderText(null);
            alert1.setContentText("You have to choose either Groupstage or Playoffs");
            alert1.showAndWait();
        }
    }

    public void initialize() {
        teamsBox.getItems().addAll(AmountOfTeams.values());
        setEditable();
    }

    public void setEditable() {
       /* column1.setEditable(true);
        column2.setEditable(true);
        column3.setEditable(true);
        column4.setEditable(true);
        column5.setEditable(true);
        column6.setEditable(true);
        column7.setEditable(true);
        column8.setEditable(true);
        column9.setEditable(true);
        column10.setEditable(true);

        */
    }

    @FXML
    private void initTeamsTableData(ActionEvent event) {
        for (Player p : mainController.getPlayers()){
            playersBox.getItems().add(p.getName());
        }
        //playersBox.getItems().addAll(mainController.getPlayers());
        try {
            switch (teamsBox.getSelectionModel().getSelectedItem()) {
                case Three:
                    tblTeams.getColumns().addAll(column, column1, column2);
                    tblTeams.setItems(addTeams());
                    selectTeamBox.getItems().addAll("Team1", "Team2");
                    spotBox.getItems().addAll("Player1", "Player2");
                    column.setCellValueFactory(new PropertyValueFactory<>("name"));
                    column1.setCellValueFactory(new PropertyValueFactory<>("player1"));
                    column2.setCellValueFactory(new PropertyValueFactory<>("player2"));
                    break;
                case Four:
                    tblTeams.getColumns().addAll(column1, column2, column3, column4);
                    //tblTeams.setItems(getPlayer(mainController.getPlayers()));
                    column1.setCellValueFactory(new PropertyValueFactory<>("name"));
                    break;
                case Five:
                    tblTeams.getColumns().addAll(column1, column2, column3, column4, column5);
                    //tblTeams.setItems(getPlayer(mainController.getPlayers()));
                    column1.setCellValueFactory(new PropertyValueFactory<>("name"));
                    break;
                case Six:
                    tblTeams.getColumns().addAll(column1, column2, column3, column4, column5, column6);
                    //tblTeams.setItems(getPlayer(mainController.getPlayers()));
                    column1.setCellValueFactory(new PropertyValueFactory<>("name"));
                    break;
                case Seven:
                    tblTeams.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7);
                    //tblTeams.setItems(getPlayer(mainController.getPlayers()));
                    column1.setCellValueFactory(new PropertyValueFactory<>("name"));
                    break;
                case Eight:
                    tblTeams.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8);
                    //tblTeams.setItems(getPlayer(mainController.getPlayers()));
                    column1.setCellValueFactory(new PropertyValueFactory<>("name"));
                    break;
                case Nine:
                    tblTeams.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9);
                    //tblTeams.setItems(getPlayer(mainController.getPlayers()));
                    column1.setCellValueFactory(new PropertyValueFactory<>("name"));
                    break;
                case Ten:
                    tblTeams.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9, column10);
                    //tblTeams.setItems(getPlayer(mainController.getPlayers()));

                    column1.setCellValueFactory(new PropertyValueFactory<>("name"));
                    break;
            }
        } catch (Exception e) {}
    }

    public ObservableList<Team> addTeams(){
        team1.setName("Malbas");
        team2.setName("Lakers");
        observablePlayers.addAll(team1,team2);
        return observablePlayers;
    }

    @FXML
    public void addTeams(ActionEvent event){
        if ((selectTeamBox.getValue()).equals("Team1")){
            if((spotBox.getValue()).equals("Player1")){
                team1.setPlayer1(playersBox.getValue());
            } else if((spotBox.getValue()).equals("Player2"))
                team1.setPlayer2(playersBox.getValue());
        } else if ((selectTeamBox.getValue()).equals("Team2")){
            if((spotBox.getValue()).equals("Player1")){
                team2.setPlayer1(playersBox.getValue());
            } else if((spotBox.getValue()).equals("Player2"))
                team2.setPlayer2(playersBox.getValue());
        }
        tblTeams.refresh();
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
            content.putString(String.valueOf(selected.getName()));
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
            Player p = new Player(text);
            p.setTeam1("Team1");
            //playerSave.add(p);
            //tblTeams.setItems(getPlayer(playerSave));
            success = true;
            column1.setCellValueFactory(new PropertyValueFactory<>("name"));
        }
        event.setDropCompleted(success);
        event.consume();
    }
}
