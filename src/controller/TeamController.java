package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.AmountOfTeams;
import model.Player;
import model.Team;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    private ComboBox<String> cbPlayers = new ComboBox<>();
    @FXML
    private ComboBox<String> cbSelectTeams = new ComboBox<>();
    @FXML
    private ComboBox<String> cbPlacingOnTable = new ComboBox<>();
    @FXML
    private ComboBox<String> cbRemovePlayer = new ComboBox<>();
    @FXML
    private ComboBox<String> cbRemoveTeam = new ComboBox<>();

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

    private ArrayList<Player> playersBuffer = new ArrayList<>();

    public TeamController() {

    }

    /**
     * Makes the columns editable
     */
    private void editableCols() {
        columnTeam.setCellFactory(TextFieldTableCell.forTableColumn());
        columnTeam.setOnEditCommit(e -> {
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

    /**
     * Saves the teams you added to the table
     */
    @FXML
    public void saveTeams() {
        System.out.println(tblTeams.getItems());

        List<Team> teams = (tblTeams.getItems());
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("files/teams.txt"), "ISO-8859-1"))) {
            for (Team team : teams) {
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

    public void importTeams(){

    }

    /**
     * Starts the tournament when button is clicked.
     * Choosing the playoff scene depending on which is selected
     *
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
        for (Player p : mainController.getPlayers()) {
            cbPlayers.getItems().add(p.getName());
//            cbRemovePlayer.getItems().add(p.getName());
        }
        try {
            tblTeams.getItems().removeAll(observablePlayers);
            tblTeams.getColumns().removeAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
            switch (cbTeams.getSelectionModel().getSelectedItem()) {
                case Three:
                    tblTeams.getColumns().addAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
                    tblTeams.setItems(addPlayersToTeams());
                    cbSelectTeams.getItems().addAll("Team1", "Team2", "Team3");
                    cbRemoveTeam.getItems().addAll("Team1", "Team2", "Team3");
                    cbPlacingOnTable.getItems().addAll("Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Four:
                    tblTeams.getColumns().addAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
                    tblTeams.setItems(addPlayersToTeams());
                    cbSelectTeams.getItems().addAll("Team1", "Team2", "Team3", "Team4");
                    cbRemoveTeam.getItems().addAll("Team1", "Team2", "Team3", "Team4");
                    cbPlacingOnTable.getItems().addAll("Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Five:
                    tblTeams.getColumns().addAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
                    tblTeams.setItems(addPlayersToTeams());
                    cbSelectTeams.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5");
                    cbRemoveTeam.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5");
                    cbPlacingOnTable.getItems().addAll("Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Six:
                    tblTeams.getColumns().addAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
                    tblTeams.setItems(addPlayersToTeams());
                    cbSelectTeams.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6");
                    cbRemoveTeam.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6");
                    cbPlacingOnTable.getItems().addAll("Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Seven:
                    tblTeams.getColumns().addAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
                    tblTeams.setItems(addPlayersToTeams());
                    cbSelectTeams.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7");
                    cbRemoveTeam.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7");
                    cbPlacingOnTable.getItems().addAll("Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Eight:
                    tblTeams.getColumns().addAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
                    tblTeams.setItems(addPlayersToTeams());
                    cbSelectTeams.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7", "Team8");
                    cbRemoveTeam.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7", "Team8");
                    cbPlacingOnTable.getItems().addAll("Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Nine:
                    tblTeams.getColumns().addAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
                    tblTeams.setItems(addPlayersToTeams());
                    cbSelectTeams.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7", "Team8", "Team9");
                    cbRemoveTeam.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7", "Team8", "Team9");
                    cbPlacingOnTable.getItems().addAll("Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Ten:
                    tblTeams.getColumns().addAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
                    tblTeams.setItems(addPlayersToTeams());
                    cbSelectTeams.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7", "Team8", "Team9", "Team10");
                    cbRemoveTeam.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7", "Team8", "Team9", "Team10");
                    cbPlacingOnTable.getItems().addAll("Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
            }
        } catch (Exception e) {
        }
    }

    public void selectPlayersToRemove() {
        switch (cbRemoveTeam.getSelectionModel().getSelectedItem()) {
            case "Team1":
                cbRemovePlayer.getItems().setAll(team1.getPlayers());
                break;
            case "Team2":
                cbRemovePlayer.getItems().setAll(team2.getPlayers());
                break;
            case "Team3":
                cbRemovePlayer.getItems().setAll(team3.getPlayers());
                break;
            case "Team4":
                cbRemovePlayer.getItems().setAll(team4.getPlayers());
                break;
            case "Team5":
                cbRemovePlayer.getItems().setAll(team5.getPlayers());
                break;
            case "Team6":
                cbRemovePlayer.getItems().setAll(team6.getPlayers());
                break;
            case "Team7":
                cbRemovePlayer.getItems().setAll(team7.getPlayers());
                break;
            case "Team8":
                cbRemovePlayer.getItems().setAll(team8.getPlayers());
                break;
            case "Team9":
                cbRemovePlayer.getItems().setAll(team9.getPlayers());
                break;
            case "Team10":
                cbRemovePlayer.getItems().setAll(team10.getPlayers());
                break;


        }
    }

    /**
     * Adds the amount of teams to the table
     */
    public ObservableList<Team> addPlayersToTeams() {
        switch (cbTeams.getSelectionModel().getSelectedItem()) {
            case Three:
                team1.setName("Team 1");
                team2.setName("Team 2");
                team3.setName("Team 3");
                observablePlayers.addAll(team1, team2, team3);
                break;
            case Four:

                team1.setName("Team 1");
                team2.setName("Team 2");
                team3.setName("Team 3");
                team4.setName("Team 4");
                observablePlayers.addAll(team1, team2, team3, team4);
                break;
            case Five:
                team1.setName("Team 1");
                team2.setName("Team 2");
                team3.setName("Team 3");
                team4.setName("Team 4");
                team5.setName("Team 5");
                observablePlayers.addAll(team1, team2, team3, team4, team5);
                break;
            case Six:
                team1.setName("Team 1");
                team2.setName("Team 2");
                team3.setName("Team 3");
                team4.setName("Team 4");
                team5.setName("Team 5");
                team6.setName("Team 6");
                observablePlayers.addAll(team1, team2, team3, team4, team5, team6);
                break;
            case Seven:
                team1.setName("Team 1");
                team2.setName("Team 2");
                team3.setName("Team 3");
                team4.setName("Team 4");
                team5.setName("Team 5");
                team6.setName("Team 6");
                team7.setName("Team 7");
                observablePlayers.addAll(team1, team2, team3, team4, team5, team6, team7);
                break;
            case Eight:
                team1.setName("Team 1");
                team2.setName("Team 2");
                team3.setName("Team 3");
                team4.setName("Team 4");
                team5.setName("Team 5");
                team6.setName("Team 6");
                team7.setName("Team 7");
                team8.setName("Team 8");
                observablePlayers.addAll(team1, team2, team3, team4, team5, team6, team7, team8);
                break;
            case Nine:
                team1.setName("Team 1");
                team2.setName("Team 2");
                team3.setName("Team 3");
                team4.setName("Team 4");
                team5.setName("Team 5");
                team6.setName("Team 6");
                team7.setName("Team 7");
                team8.setName("Team 8");
                team9.setName("Team 9");
                observablePlayers.addAll(team1, team2, team3, team4, team5, team6, team7, team8, team9);
                break;
            case Ten:
                team1.setName("Team 1");
                team2.setName("Team 2");
                team3.setName("Team 3");
                team4.setName("Team 4");
                team5.setName("Team 5");
                team6.setName("Team 6");
                team7.setName("Team 7");
                team8.setName("Team 8");
                team9.setName("Team 9");
                team10.setName("Team 10");
                observablePlayers.addAll(team1, team2, team3, team4, team5, team6, team7, team8, team9, team10);
                break;
        }
        return observablePlayers;
    }

    /**
     * Adds the Player object to the next empty index of the team in the table
     * This way we can sort the teams
     */
    @FXML
    public void addPlayersToTeams(ActionEvent event) {
        if ((cbSelectTeams.getValue()).equals("Team1")) {
            if ((team1.getPlayer1().equals(" "))) {
                team1.setPlayer1(cbPlayers.getValue());
            } else if ((team1.getPlayer2().equals(" "))) {
                team1.setPlayer2(cbPlayers.getValue());
            } else if ((team1.getPlayer3().equals(" "))) {
                team1.setPlayer3(cbPlayers.getValue());
            } else if ((team1.getPlayer4().equals(" "))) {
                team1.setPlayer4(cbPlayers.getValue());
            } else if ((team1.getPlayer5().equals(" "))) {
                team1.setPlayer5(cbPlayers.getValue());
            } else if ((team1.getPlayer6().equals(" "))) {
                team1.setPlayer6(cbPlayers.getValue());
            } else if ((team1.getPlayer7().equals(" "))) {
                team1.setPlayer7(cbPlayers.getValue());
            } else if ((team1.getPlayer8().equals(" "))) {
                team1.setPlayer8(cbPlayers.getValue());
            } else if ((team1.getPlayer9().equals(" "))) {
                team1.setPlayer9(cbPlayers.getValue());
            } else if ((team1.getPlayer10().equals(" "))) {
                team1.setPlayer10(cbPlayers.getValue());
            }
        }
        if ((cbSelectTeams.getValue()).equals("Team2")) {
            if ((team2.getPlayer1().equals(" "))) {
                team2.setPlayer1(cbPlayers.getValue());
            } else if ((team2.getPlayer2().equals(" "))) {
                team2.setPlayer2(cbPlayers.getValue());
            } else if ((team2.getPlayer3().equals(" "))) {
                team2.setPlayer3(cbPlayers.getValue());
            } else if ((team2.getPlayer4().equals(" "))) {
                team2.setPlayer4(cbPlayers.getValue());
            } else if ((team2.getPlayer5().equals(" "))) {
                team2.setPlayer5(cbPlayers.getValue());
            } else if ((team2.getPlayer6().equals(" "))) {
                team2.setPlayer6(cbPlayers.getValue());
            } else if ((team2.getPlayer7().equals(" "))) {
                team2.setPlayer7(cbPlayers.getValue());
            } else if ((team2.getPlayer8().equals(" "))) {
                team2.setPlayer8(cbPlayers.getValue());
            } else if ((team2.getPlayer9().equals(" "))) {
                team2.setPlayer9(cbPlayers.getValue());
            } else if ((team2.getPlayer10().equals(" "))) {
                team2.setPlayer10(cbPlayers.getValue());

            }
        }
        if ((cbSelectTeams.getValue()).equals("Team3")) {
            if ((team3.getPlayer1().equals(" "))) {
                team3.setPlayer1(cbPlayers.getValue());
            } else if ((team3.getPlayer2().equals(" "))) {
                team3.setPlayer2(cbPlayers.getValue());
            } else if ((team3.getPlayer3().equals(" "))) {
                team3.setPlayer3(cbPlayers.getValue());
            } else if ((team3.getPlayer4().equals(" "))) {
                team3.setPlayer4(cbPlayers.getValue());
            } else if ((team3.getPlayer5().equals(" "))) {
                team3.setPlayer5(cbPlayers.getValue());
            } else if ((team3.getPlayer6().equals(" "))) {
                team3.setPlayer6(cbPlayers.getValue());
            } else if ((team3.getPlayer7().equals(" "))) {
                team3.setPlayer7(cbPlayers.getValue());
            } else if ((team3.getPlayer8().equals(" "))) {
                team3.setPlayer8(cbPlayers.getValue());
            } else if ((team3.getPlayer9().equals(" "))) {
                team3.setPlayer9(cbPlayers.getValue());
            } else if ((team3.getPlayer10().equals(" "))) {
                team3.setPlayer10(cbPlayers.getValue());

            }
        }
        if ((cbSelectTeams.getValue()).equals("Team4")) {
            if ((team4.getPlayer1().equals(" "))) {
                team4.setPlayer1(cbPlayers.getValue());
            } else if ((team4.getPlayer2().equals(" "))) {
                team4.setPlayer2(cbPlayers.getValue());
            } else if ((team4.getPlayer3().equals(" "))) {
                team4.setPlayer3(cbPlayers.getValue());
            } else if ((team4.getPlayer4().equals(" "))) {
                team4.setPlayer4(cbPlayers.getValue());
            } else if ((team4.getPlayer5().equals(" "))) {
                team4.setPlayer5(cbPlayers.getValue());
            } else if ((team4.getPlayer6().equals(" "))) {
                team4.setPlayer6(cbPlayers.getValue());
            } else if ((team4.getPlayer7().equals(" "))) {
                team4.setPlayer7(cbPlayers.getValue());
            } else if ((team4.getPlayer8().equals(" "))) {
                team4.setPlayer8(cbPlayers.getValue());
            } else if ((team4.getPlayer9().equals(" "))) {
                team4.setPlayer9(cbPlayers.getValue());
            } else if ((team4.getPlayer10().equals(" "))) {
                team4.setPlayer10(cbPlayers.getValue());

            }
        }
        if ((cbSelectTeams.getValue()).equals("Team5")) {
            if ((team5.getPlayer1().equals(" "))) {
                team5.setPlayer1(cbPlayers.getValue());
            } else if ((team5.getPlayer2().equals(" "))) {
                team5.setPlayer2(cbPlayers.getValue());
            } else if ((team5.getPlayer3().equals(" "))) {
                team5.setPlayer3(cbPlayers.getValue());
            } else if ((team5.getPlayer4().equals(" "))) {
                team5.setPlayer4(cbPlayers.getValue());
            } else if ((team5.getPlayer5().equals(" "))) {
                team5.setPlayer5(cbPlayers.getValue());
            } else if ((team5.getPlayer6().equals(" "))) {
                team5.setPlayer6(cbPlayers.getValue());
            } else if ((team5.getPlayer7().equals(" "))) {
                team5.setPlayer7(cbPlayers.getValue());
            } else if ((team5.getPlayer8().equals(" "))) {
                team5.setPlayer8(cbPlayers.getValue());
            } else if ((team5.getPlayer9().equals(" "))) {
                team5.setPlayer9(cbPlayers.getValue());
            } else if ((team5.getPlayer10().equals(" "))) {
                team5.setPlayer10(cbPlayers.getValue());

            }
        }
        if ((cbSelectTeams.getValue()).equals("Team6")) {
            if ((team6.getPlayer1().equals(" "))) {
                team6.setPlayer1(cbPlayers.getValue());
            } else if ((team6.getPlayer2().equals(" "))) {
                team6.setPlayer2(cbPlayers.getValue());
            } else if ((team6.getPlayer3().equals(" "))) {
                team6.setPlayer3(cbPlayers.getValue());
            } else if ((team6.getPlayer4().equals(" "))) {
                team6.setPlayer4(cbPlayers.getValue());
            } else if ((team6.getPlayer5().equals(" "))) {
                team6.setPlayer5(cbPlayers.getValue());
            } else if ((team6.getPlayer6().equals(" "))) {
                team6.setPlayer6(cbPlayers.getValue());
            } else if ((team6.getPlayer7().equals(" "))) {
                team6.setPlayer7(cbPlayers.getValue());
            } else if ((team6.getPlayer8().equals(" "))) {
                team6.setPlayer8(cbPlayers.getValue());
            } else if ((team6.getPlayer9().equals(" "))) {
                team6.setPlayer9(cbPlayers.getValue());
            } else if ((team6.getPlayer10().equals(" "))) {
                team6.setPlayer10(cbPlayers.getValue());

            }
        }
        if ((cbSelectTeams.getValue()).equals("Team7")) {
            if ((team7.getPlayer1().equals(" "))) {
                team7.setPlayer1(cbPlayers.getValue());
            } else if ((team7.getPlayer2().equals(" "))) {
                team7.setPlayer2(cbPlayers.getValue());
            } else if ((team7.getPlayer3().equals(" "))) {
                team7.setPlayer3(cbPlayers.getValue());
            } else if ((team7.getPlayer4().equals(" "))) {
                team7.setPlayer4(cbPlayers.getValue());
            } else if ((team7.getPlayer5().equals(" "))) {
                team7.setPlayer5(cbPlayers.getValue());
            } else if ((team7.getPlayer6().equals(" "))) {
                team7.setPlayer6(cbPlayers.getValue());
            } else if ((team7.getPlayer7().equals(" "))) {
                team7.setPlayer7(cbPlayers.getValue());
            } else if ((team7.getPlayer8().equals(" "))) {
                team7.setPlayer8(cbPlayers.getValue());
            } else if ((team7.getPlayer9().equals(" "))) {
                team7.setPlayer9(cbPlayers.getValue());
            } else if ((team7.getPlayer10().equals(" "))) {
                team7.setPlayer10(cbPlayers.getValue());
            }

        }
        if ((cbSelectTeams.getValue()).equals("Team8")) {
            if ((team8.getPlayer1().equals(" "))) {
                team8.setPlayer1(cbPlayers.getValue());
            } else if ((team8.getPlayer2().equals(" "))) {
                team8.setPlayer2(cbPlayers.getValue());
            } else if ((team8.getPlayer3().equals(" "))) {
                team8.setPlayer3(cbPlayers.getValue());
            } else if ((team8.getPlayer4().equals(" "))) {
                team8.setPlayer4(cbPlayers.getValue());
            } else if ((team8.getPlayer5().equals(" "))) {
                team8.setPlayer5(cbPlayers.getValue());
            } else if ((team8.getPlayer6().equals(" "))) {
                team8.setPlayer6(cbPlayers.getValue());
            } else if ((team8.getPlayer7().equals(" "))) {
                team8.setPlayer7(cbPlayers.getValue());
            } else if ((team8.getPlayer8().equals(" "))) {
                team8.setPlayer8(cbPlayers.getValue());
            } else if ((team8.getPlayer9().equals(" "))) {
                team8.setPlayer9(cbPlayers.getValue());
            } else if ((team8.getPlayer10().equals(" "))) {
                team8.setPlayer10(cbPlayers.getValue());

            }
        }
        if ((cbSelectTeams.getValue()).equals("Team9")) {
            if ((team9.getPlayer1().equals(" "))) {
                team9.setPlayer1(cbPlayers.getValue());
            } else if ((team9.getPlayer2().equals(" "))) {
                team9.setPlayer2(cbPlayers.getValue());
            } else if ((team9.getPlayer3().equals(" "))) {
                team9.setPlayer3(cbPlayers.getValue());
            } else if ((team9.getPlayer4().equals(" "))) {
                team9.setPlayer4(cbPlayers.getValue());
            } else if ((team9.getPlayer5().equals(" "))) {
                team9.setPlayer5(cbPlayers.getValue());
            } else if ((team9.getPlayer6().equals(" "))) {
                team9.setPlayer6(cbPlayers.getValue());
            } else if ((team9.getPlayer7().equals(" "))) {
                team9.setPlayer7(cbPlayers.getValue());
            } else if ((team9.getPlayer8().equals(" "))) {
                team9.setPlayer8(cbPlayers.getValue());
            } else if ((team9.getPlayer9().equals(" "))) {
                team9.setPlayer9(cbPlayers.getValue());
            } else if ((team9.getPlayer10().equals(" "))) {
                team9.setPlayer10(cbPlayers.getValue());
            }
        }
        if ((cbSelectTeams.getValue()).equals("Team10")) {
            if ((team10.getPlayer1().equals(" "))) {
                team10.setPlayer1(cbPlayers.getValue());
            } else if ((team10.getPlayer2().equals(" "))) {
                team10.setPlayer2(cbPlayers.getValue());
            } else if ((team10.getPlayer3().equals(" "))) {
                team10.setPlayer3(cbPlayers.getValue());
            } else if ((team10.getPlayer4().equals(" "))) {
                team10.setPlayer4(cbPlayers.getValue());
            } else if ((team10.getPlayer5().equals(" "))) {
                team10.setPlayer5(cbPlayers.getValue());
            } else if ((team10.getPlayer6().equals(" "))) {
                team10.setPlayer6(cbPlayers.getValue());
            } else if ((team10.getPlayer7().equals(" "))) {
                team10.setPlayer7(cbPlayers.getValue());
            } else if ((team10.getPlayer8().equals(" "))) {
                team10.setPlayer8(cbPlayers.getValue());
            } else if ((team10.getPlayer9().equals(" "))) {
                team10.setPlayer9(cbPlayers.getValue());
            } else if ((team10.getPlayer10().equals(" "))) {
                team10.setPlayer10(cbPlayers.getValue());
            }
        }
        tblTeams.refresh();
    }

    /**
     * Removes the selected player on the selected team from the table
     */
    public void removePlayerFromTeam(ActionEvent event) {

        if ((cbRemoveTeam.getValue()).equals("Team1")) {
            if ((team1.getPlayer1().equals(cbRemovePlayer.getValue()))) {
                team1.setPlayer1(" ");
//                team1.removePlayerFromList(cbRemovePlayer.getValue());
            } else if ((team1.getPlayer2().equals(cbRemovePlayer.getValue()))) {
                team1.setPlayer2(" ");
//                team1.removePlayerFromList(cbRemovePlayer.getValue());
            } else if ((team1.getPlayer3().equals(cbRemovePlayer.getValue()))) {
                team1.setPlayer3(" ");
//                team1.removePlayerFromList(cbRemovePlayer.getValue());
            } else if ((team1.getPlayer4().equals(cbRemovePlayer.getValue()))) {
                team1.setPlayer4(" ");
//                team1.removePlayerFromList(cbRemovePlayer.getValue());
            } else if ((team1.getPlayer5().equals(cbRemovePlayer.getValue()))) {
                team1.setPlayer5(" ");
//                team1.removePlayerFromList(cbRemovePlayer.getValue());
            } else if ((team1.getPlayer6().equals(cbRemovePlayer.getValue()))) {
                team1.setPlayer6(" ");
//                team1.removePlayerFromList(cbRemovePlayer.getValue());
            } else if ((team1.getPlayer7().equals(cbRemovePlayer.getValue()))) {
                team1.setPlayer7(" ");
//                team1.removePlayerFromList(cbRemovePlayer.getValue());
            } else if ((team1.getPlayer8().equals(cbRemovePlayer.getValue()))) {
                team1.setPlayer8(" ");
//                team1.removePlayerFromList(cbRemovePlayer.getValue());
            } else if ((team1.getPlayer9().equals(cbRemovePlayer.getValue()))) {
                team1.setPlayer9(" ");
//                team1.removePlayerFromList(cbRemovePlayer.getValue());
            } else if ((team1.getPlayer10().equals(cbRemovePlayer.getValue()))) {
                team1.setPlayer10(" ");
//                team1.removePlayerFromList(cbRemovePlayer.getValue());
            }
        }
        if ((cbRemoveTeam.getValue()).equals("Team2")) {
            if ((team2.getPlayer1().equals(cbRemovePlayer.getValue()))) {
                team2.setPlayer1(" ");
            } else if ((team2.getPlayer2().equals(cbRemovePlayer.getValue()))) {
                team2.setPlayer2(" ");
            } else if ((team2.getPlayer3().equals(cbRemovePlayer.getValue()))) {
                team2.setPlayer3(" ");
            } else if ((team2.getPlayer4().equals(cbRemovePlayer.getValue()))) {
                team2.setPlayer4(" ");
            } else if ((team2.getPlayer5().equals(cbRemovePlayer.getValue()))) {
                team2.setPlayer5(" ");
            } else if ((team2.getPlayer6().equals(cbRemovePlayer.getValue()))) {
                team2.setPlayer6(" ");
            } else if ((team2.getPlayer7().equals(cbRemovePlayer.getValue()))) {
                team2.setPlayer7(" ");
            } else if ((team2.getPlayer8().equals(cbRemovePlayer.getValue()))) {
                team2.setPlayer8(" ");
            } else if ((team2.getPlayer9().equals(cbRemovePlayer.getValue()))) {
                team2.setPlayer9(" ");
            } else if ((team2.getPlayer10().equals(cbRemovePlayer.getValue()))) {
                team2.setPlayer10(" ");
            }
        }
        if ((cbRemoveTeam.getValue()).equals("Team3")) {
            if ((team3.getPlayer1().equals(cbRemovePlayer.getValue()))) {
                team3.setPlayer1(" ");
            } else if ((team3.getPlayer2().equals(cbRemovePlayer.getValue()))) {
                team3.setPlayer2(" ");
            } else if ((team3.getPlayer3().equals(cbRemovePlayer.getValue()))) {
                team3.setPlayer3(" ");
            } else if ((team3.getPlayer4().equals(cbRemovePlayer.getValue()))) {
                team3.setPlayer4(" ");
            } else if ((team3.getPlayer5().equals(cbRemovePlayer.getValue()))) {
                team3.setPlayer5(" ");
            } else if ((team3.getPlayer6().equals(cbRemovePlayer.getValue()))) {
                team3.setPlayer6(" ");
            } else if ((team3.getPlayer7().equals(cbRemovePlayer.getValue()))) {
                team3.setPlayer7(" ");
            } else if ((team3.getPlayer8().equals(cbRemovePlayer.getValue()))) {
                team3.setPlayer8(" ");
            } else if ((team3.getPlayer9().equals(cbRemovePlayer.getValue()))) {
                team3.setPlayer9(" ");
            } else if ((team3.getPlayer10().equals(cbRemovePlayer.getValue()))) {
                team3.setPlayer10(" ");
            }
        }
        if ((cbRemoveTeam.getValue()).equals("Team4")) {
            if ((team4.getPlayer1().equals(cbRemovePlayer.getValue()))) {
                team4.setPlayer1(" ");
            } else if ((team4.getPlayer2().equals(cbRemovePlayer.getValue()))) {
                team4.setPlayer2(" ");
            } else if ((team4.getPlayer3().equals(cbRemovePlayer.getValue()))) {
                team4.setPlayer3(" ");
            } else if ((team4.getPlayer4().equals(cbRemovePlayer.getValue()))) {
                team4.setPlayer4(" ");
            } else if ((team4.getPlayer5().equals(cbRemovePlayer.getValue()))) {
                team4.setPlayer5(" ");
            } else if ((team4.getPlayer6().equals(cbRemovePlayer.getValue()))) {
                team4.setPlayer6(" ");
            } else if ((team4.getPlayer7().equals(cbRemovePlayer.getValue()))) {
                team4.setPlayer7(" ");
            } else if ((team4.getPlayer8().equals(cbRemovePlayer.getValue()))) {
                team4.setPlayer8(" ");
            } else if ((team4.getPlayer9().equals(cbRemovePlayer.getValue()))) {
                team4.setPlayer9(" ");
            } else if ((team4.getPlayer10().equals(cbRemovePlayer.getValue()))) {
                team4.setPlayer10(" ");
            }
        }
        if ((cbRemoveTeam.getValue()).equals("Team5")) {
            if ((team5.getPlayer1().equals(cbRemovePlayer.getValue()))) {
                team5.setPlayer1(" ");
            } else if ((team5.getPlayer2().equals(cbRemovePlayer.getValue()))) {
                team5.setPlayer2(" ");
            } else if ((team5.getPlayer3().equals(cbRemovePlayer.getValue()))) {
                team5.setPlayer3(" ");
            } else if ((team5.getPlayer4().equals(cbRemovePlayer.getValue()))) {
                team5.setPlayer4(" ");
            } else if ((team5.getPlayer5().equals(cbRemovePlayer.getValue()))) {
                team5.setPlayer5(" ");
            } else if ((team5.getPlayer6().equals(cbRemovePlayer.getValue()))) {
                team5.setPlayer6(" ");
            } else if ((team5.getPlayer7().equals(cbRemovePlayer.getValue()))) {
                team5.setPlayer7(" ");
            } else if ((team5.getPlayer8().equals(cbRemovePlayer.getValue()))) {
                team5.setPlayer8(" ");
            } else if ((team5.getPlayer9().equals(cbRemovePlayer.getValue()))) {
                team5.setPlayer9(" ");
            } else if ((team5.getPlayer10().equals(cbRemovePlayer.getValue()))) {
                team5.setPlayer10(" ");
            }
        }
        if ((cbRemoveTeam.getValue()).equals("Team6")) {
            if ((team6.getPlayer1().equals(cbRemovePlayer.getValue()))) {
                team6.setPlayer1(" ");
            } else if ((team6.getPlayer2().equals(cbRemovePlayer.getValue()))) {
                team6.setPlayer2(" ");
            } else if ((team6.getPlayer3().equals(cbRemovePlayer.getValue()))) {
                team6.setPlayer3(" ");
            } else if ((team6.getPlayer4().equals(cbRemovePlayer.getValue()))) {
                team6.setPlayer4(" ");
            } else if ((team6.getPlayer5().equals(cbRemovePlayer.getValue()))) {
                team6.setPlayer5(" ");
            } else if ((team6.getPlayer6().equals(cbRemovePlayer.getValue()))) {
                team6.setPlayer6(" ");
            } else if ((team6.getPlayer7().equals(cbRemovePlayer.getValue()))) {
                team6.setPlayer7(" ");
            } else if ((team6.getPlayer8().equals(cbRemovePlayer.getValue()))) {
                team6.setPlayer8(" ");
            } else if ((team6.getPlayer9().equals(cbRemovePlayer.getValue()))) {
                team6.setPlayer9(" ");
            } else if ((team6.getPlayer10().equals(cbRemovePlayer.getValue()))) {
                team6.setPlayer10(" ");
            }
        }
        if ((cbRemoveTeam.getValue()).equals("Team7")) {
            if ((team7.getPlayer1().equals(cbRemovePlayer.getValue()))) {
                team7.setPlayer1(" ");
            } else if ((team7.getPlayer2().equals(cbRemovePlayer.getValue()))) {
                team7.setPlayer2(" ");
            } else if ((team7.getPlayer3().equals(cbRemovePlayer.getValue()))) {
                team7.setPlayer3(" ");
            } else if ((team7.getPlayer4().equals(cbRemovePlayer.getValue()))) {
                team7.setPlayer4(" ");
            } else if ((team7.getPlayer5().equals(cbRemovePlayer.getValue()))) {
                team7.setPlayer5(" ");
            } else if ((team7.getPlayer6().equals(cbRemovePlayer.getValue()))) {
                team7.setPlayer6(" ");
            } else if ((team7.getPlayer7().equals(cbRemovePlayer.getValue()))) {
                team7.setPlayer7(" ");
            } else if ((team7.getPlayer8().equals(cbRemovePlayer.getValue()))) {
                team7.setPlayer8(" ");
            } else if ((team7.getPlayer9().equals(cbRemovePlayer.getValue()))) {
                team7.setPlayer9(" ");
            } else if ((team7.getPlayer10().equals(cbRemovePlayer.getValue()))) {
                team7.setPlayer10(" ");
            }
        }
        if ((cbRemoveTeam.getValue()).equals("Team8")) {
            if ((team8.getPlayer1().equals(cbRemovePlayer.getValue()))) {
                team8.setPlayer1(" ");
            } else if ((team8.getPlayer2().equals(cbRemovePlayer.getValue()))) {
                team8.setPlayer2(" ");
            } else if ((team8.getPlayer3().equals(cbRemovePlayer.getValue()))) {
                team8.setPlayer3(" ");
            } else if ((team8.getPlayer4().equals(cbRemovePlayer.getValue()))) {
                team8.setPlayer4(" ");
            } else if ((team8.getPlayer5().equals(cbRemovePlayer.getValue()))) {
                team8.setPlayer5(" ");
            } else if ((team8.getPlayer6().equals(cbRemovePlayer.getValue()))) {
                team8.setPlayer6(" ");
            } else if ((team8.getPlayer7().equals(cbRemovePlayer.getValue()))) {
                team8.setPlayer7(" ");
            } else if ((team8.getPlayer8().equals(cbRemovePlayer.getValue()))) {
                team8.setPlayer8(" ");
            } else if ((team8.getPlayer9().equals(cbRemovePlayer.getValue()))) {
                team8.setPlayer9(" ");
            } else if ((team8.getPlayer10().equals(cbRemovePlayer.getValue()))) {
                team8.setPlayer10(" ");
            }
        }
        if ((cbRemoveTeam.getValue()).equals("Team9")) {
            if ((team9.getPlayer1().equals(cbRemovePlayer.getValue()))) {
                team9.setPlayer1(" ");
            } else if ((team9.getPlayer2().equals(cbRemovePlayer.getValue()))) {
                team9.setPlayer2(" ");
            } else if ((team9.getPlayer3().equals(cbRemovePlayer.getValue()))) {
                team9.setPlayer3(" ");
            } else if ((team9.getPlayer4().equals(cbRemovePlayer.getValue()))) {
                team9.setPlayer4(" ");
            } else if ((team9.getPlayer5().equals(cbRemovePlayer.getValue()))) {
                team9.setPlayer5(" ");
            } else if ((team9.getPlayer6().equals(cbRemovePlayer.getValue()))) {
                team9.setPlayer6(" ");
            } else if ((team9.getPlayer7().equals(cbRemovePlayer.getValue()))) {
                team9.setPlayer7(" ");
            } else if ((team9.getPlayer8().equals(cbRemovePlayer.getValue()))) {
                team9.setPlayer8(" ");
            } else if ((team9.getPlayer9().equals(cbRemovePlayer.getValue()))) {
                team9.setPlayer9(" ");
            } else if ((team9.getPlayer10().equals(cbRemovePlayer.getValue()))) {
                team9.setPlayer10(" ");
            }
        }
        if ((cbRemoveTeam.getValue()).equals("Team10")) {
            if ((team10.getPlayer1().equals(cbRemovePlayer.getValue()))) {
                team10.setPlayer1(" ");
            } else if ((team10.getPlayer2().equals(cbRemovePlayer.getValue()))) {
                team10.setPlayer2(" ");
            } else if ((team10.getPlayer3().equals(cbRemovePlayer.getValue()))) {
                team10.setPlayer3(" ");
            } else if ((team10.getPlayer4().equals(cbRemovePlayer.getValue()))) {
                team10.setPlayer4(" ");
            } else if ((team10.getPlayer5().equals(cbRemovePlayer.getValue()))) {
                team10.setPlayer5(" ");
            } else if ((team10.getPlayer6().equals(cbRemovePlayer.getValue()))) {
                team10.setPlayer6(" ");
            } else if ((team10.getPlayer7().equals(cbRemovePlayer.getValue()))) {
                team10.setPlayer7(" ");
            } else if ((team10.getPlayer8().equals(cbRemovePlayer.getValue()))) {
                team10.setPlayer8(" ");
            } else if ((team10.getPlayer9().equals(cbRemovePlayer.getValue()))) {
                team10.setPlayer9(" ");
            } else if ((team10.getPlayer10().equals(cbRemovePlayer.getValue()))) {
                team10.setPlayer10(" ");
            }
        }
        tblTeams.refresh();
        selectPlayersToRemove();
    }

    /**
     * Randomizes the listed players in to different teams
     */
    public void randomTeams() {
        while (playersBuffer.size() != 0) {

            Random random = new Random();
            int randomPlayer = -1;
            int randomTeam = 1;

            randomPlayer = random.nextInt(playersBuffer.size());
            
            switch (cbTeams.getSelectionModel().getSelectedItem()) {
                case Three:
                    randomTeam += random.nextInt(3);
                    break;
                case Four:
                    randomTeam += random.nextInt(4);
                    break;
                case Five:
                    randomTeam += random.nextInt(5);
                    break;
                case Six:
                    randomTeam += random.nextInt(6);
                    break;
                case Seven:
                    randomTeam += random.nextInt(7);
                    break;
                case Eight:
                    randomTeam += random.nextInt(8);
                    break;
                case Nine:
                    randomTeam += random.nextInt(9);
                    break;
                case Ten:
                    randomTeam += random.nextInt(10);
                    break;
            }
            if (randomTeam == 1) {
                if ((team1.getPlayer1().equals(" "))) {
                    team1.setPlayer1((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team1.getPlayer2().equals(" "))) {
                    team1.setPlayer2((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team1.getPlayer3().equals(" "))) {
                    team1.setPlayer3((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team1.getPlayer4().equals(" "))) {
                    team1.setPlayer4((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team1.getPlayer5().equals(" "))) {
                    team1.setPlayer5((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team1.getPlayer6().equals(" "))) {
                    team1.setPlayer6((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team1.getPlayer7().equals(" "))) {
                    team1.setPlayer7((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team1.getPlayer8().equals(" "))) {
                    team1.setPlayer8((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team1.getPlayer9().equals(" "))) {
                    team1.setPlayer9((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team1.getPlayer10().equals(" "))) {
                    team1.setPlayer10((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                }
            }
            if (randomTeam == 2) {
                if ((team2.getPlayer1().equals(" "))) {
                    team2.setPlayer1((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team2.getPlayer2().equals(" "))) {
                    team2.setPlayer2((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team2.getPlayer3().equals(" "))) {
                    team2.setPlayer3((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team2.getPlayer4().equals(" "))) {
                    team2.setPlayer4((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team2.getPlayer5().equals(" "))) {
                    team2.setPlayer5((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team2.getPlayer6().equals(" "))) {
                    team2.setPlayer6((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team2.getPlayer7().equals(" "))) {
                    team2.setPlayer7((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team2.getPlayer8().equals(" "))) {
                    team2.setPlayer8((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team2.getPlayer9().equals(" "))) {
                    team2.setPlayer9((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team2.getPlayer10().equals(" "))) {
                    team2.setPlayer10((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                }
            }
            if (randomTeam == 3) {
                if ((team3.getPlayer1().equals(" "))) {
                    team3.setPlayer1((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team3.getPlayer2().equals(" "))) {
                    team3.setPlayer2((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team3.getPlayer3().equals(" "))) {
                    team3.setPlayer3((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team3.getPlayer4().equals(" "))) {
                    team3.setPlayer4((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team3.getPlayer5().equals(" "))) {
                    team3.setPlayer5((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team3.getPlayer6().equals(" "))) {
                    team3.setPlayer6((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team3.getPlayer7().equals(" "))) {
                    team3.setPlayer7((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team3.getPlayer8().equals(" "))) {
                    team3.setPlayer8((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team3.getPlayer9().equals(" "))) {
                    team3.setPlayer9((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team3.getPlayer10().equals(" "))) {
                    team3.setPlayer10((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                }
            }
            if (randomTeam == 4) {
                if ((team4.getPlayer1().equals(" "))) {
                    team4.setPlayer1((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team4.getPlayer2().equals(" "))) {
                    team4.setPlayer2((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team4.getPlayer3().equals(" "))) {
                    team4.setPlayer3((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team4.getPlayer4().equals(" "))) {
                    team4.setPlayer4((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team4.getPlayer5().equals(" "))) {
                    team4.setPlayer5((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team4.getPlayer6().equals(" "))) {
                    team4.setPlayer6((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team4.getPlayer7().equals(" "))) {
                    team4.setPlayer7((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team4.getPlayer8().equals(" "))) {
                    team4.setPlayer8((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team4.getPlayer9().equals(" "))) {
                    team4.setPlayer9((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team4.getPlayer10().equals(" "))) {
                    team4.setPlayer10((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                }
            }
            if (randomTeam == 5) {
                if ((team5.getPlayer1().equals(" "))) {
                    team5.setPlayer1((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team5.getPlayer2().equals(" "))) {
                    team5.setPlayer2((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team5.getPlayer3().equals(" "))) {
                    team5.setPlayer3((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team5.getPlayer4().equals(" "))) {
                    team5.setPlayer4((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team5.getPlayer5().equals(" "))) {
                    team5.setPlayer5((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team5.getPlayer6().equals(" "))) {
                    team5.setPlayer6((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team5.getPlayer7().equals(" "))) {
                    team5.setPlayer7((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team5.getPlayer8().equals(" "))) {
                    team5.setPlayer8((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team5.getPlayer9().equals(" "))) {
                    team5.setPlayer9((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team5.getPlayer10().equals(" "))) {
                    team5.setPlayer10((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                }
            }
            if (randomTeam == 6) {
                if ((team6.getPlayer1().equals(" "))) {
                    team6.setPlayer1((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team6.getPlayer2().equals(" "))) {
                    team6.setPlayer2((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team6.getPlayer3().equals(" "))) {
                    team6.setPlayer3((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team6.getPlayer4().equals(" "))) {
                    team6.setPlayer4((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team6.getPlayer5().equals(" "))) {
                    team6.setPlayer5((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team6.getPlayer6().equals(" "))) {
                    team6.setPlayer6((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team6.getPlayer7().equals(" "))) {
                    team6.setPlayer7((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team6.getPlayer8().equals(" "))) {
                    team6.setPlayer8((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team6.getPlayer9().equals(" "))) {
                    team6.setPlayer9((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team6.getPlayer10().equals(" "))) {
                    team6.setPlayer10((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                }
            }
            if (randomTeam == 7) {
                if ((team7.getPlayer1().equals(" "))) {
                    team7.setPlayer1((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team7.getPlayer2().equals(" "))) {
                    team7.setPlayer2((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team7.getPlayer3().equals(" "))) {
                    team7.setPlayer3((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team7.getPlayer4().equals(" "))) {
                    team7.setPlayer4((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team7.getPlayer5().equals(" "))) {
                    team7.setPlayer5((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team7.getPlayer6().equals(" "))) {
                    team7.setPlayer6((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team7.getPlayer7().equals(" "))) {
                    team7.setPlayer7((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team7.getPlayer8().equals(" "))) {
                    team7.setPlayer8((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team7.getPlayer9().equals(" "))) {
                    team7.setPlayer9((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team7.getPlayer10().equals(" "))) {
                    team7.setPlayer10((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                }
            }
            if (randomTeam == 8) {
                if ((team8.getPlayer1().equals(" "))) {
                    team8.setPlayer1((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team8.getPlayer2().equals(" "))) {
                    team8.setPlayer2((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team8.getPlayer3().equals(" "))) {
                    team8.setPlayer3((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team8.getPlayer4().equals(" "))) {
                    team8.setPlayer4((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team8.getPlayer5().equals(" "))) {
                    team8.setPlayer5((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team8.getPlayer6().equals(" "))) {
                    team8.setPlayer6((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team8.getPlayer7().equals(" "))) {
                    team8.setPlayer7((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team8.getPlayer8().equals(" "))) {
                    team8.setPlayer8((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team8.getPlayer9().equals(" "))) {
                    team8.setPlayer9((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team8.getPlayer10().equals(" "))) {
                    team8.setPlayer10((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                }
            }
            if (randomTeam == 9) {
                if ((team9.getPlayer1().equals(" "))) {
                    team9.setPlayer1((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team9.getPlayer2().equals(" "))) {
                    team9.setPlayer2((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team9.getPlayer3().equals(" "))) {
                    team9.setPlayer3((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team9.getPlayer4().equals(" "))) {
                    team9.setPlayer4((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team9.getPlayer5().equals(" "))) {
                    team9.setPlayer5((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team9.getPlayer6().equals(" "))) {
                    team9.setPlayer6((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team9.getPlayer7().equals(" "))) {
                    team9.setPlayer7((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team9.getPlayer8().equals(" "))) {
                    team9.setPlayer8((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team9.getPlayer9().equals(" "))) {
                    team9.setPlayer9((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team9.getPlayer10().equals(" "))) {
                    team9.setPlayer10((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                }
            }
            if (randomTeam == 10) {
                if ((team10.getPlayer1().equals(" "))) {
                    team10.setPlayer1((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team10.getPlayer2().equals(" "))) {
                    team10.setPlayer2((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team10.getPlayer3().equals(" "))) {
                    team10.setPlayer3((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team10.getPlayer4().equals(" "))) {
                    team10.setPlayer4((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team10.getPlayer5().equals(" "))) {
                    team10.setPlayer5((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team10.getPlayer6().equals(" "))) {
                    team10.setPlayer6((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team10.getPlayer7().equals(" "))) {
                    team10.setPlayer7((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team10.getPlayer8().equals(" "))) {
                    team10.setPlayer8((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team10.getPlayer9().equals(" "))) {
                    team10.setPlayer9((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                } else if ((team10.getPlayer10().equals(" "))) {
                    team10.setPlayer10((playersBuffer.get(randomPlayer)).getName());
                    playersBuffer.remove(randomPlayer);
                }
            }
            tblTeams.refresh();
        }
    }

    public void loadBuffer() {
        playersBuffer = mainController.getPlayers();
    }
}
