package model;


//import controller.PlayersController;
//import controller.TeamsController;

import java.util.ArrayList;

/**
 * The class is responsible for save tha tournaments information
 * @author Andreas von Uthmann, Carl Hägred, Gustav Edén, Joel Svensson
 */
public class Tournament {

    private AmountOfTeams amountOfTeams;
    private int teamIndex = 1;
    private ArrayList<Player> arrayListPlayers = new ArrayList();
    private ArrayList teams = new ArrayList();

    /**
     * Saves the amount of teams that gets sent in trough parameters
     * @param amountOfTeams the amount of teams
     */
    public void setAmountOfTeams(AmountOfTeams amountOfTeams){
        this.amountOfTeams = amountOfTeams;
    }

    /**
     * Switches the groupStage boolean between true and false
     */

    /**
     * Saves the player that is getting sent in trough the parameters to the players list
     * @param player a player name
     */
    public void setPlayer(Player player){
        arrayListPlayers.add(player);
    }

    public Player getPlayer(int i){
        return arrayListPlayers.get(i);
    }

    public void removePlayer(int i){
        arrayListPlayers.remove(i);
    }

    /**
     * Returns a list of different players
     * @return the list of different players
     */
    public ArrayList<Player> getArrayListPlayers(){
        return arrayListPlayers;
    }

    public AmountOfTeams getAmountOfTeams(){
        return amountOfTeams;
    }
}
