package DataAccess;

import Domain.Referee;
import Domain.SystemManager;
import Domain.Team;
import Domain.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoSQL implements Dao<User> {
    private static final UserDaoSQL instance = new UserDaoSQL();
    //private constructor to avoid client applications to use constructor
    public static UserDaoSQL getInstance(){
        return instance;
    }
    private UserDaoSQL() {
        // users.add(new User("John", "john@domain.com"));
        //users.add(new User("Susan", "susan@domain.com"));
    }
    DBConnector dbc = DBConnector.getInstance();
    @Override
    public User get(String UserName, String Password) {
        try {
            Connection connection = DBConnector.getConnection();
            Statement stmt = connection.createStatement();
            String sql = "Select * From users  " +
                    "Where users.username='" + UserName + "' and users.password='" + Password + "';";
            //System.out.println(sql);
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                String Name = resultSet.getString("name");
                Boolean is_referee = resultSet.getBoolean("referee");
                if ( is_referee ){
                    return new Referee(Name, UserName, Password);
                }
                return new SystemManager(Name, UserName, Password);


            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    @Override
    public void save(User referee)  {
        try {
            Connection connection = DBConnector.getConnection();
            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO users " +
                    "VALUES (NULL,'" + referee.getName() + "','" + referee.getUsername() + "', '" + referee.getPassword() + "',1,0);";
            stmt.executeUpdate(sql);
        } catch (java.sql.SQLException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public Boolean delete(User user) {
        return null;
    }

    @Override
    public ArrayList<String> get_Matches(User referee) {
        return null;
    }



}
