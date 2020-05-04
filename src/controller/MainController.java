package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

import model.*;

public class MainController {

    private Stage mainWindow;
    private Player player;
    private Tournament tournament;

    private SceneSetter sceneSetter = new SceneSetter();


    public MainController(Stage mainWindow, Player player, Tournament tournament) {
        this.mainWindow = mainWindow;
        this.player = player;
        this.tournament = tournament;

        try {
            sceneSetter.addScenesToHashMap();
        } catch (IOException e) {
            System.out.println("Error loading scenes");
            e.printStackTrace();
        }

        this.mainWindow.setTitle("Easy Tournament");
        sceneSetter.setScene(ScenesEnum.FirstPage);
        this.mainWindow.show();
    }

    public void sendSelfToControllers(FXMLLoader loader) {
        ((SceneControllerParent) loader.getController()).setMainController(this);
    }

    public void setScene(ScenesEnum sceneToShow){
        sceneSetter.setScene(sceneToShow);
    }

    private class SceneSetter {

        private ScenesHashMap scenes = new ScenesHashMap();

        private void addScenesToHashMap() throws IOException {
            FXMLLoader firstPageLoader = new FXMLLoader(getClass().getResource("../view/FirstPage.fxml"));
            Scene firstPageScene = new Scene(firstPageLoader.load());
            sendSelfToControllers(firstPageLoader);

            FXMLLoader teamLoader = new FXMLLoader(getClass().getResource("../view/TeamsGUI.fxml"));
            Scene teamScene = new Scene(teamLoader.load());
            sendSelfToControllers(teamLoader);

            FXMLLoader playerLoader = new FXMLLoader(getClass().getResource("../view/PlayersGUI.fxml"));
            Scene playerScene = new Scene(playerLoader.load());
            sendSelfToControllers(playerLoader);

            scenes.put(ScenesEnum.FirstPage, firstPageScene);
            scenes.put(ScenesEnum.Team, teamScene);
            scenes.put(ScenesEnum.Player, playerScene);
        }

        public void setScene(ScenesEnum sceneName) {
            if (scenes.get(sceneName) != mainWindow.getScene())
                mainWindow.setScene(scenes.get(sceneName));
        }
    }

    public void addPlayer(Player player){
        tournament.setPlayer(player);
    }

    public Player getPlayer(int i){
        return tournament.getPlayer(i);
    }

    public ArrayList<Player> getPlayers(){
        return tournament.getPlayers();
    }

    public void removePlayer(int i){
        tournament.removePlayer(i);
    }

    public void setAmountOfTeams(AmountOfTeams amountOfTeams){
        tournament.setAmountOfTeams(amountOfTeams);
    }

    public AmountOfTeams getAmountOfTeams(){
        return tournament.getAmountOfTeams();
    }
}
