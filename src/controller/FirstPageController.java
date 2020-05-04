package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class FirstPageController extends SceneControllerParent {

    @FXML
    public void createTournamentClicked(ActionEvent actionEvent) {
        mainController.setScene(ScenesEnum.Player);
    }
}

