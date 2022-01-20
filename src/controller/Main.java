package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import model.*;

/**
 * @author Andreas von Uthmann, Carl Hägred, Gustav Edén, Joel Svensson
 */
public class Main extends Application { //test

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
