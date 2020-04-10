
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

import java.io.IOException;

public class Controller {
    private Main main;

    public void saveConfig() {

    }

    public void amountOfTeams() {

    }

    public void structure() {

    }

    @FXML
    public void setConfigGUI(ActionEvent event) throws IOException {
        Parent playerGUI = FXMLLoader.load(getClass().getResource("TournamentConfig.fxml"));
        Scene playerScene = new Scene(playerGUI);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(playerScene);
        window.show();
    }

    @FXML
    public void setPlayerGUI(ActionEvent event) throws IOException {
        Parent playerGUI = FXMLLoader.load(getClass().getResource("AddPlayersGui.fxml"));
        Scene playerScene = new Scene(playerGUI);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(playerScene);
        window.show();
    }

    @FXML
    public void setTeamsGUI(ActionEvent event) throws IOException {
        Parent playerGUI = FXMLLoader.load(getClass().getResource("ListGUI.fxml"));
        Scene playerScene = new Scene(playerGUI);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(playerScene);
        window.show();
    }

    @FXML
    public void setOverViewGUI(ActionEvent event) throws IOException {
        Parent playerGUI = FXMLLoader.load(getClass().getResource("joelsGui.fxml"));
        Scene playerScene = new Scene(playerGUI);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(playerScene);
        window.show();
    }


}
