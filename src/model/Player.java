package model;

/**
 *
 * @author Andreas von Uthmann, Carl Hägred, Gustav Edén, Joel Svensson
 */
public class Player {
    private String name;

    private String team1;

    public Player(String name){
        this.name=name;
    }
    public Player(){
        this.name="";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public void setTeam1(String str){
        this.team1 = str;
    }
}
