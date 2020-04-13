import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tournament {

    private int amountOfTeams;
    private Config config;
    private boolean groupStage = false;
    private boolean playOffs = false;
    private int teamIndex = 1;
    private ArrayList players = new ArrayList();
    private ArrayList teams = new ArrayList();


    public void saveConfig(Config config){
        this.config = config;
    }

    public void amountOfTeams(int amountOfTeams){
        this.amountOfTeams = amountOfTeams;
    }

    public void groupStage() {
        groupStage = true;
    }

    public void playoffs() {
        groupStage = true;
    }

    public void addPlayer(String player){
        players.add(player);
    }

    public void addTeams(){
        for (int i = 0; i < amountOfTeams; i++){
            

            teamIndex++;
        }
    }




}
