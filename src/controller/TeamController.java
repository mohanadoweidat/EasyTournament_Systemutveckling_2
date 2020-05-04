package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.*;
import model.*;

import java.util.ArrayList;

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

    private ObservableList<String> tableContent = FXCollections.observableArrayList();

    private TableColumn<Player, String> column1 = new TableColumn("Team 1");
    private TableColumn<Player, String> column2 = new TableColumn("Team 2");
    private TableColumn<Player, String> column3 = new TableColumn("Team 3");
    private TableColumn<Player, String> column4 = new TableColumn("Team 4");
    private TableColumn<Player, String> column5 = new TableColumn("Team 5");
    private TableColumn<Player, String> column6 = new TableColumn("Team 6");
    private TableColumn<Player, String> column7 = new TableColumn("Team 7");
    private TableColumn<Player, String> column8 = new TableColumn("Team 8");
    private TableColumn<Player, String> column9 = new TableColumn("Team 9");
    private TableColumn<Player, String> column10 = new TableColumn("Team 10");

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
            //mainController.setScene(ScenesEnum.GroupStage);
        } else if (cbPlayoffs.isSelected()) {

        } else {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Error message");
            alert1.setHeaderText(null);
            alert1.setContentText("You have to choose either Groupstage or Playoffs");
            alert1.showAndWait();
        }
    }

    public void setupList(){
        for (Player p : mainController.getPlayers()) {
            listTeamsPlayer.getItems().add(p.getName());
        }
    }

    public void initialize() {
        teamsBox.getItems().addAll(AmountOfTeams.values());
        setEditable();
    }

    public void setEditable() {
        column1.setEditable(true);
        column2.setEditable(true);
        column3.setEditable(true);
        column4.setEditable(true);
        column5.setEditable(true);
        column6.setEditable(true);
        column7.setEditable(true);
        column8.setEditable(true);
        column9.setEditable(true);
        column10.setEditable(true);
    }

    @FXML
    private void initTeamsTableData(ActionEvent event) {
        try {
            switch (teamsBox.getSelectionModel().getSelectedItem()) {
                case Three:
                    tblTeams.getColumns().addAll(column1, column2, column3);
                    tblTeams.setItems(getPlayer(mainController.getPlayers()));
                    column1.setCellValueFactory(new PropertyValueFactory<>("name"));
                    break;
                case Four:
                    tblTeams.getColumns().addAll(column1, column2, column3, column4);
                    tblTeams.setItems(getPlayer(mainController.getPlayers()));
                    column1.setCellValueFactory(new PropertyValueFactory<>("name"));
                    break;
                case Five:
                    tblTeams.getColumns().addAll(column1, column2, column3, column4, column5);
                    tblTeams.setItems(getPlayer(mainController.getPlayers()));
                    column1.setCellValueFactory(new PropertyValueFactory<>("name"));
                    break;
                case Six:
                    tblTeams.getColumns().addAll(column1, column2, column3, column4, column5, column6);
                    tblTeams.setItems(getPlayer(mainController.getPlayers()));
                    column1.setCellValueFactory(new PropertyValueFactory<>("name"));
                    break;
                case Seven:
                    tblTeams.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7);
                    tblTeams.setItems(getPlayer(mainController.getPlayers()));
                    column1.setCellValueFactory(new PropertyValueFactory<>("name"));
                    break;
                case Eight:
                    tblTeams.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8);
                    tblTeams.setItems(getPlayer(mainController.getPlayers()));
                    column1.setCellValueFactory(new PropertyValueFactory<>("name"));
                    break;
                case Nine:
                    tblTeams.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9);
                    tblTeams.setItems(getPlayer(mainController.getPlayers()));
                    column1.setCellValueFactory(new PropertyValueFactory<>("name"));
                    break;
                case Ten:
                    tblTeams.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9, column10);
                    tblTeams.setItems(getPlayer(mainController.getPlayers()));
                    column1.setCellValueFactory(new PropertyValueFactory<>("name"));
                    break;
            }
        } catch (Exception e) {}
    }

    public ObservableList<Player> getPlayer(ArrayList<Player> input){
        ObservableList<Player> observablePlayers = FXCollections.observableArrayList();
        for (Player p: input){
            observablePlayers.add(p);
        }
        return observablePlayers;
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
