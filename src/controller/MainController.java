package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController {

    private Stage mainWindow;
    private SceneSetter sceneSetter = new SceneSetter();

    public MainController(Stage mainWindow) {
        this.mainWindow = mainWindow;

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

            FXMLLoader setupLoader = new FXMLLoader(getClass().getResource("../view/SetupGUI.fxml"));
            Scene setupScene = new Scene(setupLoader.load());
            sendSelfToControllers(setupLoader);

            FXMLLoader groupStageLoader = new FXMLLoader(getClass().getResource("../view/SetupGUI.fxml"));
            Scene groupStageScene = new Scene(groupStageLoader.load());
            sendSelfToControllers(groupStageLoader);

            scenes.put(ScenesEnum.FirstPage, firstPageScene);
            scenes.put(ScenesEnum.Setup, setupScene);
            scenes.put(ScenesEnum.GroupStage, groupStageScene);
        }

        public void setScene(ScenesEnum sceneName) {
            if (scenes.get(sceneName) != mainWindow.getScene())
                mainWindow.setScene(scenes.get(sceneName));
        }
    }
}
