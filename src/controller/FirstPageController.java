package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class FirstPageController extends SceneControllerParent {

    /**
     * Changes scenes too the playerGUI
     */
    @FXML
    public void createTournamentClicked(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.Player);
    }
}

