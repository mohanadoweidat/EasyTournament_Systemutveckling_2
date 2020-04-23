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
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/FirstPage.fxml"));
        Parent config = loader.load();
//        Parent config = FXMLLoader.load(controller.Main.class.getResource("fxml/FirstPage.fxml"));
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
