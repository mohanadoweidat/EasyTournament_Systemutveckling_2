package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Connects the FirstPage fxml-file with the ret of the system
 * @author  Carl Hägred
 */
public class FirstPageController extends SceneControllerParent {

    /**
     * Changes scenes too the playerGUI
     */
    @FXML
    public void createTournamentClicked(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.Player);
    }

    /**
     * Changes scenes too the GroupStageGUI
     */
    public void handleLeaguePlay(){
        mainController.setScene(ScenesEnum.GroupStage);
        mainController.loadTeamsToLeaguePlay();
    }
}

