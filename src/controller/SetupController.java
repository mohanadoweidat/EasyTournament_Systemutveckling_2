package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.*;

public class SetupController extends SceneControllerParent {

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
    private ChoiceBox<AmountOfTeams> teamsBox = new ChoiceBox();

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
    public void startTournamentClicked(ActionEvent actionEvent) {
        if (cbGroupStage.isSelected()) {
            mainController.setScene(ScenesEnum.GroupStage);
        } else if (cbPlayoffs.isSelected()) {

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
                    break;
                case Four:
                    tblTeams.getColumns().addAll(column1, column2, column3, column4);
                    break;
                case Five:
                    tblTeams.getColumns().addAll(column1, column2, column3, column4, column5);
                    break;
                case Six:
                    tblTeams.getColumns().addAll(column1, column2, column3, column4, column5, column6);
                    break;
                case Seven:
                    tblTeams.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7);
                    break;
                case Eight:
                    tblTeams.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8);
                    break;
                case Nine:
                    tblTeams.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9);
                    break;
                case Ten:
                    tblTeams.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9, column10);
                    break;
            }
        } catch (Exception e) {
            
        }
    }
}
