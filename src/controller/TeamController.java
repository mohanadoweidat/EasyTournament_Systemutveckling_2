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
            switch (teamsBox.getSelectionModel().getSelectedItem()) {
                case Three:
                    mainController.setScene(ScenesEnum.ThreeTeamsPlayoff);
                    break;
                case Four:
                    mainController.setScene(ScenesEnum.FourTeamsPlayoff);
                    break;
                case Five:
                    mainController.setScene(ScenesEnum.FiveTeamsPlayoff);
                    break;
                case Six:
                    mainController.setScene(ScenesEnum.SixTeamsPlayoff);
                    break;
                case Seven:
                    mainController.setScene(ScenesEnum.SevenTeamsPlayoff);
                    break;
                case Eight:
                    mainController.setScene(ScenesEnum.EightTeamsPlayoff);
                    break;
                case Nine:
                    mainController.setScene(ScenesEnum.NineTeamsPlayoff);
                    break;
                case Ten:
                    mainController.setScene(ScenesEnum.TenTeamsPlayoff);
                    break;
            }
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
        column.setCellValueFactory(new PropertyValueFactory<>("name"));
        column1.setCellValueFactory(new PropertyValueFactory<>("player1"));
        column2.setCellValueFactory(new PropertyValueFactory<>("player2"));
        column3.setCellValueFactory(new PropertyValueFactory<>("player3"));
        column4.setCellValueFactory(new PropertyValueFactory<>("player4"));
        column5.setCellValueFactory(new PropertyValueFactory<>("player5"));
        column6.setCellValueFactory(new PropertyValueFactory<>("player6"));
        column7.setCellValueFactory(new PropertyValueFactory<>("player7"));
        column8.setCellValueFactory(new PropertyValueFactory<>("player8"));
        column9.setCellValueFactory(new PropertyValueFactory<>("player9"));
        column10.setCellValueFactory(new PropertyValueFactory<>("player10"));
    }

    @FXML
    private void initTeamsTableData(ActionEvent event) {
        for (Player p : mainController.getPlayers()){
            playersBox.getItems().add(p.getName());
        }
        try {
            switch (teamsBox.getSelectionModel().getSelectedItem()) {
                case Three:
                    tblTeams.getColumns().addAll(column, column1, column2, column3);
                    tblTeams.setItems(addTeams());
                    selectTeamBox.getItems().addAll("Team1", "Team2", "Team3");
                    spotBox.getItems().addAll("Player1", "Player2", "Player3" , "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Four:
                    tblTeams.getColumns().addAll(column, column1, column2, column3, column4);
                    tblTeams.setItems(addTeams());
                    selectTeamBox.getItems().addAll("Team1", "Team2", "Team3", "Team4");
                    spotBox.getItems().addAll("Player1", "Player2", "Player3" , "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Five:
                    tblTeams.getColumns().addAll(column, column1, column2, column3, column4, column5);
                    tblTeams.setItems(addTeams());
                    selectTeamBox.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5");
                    spotBox.getItems().addAll("Player1", "Player2", "Player3" , "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Six:
                    tblTeams.getColumns().addAll(column, column1, column2, column3, column4, column5, column6);
                    tblTeams.setItems(addTeams());
                    selectTeamBox.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6");
                    spotBox.getItems().addAll("Player1", "Player2", "Player3" , "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Seven:
                    tblTeams.getColumns().addAll(column, column1, column2, column3, column4, column5, column6, column7);
                    tblTeams.setItems(addTeams());
                    selectTeamBox.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7");
                    spotBox.getItems().addAll("Player1", "Player2", "Player3" , "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Eight:
                    tblTeams.getColumns().addAll(column, column1, column2, column3, column4, column5, column6, column7, column8);
                    tblTeams.setItems(addTeams());
                    selectTeamBox.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7", "Team8");
                    spotBox.getItems().addAll("Player1", "Player2", "Player3" , "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Nine:
                    tblTeams.getColumns().addAll(column, column1, column2, column3, column4, column5, column6, column7, column8, column9);
                    tblTeams.setItems(addTeams());
                    selectTeamBox.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7", "Team8", "Team9");
                    spotBox.getItems().addAll("Player1", "Player2", "Player3" , "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Ten:
                    tblTeams.getColumns().addAll(column, column1, column2, column3, column4, column5, column6, column7, column8, column9, column10);
                    tblTeams.setItems(addTeams());
                    selectTeamBox.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7", "Team8", "Team9", "Team10");
                    spotBox.getItems().addAll("Player1", "Player2", "Player3" , "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
            }
        } catch (Exception e) {}
    }

    public ObservableList<Team> addTeams(){
        switch (teamsBox.getSelectionModel().getSelectedItem()){
            case Three:
                team1.setName("Team1");
                team2.setName("Team2");
                team3.setName("Team3");
                observablePlayers.addAll(team1,team2,team3);
                break;
            case Four:
                team1.setName("Team1");
                team2.setName("Team2");
                team3.setName("Team3");
                team4.setName("Team4");
                observablePlayers.addAll(team1,team2,team3,team4);
                break;
            case Five:
                team1.setName("Team1");
                team2.setName("Team2");
                team3.setName("Team3");
                team4.setName("Team4");
                team5.setName("Team5");
                observablePlayers.addAll(team1,team2,team3,team4,team5);
                break;
            case Six:
                team1.setName("Team1");
                team2.setName("Team2");
                team3.setName("Team3");
                team4.setName("Team4");
                team5.setName("Team5");
                team6.setName("Team6");
                observablePlayers.addAll(team1,team2,team3,team4,team5,team6);
                break;
            case Seven:
                team1.setName("Team1");
                team2.setName("Team2");
                team3.setName("Team3");
                team4.setName("Team4");
                team5.setName("Team5");
                team6.setName("Team6");
                team7.setName("Team7");
                observablePlayers.addAll(team1,team2,team3,team4,team5,team6,team7);
                break;
            case Eight:
                team1.setName("Team1");
                team2.setName("Team2");
                team3.setName("Team3");
                team4.setName("Team4");
                team5.setName("Team5");
                team6.setName("Team6");
                team7.setName("Team7");
                team8.setName("Team8");
                observablePlayers.addAll(team1,team2,team3,team4,team5,team6,team7,team8);
                break;
            case Nine:
                team1.setName("Team1");
                team2.setName("Team2");
                team3.setName("Team3");
                team4.setName("Team4");
                team5.setName("Team5");
                team6.setName("Team6");
                team7.setName("Team7");
                team8.setName("Team8");
                team9.setName("Team9");
                observablePlayers.addAll(team1,team2,team3,team4,team5,team6,team7,team8,team9);
                break;
            case Ten:
                team1.setName("Team1");
                team2.setName("Team2");
                team3.setName("Team3");
                team4.setName("Team4");
                team5.setName("Team5");
                team6.setName("Team6");
                team7.setName("Team7");
                team8.setName("Team8");
                team9.setName("Team9");
                team10.setName("Team10");
                observablePlayers.addAll(team1,team2,team3,team4,team5,team6,team7,team8,team9,team10);
                break;
        }

        return observablePlayers;
    }

    @FXML
    public void addTeams(ActionEvent event){
        if ((selectTeamBox.getValue()).equals("Team1")){
            if((spotBox.getValue()).equals("Player1")){
                team1.setPlayer1(playersBox.getValue());
            } else if((spotBox.getValue()).equals("Player2"))
                team1.setPlayer2(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player3"))
                team1.setPlayer3(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player4"))
                team1.setPlayer4(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player5"))
                team1.setPlayer5(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player6"))
                team1.setPlayer6(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player7"))
                team1.setPlayer7(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player8"))
                team1.setPlayer8(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player9"))
                team1.setPlayer9(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player10"))
                team1.setPlayer10(playersBox.getValue());

        } else if ((selectTeamBox.getValue()).equals("Team2")){
            if((spotBox.getValue()).equals("Player1")){
                team2.setPlayer1(playersBox.getValue());
            } else if((spotBox.getValue()).equals("Player2"))
                team2.setPlayer2(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player3"))
                team2.setPlayer3(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player4"))
                team2.setPlayer4(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player5"))
                team2.setPlayer5(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player6"))
                team2.setPlayer6(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player7"))
                team2.setPlayer7(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player8"))
                team2.setPlayer8(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player9"))
                team2.setPlayer9(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player10"))
                team2 .setPlayer10(playersBox.getValue());

        } else if ((selectTeamBox.getValue()).equals("Team3")){
            if((spotBox.getValue()).equals("Player1")){
                team3.setPlayer1(playersBox.getValue());
            } else if((spotBox.getValue()).equals("Player2"))
                team3.setPlayer2(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player3"))
                team3.setPlayer3(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player4"))
                team3.setPlayer4(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player5"))
                team3.setPlayer5(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player6"))
                team3.setPlayer6(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player7"))
                team3.setPlayer7(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player8"))
                team3.setPlayer8(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player9"))
                team3.setPlayer9(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player10"))
                team3.setPlayer10(playersBox.getValue());

        } else if ((selectTeamBox.getValue()).equals("Team4")){
            if((spotBox.getValue()).equals("Player1")){
                team4.setPlayer1(playersBox.getValue());
            } else if((spotBox.getValue()).equals("Player2"))
                team4.setPlayer2(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player3"))
                team4.setPlayer3(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player4"))
                team4.setPlayer4(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player5"))
                team4.setPlayer5(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player6"))
                team4.setPlayer6(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player7"))
                team4.setPlayer7(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player8"))
                team4.setPlayer8(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player9"))
                team4.setPlayer9(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player10"))
                team4.setPlayer10(playersBox.getValue());

        } else if ((selectTeamBox.getValue()).equals("Team5")){
            if((spotBox.getValue()).equals("Player1")){
                team5.setPlayer1(playersBox.getValue());
            } else if((spotBox.getValue()).equals("Player2"))
                team5.setPlayer2(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player3"))
                team5.setPlayer3(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player4"))
                team5.setPlayer4(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player5"))
                team5.setPlayer5(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player6"))
                team5.setPlayer6(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player7"))
                team5.setPlayer7(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player8"))
                team5.setPlayer8(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player9"))
                team5.setPlayer9(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player10"))
                team5.setPlayer10(playersBox.getValue());

        } else if ((selectTeamBox.getValue()).equals("Team6")){
            if((spotBox.getValue()).equals("Player1")){
                team6.setPlayer1(playersBox.getValue());
            } else if((spotBox.getValue()).equals("Player2"))
                team6.setPlayer2(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player3"))
                team6.setPlayer3(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player4"))
                team6.setPlayer4(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player5"))
                team6.setPlayer5(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player6"))
                team6.setPlayer6(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player7"))
                team6.setPlayer7(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player8"))
                team6.setPlayer8(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player9"))
                team6.setPlayer9(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player10"))
                team6.setPlayer10(playersBox.getValue());

        } else if ((selectTeamBox.getValue()).equals("Team7")){
            if((spotBox.getValue()).equals("Player1")){
                team7.setPlayer1(playersBox.getValue());
            } else if((spotBox.getValue()).equals("Player2"))
                team7.setPlayer2(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player3"))
                team7.setPlayer3(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player4"))
                team7.setPlayer4(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player5"))
                team7.setPlayer5(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player6"))
                team7.setPlayer6(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player7"))
                team7.setPlayer7(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player8"))
                team7.setPlayer8(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player9"))
                team7.setPlayer9(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player10"))
                team7.setPlayer10(playersBox.getValue());

        } else if ((selectTeamBox.getValue()).equals("Team8")){
            if((spotBox.getValue()).equals("Player1")){
                team8.setPlayer1(playersBox.getValue());
            } else if((spotBox.getValue()).equals("Player2"))
                team8.setPlayer2(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player3"))
                team8.setPlayer3(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player4"))
                team8.setPlayer4(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player5"))
                team8.setPlayer5(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player6"))
                team8.setPlayer6(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player7"))
                team8.setPlayer7(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player8"))
                team8.setPlayer8(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player9"))
                team8.setPlayer9(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player10"))
                team8.setPlayer10(playersBox.getValue());

        } else if ((selectTeamBox.getValue()).equals("Team9")){
            if((spotBox.getValue()).equals("Player1")){
                team9.setPlayer1(playersBox.getValue());
            } else if((spotBox.getValue()).equals("Player2"))
                team9.setPlayer2(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player3"))
                team9.setPlayer3(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player4"))
                team9.setPlayer4(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player5"))
                team9.setPlayer5(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player6"))
                team9.setPlayer6(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player7"))
                team9.setPlayer7(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player8"))
                team9.setPlayer8(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player9"))
                team9.setPlayer9(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player10"))
                team9.setPlayer10(playersBox.getValue());

        } else if ((selectTeamBox.getValue()).equals("Team10")){
            if((spotBox.getValue()).equals("Player1")){
                team10.setPlayer1(playersBox.getValue());
            } else if((spotBox.getValue()).equals("Player2"))
                team10.setPlayer2(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player3"))
                team10.setPlayer3(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player4"))
                team10.setPlayer4(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player5"))
                team10.setPlayer5(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player6"))
                team10.setPlayer6(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player7"))
                team10.setPlayer7(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player8"))
                team10.setPlayer8(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player9"))
                team10.setPlayer9(playersBox.getValue());
            else if((spotBox.getValue()).equals("Player10"))
                team10.setPlayer10(playersBox.getValue());
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
