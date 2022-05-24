package Domain;

import java.util.Date;

public class Player {
    String name,position,team;
    Date BD;
    public Player(){

    }
    public Player(String name,String team, String position, Date BD){
        this.name = name;
        this.team = team;
        this.position = position;
        this.BD = BD;
    }

    public String getName (){
        return name;

    }
    public void setName(String playerName){
        name = playerName;
    }

}
