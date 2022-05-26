package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import Domain.Game.Match;
import Domain.Team;

public class MatchDaoSQL implements Dao<Match>{
    private static final MatchDaoSQL instance = new MatchDaoSQL();
    public static MatchDaoSQL getInstance(){
        return instance;
    }
    private MatchDaoSQL() {
    }
    DBConnector dbc = DBConnector.getInstance();

    @Override
    public Match get(String username, String password) {
    return null;
    }

    @Override
    public void save(Match match)  {
        try {
            Connection connection = DBConnector.getConnection();
            System.out.println("connection success!");
            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO matches " +
                    "VALUES ('" + match.getDate() + "','" + match.getHome() + "', '" + match.getAway() + "', '" + match.getLeague() + "', NULL ,'" + match.getTime() +"', '"+match.getSeason()+ "');";
            System.out.println(sql);
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean delete(Match match) {
        return true;
    }

    @Override
    public ArrayList<String> get_Matches(Match referee) {
        return null;
    }

    public Boolean getSeasonLeague(String league,int season) {


        ArrayList<Team> ans=new ArrayList<Team>();
        try {
            Connection connection = DBConnector.getConnection();

            Statement stmt = connection.createStatement();
            String sql ="Select * From matches Where matches.league = '" + league + "'" +" AND "+"matches.season = '"+season+"'";
            System.out.println(sql);
            ResultSet resultSet = stmt.executeQuery(sql);

            if (resultSet.next()==false) return false;

            return true;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }


    }


}

