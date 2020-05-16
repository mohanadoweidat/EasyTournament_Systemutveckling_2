package controller;

import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import model.Player;

import java.io.*;
import java.util.ArrayList;

/**
 *
 *
 * @author Andreas von Uthmann, Carl Hägred, Gustav Edén, Joel Svensson
 */

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

    private ObservableList<String> listOfPlayers = FXCollections.observableArrayList();

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
        mainController.loadBuffer();
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
            listOfPlayers.add(tfPlayerName.getText());
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
            alert1.setContentText("You need to choose a player to remove");
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
     * Writes the group of players too a file
     * @auther Gustav Edén
     */
    public void writePlayersToFile(){
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Choose location To Save Report");


        File selectedFile = null;
        if(selectedFile==null) {
            selectedFile = chooser.showSaveDialog(null);
        }

        PrintWriter outFile = null;
        try {
            outFile = new PrintWriter(selectedFile+".txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(int i = 0; i< listOfPlayers.size(); i++){
            outFile.println(listOfPlayers.get(i));
        }
        outFile.close();
    }
    /**
     * Reads from groups from a file
     * @author Gustav Edén
     */
    public void readGroupFromFile(){
        FileChooser chooser1= new FileChooser();
        File file= chooser1.showOpenDialog(null);
        try {
            BufferedReader in;
            in = new BufferedReader(new FileReader(file));
            String line = in.readLine();

            while (line != null) {
                listAddedPlayers.getItems().add(line);
                mainController.addPlayer(new Player(line));
                line = in.readLine();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


}
