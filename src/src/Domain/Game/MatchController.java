package Domain.Game;

import DataAccess.Dao;
import DataAccess.MatchDaoSQL;
import DataAccess.RefereeDaoSQL;
import Domain.Referee;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Time;

public class MatchController {
    Dao ud;
    public MatchController() {ud = MatchDaoSQL.getInstance();
    }
    public void insertMatch (Match toInsert ) {

        try {
            ud.save(toInsert);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> getMatches(Referee referee ){
        try {
            return ud.get_Matches(referee);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Match> busyYear(String league, int season){


        return ((MatchDaoSQL)ud).getSeasonLeague(league,season);


    }


}
