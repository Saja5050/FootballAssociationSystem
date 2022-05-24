package DataAccess;

import Domain.Referee;
import Domain.Team;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class RefereeDaoSQL implements Dao<Referee> {
    private static final RefereeDaoSQL instance = new RefereeDaoSQL();
    //private constructor to avoid client applications to use constructor
    public static RefereeDaoSQL getInstance(){
        return instance;
    }
    private RefereeDaoSQL() {
    }
    DBConnector dbc = DBConnector.getInstance();


    @Override
    public ArrayList<Referee> getTeam(String country1) {
        return null;
    }

    @Override
    public Referee get(String username, String password) {
        try {
            Connection connection = DBConnector.getConnection();
            System.out.println("connection success!");
            Statement stmt = connection.createStatement();
            String sql = "Select * From users  " +
                    "Where users.username='" + username + "' and users.password='" + password + "' and users.referee = 1;";
            System.out.println(sql);
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                return new Referee(name, username, password);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    @Override
    public void save(Referee referee)  {
        try {
            Connection connection = DBConnector.getConnection();
            System.out.println("connection success!");
            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO users " +
                    "VALUES (NULL,'" + referee.getName() + "','" + referee.getUsername() + "', '" + referee.getPassword() + "',1);";
            System.out.println(sql);
            stmt.executeUpdate(sql);
        } catch (java.sql.SQLException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public ArrayList<String> get_Matches(Referee referee) {
        String username = referee.getUsername();
        ArrayList<String> matches = new ArrayList<>();
        try {
            Connection connection = DBConnector.getConnection();
            System.out.println("connection success!");
            Statement stmt = connection.createStatement();
            String sql = "Select * From matches  " +
                    "Where matches.referee='" + username + "';";
            System.out.println(sql);
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                // int i = resultSet.getInt("id");
                String home = resultSet.getString("home");
                String away = resultSet.getString("home");
                Date date = resultSet.getDate("date");
                matches.add( home + " VS " + away + "  " + date );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return matches;
    }


}
