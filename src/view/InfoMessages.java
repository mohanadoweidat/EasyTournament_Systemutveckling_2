package view;

import javafx.scene.control.Alert;

public class InfoMessages
{
    private Alert alert;

   public void pickTeamAndPlayerMessage()
   {
       alert = new Alert(Alert.AlertType.WARNING);
       alert.setTitle("Information");
       alert.setHeaderText(null);
       alert.setContentText("Pick a team and a player!");
       alert.showAndWait();
   }

   public void emptyTeamOrPlayerMessage()
   {
       alert = new Alert(Alert.AlertType.ERROR);
       alert.setTitle("Information");
       alert.setHeaderText(null);
       alert.setContentText("There is no teams or players!");
       alert.showAndWait();
   }
}
