//package controller;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import model.*;
//
//import java.io.IOException;
//
//public class PlayoffsController {
//    private Controller controller;
//    private AmountOfTeams amountOfTeams;
//
//    public PlayoffsController(Controller controller) {
//        this.controller = controller;
//    }
//
//    @FXML
//    public void setPlayoffsGUI(ActionEvent event, AmountOfTeams selectedItem) throws IOException {
//        this.amountOfTeams=selectedItem;
//        FXMLLoader loader = new FXMLLoader();
//        switch (selectedItem) {
//            case Three:
//                loader.setLocation(getClass().getResource("../view/ThreeTeamsPlayoff.fxml"));
//            case Four:
//                loader.setLocation(getClass().getResource("../view/fourTeamsPlayoff.fxml"));
//            case Five:
//                loader.setLocation(getClass().getResource("../view/FiveTeamsPlayoff.fxml"));
//            case Six:
//                loader.setLocation(getClass().getResource("../view/SixTeamsPlayoff.fxml"));
//            case Seven:
//                loader.setLocation(getClass().getResource("../view/SevenTeamsPlayoff.fxml"));
//            case Eight:
//                loader.setLocation(getClass().getResource("../view/EightTeamPlayoffs.fxml"));
//            case Nine:
//                loader.setLocation(getClass().getResource("../view/NineTeamsPlayoff.fxml"));
//            case Ten:
//                loader.setLocation(getClass().getResource("../view/TenTeamsPlayoff.fxml"));
//                break;
//        }
//        Parent playerGUI = loader.load();
////        Controller controller = loader.getController();
//        Scene playerScene = new Scene(playerGUI);
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setScene(playerScene);
//        window.show();
//    }
//}
//