import java.util.ArrayList;

public class Tournament {

    private String amountOfTeams;
    private Config config;
    private boolean groupStage = false;
    private boolean playOffs = false;
    private int teamIndex = 1;
    private ArrayList players = new ArrayList();
    private ArrayList teams = new ArrayList();
    private Controller controller;

    /**
     * Saves the Controller that gets sent in through tha parameters in the Controller variable
     * @param controller the Controller class
     */
    public Tournament(Controller controller){
        this.controller=controller;
    }

    /**
     * Saves the new config for the tournament
     * @param config the setup for the tournament
     */
    public void saveConfig(Config config){
        this.config = config;
    }

    /**
     * Saves the amount of teams that gets sent in trough parameters
     * @param amountOfTeams the amount of teams
     */
    public void setAmountOfTeams(String amountOfTeams){
        this.amountOfTeams = amountOfTeams;
        System.out.println(this.amountOfTeams);
    }

    /**
     * Switches the groupStage boolean between true and false
     */
    public void groupStage() {
        if (groupStage){
            groupStage=false;
        }else if (!groupStage){
            groupStage=true;
        }
    }

    /**
     * Switches the playOffs boolean between true and false
     */
    public void playoffs() {
        if (playOffs){
            playOffs=false;
        }else if (!playOffs){
            playOffs=true;
        }
    }

    /**
     * Saves the player that is getting sent in trough the parameters to the players list
     * @param player a player name
     */
    public void addPlayer(String player){
        players.add(player);
        System.out.println(players);
    }


    /**
     * Returns a list of different players
     * @return the list of different players
     */
    public ArrayList getPlayersList(){
        return players;
    }

    /**
     * Adds all the saved information for the tournament and returns it
     * @return The summering of the tournament setup
     */
    public String toString(){
        return (String)amountOfTeams; //+ "\n" + groupStage + "\n" + playOffs + "\n" + players;
    }
}
