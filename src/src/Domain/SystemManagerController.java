package Domain;
import DataAccess.*;

public class SystemManagerController {
    Dao ud;
    public SystemManagerController() {ud = UserDaoSQL.getInstance();
    }


    public void insertReferee (String Name, String UserName, String Password ) {
        Referee aReferee= new Referee(Name, UserName ,Password);
        try {
            ud.save(aReferee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public User sign_in(String userName, String password) {
        try {
            return (User) ud.get(userName,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
