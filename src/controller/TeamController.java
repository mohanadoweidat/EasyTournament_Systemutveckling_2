package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import model.*;

import java.io.*;
import java.util.List;

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
    private ChoiceBox<AmountOfTeams> cbTeams = new ChoiceBox();
    @FXML
    private ChoiceBox<String> cbPlayers = new ChoiceBox();
    @FXML
    private ChoiceBox<String> cbSelectTeams = new ChoiceBox();
    @FXML
    private ChoiceBox<String> cbPlacingOnTable = new ChoiceBox();

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

    private TableColumn<Team, String> columnTeam = new TableColumn("Team");
    private TableColumn<Team, String> columnPlayer1 = new TableColumn("Player 1");
    private TableColumn<Team, String> columnPlayer2 = new TableColumn("Player 2");
    private TableColumn<Team, String> columnPlayer3 = new TableColumn("Player 3");
    private TableColumn<Team, String> columnPlayer4 = new TableColumn("Player 4");
    private TableColumn<Team, String> columnPlayer5 = new TableColumn("Player 5");
    private TableColumn<Team, String> columnPlayer6 = new TableColumn("Player 6");
    private TableColumn<Team, String> columnPlayer7 = new TableColumn("Player 7");
    private TableColumn<Team, String> columnPlayer8 = new TableColumn("Player 8");
    private TableColumn<Team, String> columnPlayer9 = new TableColumn("Player 9");
    private TableColumn<Team, String> columnPlayer10 = new TableColumn("Player 10");

    private ObservableList<Team> observablePlayers = FXCollections.observableArrayList();

    /**
     * Makes the columns editable
     */
    private void editableCols(){
        columnTeam.setCellFactory(TextFieldTableCell.forTableColumn());
        columnTeam.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setName(e.getNewValue());
        });
        tblTeams.setEditable(true);
    }
    /**
     * Changes scenes to the FirstPage
     */
    @FXML
    public void setFirstPageGUI(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.FirstPage);
    }

    /**
     * Changes scenes to the PlayersGUI
     */
    @FXML
    public void setPlayerGUI(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.Player);
    }

    @FXML
    public void saveTeams(){
        System.out.println(tblTeams.getItems());

        List<Team> teams = (tblTeams.getItems());
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("files/teams.txt"), "ISO-8859-1"))) {
                for (Team team : teams){
                    bw.write(team.getName() + " ");
                    /*bw.write(team.getPlayer1() + " ");
                    bw.write(team.getPlayer2() + " ");
                    bw.write(team.getPlayer3() + " ");
                    bw.write(team.getPlayer4() + " ");
                    bw.write(team.getPlayer5() + " ");
                    bw.write(team.getPlayer6() + " ");
                    bw.write(team.getPlayer7() + " ");
                    bw.write(team.getPlayer8() + " ");
                    bw.write(team.getPlayer9() + " ");
                    bw.write(team.getPlayer10() + " ");
                    */
                    bw.newLine();
                }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Starts the tournament when button is clicked.
     * Choosing the playoff scene depending on which is selected
     * @param actionEvent
     */
    @FXML
    public void startTournamentClicked(ActionEvent actionEvent) {
        mainController.addTeams(tblTeams.getItems());
        if (cbGroupStage.isSelected()) {
            mainController.setAmountOfTeams(cbTeams.getSelectionModel().getSelectedItem());
            mainController.setScene(ScenesEnum.GroupStage);
        } else if (cbPlayoffs.isSelected()) {
            switch (cbTeams.getSelectionModel().getSelectedItem()) {
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
        mainController.loadTeamsToLeaguePlay();
    }

    /**
     * Puts the value on the different columns
     */
    public void initialize() {
        editableCols();
        cbTeams.getItems().addAll(AmountOfTeams.values());
        columnTeam.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnPlayer1.setCellValueFactory(new PropertyValueFactory<>("player1"));
        columnPlayer2.setCellValueFactory(new PropertyValueFactory<>("player2"));
        columnPlayer3.setCellValueFactory(new PropertyValueFactory<>("player3"));
        columnPlayer4.setCellValueFactory(new PropertyValueFactory<>("player4"));
        columnPlayer5.setCellValueFactory(new PropertyValueFactory<>("player5"));
        columnPlayer6.setCellValueFactory(new PropertyValueFactory<>("player6"));
        columnPlayer7.setCellValueFactory(new PropertyValueFactory<>("player7"));
        columnPlayer8.setCellValueFactory(new PropertyValueFactory<>("player8"));
        columnPlayer9.setCellValueFactory(new PropertyValueFactory<>("player9"));
        columnPlayer10.setCellValueFactory(new PropertyValueFactory<>("player10"));
    }

    /**
     * Chooses the amount of columns and rows for the teams and players depending on which is choosen in the ChoiceBox
     */
    @FXML
    private void initTeamsTableData(ActionEvent event) {
        for (Player p : mainController.getPlayers()){
            cbPlayers.getItems().add(p.getName());
        }
        try {
            switch (cbTeams.getSelectionModel().getSelectedItem()) {
                case Three:
                    tblTeams.getColumns().addAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
                    tblTeams.setItems(addPlayersToTeams());
                    cbSelectTeams.getItems().addAll("Team1", "Team2", "Team3");
                    cbPlacingOnTable.getItems().addAll("Player1", "Player2", "Player3" , "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Four:
                    tblTeams.getColumns().addAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
                    tblTeams.setItems(addPlayersToTeams());
                    cbSelectTeams.getItems().addAll("Team1", "Team2", "Team3", "Team4");
                    cbPlacingOnTable.getItems().addAll("Player1", "Player2", "Player3" , "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Five:
                    tblTeams.getColumns().addAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
                    tblTeams.setItems(addPlayersToTeams());
                    cbSelectTeams.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5");
                    cbPlacingOnTable.getItems().addAll("Player1", "Player2", "Player3" , "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Six:
                    tblTeams.getColumns().addAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
                    tblTeams.setItems(addPlayersToTeams());
                    cbSelectTeams.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6");
                    cbPlacingOnTable.getItems().addAll("Player1", "Player2", "Player3" , "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Seven:
                    tblTeams.getColumns().addAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
                    tblTeams.setItems(addPlayersToTeams());
                    cbSelectTeams.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7");
                    cbPlacingOnTable.getItems().addAll("Player1", "Player2", "Player3" , "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Eight:
                    tblTeams.getColumns().addAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
                    tblTeams.setItems(addPlayersToTeams());
                    cbSelectTeams.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7", "Team8");
                    cbPlacingOnTable.getItems().addAll("Player1", "Player2", "Player3" , "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Nine:
                    tblTeams.getColumns().addAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
                    tblTeams.setItems(addPlayersToTeams());
                    cbSelectTeams.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7", "Team8", "Team9");
                    cbPlacingOnTable.getItems().addAll("Player1", "Player2", "Player3" , "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Ten:
                    tblTeams.getColumns().addAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
                    tblTeams.setItems(addPlayersToTeams());
                    cbSelectTeams.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7", "Team8", "Team9", "Team10");
                    cbPlacingOnTable.getItems().addAll("Player1", "Player2", "Player3" , "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
            }
        } catch (Exception e) {}
    }

    /**
     * Adds the amount of teams to the table
     */

    public ObservableList<Team> addPlayersToTeams(){
        switch (cbTeams.getSelectionModel().getSelectedItem()){
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

    /**
     * Adds the Player object to specific index in the table
     * This way we can sort the teams
     */
    @FXML
    public void addPlayersToTeams(ActionEvent event){
        if ((cbSelectTeams.getValue()).equals("Team1")){
            if((cbPlacingOnTable.getValue()).equals("Player1")){
                team1.setPlayer1(cbPlayers.getValue());
            } else if((cbPlacingOnTable.getValue()).equals("Player2"))
                team1.setPlayer2(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player3"))
                team1.setPlayer3(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player4"))
                team1.setPlayer4(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player5"))
                team1.setPlayer5(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player6"))
                team1.setPlayer6(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player7"))
                team1.setPlayer7(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player8"))
                team1.setPlayer8(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player9"))
                team1.setPlayer9(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player10"))
                team1.setPlayer10(cbPlayers.getValue());

        } else if ((cbSelectTeams.getValue()).equals("Team2")){
            if((cbPlacingOnTable.getValue()).equals("Player1")){
                team2.setPlayer1(cbPlayers.getValue());
            } else if((cbPlacingOnTable.getValue()).equals("Player2"))
                team2.setPlayer2(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player3"))
                team2.setPlayer3(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player4"))
                team2.setPlayer4(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player5"))
                team2.setPlayer5(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player6"))
                team2.setPlayer6(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player7"))
                team2.setPlayer7(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player8"))
                team2.setPlayer8(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player9"))
                team2.setPlayer9(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player10"))
                team2 .setPlayer10(cbPlayers.getValue());

        } else if ((cbSelectTeams.getValue()).equals("Team3")){
            if((cbPlacingOnTable.getValue()).equals("Player1")){
                team3.setPlayer1(cbPlayers.getValue());
            } else if((cbPlacingOnTable.getValue()).equals("Player2"))
                team3.setPlayer2(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player3"))
                team3.setPlayer3(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player4"))
                team3.setPlayer4(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player5"))
                team3.setPlayer5(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player6"))
                team3.setPlayer6(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player7"))
                team3.setPlayer7(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player8"))
                team3.setPlayer8(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player9"))
                team3.setPlayer9(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player10"))
                team3.setPlayer10(cbPlayers.getValue());

        } else if ((cbSelectTeams.getValue()).equals("Team4")){
            if((cbPlacingOnTable.getValue()).equals("Player1")){
                team4.setPlayer1(cbPlayers.getValue());
            } else if((cbPlacingOnTable.getValue()).equals("Player2"))
                team4.setPlayer2(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player3"))
                team4.setPlayer3(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player4"))
                team4.setPlayer4(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player5"))
                team4.setPlayer5(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player6"))
                team4.setPlayer6(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player7"))
                team4.setPlayer7(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player8"))
                team4.setPlayer8(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player9"))
                team4.setPlayer9(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player10"))
                team4.setPlayer10(cbPlayers.getValue());

        } else if ((cbSelectTeams.getValue()).equals("Team5")){
            if((cbPlacingOnTable.getValue()).equals("Player1")){
                team5.setPlayer1(cbPlayers.getValue());
            } else if((cbPlacingOnTable.getValue()).equals("Player2"))
                team5.setPlayer2(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player3"))
                team5.setPlayer3(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player4"))
                team5.setPlayer4(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player5"))
                team5.setPlayer5(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player6"))
                team5.setPlayer6(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player7"))
                team5.setPlayer7(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player8"))
                team5.setPlayer8(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player9"))
                team5.setPlayer9(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player10"))
                team5.setPlayer10(cbPlayers.getValue());

        } else if ((cbSelectTeams.getValue()).equals("Team6")){
            if((cbPlacingOnTable.getValue()).equals("Player1")){
                team6.setPlayer1(cbPlayers.getValue());
            } else if((cbPlacingOnTable.getValue()).equals("Player2"))
                team6.setPlayer2(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player3"))
                team6.setPlayer3(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player4"))
                team6.setPlayer4(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player5"))
                team6.setPlayer5(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player6"))
                team6.setPlayer6(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player7"))
                team6.setPlayer7(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player8"))
                team6.setPlayer8(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player9"))
                team6.setPlayer9(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player10"))
                team6.setPlayer10(cbPlayers.getValue());

        } else if ((cbSelectTeams.getValue()).equals("Team7")){
            if((cbPlacingOnTable.getValue()).equals("Player1")){
                team7.setPlayer1(cbPlayers.getValue());
            } else if((cbPlacingOnTable.getValue()).equals("Player2"))
                team7.setPlayer2(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player3"))
                team7.setPlayer3(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player4"))
                team7.setPlayer4(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player5"))
                team7.setPlayer5(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player6"))
                team7.setPlayer6(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player7"))
                team7.setPlayer7(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player8"))
                team7.setPlayer8(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player9"))
                team7.setPlayer9(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player10"))
                team7.setPlayer10(cbPlayers.getValue());

        } else if ((cbSelectTeams.getValue()).equals("Team8")){
            if((cbPlacingOnTable.getValue()).equals("Player1")){
                team8.setPlayer1(cbPlayers.getValue());
            } else if((cbPlacingOnTable.getValue()).equals("Player2"))
                team8.setPlayer2(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player3"))
                team8.setPlayer3(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player4"))
                team8.setPlayer4(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player5"))
                team8.setPlayer5(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player6"))
                team8.setPlayer6(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player7"))
                team8.setPlayer7(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player8"))
                team8.setPlayer8(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player9"))
                team8.setPlayer9(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player10"))
                team8.setPlayer10(cbPlayers.getValue());

        } else if ((cbSelectTeams.getValue()).equals("Team9")){
            if((cbPlacingOnTable.getValue()).equals("Player1")){
                team9.setPlayer1(cbPlayers.getValue());
            } else if((cbPlacingOnTable.getValue()).equals("Player2"))
                team9.setPlayer2(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player3"))
                team9.setPlayer3(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player4"))
                team9.setPlayer4(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player5"))
                team9.setPlayer5(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player6"))
                team9.setPlayer6(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player7"))
                team9.setPlayer7(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player8"))
                team9.setPlayer8(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player9"))
                team9.setPlayer9(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player10"))
                team9.setPlayer10(cbPlayers.getValue());

        } else if ((cbSelectTeams.getValue()).equals("Team10")){
            if((cbPlacingOnTable.getValue()).equals("Player1")){
                team10.setPlayer1(cbPlayers.getValue());
            } else if((cbPlacingOnTable.getValue()).equals("Player2"))
                team10.setPlayer2(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player3"))
                team10.setPlayer3(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player4"))
                team10.setPlayer4(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player5"))
                team10.setPlayer5(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player6"))
                team10.setPlayer6(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player7"))
                team10.setPlayer7(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player8"))
                team10.setPlayer8(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player9"))
                team10.setPlayer9(cbPlayers.getValue());
            else if((cbPlacingOnTable.getValue()).equals("Player10"))
                team10.setPlayer10(cbPlayers.getValue());
        }
        tblTeams.refresh();
    }
}
