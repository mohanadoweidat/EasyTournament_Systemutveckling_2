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

    public Team(String name, String player1, String player2,String player3,String player4,String player5,String player6,String player7,String player8,String player9,String player10){
        this.name = name;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.player5 = player5;
        this.player6 = player6;
        this.player7 = player7;
        this.player8 = player8;
        this.player9 = player9;
        this.player10 = player10;



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

    public String getPlayer4() {
        return player4;
    }

    public void setPlayer4(String player4) {
        this.player4 = player4;
    }

    public String getPlayer5() {
        return player5;
    }

    public void setPlayer5(String player5) {
        this.player5 = player5;
    }

    public String getPlayer6() {
        return player6;
    }

    public void setPlayer6(String player6) {
        this.player6 = player6;
    }

    public String getPlayer7() {
        return player7;
    }

    public void setPlayer7(String player7) {
        this.player7 = player7;
    }

    public String getPlayer8() {
        return player8;
    }

    public void setPlayer8(String player8) {
        this.player8 = player8;
    }

    public String getPlayer9() {
        return player9;
    }

    public void setPlayer9(String player9) {
        this.player9 = player9;
    }

    public String getPlayer10() {
        return player10;
    }

    public void setPlayer10(String player10) {
        this.player10 = player10;
    }
}
