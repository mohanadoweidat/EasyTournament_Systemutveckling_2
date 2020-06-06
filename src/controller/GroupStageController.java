package controller;

import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.stage.FileChooser;
import javafx.util.converter.IntegerStringConverter;
import model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Connects the GroupStage fxml-file with the ret of the system
 * @author Andreas von Uthmann, Carl Hägred, Gustav Edén, Joel Svensson
 */
public class GroupStageController extends SceneControllerParent {

    @FXML
    private TableView<Team> tblGroupStage;

    @FXML
    private TableColumn<Team, String> colPosition = new TableColumn<>("position");

    @FXML
    private TableColumn<Team, String> colTeams = new TableColumn<>("teams");

    @FXML
    private TableColumn<Team, Integer> colWins = new TableColumn<>("wins");

    @FXML
    private TableColumn<Team, Integer> colLosses = new TableColumn<>("losses");

    @FXML
    private TableColumn<Team, Integer> colDraws = new TableColumn<>("draws");

    @FXML
    private TableColumn<Team, Integer> colPoints = new TableColumn<>("points");

    @FXML
    private Label lblTeamToPlay1;

    @FXML
    private Label lblTeamToPlay2;

    @FXML
    private Label lblTeamToPlay3;

    @FXML
    private Label lblTeamToPlay4;

    @FXML
    private Button btnWinner1;

    @FXML
    private Button btnWinner2;

    @FXML
    private Button btnWinner3;

    @FXML
    private Button btnWinner4;

    private ArrayList<Team> teamBuffer = new ArrayList<>();

    private ObservableList <Team> data = FXCollections.observableArrayList();

    private Random random = new Random();

    private ArrayList<Team> teamsBuffer = new ArrayList();

    private ArrayList<Team> teamsToPlay = new ArrayList();

    private int timesPlayed = 0;

    private int bufferTimesToPlay = 0;

    private int teams = 0;

