package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


/**
 *
 *
 * @author Andreas von Uthmann, Carl Hägred, Gustav Edén, Joel Svensson
 */
public class FirstPageController extends SceneControllerParent {

    /**
     * Changes scenes too the playerGUI
     */
    @FXML
    public void createTournamentClicked(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.Player);
    }



    public void handleLeaguePlay(){
        mainController.setScene(ScenesEnum.GroupStage);
        mainController.loadTeamsToLeaguePlay();
    }
}

