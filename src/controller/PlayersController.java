//package controller;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.stage.Stage;
//import model.AmountOfTeams;
//import model.Tournament;
//
//import java.awt.event.ActionListener;
//import java.io.IOException;
//
//public class PlayersController {
//    private Tournament tournament = new Tournament(this);
//
//    @FXML
//    private TextField tfPlayerName;
//    @FXML
//    private ListView listAddedPlayers = new ListView();
//    @FXML
//    private ComboBox<String> cbAmountOfTeams;
//    @FXML
//    private ChoiceBox teamsBox = new ChoiceBox();
//    @FXML
//    private ListView listTeamsPlayer = new ListView();
//    @FXML
//    private final ListView addedPlayers = new ListView();
//
//    private ObservableList<Object> amountOfTeamsStatusList = FXCollections.observableArrayList(AmountOfTeams.values());
//    private TeamsController teamsController;
//    private Stage mainWindow;
//
//    public PlayersController(Stage primaryStage, TeamsController teamsController){
//        this.teamsController=teamsController;
//        this.mainWindow=primaryStage;
//        initFirstPage();
//    }
//
//
//    @FXML
//    public void setPlayerGUI(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("../view/PlayersGui.fxml"));
//        Parent playerGUI = loader.load();
//        // controller.Controller controller = loader.getController();
//        //controller.initAddPlayersViewData();
//        Scene playerScene = new Scene(playerGUI);
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setScene(playerScene);
//        window.show();
//    }
//
//    /**
//     * The method reads a fxml-file and changes the current window to the new fxml-file
//     */
//    @FXML
//    public void setFirstPageGUI(ActionEvent event) throws IOException {
//        Parent playerGUI = FXMLLoader.load(getClass().getResource("../view/FirstPage.fxml"));
//        Scene playerScene = new Scene(playerGUI);
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setScene(playerScene);
//        window.show();
//    }
//    @FXML
//    public void setupTeamsGUI(ActionEvent event) throws IOException {
//        teamsController.setTeamsGUI(event);
//    }
//
//
//    public void initFirstPage() {
//        Parent playerGUI = null;
//        try {
//            playerGUI = FXMLLoader.load(getClass().getResource("../view/FirstPage.fxml"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Scene playerScene = new Scene(playerGUI);
////        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        mainWindow.setScene(playerScene);
//        mainWindow.show();
//    }
//
//    /**
//     * Saves the player that the user added to the player list
//     */
//    public void addPlayersToList() {
//        String test = tfPlayerName.getText();
//        if (test.isBlank()) {
//            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
//            alert1.setTitle("Name problems");
//            alert1.setHeaderText(null);
//            alert1.setContentText("The name can't be empty");
//            alert1.showAndWait();
//        } else if (Character.isDigit(test.charAt(0))) {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Name problems");
//            alert.setHeaderText(null);
//            alert.setContentText("The name needs to start with a letter");
//            alert.showAndWait();
//        } else {
//            listAddedPlayers.getItems().add(tfPlayerName.getText());
//            listTeamsPlayer.getItems().add(tfPlayerName.getText());
//            addedPlayers.getItems().add(tfPlayerName.getText());
//            tournament.addPlayer(tfPlayerName.getText());
//        }
//        tfPlayerName.setText("");
//    }
//
//    public void initialize(){
//        teamsBox.setItems(amountOfTeamsStatusList);
//    }
//}
