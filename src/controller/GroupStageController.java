package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;

public class GroupStageController {
    private Controller controller;


    public GroupStageController(Controller controller) {
        this.controller = controller;
    }

    @FXML
    public void setGroupStageGUI(ActionEvent event, AmountOfTeams selectedItem) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        switch (selectedItem) {
            case Three:
                loader.setLocation(getClass().getResource("../view/FirstPage.fxml"));
                break;
        }
        //loader.setLocation(getClass().getResource("../view/FirstPage.fxml"));
        Parent playerGUI = loader.load();
        Controller controller = loader.getController();
        Scene playerScene = new Scene(playerGUI);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(playerScene);
        window.show();
    }
}
