package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * This class stores the stats of the teams
 *
 * @author Andreas von Uthmann, Carl Hägred, Gustav Edén, Joel Svensson
 */
public class TeamStats {
    private SimpleStringProperty teams,position;
    private SimpleIntegerProperty points,draws,wins,losses;

    public TeamStats(String position,String teams,int wins,int draws,int losses,int points){
        this.position=new SimpleStringProperty(position);
        this.teams=new SimpleStringProperty(teams);
        this.wins=new SimpleIntegerProperty(wins);
        this.draws= new SimpleIntegerProperty(draws);
        this.losses=new SimpleIntegerProperty(losses);
        this.points=new SimpleIntegerProperty(points);
    }


    /**
     * Returns the selected team
     */
    public String getTeams() {
        return teams.get();
    }

    /**
     * Saves the selected team
     */
    public void setTeams(String teams) {
        this.teams.set(teams);
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