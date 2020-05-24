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
 * The class creates the league play
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

    private ArrayList<Team> teamBuffer = new ArrayList<>();

    private ObservableList <Team> data = FXCollections.observableArrayList();

    private Random random = new Random();

    private ArrayList<Team> teamsBuffer = new ArrayList();

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

        tblGroupStage.setEditable(true);
    }

    public void setupLeaguePlay(){
        List<Team> teamsToPlay = (tblGroupStage.getItems());
        TextInputDialog dialog = new TextInputDialog("Ex. 2");
        dialog.setTitle("Easy Tournament");
        dialog.setHeaderText("Enter the amount of times you want eanch team to meat each other");
        dialog.setContentText("Please enter the amount of times:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            try{
                mainController.setTimesToMeat(Integer.parseInt(result.get()));
            }catch (Exception e){
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Error message");
                alert1.setHeaderText(null);
                alert1.setContentText("Only enter numbers");
                alert1.showAndWait();
            }
        }




 //       for (Team team : teamsToPlay) {

        //}
    }

    public void nextGames(){
        tblGroupStage.getSortOrder().add(colPoints);
        if (teams == 0){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Error message");
            alert1.setHeaderText(null);
            alert1.setContentText("You need to add teams to see next match");
            alert1.showAndWait();
        } else if (teams == 3) {
            int a = random.nextInt((teams + 1));
            while (a == 0) {
                a = random.nextInt((teams + 1));
            }
            lblTeamToPlay1.setText("Team " + a);
            int b = random.nextInt((teams + 1));
            while (b == a || b == 0) {
                b = random.nextInt((teams + 1));
            }
            lblTeamToPlay3.setText("Team " + b);
        } else {
            int a = random.nextInt((teams + 1));
            while (a == 0) {
                a = random.nextInt((teams + 1));
            }
            lblTeamToPlay1.setText("Team " + a);
            int b = random.nextInt((teams + 1));
            while (b == a || b == 0) {
                b = random.nextInt((teams + 1));
            }
            lblTeamToPlay2.setText("Team " + b);
            int c = random.nextInt((teams + 1));
            while (c == b || c == a || c == 0) {
                c = random.nextInt((teams + 1));
            }
            lblTeamToPlay3.setText("Team " + c);
            int d = random.nextInt((teams + 1));
            while (d == a || d == b || d == c || d == 0) {
                d = random.nextInt((teams + 1));
            }
            lblTeamToPlay4.setText("Team " + d);
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
