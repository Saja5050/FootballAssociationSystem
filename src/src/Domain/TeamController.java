package Domain;
import DataAccess.*;


import java.util.ArrayList;

public  class TeamController {
    Dao ud;
    public TeamController() {ud = TeamDaoSQL.getInstance();
    }
    public ArrayList<Team> getTeams(String leagueName){
        try {
            return  (ArrayList<Team>)(((TeamDaoSQL)ud).getTeam(leagueName));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
