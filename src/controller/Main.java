package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        /*FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/FirstPage.fxml"));
        Parent config = loader.load();
        primaryStage.setTitle("Easy Tournament");
        primaryStage.setScene(new Scene(config,750,600));
        primaryStage.show();

         */
        new MainController(primaryStage);
    }

    public void setTeamGUI(){
    }

    public void setOverViewGUI(){

    }
    public static void main(String[] args) {
        launch(args);
    }
}
