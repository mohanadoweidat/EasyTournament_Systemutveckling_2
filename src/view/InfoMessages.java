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

    public void nameAlreadyExist()
    {
        alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Name already exist!");
        alert.showAndWait();
    }

    public void emptyName()
    {
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("Name problems");
        alert1.setHeaderText(null);
        alert1.setContentText("The name can't be empty");
        alert1.showAndWait();
    }

    public void specialName()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Name problems");
        alert.setHeaderText(null);
        alert.setContentText("The name needs to start with a letter");
        alert.showAndWait();
    }
}
