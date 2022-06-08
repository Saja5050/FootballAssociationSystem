package DataAccess;
import Domain.Referee;
import Domain.User;


import java.sql.SQLException;
import java.util.*;
public interface Dao <T> {
        T get(String username, String password);
        void save(T t) throws SQLException;
        Boolean delete(T t);
        ArrayList<String> get_Matches(T referee);
}

