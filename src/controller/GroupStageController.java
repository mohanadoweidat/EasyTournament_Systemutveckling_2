package controller;

import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.util.converter.IntegerStringConverter;
import model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
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

    private int teams = 0;

    /**
     * Sets up the columns and calls the method that fills the table with the teams
     */
    public void initTable(){
        try{
            //colPosition.setCellValueFactory(new PropertyValueFactory<>("Position"));
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

    public void nextGames(){
        if (teams == 0){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Error message");
            alert1.setHeaderText(null);
            alert1.setContentText("You need to add teams to see next match");
            alert1.showAndWait();
        } else if (teams == 3) {
            int a = random.nextInt(teams);
            while (a == 0) {
                a = random.nextInt(teams);
            }
            lblTeamToPlay1.setText("Team " + a);
            int b = random.nextInt(teams);
            while (b == a || b == 0) {
                b = random.nextInt(teams);
            }
            lblTeamToPlay3.setText("Team " + b);
        } else {
            int a = random.nextInt(teams);
            while (a == 0) {
                a = random.nextInt(teams);
            }
            lblTeamToPlay1.setText("Team " + a);
            int b = random.nextInt(teams);
            while (b == a || b == 0) {
                b = random.nextInt(teams);
            }
            lblTeamToPlay2.setText("Team " + b);
            int c = random.nextInt(teams);
            while (c == b || c == a || c == 0) {
                c = random.nextInt(teams);
            }
            lblTeamToPlay3.setText("Team " + c);
            int d = random.nextInt(teams);
            while (d == a || d == b || d == c || d == 0) {
                d = random.nextInt(teams);
            }
            lblTeamToPlay4.setText("Team " + d);
        }
    }

    public void importTeams(){
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("Error message");
        alert1.setHeaderText(null);
        alert1.setContentText("Feature is coming soon");
        alert1.showAndWait();
    }

    /**
     * Fills the table with the teams
     */
    public void loadData(){
        if ((mainController.getAmountOfTeams()) == null){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Error message");
            alert1.setHeaderText(null);
            alert1.setContentText("You need to import players to add them");
            alert1.showAndWait();
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
