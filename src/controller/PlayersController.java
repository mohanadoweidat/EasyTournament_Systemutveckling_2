package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.AmountOfTeams;
import model.Player;

import java.util.ArrayList;

public class PlayersController extends SceneControllerParent {

    @FXML
    private ListView listAddedPlayers = new ListView();
    @FXML
    private ArrayList<Player> playerSave = new ArrayList();
    @FXML
    private ListView listOverview = new ListView();
    @FXML
    private ListView listTeamsPlayer = new ListView();
    @FXML
    private TextField tfPlayerName = new TextField();

    @FXML
    public void setFirstPageGUI(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.FirstPage);
    }

    @FXML
    public void setTeamsGUI(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.Team);
    }

    public void addPlayersToList() {
        String test = tfPlayerName.getText();
        if (test.isBlank()) {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Name problems");
            alert1.setHeaderText(null);
            alert1.setContentText("The name can't be empty");
            alert1.showAndWait();
        } else if (Character.isDigit(test.charAt(0))) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Name problems");
            alert.setHeaderText(null);
            alert.setContentText("The name needs to start with a letter");
            alert.showAndWait();
        } else {
            listAddedPlayers.getItems().add(tfPlayerName.getText());
            mainController.addPlayer(new Player(tfPlayerName.getText()));
        }
        tfPlayerName.setText("");
    }

    /**
     * Removes players from the "added players" list
     */
    //TODO FIXA REMOVE MED NYA CONTROLLERS OCH MODELKLASSER
    public void removePlayerPlayersGui() {
        final int selectedIndex = listAddedPlayers.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            String removeSelected = String.valueOf(listAddedPlayers.getSelectionModel().getSelectedItem());
            listAddedPlayers.getItems().remove(selectedIndex);
        }
    }
}