    /**
     * Changes scenes to the PlayersGUI
     */
    @FXML
    public void setPlayersGUI(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.Player);
    }

    /**
     * Changes scenes to the firstPageGUI
     */
    @FXML
    public void setFirstPageGUI(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.FirstPage);
    }

    /**
     * Changes scenes to the teamGUI
     */
    @FXML
    public void setTeamsGUI(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.Team);
    }

    /**
     * Sets up the columns and calls the method that fills the table with the teams
     */
    public void initTable(){
        try{
            colTeams.setCellValueFactory(new PropertyValueFactory<>("Name"));
            colWins.setCellValueFactory(new PropertyValueFactory<>("Wins"));
            colLosses.setCellValueFactory(new PropertyValueFactory<>("Losses"));
            colDraws.setCellValueFactory(new PropertyValueFactory<>("Draws"));
            colPoints.setCellValueFactory(new PropertyValueFactory<>("Points"));
            tblGroupStage.setItems(data);
            editableCols();
            loadData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Makes the columns editable
     */
    private void editableCols(){
        colTeams.setCellFactory(TextFieldTableCell.forTableColumn());
        colTeams.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setName(e.getNewValue());
        });

        /*
        colWins.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colWins.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setWins(Integer.parseInt(String.valueOf(e.getNewValue())));
        });

        colLosses.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colLosses.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setLosses(Integer.parseInt(String.valueOf(e.getNewValue())));
        });

        colDraws.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colDraws.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setDraws(Integer.parseInt(String.valueOf(e.getNewValue())));
        });

        colPoints.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colPoints.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setPoints(Integer.parseInt(String.valueOf(e.getNewValue())));
        });

        */

        tblGroupStage.setEditable(true);
    }

    public void setupLeaguePlay(){
        timesPlayed = 0;
        for (Team team : tblGroupStage.getItems()) {
            team.reset();
        }
        /*TextInputDialog dialog = new TextInputDialog("Ex. 2");
        dialog.setTitle("Easy Tournament");
        dialog.setHeaderText("Enter the amount of times you want eanch team to meat each other");
        dialog.setContentText("Please enter the amount of times:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            try{

                bufferTimesToPlay = (Integer.parseInt(result.get()));

                System.out.println(bufferTimesToPlay);
            }catch (Exception e){
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Error message");
                alert1.setHeaderText(null);
                alert1.setContentText("Only enter numbers");
                alert1.showAndWait();
            }
        }

        for(int i = 0; i < bufferTimesToPlay; i++) {
            teamsToPlay.addAll(tblGroupStage.getItems());
        }

        //nextGamesTest();

         */
    }

    public void nextGamesTest(){
        if (teams == 0) {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Error message");
            alert1.setHeaderText(null);
            alert1.setContentText("You need to add teams to see next match");
            alert1.showAndWait();
        }else if (teams == 3){
            if (bufferTimesToPlay == 0){
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("");
                alert1.setHeaderText(null);
                alert1.setContentText("League is over \nStart a new one");
                alert1.showAndWait();
            }else {
                if (timesPlayed != bufferTimesToPlay) {
                    int a = random.nextInt(teamsToPlay.size());
                    lblTeamToPlay1.setText(teamsToPlay.get(a).getName());
                    teamsToPlay.remove(a);
                    int b = random.nextInt(teamsToPlay.size());
                    while (b == a) {
                        b = random.nextInt((teams));
                    }
                    lblTeamToPlay1.setText(teamsToPlay.get(b).getName());
                    teamsToPlay.remove(b);

                    timesPlayed++;

                }
                btnWinner1.setVisible(true);
                btnWinner2.setVisible(true);
                btnWinner3.setVisible(true);
                btnWinner4.setVisible(true);
            }
        }
    }

    public void winner1(){
        if (!lblTeamToPlay1.getText().equals("")) {
            for (Team team : tblGroupStage.getItems()) {
                if (team.getName().equals(lblTeamToPlay1.getText())) {
                    team.setWins(1);
                }
                if (team.getName().equals(lblTeamToPlay3.getText())) {
                    team.setLosses(1);
                }
            }
            tblGroupStage.refresh();
        }
        tblGroupStage.getSortOrder().add(colPoints);
    }

    public void winner2(){
        if (!lblTeamToPlay3.getText().equals("")) {
            for (Team team : tblGroupStage.getItems()) {
                if (team.getName().equals(lblTeamToPlay3.getText())) {
                    team.setWins(1);
                }
                if (team.getName().equals(lblTeamToPlay1.getText())) {
                    team.setLosses(1);
                }
            }
            tblGroupStage.refresh();
        }
        tblGroupStage.getSortOrder().add(colPoints);
    }

    public void winner3(){
        if (!lblTeamToPlay2.getText().equals("")) {
            for (Team team : tblGroupStage.getItems()) {
                if (team.getName().equals(lblTeamToPlay2.getText())) {
                    team.setWins(1);
                }
                if (team.getName().equals(lblTeamToPlay4.getText())) {
                    team.setLosses(1);
                }
            }
            tblGroupStage.refresh();
        }
        tblGroupStage.getSortOrder().add(colPoints);
    }

    public void winner4(){
        if (!lblTeamToPlay4.getText().equals("")) {
            for (Team team : tblGroupStage.getItems()) {
                if (team.getName().equals(lblTeamToPlay4.getText())) {
                    team.setWins(1);
                }
                if (team.getName().equals(lblTeamToPlay2.getText())) {
                    team.setLosses(1);
                }
            }
            tblGroupStage.refresh();
        }
        tblGroupStage.getSortOrder().add(colPoints);
    }

    public void nextGames(){
        if (teams == 0){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Error message");
            alert1.setHeaderText(null);
            alert1.setContentText("You need to add teams to see next match");
            alert1.showAndWait();
        } else if (teams == 3) {
            int a = random.nextInt(teams);
            lblTeamToPlay1.setText(mainController.getTeam(a).getName());
            int b = random.nextInt((teams));
            while (b == a) {
                b = random.nextInt((teams));
            }
            lblTeamToPlay3.setText(mainController.getTeam(b).getName());
            btnWinner1.setVisible(true);
            btnWinner2.setVisible(true);
            btnWinner3.setVisible(false);
            btnWinner4.setVisible(false);
        } else {
            btnWinner1.setVisible(true);
            btnWinner2.setVisible(true);
            btnWinner3.setVisible(true);
            btnWinner4.setVisible(true);
            int a = random.nextInt(teams);
            lblTeamToPlay1.setText(mainController.getTeam(a).getName());
            int b = random.nextInt((teams));
            while (b == a) {
                b = random.nextInt((teams));
            }
            lblTeamToPlay2.setText(mainController.getTeam(b).getName());
            int c = random.nextInt((teams));
            while (c == b || c == a) {
                c = random.nextInt((teams));
            }
            lblTeamToPlay3.setText(mainController.getTeam(c).getName());
            int d = random.nextInt((teams));
            while (d == a || d == b || d == c) {
                d = random.nextInt((teams));
            }
            lblTeamToPlay4.setText(mainController.getTeam(d).getName());
        }
    }

   /**
    * Imports pre-saved teams
    */
   public void importTeams(){
       teamsBuffer.clear();
       ObservableList<Team> dataTable = FXCollections.observableArrayList();
       FileChooser chooser1 = new FileChooser();
       File file = chooser1.showOpenDialog(null);
       try {
           BufferedReader in;
           in = new BufferedReader(new FileReader(file));
           String line = in.readLine();
           String[] team;
           int count = 0;
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
               count++;
               line = in.readLine();
           }
           if(count != 0) {
               teams = count;
               nextGames();
           }
           tblGroupStage.setItems(dataTable);
           tblGroupStage.refresh();
       } catch (Exception ex) {
           ex.printStackTrace();
       }
   }

    /**
     * Saves the teams and the score you added to the table
     */
    @FXML
    public void saveTeams() {
        List<Team> teams = (tblGroupStage.getItems());
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Choose location To Save Report");

        File selectedFile = null;
        if(selectedFile==null) {
            selectedFile = chooser.showSaveDialog(null);
        }

        PrintWriter outFile = null;
        try {
            outFile = new PrintWriter(selectedFile+".txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

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
        outFile.close();
    }

    public void startNewLeague(){
        List<Team> teams = (tblGroupStage.getItems());
        if (teams.size() == 0){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Error message");
            alert1.setHeaderText(null);
            alert1.setContentText("You need to add teams to start the League Play");
            alert1.showAndWait();
        }else {
            for (Team team : teams) {
                team.setWins(0);
                team.setDraws(0);
                team.setPoints(0);
                team.setLosses(0);
                tblGroupStage.refresh();
            }
            setupLeaguePlay();
        }
    }

    /**
     * Fills the table with the teams
     */
    public void loadData(){
        btnWinner1.setVisible(false);
        btnWinner2.setVisible(false);
        btnWinner3.setVisible(false);
        btnWinner4.setVisible(false);
        if ((mainController.getAmountOfTeams()) == null){
        }else {
            ObservableList<Team> dataTable = FXCollections.observableArrayList();
            teams = 0;
            switch (mainController.getAmountOfTeams()) {
                case Three:
                    teams = 3;
                    nextGames();
                    break;
                case Four:
                    teams = 4;
                    nextGames();
                    break;
                case Five:
                    teams = 5;
                    nextGames();
                    break;
                case Six:
                    teams = 6;
                    nextGames();
                    break;
                case Seven:
                    teams = 7;
                    nextGames();
                    break;
                case Eight:
                    teams = 8;
                    nextGames();
                    break;
                case Nine:
                    teams = 9;
                    nextGames();
                    break;
                case Ten:
                    teams = 10;
                    nextGames();
                    break;
            }
            teamBuffer = (mainController.getTeams());
            for (int j = 0; j < teams; j++) {
                dataTable.add(teamBuffer.get(j));
                tblGroupStage.setItems(dataTable);
            }
        }
    }
}
