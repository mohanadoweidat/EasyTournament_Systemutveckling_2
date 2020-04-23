//package controller;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.ListView;
//import javafx.stage.Stage;
//import model.Tournament;
//
//import java.io.IOException;
//
//public class TeamsController {
//    private Tournament tournament = new Tournament(this);
//
//    private final ListView addedPlayers = new ListView();
//    @FXML
//    private ListView listOverview = new ListView();
//    @FXML
//    private ListView listTeamsPlayer = new ListView();
//    private PlayersController playersController;
//
//
////    public TeamsController(PlayersController playersController) {
////        this.playersController=playersController;
////    }
//
//
//    @FXML
//    public void setTeamsGUI(ActionEvent event) throws IOException {
////        tournament.addPlayer(tournament.getPlayers());
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("../view/TeamsGUI.fxml"));
//        Parent playerGUI = loader.load();
//        TeamsController teamsController = loader.getController();
//        teamsController.initTeamsViewData(addedPlayers);
//        Scene playerScene = new Scene(playerGUI);
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setScene(playerScene);
//        window.show();
//    }
//
//    public void setupPlayersGUI(ActionEvent event) throws IOException {
//        playersController.setPlayerGUI(event);
//    }
//    public void setupFirstPage(ActionEvent event) throws IOException {
//        playersController.setFirstPageGUI(event);
//    }
//
//    /**
//     * Shows the data should be in the gui when it loads
//     * @param addedPlayers a list of the players that has been added
//     */
//    public void initTeamsViewData(ListView addedPlayers){
//        listTeamsPlayer.getItems().add(addedPlayers);
//    }
//}
