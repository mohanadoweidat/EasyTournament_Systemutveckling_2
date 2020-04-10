public class Tournament {

    private int amountOfTeams;
    private Config config;
    private boolean groupStage = false;
    private boolean playOffs = false;


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
}
