package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import model.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Player player = new Player();
        Tournament tournament = new Tournament();
        new MainController(primaryStage, player, tournament);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
