import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent config = FXMLLoader.load(getClass().getResource("TournamentConfig.fxml"));
        primaryStage.setTitle("Easy Tournament");
        primaryStage.setScene(new Scene(config,750,600));
        primaryStage.show();
    }

    public void setTeamGUI(){
    }

    public void setOverViewGUI(){

    }
    public static void main(String[] args) {
        launch(args);
    }
}
