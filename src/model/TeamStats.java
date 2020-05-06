package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

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


    public String getTeams() {
        return teams.get();
    }

    public void setTeams(String teams) {
        this.teams.set(teams);
    }

    public String getPosition() {
        return position.get();
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    public Integer getPoints() {
        return points.get();
    }

    public void setPoints(int points) {
        this.points.set(points);
    }

    public Integer getDraws() {
        return draws.get();
    }

    public void setDraws(int draws) {
        this.draws.set(draws);
    }

    public Integer getLosses() {
        return losses.get();
    }

    public void setLosses(int losses) {
        this.losses.set(losses);
    }

    public Integer getWins() {
        return wins.get();
    }

    public void setWins(int wins) {
        this.wins.set(wins);
    }




}