package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * This class stores the stats of the teams
 *
 * @author Gustav Edén
 */
public class TeamStats {
    private SimpleStringProperty team,position;
    private SimpleIntegerProperty points,draws,wins,losses;

    public TeamStats(String position,String teams,int wins,int draws,int losses,int points){
        this.position = new SimpleStringProperty(position);
        this.team = new SimpleStringProperty(teams);
        this.wins = new SimpleIntegerProperty(wins);
        this.draws = new SimpleIntegerProperty(draws);
        this.losses = new SimpleIntegerProperty(losses);
        this.points = new SimpleIntegerProperty(points);
    }


    /**
     * Returns the selected team
     */
    public String getTeams() {
        return team.get();
    }

    /**
     * Saves the selected team
     */
    public void setTeams(String teams) {
        this.team.set(teams);
    }

    /**
     * Returns the
     */
    public String getPosition() {
        return position.get();
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    /**
     * Returns the points
     */
    public Integer getPoints() {
        return points.get();
    }

    public void setPoints(int points) {
        this.points.set(points);
    }

    /**
     * Returns the
     */
    public Integer getDraws() {
        return draws.get();
    }

    public void setDraws(int draws) {
        this.draws.set(draws);
    }

    /**
     * Returns the looser
     */
    public Integer getLosses() {
        return losses.get();
    }

    public void setLosses(int losses) {
        this.losses.set(losses);
    }

    /**
     * Returns the winner
     */
    public Integer getWins() {
        return wins.get();
    }

    public void setWins(int wins) {
        this.wins.set(wins);
    }




}