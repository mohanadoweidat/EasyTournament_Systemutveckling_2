package model;


//import controller.PlayersController;
//import controller.TeamsController;

import java.util.ArrayList;

/**
 * The class is responsible for save tha tournaments information
 * @author Carl Hagred
 */
public class Tournament {

    private AmountOfTeams amountOfTeams;
    private int teamIndex = 1;
    private ArrayList<Player> players = new ArrayList();
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
        players.add(player);
    }

    public Player getPlayer(int i){
        return players.get(i);
    }

    public void removePlayer(int i){
        players.remove(i);
    }

    /**
     * Returns a list of different players
     * @return the list of different players
     */
    public ArrayList<Player> getPlayers(){
        return players;
    }

    public AmountOfTeams getAmountOfTeams(){
        return amountOfTeams;
    }
}
