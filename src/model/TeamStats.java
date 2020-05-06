package model;

public class TeamStats {
    private String teams,position;
    private int points;
    private int draws;

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    private int losses;
    private int wins;

    public TeamStats(String teams,String position,int points,int draws,int losses, int wins){
        this.teams=teams;
        this.position=position;
        this.points=points;
        this.draws= draws;
        this.losses=losses;
        this.wins=wins;
    }
}