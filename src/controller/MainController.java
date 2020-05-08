package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author Andreas von Uthmann, Carl Hägred, Gustav Edén, Joel Svensson
 */
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

    /**
     * Sends the instance of the mainController to scene in the parameters
     */
    public void sendSelfToControllers(FXMLLoader loader) {
        ((SceneControllerParent) loader.getController()).setMainController(this);
    }

    /**
     * Displays the scene that you calls upon
     */
    public void setScene(ScenesEnum sceneToShow){
        sceneSetter.setScene(sceneToShow);
    }

    /**
     * This class is responsible for adding all scenes to a hashmap
     */
    private class SceneSetter {

        private ScenesHashMap scenes = new ScenesHashMap();

        /**
         * Adds all scenes to the hashmap
         */
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

            FXMLLoader groupStageLoader = new FXMLLoader(getClass().getResource("../view/GroupStage.fxml"));
            Scene groupStageScene = new Scene(groupStageLoader.load());
            sendSelfToControllers(groupStageLoader);

            FXMLLoader ThreePlayerLoader = new FXMLLoader(getClass().getResource("../view/ThreeTeamsPlayoff.fxml"));
            Scene ThreePlayerScene = new Scene(ThreePlayerLoader.load());
            sendSelfToControllers(ThreePlayerLoader);

            FXMLLoader FourPlayerLoader = new FXMLLoader(getClass().getResource("../view/fourTeamsPlayoff.fxml"));
            Scene FourPlayerScene = new Scene(FourPlayerLoader.load());
            sendSelfToControllers(FourPlayerLoader);

            FXMLLoader FivePlayerLoader = new FXMLLoader(getClass().getResource("../view/FiveTeamsPlayoff.fxml"));
            Scene FivePlayerScene = new Scene(FivePlayerLoader.load());
            sendSelfToControllers(FivePlayerLoader);

            FXMLLoader SixPlayerLoader = new FXMLLoader(getClass().getResource("../view/SixTeamsPlayoff.fxml"));
            Scene SixPlayerScene = new Scene(SixPlayerLoader.load());
            sendSelfToControllers(SixPlayerLoader);

            FXMLLoader SevenPlayerLoader = new FXMLLoader(getClass().getResource("../view/SevenTeamsPlayoff.fxml"));
            Scene SevenPlayerScene = new Scene(SevenPlayerLoader.load());
            sendSelfToControllers(SevenPlayerLoader);

            FXMLLoader EightPlayerLoader = new FXMLLoader(getClass().getResource("../view/EightTeamPlayoffs.fxml"));
            Scene EightPlayerScene = new Scene(EightPlayerLoader.load());
            sendSelfToControllers(EightPlayerLoader);

            FXMLLoader NinePlayerLoader = new FXMLLoader(getClass().getResource("../view/NineTeamsPlayoff.fxml"));
            Scene NinePlayerScene = new Scene(NinePlayerLoader.load());
            sendSelfToControllers(NinePlayerLoader);

            FXMLLoader TenPlayerLoader = new FXMLLoader(getClass().getResource("../view/TenTeamsPlayoff.fxml"));
            Scene TenPlayerScene = new Scene(TenPlayerLoader.load());
            sendSelfToControllers(TenPlayerLoader);

            scenes.put(ScenesEnum.FirstPage, firstPageScene);
            scenes.put(ScenesEnum.Team, teamScene);
            scenes.put(ScenesEnum.Player, playerScene);
            scenes.put(ScenesEnum.GroupStage, groupStageScene);
            scenes.put(ScenesEnum.ThreeTeamsPlayoff, ThreePlayerScene);
            scenes.put(ScenesEnum.FourTeamsPlayoff, FourPlayerScene);
            scenes.put(ScenesEnum.FiveTeamsPlayoff, FivePlayerScene);
            scenes.put(ScenesEnum.SixTeamsPlayoff, SixPlayerScene);
            scenes.put(ScenesEnum.SevenTeamsPlayoff, SevenPlayerScene);
            scenes.put(ScenesEnum.EightTeamsPlayoff, EightPlayerScene);
            scenes.put(ScenesEnum.NineTeamsPlayoff, NinePlayerScene);
            scenes.put(ScenesEnum.TenTeamsPlayoff, TenPlayerScene);
        }

        /**
         * Displays the selected scene
         */
        public void setScene(ScenesEnum sceneName) {
            if (scenes.get(sceneName) != mainWindow.getScene())
                mainWindow.setScene(scenes.get(sceneName));
        }
    }

    /**
     * Adds a player object
     */
    public void addPlayer(Player player){
        tournament.setPlayer(player);
    }

    /**
     * Returns a player object
     */
    public Player getPlayer(int i){
        return tournament.getPlayer(i);
    }

    /**
     * Returns the list of all players
     */
    public ArrayList<Player> getPlayers(){
        return tournament.getArrayListPlayers();
    }

    /**
     * Removes a player object
     */
    public void removePlayer(int i){
        tournament.removePlayer(i);
    }

    /**
     * Saves the amount of teams
     */
    public void setAmountOfTeams(AmountOfTeams amountOfTeams){
        tournament.setAmountOfTeams(amountOfTeams);
    }

    /**
     * gets the amount of teams
     */
    public AmountOfTeams getAmountOfTeams(){
        return tournament.getAmountOfTeams();
    }
}
