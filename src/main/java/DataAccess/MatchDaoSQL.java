package DataAccess;

import java.sql.*;
import java.util.ArrayList;

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
           // System.out.println("connection success!");
            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO matches " +
                    "VALUES ('" + match.getSQlDate() + "','" + match.getHome() + "', '" + match.getAway() + "', '" + match.getLeague() + "', NULL ,'" + match.getTime() +"', '"+match.getSeason()+ "');";
            //System.out.println(sql);

            stmt.executeUpdate(sql);
            stmt.close();
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


    public Boolean deleteSeason(String country,int season) {
        try {
            Connection connection = DBConnector.getConnection();
            Statement stmt = connection.createStatement();
            String sql = "Delete From matches  " +
                    "Where matches.league='" + country + "' and matches.season='" + season + "'";
            int resultSet = stmt.executeUpdate(sql);


            if(resultSet!=0){
                stmt.close();
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
        }






    public ArrayList<Match> getSeasonLeague(String league,int season) {


        ArrayList<Match> ans=new ArrayList<Match>();
        try {
            Connection connection = DBConnector.getConnection();

            Statement stmt = connection.createStatement();
            String sql ="Select * From matches Where matches.league = '" + league + "'" +" AND "+"matches.season = '"+season+"'";
            //System.out.println(sql);
            ResultSet resultSet = stmt.executeQuery(sql);


           // if (resultSet.next()==false) return false;
            while (resultSet.next()) {
                int s = Integer.parseInt(resultSet.getString("season"));
                String home = resultSet.getString("home");
                String away = resultSet.getString("away");
                String liga = resultSet.getString("league");

                Match match = new Match(new Date(0,0,0),home,away,liga,null,null,s);
                ans.add(match);
            }
            stmt.close();
            if(ans.size()>0)
            {
                return ans;
            }

            return null;
        }
        catch (Exception e)
        {

            throw new RuntimeException(e);
        }


    }


}

