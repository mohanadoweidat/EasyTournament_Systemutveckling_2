package controller;

import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.util.converter.IntegerStringConverter;
import model.*;

/**
 * The class creates the league play
 * @author Andreas von Uthmann, Carl Hägred, Gustav Edén, Joel Svensson
 */
public class GroupStageController extends SceneControllerParent {

    @FXML
    private TableView<TeamStats> tblGroupStage;

    @FXML
    private TableColumn<TeamStats, String> colPosition = new TableColumn<>("position");

    @FXML
    private TableColumn<TeamStats, String> colTeams = new TableColumn<>("teams");

    @FXML
    private TableColumn<TeamStats, Integer> colWins = new TableColumn<>("wins");

    @FXML
    private TableColumn<TeamStats, Integer> colLosses = new TableColumn<>("losses");

    @FXML
    private TableColumn<TeamStats, Integer> colDraws = new TableColumn<>("draws");

    @FXML
    private TableColumn<TeamStats, Integer> colPoints = new TableColumn<>("points");

    private ObservableList <TeamStats> data = FXCollections.observableArrayList();

    /**
     * Sets up the columns and calls the method that fills the table with the teams
     */
    public void initTable(){
        try{
            colPosition.setCellValueFactory(new PropertyValueFactory<>("Position"));
            colTeams.setCellValueFactory(new PropertyValueFactory<>("Teams"));
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
        colPosition.setCellFactory(TextFieldTableCell.forTableColumn());
        colPosition.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setPosition(e.getNewValue());
        });

        colTeams.setCellFactory(TextFieldTableCell.forTableColumn());
        colTeams.setOnEditCommit(e->{
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setTeams(e.getNewValue());
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

    /**
     * Fills the table with the teams
     */
    private void loadData(){
        ObservableList<TeamStats> dataTable= FXCollections.observableArrayList();
        int teams = 0;
        switch (mainController.getAmountOfTeams()) {
            case Three:
                teams = 3;
                break;
            case Four:
                teams = 4;
                break;
            case Five:
                teams = 5;
                break;
            case Six:
                teams = 6;
                break;
            case Seven:
                teams = 7;
                break;
            case Eight:
                teams = 8;
                break;
            case Nine:
                teams = 9;
                break;
            case Ten:
                teams = 10;
                break;
        }
        for(int j =0; j < teams; j++){
            dataTable.add(new TeamStats(String.valueOf(j + 1),"Team" + (j + 1), 0,0,0,0));
            tblGroupStage.setItems(dataTable);
        }
    }
}
