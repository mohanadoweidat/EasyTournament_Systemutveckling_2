import java.io.IOException;

public class Controller {
    private Main main;

    public void saveConfig(){

    }

    public void amountOfTeams(){

    }

    public void structure(){

    }

    public void setConfigGUI(){
        try {
            main.setConfigGUI();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void setPlayerGUI(){
        try {
            main.setPlayerGUI();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
