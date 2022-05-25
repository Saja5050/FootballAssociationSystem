package DataAccess;

import Domain.Team;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class TeamDaoSQL implements Dao<Team> {
        private static final TeamDaoSQL instance = new TeamDaoSQL();
        //private constructor to avoid client applications to use constructor
        public static TeamDaoSQL getInstance(){
            return instance;
        }
        private TeamDaoSQL() {
        }
        DBConnector dbc = DBConnector.getInstance();


    public ArrayList<Team> getTeam(String country1) {
        ArrayList<Team> ans=new ArrayList<Team>();
        try {
            Connection connection = DBConnector.getConnection();
            System.out.println("connection success!");
            Statement stmt = connection.createStatement();
            String sql ="Select * From teams Where teams.country = '" + country1 + "'" +
                    "ORDER BY id ASC;";
            System.out.println(sql);
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String name = resultSet.getString("name");
                String coach = resultSet.getString("coach");
                String league = resultSet.getString("league");
                String country = resultSet.getString("country");
                Team teamToAdd = new Team(id,name,coach,league,country);
                ans.add(teamToAdd);
            }
            return ans;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public Team get(String username, String password) {
        return null;
    }

    @Override
    public void save(Team team) throws SQLException {

    }

    @Override
    public ArrayList<String> get_Matches(Team referee) {
        return null;
    }

}
