package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
     * Adds a player to the game
     */
    @FXML
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
     * Removes players from the selected player
     */
    @FXML
    public void removePlayerPlayersGui() {
        final int selectedIndex = listAddedPlayers.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            mainController.removePlayer(selectedIndex);
            listAddedPlayers.getItems().remove(selectedIndex);
        } else{
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Delete problems");
            alert1.setHeaderText(null);
            alert1.setContentText("You need to shoes a player to remove");
            alert1.showAndWait();
        }
    }

    /**
     * This method will handle the importing off pre saved player groups
     */
    @FXML
    public void handleImportGroups(ActionEvent event){
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("Delete problems");
        alert1.setHeaderText(null);
        alert1.setContentText("This feature is coming soon");
        alert1.showAndWait();
    }

    /**
     * This method will handle the saveing player groups
     */
    @FXML
    public void handleSaveGroups(ActionEvent event){
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("Delete problems");
        alert1.setHeaderText(null);
        alert1.setContentText("This feature is coming soon");
        alert1.showAndWait();
    }
}
