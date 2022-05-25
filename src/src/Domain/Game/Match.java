package Domain.Game;

import java.sql.Time;
import java.sql.Date;

public class Match {
    String home;
    String away;
    String league;

    java.util.Date date ;
    java.sql.Date sqlDate;
    Time time;
    String referee;
    int season;

    public void setTime(Time time) {
        this.time = time;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSeason() {
        return season;
    }

    public Match(Date date, String home, String away, String league, String referee, Time time, int season){
        this.home = home;
        this.away = away;
        this.league = league;
        this.date =date;
        this.sqlDate= new java.sql.Date(date.getTime());
        this.time = time;
        this.referee = referee;
        this.season=season;
    }

    public Match(Date date, String home, String away, String league, String referee, Time time){
        this.home = home;
        this.away = away;
        this.league = league;
        this.date =date;
        this.sqlDate= new java.sql.Date(date.getTime());
        this.time = time;
        this.referee = referee;
    }
    public String getHome(){
        return home;
    }
    public String getAway(){
        return away;
    }
    public String getLeague(){
        return league;
    }
    public  java.sql.Date getDate(){
        return this.sqlDate;
    }
    public Time getTime() {
        return time;
    }
    public String getREfereeName(){
        return referee;
    }
}
