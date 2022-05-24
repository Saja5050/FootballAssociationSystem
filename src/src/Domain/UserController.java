package Domain;
import DataAccess.*;

import java.sql.SQLException;

public class UserController {
   Dao ud;
    public UserController() {ud = UserDaoSQL.getInstance();
    }
    public void insertUser (String Name, String UserName ,String Password ) {
        User aUser= new User(Name,UserName,Password);
        try {
            ud.save(aUser);
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
