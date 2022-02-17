package controller;

import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import model.Player;
import view.InfoMessages;

import java.io.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Connects the Players fxml-file with the rest of the system
 * @author Andreas von Uthmann, Carl Hägred, Gustav Edén, Joel Svensson
 */

public class PlayersController extends SceneControllerParent {

    @FXML
    private ListView listAddedPlayers = new ListView();
    @FXML
    private TextField tfPlayerName = new TextField();

    private ObservableList<String> listOfPlayers = FXCollections.observableArrayList();

    private InfoMessages infoMessages = new InfoMessages();

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
    }

    /**
     * Adds a player to the game
     */
    @FXML
    public void addPlayersToList()
    {
        String test = tfPlayerName.getText();
        if (test.isBlank())
        {
            infoMessages.emptyName();
        }
        else if (Character.isDigit(test.charAt(0)))
        {
            infoMessages.specialName();
        }
        else {
            if(!checkPlayerName(tfPlayerName.getText()))
            {
                listAddedPlayers.getItems().add(tfPlayerName.getText());
                listOfPlayers.add(tfPlayerName.getText());
                mainController.addPlayer(new Player(tfPlayerName.getText()));
            }
            else
            {
                infoMessages.nameAlreadyExist();
            }
        }
        tfPlayerName.setText("");
    }

    private boolean checkPlayerName(String name)
    {
        for (int i = 0; i < listOfPlayers.size(); i++)
        {
            if(listOfPlayers.get(i).equals(name))
            {
                return true;
            }

        }
        return false;
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
            listOfPlayers.remove(selectedIndex);
        } else{
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Delete problems");
            alert1.setHeaderText(null);
            alert1.setContentText("Select the player from the list that you want to remove");
            alert1.showAndWait();
        }
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
            if(selectedFile == null)
            {
                return;
            }
            else {
                outFile = new PrintWriter(selectedFile+".txt");
                for(int i = 0; i< listOfPlayers.size(); i++){
                    outFile.println(listOfPlayers.get(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
            if (file != null){
                in = new BufferedReader(new FileReader(file));
                String line = in.readLine();
            while (line != null) {
                listAddedPlayers.getItems().add(line);
                mainController.addPlayer(new Player(line));
                line = in.readLine();
            }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
