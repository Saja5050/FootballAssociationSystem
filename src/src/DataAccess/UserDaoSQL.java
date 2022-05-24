package DataAccess;

import Domain.Referee;
import Domain.Team;
import Domain.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDaoSQL implements Dao<User> {
    private static final UserDaoSQL instance = new UserDaoSQL();
    //private constructor to avoid client applications to use constructor
    public static UserDaoSQL getInstance(){
        return instance;
    }
    UserDaoSQL() {
        // users.add(new User("John", "john@domain.com"));
        //users.add(new User("Susan", "susan@domain.com"));
    }
    DBConnector dbc = DBConnector.getInstance();


    @Override
    public ArrayList<User> getTeam(String country1) {
        return null;
    }
    @Override
    public User get(String UserName, String Password) {
        try {
            Connection connection = DBConnector.getConnection();
            System.out.println("connection success!");
            Statement stmt = connection.createStatement();
            String sql = "Select * From users  " +
                    "Where users.username='" + UserName + "' and users.password='" + Password + "';";
            System.out.println(sql);
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                String Name = resultSet.getString("name");
                Boolean is_referee = resultSet.getBoolean("referee");
                if ( is_referee ){
                    return new Referee(Name, UserName, Password);
                }
                return new User(Name, UserName, Password);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    @Override
    public void save(User user)  {
            try {

                Connection connection = DBConnector.getConnection();
                System.out.println("connection success!");
                Statement stmt = connection.createStatement();
                String sql = "INSERT INTO User  " +
                        "VALUES (NULL," + user.getName() + ",'" + user.getUsername() + "', '" + user.getPassword() + "');";
                System.out.println(sql);
                stmt.executeUpdate(sql);
            } catch (java.sql.SQLException e) {
                System.out.println(e.toString());
            }

        }

    @Override
    public ArrayList<String> get_Matches(User referee) {
        return null;
    }


}
