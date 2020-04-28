package model;

import java.util.ArrayList;

/**
 * The class represent teams in the tournament
 * @author Carl Hagred
 */
public class Team {

    private String name;
    private final ArrayList<Player> players = new ArrayList();

    public Team(String name){
        this.name=name;
    }

    /**
     * Returns the name of the team
     * @return name as a string
     */
    public String getName() {
        return name;
    }

    /**
     * Changes the name of the team
     * @param name a string
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Adds a player instance to the players list
     * @param player an instance of the Player-class
     */
    public void addPlayers(Player player){
        players.add(player);
    }
}
