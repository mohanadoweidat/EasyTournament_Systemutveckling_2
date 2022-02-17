package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import model.AmountOfTeams;
import model.Player;
import model.Team;
import view.InfoMessages;

import java.io.*;
import java.util.*;

/**
 * Connects the Team fxml-file with the ret of the system
 * @author Andreas von Uthmann, Carl Hägred
 */

public class TeamController extends SceneControllerParent {

    private AmountOfTeams amountOfTeams;
    @FXML
    private TableView<Team> tblTeams = new TableView<>();
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


    public ComboBox<String> getCbPlayers()
    {
        return cbPlayers;
    }

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

    private int amountOfTeamsInInt = 0;

    private Random random = new Random();

    private ObservableList<String> tableContent = FXCollections.observableArrayList();

    private Team team1;
    private Team team2;
    private Team team3;
    private Team team4;
    private Team team5;
    private Team team6;
    private Team team7;
    private Team team8;
    private Team team9;
    private Team team10;

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
    private ArrayList<Team> teamsBuffer = new ArrayList();
    private int teams = 0;

    private InfoMessages infoMessages;

    public TeamController()
    {
        infoMessages = new InfoMessages();
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
        List<Team> teams = (tblTeams.getItems());
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Choose location To Save Report");

        File selectedFile = null;
        if (selectedFile == null) {
            selectedFile = chooser.showSaveDialog(null);
        }

        PrintWriter outFile = null;
        try {
            if(selectedFile == null)
            {
              return;
            }
            else{
                outFile = new PrintWriter(selectedFile + ".txt");
                for (Team team : teams) {
                    outFile.print(team.getName() + ",");
                    outFile.print(team.getPlayer1() + ",");
                    outFile.print(team.getPlayer2() + ",");
                    outFile.print(team.getPlayer3() + ",");
                    outFile.print(team.getPlayer4() + ",");
                    outFile.print(team.getPlayer5() + ",");
                    outFile.print(team.getPlayer6() + ",");
                    outFile.print(team.getPlayer7() + ",");
                    outFile.print(team.getPlayer8() + ",");
                    outFile.print(team.getPlayer9() + ",");
                    outFile.print(team.getPlayer10() + ",");
                    outFile.print(team.getPoints() + ",");
                    outFile.print(team.getDraws() + ",");
                    outFile.print(team.getWins() + ",");
                    outFile.print(team.getLosses() + ",");
                    outFile.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        outFile.close();
    }

    /**
     * Reads teams from a file
     */
    public void importTeams() {
        teamsBuffer.clear();
        ObservableList<Team> dataTable = FXCollections.observableArrayList();
        FileChooser chooser1 = new FileChooser();
        File file = chooser1.showOpenDialog(null);
        try {
            BufferedReader in;
            if (file != null){
            in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
            String[] team;
            while (line != null) {
                team = line.split(",");
                dataTable.add(
                        new Team(team[0],team[1],team[2],team[3],team[4],
                                team[5],team[6],team[7],team[8],team[9],team[10],
                                Integer.parseInt(team[11]),Integer.parseInt(team[12]),
                                Integer.parseInt(team[13]),Integer.parseInt(team[14])));
                mainController.addTeam(
                        new Team(team[0],team[1],team[2],team[3],team[4],
                                team[5],team[6],team[7],team[8],team[9],team[10],
                                Integer.parseInt(team[11]),Integer.parseInt(team[12]),
                                Integer.parseInt(team[13]),Integer.parseInt(team[14])));
                line = in.readLine();
            }
            }
            tblTeams.setItems(dataTable);
            tblTeams.refresh();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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

    public void loadTeams() {
        try  {
            team1 = mainController.getTeam(0);
        } catch(Exception e) {
            team1 = new Team();
        }
        try  {
            team2 = mainController.getTeam(1);
        } catch(Exception e) {
            team2 = new Team();
        }
        try  {
            team3 = mainController.getTeam(2);
        } catch(Exception e) {
            team3 = new Team();
        }
        try  {
            team4 = mainController.getTeam(3);
        } catch(Exception e) {
            team4 = new Team();
        }
        try  {
            team5 = mainController.getTeam(4);
        } catch(Exception e) {
            team5 = new Team();
        }
        try  {
            team6 = mainController.getTeam(5);
        } catch(Exception e) {
            team6 = new Team();
        }
        try  {
            team7 = mainController.getTeam(6);
        } catch(Exception e) {
            team7 = new Team();
        }
        try  {
            team8 = mainController.getTeam(7);
        } catch(Exception e) {
            team8 = new Team();
        }
        try  {
            team9 = mainController.getTeam(8);
        } catch(Exception e) {
            team9 = new Team();
        }
        try  {
            team10 = mainController.getTeam(9);
        } catch(Exception e) {
            team10 = new Team();
        }
    }
    public void loadPlayers(){
        for (Player p : mainController.getPlayers()) {
            cbPlayers.getItems().add(p.getName());
        }
    }



    /**
     * Chooses the amount of columns and rows for the teams and players depending on which is choosen in the ChoiceBox
     */
    @FXML
    private void initTeamsTableData(ActionEvent event) {
        if (tblTeams.getItems().size() <= 0){
            loadTeams();
            loadPlayers();
        try {
            tblTeams.getItems().removeAll(observablePlayers);
            tblTeams.getColumns().removeAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
            switch (cbTeams.getSelectionModel().getSelectedItem()) {
                case Three:
                    amountOfTeamsInInt = 3;
                    tblTeams.getColumns().addAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
                    tblTeams.setItems(addPlayersToTeams());
                    cbSelectTeams.getItems().addAll("Team1", "Team2", "Team3");
                    cbRemoveTeam.getItems().addAll("Team1", "Team2", "Team3");
                    cbPlacingOnTable.getItems().addAll("Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Four:
                    amountOfTeamsInInt = 4;
                    tblTeams.getColumns().addAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
                    tblTeams.setItems(addPlayersToTeams());
                    cbSelectTeams.getItems().addAll("Team1", "Team2", "Team3", "Team4");
                    cbRemoveTeam.getItems().addAll("Team1", "Team2", "Team3", "Team4");
                    cbPlacingOnTable.getItems().addAll("Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Five:
                    amountOfTeamsInInt = 5;
                    tblTeams.getColumns().addAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
                    tblTeams.setItems(addPlayersToTeams());
                    cbSelectTeams.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5");
                    cbRemoveTeam.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5");
                    cbPlacingOnTable.getItems().addAll("Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Six:
                    amountOfTeamsInInt = 6;
                    tblTeams.getColumns().addAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
                    tblTeams.setItems(addPlayersToTeams());
                    cbSelectTeams.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6");
                    cbRemoveTeam.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6");
                    cbPlacingOnTable.getItems().addAll("Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Seven:
                    amountOfTeamsInInt = 7;
                    tblTeams.getColumns().addAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
                    tblTeams.setItems(addPlayersToTeams());
                    cbSelectTeams.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7");
                    cbRemoveTeam.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7");
                    cbPlacingOnTable.getItems().addAll("Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Eight:
                    amountOfTeamsInInt = 8;
                    tblTeams.getColumns().addAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
                    tblTeams.setItems(addPlayersToTeams());
                    cbSelectTeams.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7", "Team8");
                    cbRemoveTeam.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7", "Team8");
                    cbPlacingOnTable.getItems().addAll("Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Nine:
                    amountOfTeamsInInt = 9;
                    tblTeams.getColumns().addAll(columnTeam, columnPlayer1, columnPlayer2, columnPlayer3, columnPlayer4, columnPlayer5, columnPlayer6, columnPlayer7, columnPlayer8, columnPlayer9, columnPlayer10);
                    tblTeams.setItems(addPlayersToTeams());
                    cbSelectTeams.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7", "Team8", "Team9");
                    cbRemoveTeam.getItems().addAll("Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7", "Team8", "Team9");
                    cbPlacingOnTable.getItems().addAll("Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10");
                    break;
                case Ten:
                    amountOfTeamsInInt = 10;
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
    public void addPlayersToTeams(ActionEvent event)
    {
            if (cbSelectTeams.getValue() != null && cbPlayers.getValue() != null)
            {
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
                cbPlayers.getItems().remove(cbPlayers.getValue());
                tblTeams.refresh();
            }
            else
            {
                infoMessages.pickTeamAndPlayerMessage();
            }
    }

    /**
     * Removes the selected player on the selected team from the table
     */
    public void removePlayerFromTeam(ActionEvent event) {
        if(cbRemoveTeam.getItems().size() > 0 && cbRemovePlayer.getItems().size() > 0) {
            if (cbRemoveTeam.getValue() != null && cbRemovePlayer.getValue() != null) {
                if ((cbRemoveTeam.getValue()).equals("Team1")) {
                    if ((team1.getPlayer1().equals(cbRemovePlayer.getValue()))) {
                        team1.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team1.setPlayer1(" ");
                    } else if ((team1.getPlayer2().equals(cbRemovePlayer.getValue()))) {
                        team1.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team1.setPlayer2(" ");
                    } else if ((team1.getPlayer3().equals(cbRemovePlayer.getValue()))) {
                        team1.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team1.setPlayer3(" ");
                    } else if ((team1.getPlayer4().equals(cbRemovePlayer.getValue()))) {
                        team1.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team1.setPlayer4(" ");
                    } else if ((team1.getPlayer5().equals(cbRemovePlayer.getValue()))) {
                        team1.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team1.setPlayer5(" ");
                    } else if ((team1.getPlayer6().equals(cbRemovePlayer.getValue()))) {
                        team1.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team1.setPlayer6(" ");
                    } else if ((team1.getPlayer7().equals(cbRemovePlayer.getValue()))) {
                        team1.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team1.setPlayer7(" ");
                    } else if ((team1.getPlayer8().equals(cbRemovePlayer.getValue()))) {
                        team1.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team1.setPlayer8(" ");
                    } else if ((team1.getPlayer9().equals(cbRemovePlayer.getValue()))) {
                        team1.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team1.setPlayer9(" ");
                    } else if ((team1.getPlayer10().equals(cbRemovePlayer.getValue()))) {
                        team1.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team1.setPlayer10(" ");
                    }
                }
                if ((cbRemoveTeam.getValue()).equals("Team2")) {
                    if ((team2.getPlayer1().equals(cbRemovePlayer.getValue()))) {
                        team2.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team2.setPlayer1(" ");
                    } else if ((team2.getPlayer2().equals(cbRemovePlayer.getValue()))) {
                        team2.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team2.setPlayer2(" ");
                    } else if ((team2.getPlayer3().equals(cbRemovePlayer.getValue()))) {
                        team2.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team2.setPlayer3(" ");
                    } else if ((team2.getPlayer4().equals(cbRemovePlayer.getValue()))) {
                        team2.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team2.setPlayer4(" ");
                    } else if ((team2.getPlayer5().equals(cbRemovePlayer.getValue()))) {
                        team2.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team2.setPlayer5(" ");
                    } else if ((team2.getPlayer6().equals(cbRemovePlayer.getValue()))) {
                        team2.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team2.setPlayer6(" ");
                    } else if ((team2.getPlayer7().equals(cbRemovePlayer.getValue()))) {
                        team2.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team2.setPlayer7(" ");
                    } else if ((team2.getPlayer8().equals(cbRemovePlayer.getValue()))) {
                        team2.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team2.setPlayer8(" ");
                    } else if ((team2.getPlayer9().equals(cbRemovePlayer.getValue()))) {
                        team2.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team2.setPlayer9(" ");
                    } else if ((team2.getPlayer10().equals(cbRemovePlayer.getValue()))) {
                        team2.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team2.setPlayer10(" ");
                    }
                }
                if ((cbRemoveTeam.getValue()).equals("Team3")) {
                    if ((team3.getPlayer1().equals(cbRemovePlayer.getValue()))) {
                        team3.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team3.setPlayer1(" ");
                    } else if ((team3.getPlayer2().equals(cbRemovePlayer.getValue()))) {
                        team3.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team3.setPlayer2(" ");
                    } else if ((team3.getPlayer3().equals(cbRemovePlayer.getValue()))) {
                        team3.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team3.setPlayer3(" ");
                    } else if ((team3.getPlayer4().equals(cbRemovePlayer.getValue()))) {
                        team3.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team3.setPlayer4(" ");
                    } else if ((team3.getPlayer5().equals(cbRemovePlayer.getValue()))) {
                        team3.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team3.setPlayer5(" ");
                    } else if ((team3.getPlayer6().equals(cbRemovePlayer.getValue()))) {
                        team3.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team3.setPlayer6(" ");
                    } else if ((team3.getPlayer7().equals(cbRemovePlayer.getValue()))) {
                        team3.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team3.setPlayer7(" ");
                    } else if ((team3.getPlayer8().equals(cbRemovePlayer.getValue()))) {
                        team3.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team3.setPlayer8(" ");
                    } else if ((team3.getPlayer9().equals(cbRemovePlayer.getValue()))) {
                        team3.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team3.setPlayer9(" ");
                    } else if ((team3.getPlayer10().equals(cbRemovePlayer.getValue()))) {
                        team3.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team3.setPlayer10(" ");
                    }
                }
                if ((cbRemoveTeam.getValue()).equals("Team4")) {
                    if ((team4.getPlayer1().equals(cbRemovePlayer.getValue()))) {
                        team4.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team4.setPlayer1(" ");
                    } else if ((team4.getPlayer2().equals(cbRemovePlayer.getValue()))) {
                        team4.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team4.setPlayer2(" ");
                    } else if ((team4.getPlayer3().equals(cbRemovePlayer.getValue()))) {
                        team4.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team4.setPlayer3(" ");
                    } else if ((team4.getPlayer4().equals(cbRemovePlayer.getValue()))) {
                        team4.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team4.setPlayer4(" ");
                    } else if ((team4.getPlayer5().equals(cbRemovePlayer.getValue()))) {
                        team4.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team4.setPlayer5(" ");
                    } else if ((team4.getPlayer6().equals(cbRemovePlayer.getValue()))) {
                        team4.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team4.setPlayer6(" ");
                    } else if ((team4.getPlayer7().equals(cbRemovePlayer.getValue()))) {
                        team4.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team4.setPlayer7(" ");
                    } else if ((team4.getPlayer8().equals(cbRemovePlayer.getValue()))) {
                        team4.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team4.setPlayer8(" ");
                    } else if ((team4.getPlayer9().equals(cbRemovePlayer.getValue()))) {
                        team4.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team4.setPlayer9(" ");
                    } else if ((team4.getPlayer10().equals(cbRemovePlayer.getValue()))) {
                        team4.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team4.setPlayer10(" ");
                    }
                }
                if ((cbRemoveTeam.getValue()).equals("Team5")) {
                    if ((team5.getPlayer1().equals(cbRemovePlayer.getValue()))) {
                        team5.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team5.setPlayer1(" ");
                    } else if ((team5.getPlayer2().equals(cbRemovePlayer.getValue()))) {
                        team5.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team5.setPlayer2(" ");
                    } else if ((team5.getPlayer3().equals(cbRemovePlayer.getValue()))) {
                        team5.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team5.setPlayer3(" ");
                    } else if ((team5.getPlayer4().equals(cbRemovePlayer.getValue()))) {
                        team5.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team5.setPlayer4(" ");
                    } else if ((team5.getPlayer5().equals(cbRemovePlayer.getValue()))) {
                        team5.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team5.setPlayer5(" ");
                    } else if ((team5.getPlayer6().equals(cbRemovePlayer.getValue()))) {
                        team5.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team5.setPlayer6(" ");
                    } else if ((team5.getPlayer7().equals(cbRemovePlayer.getValue()))) {
                        team5.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team5.setPlayer7(" ");
                    } else if ((team5.getPlayer8().equals(cbRemovePlayer.getValue()))) {
                        team5.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team5.setPlayer8(" ");
                    } else if ((team5.getPlayer9().equals(cbRemovePlayer.getValue()))) {
                        team5.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team5.setPlayer9(" ");
                    } else if ((team5.getPlayer10().equals(cbRemovePlayer.getValue()))) {
                        team5.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team5.setPlayer10(" ");
                    }
                }
                if ((cbRemoveTeam.getValue()).equals("Team6")) {
                    if ((team6.getPlayer1().equals(cbRemovePlayer.getValue()))) {
                        team6.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team6.setPlayer1(" ");
                    } else if ((team6.getPlayer2().equals(cbRemovePlayer.getValue()))) {
                        team6.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team6.setPlayer2(" ");
                    } else if ((team6.getPlayer3().equals(cbRemovePlayer.getValue()))) {
                        team6.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team6.setPlayer3(" ");
                    } else if ((team6.getPlayer4().equals(cbRemovePlayer.getValue()))) {
                        team6.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team6.setPlayer4(" ");
                    } else if ((team6.getPlayer5().equals(cbRemovePlayer.getValue()))) {
                        team6.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team6.setPlayer5(" ");
                    } else if ((team6.getPlayer6().equals(cbRemovePlayer.getValue()))) {
                        team6.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team6.setPlayer6(" ");
                    } else if ((team6.getPlayer7().equals(cbRemovePlayer.getValue()))) {
                        team6.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team6.setPlayer7(" ");
                    } else if ((team6.getPlayer8().equals(cbRemovePlayer.getValue()))) {
                        team6.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team6.setPlayer8(" ");
                    } else if ((team6.getPlayer9().equals(cbRemovePlayer.getValue()))) {
                        team6.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team6.setPlayer9(" ");
                    } else if ((team6.getPlayer10().equals(cbRemovePlayer.getValue()))) {
                        team6.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team6.setPlayer10(" ");
                    }
                }
                if ((cbRemoveTeam.getValue()).equals("Team7")) {
                    if ((team7.getPlayer1().equals(cbRemovePlayer.getValue()))) {
                        team7.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team7.setPlayer1(" ");
                    } else if ((team7.getPlayer2().equals(cbRemovePlayer.getValue()))) {
                        team7.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team7.setPlayer2(" ");
                    } else if ((team7.getPlayer3().equals(cbRemovePlayer.getValue()))) {
                        team7.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team7.setPlayer3(" ");
                    } else if ((team7.getPlayer4().equals(cbRemovePlayer.getValue()))) {
                        team7.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team7.setPlayer4(" ");
                    } else if ((team7.getPlayer5().equals(cbRemovePlayer.getValue()))) {
                        team7.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team7.setPlayer5(" ");
                    } else if ((team7.getPlayer6().equals(cbRemovePlayer.getValue()))) {
                        team7.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team7.setPlayer6(" ");
                    } else if ((team7.getPlayer7().equals(cbRemovePlayer.getValue()))) {
                        team7.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team7.setPlayer7(" ");
                    } else if ((team7.getPlayer8().equals(cbRemovePlayer.getValue()))) {
                        team7.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team7.setPlayer8(" ");
                    } else if ((team7.getPlayer9().equals(cbRemovePlayer.getValue()))) {
                        team7.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team7.setPlayer9(" ");
                    } else if ((team7.getPlayer10().equals(cbRemovePlayer.getValue()))) {
                        team7.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team7.setPlayer10(" ");
                    }
                }
                if ((cbRemoveTeam.getValue()).equals("Team8")) {
                    if ((team8.getPlayer1().equals(cbRemovePlayer.getValue()))) {
                        team8.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team8.setPlayer1(" ");
                    } else if ((team8.getPlayer2().equals(cbRemovePlayer.getValue()))) {
                        team8.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team8.setPlayer2(" ");
                    } else if ((team8.getPlayer3().equals(cbRemovePlayer.getValue()))) {
                        team8.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team8.setPlayer3(" ");
                    } else if ((team8.getPlayer4().equals(cbRemovePlayer.getValue()))) {
                        team8.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team8.setPlayer4(" ");
                    } else if ((team8.getPlayer5().equals(cbRemovePlayer.getValue()))) {
                        team8.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team8.setPlayer5(" ");
                    } else if ((team8.getPlayer6().equals(cbRemovePlayer.getValue()))) {
                        team8.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team8.setPlayer6(" ");
                    } else if ((team8.getPlayer7().equals(cbRemovePlayer.getValue()))) {
                        team8.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team8.setPlayer7(" ");
                    } else if ((team8.getPlayer8().equals(cbRemovePlayer.getValue()))) {
                        team8.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team8.setPlayer8(" ");
                    } else if ((team8.getPlayer9().equals(cbRemovePlayer.getValue()))) {
                        team8.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team8.setPlayer9(" ");
                    } else if ((team8.getPlayer10().equals(cbRemovePlayer.getValue()))) {
                        team8.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team8.setPlayer10(" ");
                    }
                }
                if ((cbRemoveTeam.getValue()).equals("Team9")) {
                    if ((team9.getPlayer1().equals(cbRemovePlayer.getValue()))) {
                        team9.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team9.setPlayer1(" ");
                    } else if ((team9.getPlayer2().equals(cbRemovePlayer.getValue()))) {
                        team9.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team9.setPlayer2(" ");
                    } else if ((team9.getPlayer3().equals(cbRemovePlayer.getValue()))) {
                        team9.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team9.setPlayer3(" ");
                    } else if ((team9.getPlayer4().equals(cbRemovePlayer.getValue()))) {
                        team9.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team9.setPlayer4(" ");
                    } else if ((team9.getPlayer5().equals(cbRemovePlayer.getValue()))) {
                        team9.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team9.setPlayer5(" ");
                    } else if ((team9.getPlayer6().equals(cbRemovePlayer.getValue()))) {
                        team9.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team9.setPlayer6(" ");
                    } else if ((team9.getPlayer7().equals(cbRemovePlayer.getValue()))) {
                        team9.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team9.setPlayer7(" ");
                    } else if ((team9.getPlayer8().equals(cbRemovePlayer.getValue()))) {
                        team9.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team9.setPlayer8(" ");
                    } else if ((team9.getPlayer9().equals(cbRemovePlayer.getValue()))) {
                        team9.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team9.setPlayer9(" ");
                    } else if ((team9.getPlayer10().equals(cbRemovePlayer.getValue()))) {
                        team9.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team9.setPlayer10(" ");
                    }
                }
                if ((cbRemoveTeam.getValue()).equals("Team10")) {
                    if ((team10.getPlayer1().equals(cbRemovePlayer.getValue()))) {
                        team10.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team10.setPlayer1(" ");
                    } else if ((team10.getPlayer2().equals(cbRemovePlayer.getValue()))) {
                        team10.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team10.setPlayer2(" ");
                    } else if ((team10.getPlayer3().equals(cbRemovePlayer.getValue()))) {
                        team10.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team10.setPlayer3(" ");
                    } else if ((team10.getPlayer4().equals(cbRemovePlayer.getValue()))) {
                        team10.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team10.setPlayer4(" ");
                    } else if ((team10.getPlayer5().equals(cbRemovePlayer.getValue()))) {
                        team10.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team10.setPlayer5(" ");
                    } else if ((team10.getPlayer6().equals(cbRemovePlayer.getValue()))) {
                        team10.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team10.setPlayer6(" ");
                    } else if ((team10.getPlayer7().equals(cbRemovePlayer.getValue()))) {
                        team10.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team10.setPlayer7(" ");
                    } else if ((team10.getPlayer8().equals(cbRemovePlayer.getValue()))) {
                        team10.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team10.setPlayer8(" ");
                    } else if ((team10.getPlayer9().equals(cbRemovePlayer.getValue()))) {
                        team10.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team10.setPlayer9(" ");
                    } else if ((team10.getPlayer10().equals(cbRemovePlayer.getValue()))) {
                        team10.RemovePlayerFromRemoveList(cbRemovePlayer.getValue());
                        team10.setPlayer10(" ");
                    }
                }
                cbPlayers.getItems().add(cbRemovePlayer.getValue());
                cbRemovePlayer.getItems().remove(cbRemovePlayer.getValue());
                selectPlayersToRemove();
                tblTeams.refresh();
            }
            else{
                infoMessages.pickTeamAndPlayerMessage();
            }
        }
        else{
            infoMessages.emptyTeamOrPlayerMessage();
        }
    }

    /**
     * Randomizes the listed players in to different teams
     */
    public void randomTeams() {
        loadBuffer();
        while (playersBuffer.size() != 0) {
            int randomPlayer = 0;
            randomPlayer = random.nextInt(playersBuffer.size());
            for (Team team : tblTeams.getItems()) {
                if (playersBuffer.size() != 0) {
                    team.addRandomPlayer((playersBuffer.get(randomPlayer)).getName());
                    cbPlayers.getItems().remove(((playersBuffer.get(randomPlayer)).getName()));
                    playersBuffer.remove(randomPlayer);
                    tblTeams.refresh();
                    if (playersBuffer.size() != 0) {
                        randomPlayer = random.nextInt(playersBuffer.size());
                    }
                }
            }
        }
    }

    /**
     * Removes all players from the table
     */

    public void removeAllPlayersFromTeam(){
            for (Team t : tblTeams.getItems()){
                    cbPlayers.getItems().addAll(t.getPlayers());
                    t.RemovePlayersTeam();
            }
        tblTeams.refresh();
    }

    /**
     * Puts the players in the tournament in the buffer
     */
    public void loadBuffer() {
        playersBuffer = mainController.getPlayers();
    }
}
