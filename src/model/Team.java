package model;

import java.util.ArrayList;

/**
 * The class represent teams in the tournament
 * @author Carl Hagred
 */
public class Team {

    private String name;
    private String player1;
    private String player2;
    private String player3;
    private String player4;
    private String player5;
    private String player6;
    private String player7;
    private String player8;
    private String player9;
    private String player10;

    private final ArrayList<Player> players = new ArrayList();

    public Team(){}

    public Team(String name, String player1, String player2){
        this.name = name;
        this.player1 = player1;
        this.player2 = player2;
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

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayer3() {
        return player3;
    }

    public void setPlayer3(String player3) {
        this.player3 = player3;
    }
}
