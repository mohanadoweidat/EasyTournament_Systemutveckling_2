package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import model.*;
import java.io.IOException;

/**
 *
 *
 * @author Andreas von Uthmann, Carl Hägred, Gustav Edén, Joel Svensson
 */
public class GroupStageController extends SceneControllerParent {

    @FXML
    private TableView<TeamStats> tblGroupStage;

    @FXML
    private TableColumn<TeamStats, String> colPosition= new TableColumn<>("position");

    @FXML
    private TableColumn<TeamStats, String> colTeams= new TableColumn<>("teams");

    @FXML
    private TableColumn<TeamStats, Integer> colWins= new TableColumn<>("wins");

    @FXML
    private TableColumn<TeamStats, Integer> colLosses= new TableColumn<>("losses");

    @FXML
    private TableColumn<TeamStats, Integer> colDraws= new TableColumn<>("draws");

    @FXML
    private TableColumn<TeamStats, Integer> colPoints= new TableColumn<>("points");

    private ObservableList <TeamStats> data = FXCollections.observableArrayList();

    @FXML
    public void setGroupStageGUI(AmountOfTeams selectedItem) throws IOException {
        switch (selectedItem) {
            case Three:
                break;
            case Four:
                break;
            case Five:
                break;
            case Six:
                break;
            case Seven:
                break;
            case Eight:
                break;
            case Nine:
                break;
            case Ten:
                break;
        }
    }

    //Groupstage
    public void initTable(){
        try{
            colPosition.setCellValueFactory(new PropertyValueFactory<>("Position"));
            colTeams.setCellValueFactory(new PropertyValueFactory<>("Teams"));
            colWins.setCellValueFactory(new PropertyValueFactory<>("Wins"));
            colLosses.setCellValueFactory(new PropertyValueFactory<>("Losses"));
            colDraws.setCellValueFactory(new PropertyValueFactory<>("Draws"));
            colPoints.setCellValueFactory(new PropertyValueFactory<>("Points"));
            data.add(new TeamStats("1","team1",1,1,1,1));
            tblGroupStage.setItems(data);
            editableCols();
            loadData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

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

    private void loadData(){
        ObservableList<TeamStats> dataTable= FXCollections.observableArrayList();
        for(int i =0;i<10; i++){
            dataTable.add(new TeamStats(String.valueOf(i),"1" +i, 1+i,1 +i,1+i,1+i));
            tblGroupStage.setItems(dataTable);
        }
    }
}
