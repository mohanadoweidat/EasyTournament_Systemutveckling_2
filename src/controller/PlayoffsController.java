package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.*;

public class PlayoffsController extends SceneControllerParent{

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
    @FXML
    private TextField tfQual1 = new TextField();
    @FXML
    private TextField tfQual2 = new TextField();
    @FXML
    private TextField tfQual3 = new TextField();
    @FXML
    private TextField tfQual4 = new TextField();
    @FXML
    private TextField tfTeam3 = new TextField();
    @FXML
    private TextField tfTeam4 = new TextField();
    @FXML
    private TextField tfTeam5 = new TextField();
    @FXML
    private TextField tfTeam6 = new TextField();
    @FXML
    private TextField tfTeam7 = new TextField();
    @FXML
    private TextField tfTeam8 = new TextField();
    @FXML
    private TextField tfSemifinal1Away = new TextField();
    @FXML
    private TextField tfSemifinal2Home = new TextField();
    @FXML
    private TextField tfSemifinal2Away = new TextField();
    @FXML
    private TextField tfFinalHome = new TextField();
    @FXML
    private TextField tfFinalAway = new TextField();
    @FXML
    private Label lblSemifinal1Home = new Label();
    @FXML
    private Label lblSemifinal1Away = new Label();
    @FXML
    private Label lblSemifinal2Home = new Label();
    @FXML
    private Label lblSemifinal2Away = new Label();
    @FXML
    private Label lblFinalHome = new Label();
    @FXML
    private Label lblFinalAway = new Label();
    @FXML
    private Label lblWinner = new Label();
    @FXML
    private Label lblQfHome = new Label();
    @FXML
    private Label lblQf2 = new Label();
    @FXML
    private Label lblQualGame1Home = new Label();
    @FXML
    private Label lblQualGame1Away = new Label();
    @FXML
    private Label lblQualGame2Home = new Label();
    @FXML
    private Label lblQualGame2Away = new Label();
    @FXML
    private Label lblQf3Home = new Label();
    @FXML
    private Label lblQf3Away = new Label();
    @FXML
    private Label lblQf4Home = new Label();
    @FXML
    private Label lblQf4Away = new Label();

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
        }catch(NumberFormatException ex){
            ex.printStackTrace();
        }
    }

    public void qualificationGameOneForNineAndTenTeams(){
        int scoreQual1 = Integer.parseInt(tfQual1.getText());
        int scoreQual2 = Integer.parseInt(tfQual2.getText());

        if (scoreQual1 > scoreQual2){
            tfTeam5.setPromptText("Team 5");
            lblQf3Home.setText("Team 5");
        } else {
            tfTeam5.setPromptText("Team 6");
            lblQf3Home.setText("Team 6");
        }
    }
    public void qualificationGameTwoForTenTeams(){
        int scoreQual1 = Integer.parseInt(tfQual3.getText());
        int scoreQual2 = Integer.parseInt(tfQual4.getText());

        if (scoreQual1 > scoreQual2){
            tfTeam8.setPromptText("Team 9");
            lblQf4Away.setText("Team 9");
        } else {
            tfTeam8.setPromptText("Team 10");
            lblQf4Away.setText("Team 10");
        }
    }
    public void gameOne(){
        int score1 = Integer.parseInt(tfTeam1.getText());
        int score2 = Integer.parseInt(tfTeam2.getText());

        if (score1 > score2) {
            tfSemifinal1Home.setPromptText("Team 1");
            lblSemifinal1Home.setText("Team 1");
        } else if (score1 < score2){
            tfSemifinal1Home.setPromptText("Team 2");
            lblSemifinal1Home.setText("Team 2");
        }
    }

    public void gameTwo(){
        int score3 = Integer.parseInt(tfTeam3.getText());
        int score4 = Integer.parseInt(tfTeam4.getText());

        if (score3 > score4){
            tfSemifinal1Away.setPromptText("Team 3");
            lblSemifinal1Away.setText("Team 3");
        }else {
            tfSemifinal1Away.setPromptText("Team 4");
            lblSemifinal1Away.setText("Team 4");
        }
    }

    public void gameThree(){
        int score5 = Integer.parseInt(tfTeam5.getText());
        int score6 = Integer.parseInt(tfTeam6.getText());

        if (score5 > score6){
            tfSemifinal2Home.setPromptText(lblQf3Home.getText());
            lblSemifinal2Home.setText(lblQf3Home.getText());
        } else{
            tfSemifinal2Home.setPromptText(lblQf3Away.getText());
            lblSemifinal2Home.setText(lblQf3Away.getText());
        }
    }

    public void gameFour(){
        int score7 = Integer.parseInt(tfTeam7.getText());
        int score8 = Integer.parseInt(tfTeam8.getText());

        if (score7 > score8){
            tfSemifinal2Away.setPromptText(lblQf4Home.getText());
            lblSemifinal2Away.setText(lblQf4Home.getText());
        } else{
            tfSemifinal2Away.setPromptText(lblQf4Away.getText());
            lblSemifinal2Away.setText(lblQf4Away.getText());
        }
    }

    public void gameFive(){
        int score9 = Integer.parseInt(tfSemifinal1Home.getText());
        int score10 = Integer.parseInt(tfSemifinal1Away.getText());

        if (score9 > score10){
            lblFinalHome.setText(lblSemifinal1Home.getText());
            tfFinalHome.setPromptText(lblSemifinal1Home.getText());
        } else {
            lblFinalHome.setText(lblSemifinal1Away.getText());
            tfFinalHome.setPromptText(lblSemifinal1Away.getText());
        }
    }

    public void gameSix(){
        int score11 = Integer.parseInt(tfSemifinal2Home.getText());
        int score12 = Integer.parseInt(tfSemifinal2Away.getText());

        if (score11 > score12){
            lblFinalAway.setText(lblSemifinal2Home.getText());
            tfFinalAway.setPromptText(lblSemifinal2Home.getText());
        } else {
            lblFinalAway.setText(lblSemifinal2Away.getText());
            tfFinalAway.setPromptText(lblSemifinal2Away.getText());
        }
    }

    public void gameSeven(){
        int score13 = Integer.parseInt(tfFinalHome.getText());
        int score14 = Integer.parseInt(tfFinalAway.getText());

        if (score13 > score14){
            lblWinner.setText(lblFinalHome.getText());
        } else {
            lblWinner.setText(lblFinalAway.getText());
        }
    }
}

