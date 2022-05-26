package Domain.Game;
import Domain.Team;
import Domain.TeamController;
import Domain.TeamController.*;
import java.util.Date;
import java.sql.Time;
import java.util.ArrayList;


public class League {
    public static ArrayList<Team> spainLeague;
    public static ArrayList<Team> israeliLeague;
    private String name;

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date startDate;
    public Time officalTime;

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        // get Date and add 1
        int year=this.startDate.getYear();
        int month=this.startDate.getMonth();
        int day=this.startDate.getDay();

        day++;

        if(day>28)
        {
            day=1;
            month++;
        }
        if(month>12)
            year++;
        this.startDate=new Date(year,month,day);

        return startDate;
    }

    public Time getOfficalTime() {
        return officalTime;
    }

    //    public League(String name){
//        this.name = name;
//    }
    public League (String name,int season){
        TeamController teamController=new TeamController();
        this.name=name;
        this.startDate=new Date(season-1900,1,1);
        this.officalTime=new Time (20,30,00);
        this.israeliLeague =teamController.getTeams("Israel");
        this.spainLeague =teamController.getTeams("Spain");
    }
    public League (String name){
        TeamController teamController=new TeamController();
        this.name=name;
        this.startDate=new Date(2022,7,28);
        this.officalTime=new Time (20,30,00);
        this.israeliLeague =teamController.getTeams("Israel");
        this.spainLeague =teamController.getTeams("Spain");
    }
//    public ArrayList<Team> getIsraelTeams(){
//        Team temp= new Team("Ligat Haal","Israel");
////
////    }
    public ArrayList<Team> getTeam2(){
        return spainLeague;
    }
    public void setIsraeliLeague(int id,String name,String coach,String league,String country){
       Team teamToAdd = new Team(id,name,coach,league,country);
        israeliLeague.add(teamToAdd);
    }
    public void setSpainLeague(int id,String name,String coach,String league,String country){
        Team teamToAdd = new Team(id,name,coach,league,country);
        spainLeague.add(teamToAdd);
    }


}
