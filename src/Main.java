import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;

public class Main extends Application {

    private Stage window;
    private Scene startGUI, configScene, playerScene, teamGUI, overViewGUI;




    @Override
    public void start(Stage primaryStage) throws IOException {

       window = primaryStage;

        //Parent config = FXMLLoader.load(getClass().getResource("TournamentConfig.fxml"));
        //Parent player = FXMLLoader.load(getClass().getResource("AddPlayerGui.fxml"));

        configScene = new Scene((FXMLLoader.load(getClass().getResource("TournamentConfig.fxml"))), 750,600);
        //playerScene = new Scene((FXMLLoader.load(getClass().getResource("AddPlayerGui.fxml"))), 750,600);

        window.setScene(configScene);
        window.setTitle("Easy Tournament");
        window.show();
    }

    public void setConfigGUI() throws IOException {
        window.setScene(new Scene((FXMLLoader.load(getClass().getResource("TournamentConfig.fxml"))), 750,600));
    }

    public void setPlayerGUI() throws IOException {
        window.setScene(new Scene((FXMLLoader.load(getClass().getResource("AddPlayerGui.fxml"))), 750,600));
    }

    public void setTeamGUI(){

    }

    public void setOverViewGUI(){

    }
    public static void main(String[] args) {
        launch(args);
    }
}
