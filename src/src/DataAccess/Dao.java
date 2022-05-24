package DataAccess;


import java.sql.SQLException;
import java.util.*;
public interface Dao <T> {

        ArrayList<T> getTeam(String country1);
        T get(String username, String password);
        // T getMatch(Date date , String home, String away, String league, String referee, Time time);
        void save(T t) throws SQLException;
        ArrayList<String> get_Matches(T referee);
}

