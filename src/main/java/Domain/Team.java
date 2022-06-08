package Domain;

import java.util.Date;

public class Team {

    private int id;
    private String name;
    private String coach;
    private String league;
    private String country;
//    private Player player = new Player();
//    private Player [] players;

    public Team(int id,String name ,String coach ,String league,  String country){
        this.name = name;
        this.id = id;
        this.coach = coach;
        this.country = country;
        this.league = league;
    }
    public Team( String league,  String country){
        this.name = "";
        this.id = 0;
        this.coach = "";
        this.country = country;
        this.league = league;
    }


    public int getTeamId(){
        return id;
    }
    public String getName (){
        return name;

    }
    public String getCoachName(){
        return coach;
    }
    public String getLeagueName(){
        return league;
    }
    public String getCountryName(){
        return country;
    }
}
