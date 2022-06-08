package Domain;
import DataAccess.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class RefereeController {
    Dao ud;
    public RefereeController() {ud = RefereeDaoSQL.getInstance();
    }
    public void insertReferee (String Name, String UserName, String Password ) {
        Referee aReferee= new Referee(Name, UserName ,Password);
        try {
            ud.save(aReferee);
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
}
