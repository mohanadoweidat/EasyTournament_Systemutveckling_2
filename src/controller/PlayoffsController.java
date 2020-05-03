package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;

import java.awt.*;
import java.io.IOException;

public class PlayoffsController {
    private Controller controller;
    private AmountOfTeams amountOfTeams;

    @FXML
    private TextField tfTeam1 = new TextField();
    @FXML
    private TextField tfTeam2 = new TextField();
    @FXML
    private Label lblTeam1 = new Label();
    @FXML
    private Label lblSemifinal1 = new Label();

    @FXML
    private TextField tfSemifinal1Home = new TextField();



    public PlayoffsController(Controller controller) {
        this.controller = controller;
    }

    @FXML
    public void setPlayoffsGUI(ActionEvent event, AmountOfTeams selectedItem) throws IOException {
        this.amountOfTeams=selectedItem;
        FXMLLoader loader = new FXMLLoader();
        switch (selectedItem) {
            case Three:
                loader.setLocation(getClass().getResource("../view/ThreeTeamsPlayoff.fxml"));
                break;
            case Four:
                loader.setLocation(getClass().getResource("../view/fourTeamsPlayoff.fxml"));
                break;
            case Five:
                loader.setLocation(getClass().getResource("../view/FiveTeamsPlayoff.fxml"));
                break;
            case Six:
                loader.setLocation(getClass().getResource("../view/SixTeamsPlayoff.fxml"));
                break;
            case Seven:
                loader.setLocation(getClass().getResource("../view/SevenTeamsPlayoff.fxml"));
                break;
            case Eight:
                loader.setLocation(getClass().getResource("../view/EightTeamPlayoffs.fxml"));
                break;
            case Nine:
                loader.setLocation(getClass().getResource("../view/NineTeamsPlayoff.fxml"));
                break;
            case Ten:
                loader.setLocation(getClass().getResource("../view/TenTeamsPlayoff.fxml"));
                break;
        }
        Parent playerGUI = loader.load();
//        Controller controller = loader.getController();
        Scene playerScene = new Scene(playerGUI);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(playerScene);
        window.show();
    }

    public void results() {
        boolean winner = true;
        try {
            int score1 = Integer.parseInt(tfTeam1.getText());
            int score2 = Integer.parseInt(tfTeam2.getText());
            System.out.println(score1+ ", " + score2);

            if (score1 > score2) {
                tfSemifinal1Home.setPromptText("Team 1");
                lblSemifinal1.setText("Team 1");
            } else if (score1 < score2) {
                tfSemifinal1Home.setPromptText("Team 2");
                lblSemifinal1.setText("Team 2");
            }
        }catch(NumberFormatException ex){ // handle your exception

        }
    }
}
