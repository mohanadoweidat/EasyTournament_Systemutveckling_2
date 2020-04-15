
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.stage.*;

import java.awt.*;
import java.io.IOException;

public class Controller {

    private Tournament tournament = new Tournament();

    private Config config;
    @FXML
    private CheckBox cbGroupStage;
    @FXML
    private CheckBox cbPlayoffs;
    @FXML
    private ComboBox<Config> cbConfig;
    @FXML
    private TextField tfAmountOfTeams;
    @FXML
    private TextField tfPlayerName;
    @FXML
    private ListView listAddedPlayers;

    private ObservableList<Config> configStatusList = FXCollections.observableArrayList(Config.values());


    public Controller(){

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
        handleAmountOfTeams();
        Parent playerGUI = FXMLLoader.load(getClass().getResource("AddPlayersGui.fxml"));
        Scene playerScene = new Scene(playerGUI);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(playerScene);
        window.show();
    }

    @FXML
    public void setTeamsGUI(ActionEvent event) throws IOException {
        tournament.addPlayer(listAddedPlayers.getItems());
        Parent playerGUI = FXMLLoader.load(getClass().getResource("ListGUI.fxml"));
        Scene playerScene = new Scene(playerGUI);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(playerScene);
        window.show();
    }

    @FXML
    public void setOverViewGUI(ActionEvent event) throws IOException {
        Parent playerGUI = FXMLLoader.load(getClass().getResource("OverviewGUI.fxml"));
        Scene playerScene = new Scene(playerGUI);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(playerScene);
        window.show();
    }

    @FXML
    public void handleGroupStageBox(ActionEvent actionEvent){
            tournament.groupStage();

    }


    @FXML
    public void handlePlayoffsBox(ActionEvent actionEvent){
            tournament.playoffs();
    }

    @FXML
    public void handleConfig(){
       // tournament.playoffs();
    }


    /*public void initialize(){
        cbConfig.setValue(config);
        cbConfig.setItems(configStatusList);
    }

     */


    @FXML
    public void handleAmountOfTeams(){
        tournament.setAmountOfTeams(tfAmountOfTeams.getText());
    }

    public void addPlayersToList(){
        listAddedPlayers.getItems().add(tfPlayerName.getText());
    }


}
