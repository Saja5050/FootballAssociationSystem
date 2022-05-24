package Domain.Game;

import java.sql.Time;
import java.sql.Date;

public class Match {
    String home;
    String away;
    String league;
    Date date;
    Time time;
    String referee;

    public void setTime(Time time) {
        this.time = time;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Match(Date date, String home, String away, String league, String referee, Time time){
        this.home = home;
        this.away = away;
        this.league = league;
        this.date = date;
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
    public Date getDate(){
        return date;
    }
    public Time getTime() {
        return time;
    }
    public String getREfereeName(){
        return referee;
    }
}
