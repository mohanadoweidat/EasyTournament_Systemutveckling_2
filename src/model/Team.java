package model;

import java.util.ArrayList;

/**
 * The class represent teams in the tournament
 * @author  Carl Hägred, Joel Svensson
 */
public class Team {

    private String name = " ", player1 = " ", player2 = " ", player3 = " ", player4 = " ", player5 = " ", player6 = " ", player7 = " ", player8 = " ", player9 = " ", player10 = " ";
    private int points = 0,draws = 0,wins = 0,losses = 0, timesToPlay = 0, games = 0;

    private final ArrayList<String> arrayListPlayers = new ArrayList();

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

    public Team(String player1, String player2,String player3,String player4,String player5,String player6,String player7,String player8,String player9,String player10){
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

    public Team(String name, String player1, String player2,String player3,String player4,String player5,String player6,String player7,String player8,String player9,String player10, int points, int draws, int wins, int losses){
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
        this.points = points;
        this.draws = draws;
        this.wins = wins;
        this.losses = losses;
    }

    public Team(String name) {
        this.name = name;
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
    public void addPlayers(String player){
        arrayListPlayers.add(player);
    }
    public ArrayList getPlayers(){
        return arrayListPlayers;
    }

    public void RemovePlayerFromRemoveList(String player){
        for (String s : arrayListPlayers) {
            if (s.equals(player)) {
                arrayListPlayers.remove(player);
                arrayListPlayers.trimToSize();
            }
        }
    }

    public void RemovePlayersTeam(){
        arrayListPlayers.clear();
        player1 = " ";
        player2 = " ";
        player3 = " ";
        player4 = " ";
        player5 = " ";
        player6 = " ";
        player7 = " ";
        player8 = " ";
        player9 = " ";
        player10 = " ";
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        arrayListPlayers.add(player1);
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        arrayListPlayers.add(player2);
        this.player2 = player2;
    }

    public String getPlayer3() {
        return player3;
    }

    public void setPlayer3(String player3) {
        arrayListPlayers.add(player3);
        this.player3 = player3;
    }

    public String getPlayer4() {
        return player4;
    }

    public void setPlayer4(String player4) {
        arrayListPlayers.add(player4);
        this.player4 = player4;
    }

    public String getPlayer5() {
        return player5;
    }

    public void setPlayer5(String player5) {
        arrayListPlayers.add(player5);
        this.player5 = player5;
    }

    public String getPlayer6() {
        return player6;
    }

    public void setPlayer6(String player6) {
        arrayListPlayers.add(player6);
        this.player6 = player6;
    }

    public String getPlayer7() {
        return player7;
    }

    public void setPlayer7(String player7) {
        arrayListPlayers.add(player7);
        this.player7 = player7;
    }

    public String getPlayer8() {
        return player8;
    }

    public void setPlayer8(String player8) {
        arrayListPlayers.add(player8);
        this.player8 = player8;
    }

    public String getPlayer9() {
        return player9;
    }

    public void setPlayer9(String player9) {
        arrayListPlayers.add(player9);
        this.player9 = player9;
    }

    public String getPlayer10() {
        return player10;
    }

    public void setPlayer10(String player10) {
        arrayListPlayers.add(player10);
        this.player10 = player10;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int i) {
        this.wins += i;
        this.points += 3;
        this.games += 1;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int i) {
        this.losses += i;
        this.games += 1;

    }

    public void reset(){
        this.losses = 0;
        this.points = 0;
        this.wins = 0;
        this.draws = 0;
        this.games = 0;
        this.timesToPlay = 0;
    }


    public void addRandomPlayer(String name){
        if ((player1.equals(" "))) {
            setPlayer1(name);
        } else if ((player2.equals(" "))) {
            setPlayer2(name);
        } else if ((player3.equals(" "))) {
            setPlayer3(name);
        } else if ((player4.equals(" "))) {
            setPlayer4(name);
        } else if ((player5.equals(" "))) {
            setPlayer5(name);
        } else if ((player6.equals(" "))) {
            setPlayer6(name);
        } else if ((player7.equals(" "))) {
            setPlayer7(name);
        } else if ((player8.equals(" "))) {
            setPlayer8(name);
        } else if ((player9.equals(" "))) {
            setPlayer9(name);
        } else if ((player10.equals(" "))) {
            setPlayer10(name);
        }
    }
}
