package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import Domain.Game.Match;
public class MatchDaoSQL implements Dao<Match>{
    private static final MatchDaoSQL instance = new MatchDaoSQL();
    public static MatchDaoSQL getInstance(){
        return instance;
    }
    private MatchDaoSQL() {
    }
    DBConnector dbc = DBConnector.getInstance();


    @Override
    public ArrayList<Match> getTeam(String country1) {
        return null;
    }

    @Override
    public Match get(String username, String password) {
    return null;
    }

    @Override
    public void save(Match match) throws SQLException {
        try {
            Connection connection = DBConnector.getConnection();
            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO matches " +
                    "VALUES ('" + match.getDate() + "','" + match.getHome() + "', '" + match.getAway() + "', '" + match.getLeague() + "', NULL ,'" + match.getTime() + "');";
            System.out.println(sql);
            stmt.executeUpdate(sql);
        } catch (java.sql.SQLException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public ArrayList<String> get_Matches(Match referee) {
        return null;
    }
}

