import DataAccess.Dao;
import DataAccess.RefereeDaoSQL;
import DataAccess.UserDaoSQL;
import Domain.Referee;
import Service.UserApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.sql.SQLException;


public class AddReferee {

    private UserApplication userApplication ;
    private Referee referee1,referee2,referee3,referee4,referee5,referee6;
    private Dao referee_dao;
    private Dao user_dao;

    @BeforeEach
    public void before_test(){
        this.userApplication = new UserApplication();
        this.referee_dao = RefereeDaoSQL.getInstance();
        this.user_dao = UserDaoSQL.getInstance();
        this.referee1 = new Referee("ho","hoa","123456789");
        this.referee2 = new Referee("","","");
        this.referee3 = new Referee(" "," "," ");
        this.referee4 = new Referee("Danny Makkelie","DannyMak","abcd");
        this.referee5 = new Referee("Michael Oliver","MichealOliv","123m");
        this.referee6 = new Referee("Andreas Ekberg","AndreasEk","andrea99");
    }

    @Test
    @DisplayName("check with valid inputs")
    public void insertRefereeTest1(){
        referee_dao.delete(referee1);
        userApplication.insertReferee("ho","hoa","123456789");
        Assert.assertNotNull(RefereeDaoSQL.getInstance().get("hoa","123456789"));
        referee_dao.delete(referee1);
    }

    @Test
    @DisplayName("check with empty inputs")
    public void insertRefereeTest2(){
        referee_dao.delete(referee2);
        userApplication.insertReferee("","","");
        Assert.assertNotNull(RefereeDaoSQL.getInstance().get("",""));
        referee_dao.delete(referee2);
    }

    @Test
    @DisplayName("check with invalid inputs")
    public void insertRefereeTest3(){
        referee_dao.delete(referee3);
        userApplication.insertReferee(" "," "," ");
        Assert.assertNotNull(RefereeDaoSQL.getInstance().get(" "," "));
        referee_dao.delete(referee3);
    }

    @Test
    @DisplayName("check Referee constructor and methods")
    public void RefereeTest1(){
        Assert.assertEquals("Danny Makkelie",referee4.getName());
        Assert.assertEquals("DannyMak", referee4.getUsername());
        Assert.assertEquals("abcd",referee4.getPassword());
        Assert.assertTrue(referee4.is_referee());
    }

    @Test
    @DisplayName("check the method get(String username, String password)")
    public void UserDaoSQL1(){
        Assert.assertNotNull(user_dao.get("ehsank","123"));
        Assert.assertNull(user_dao.get("ehsank","321"));
    }
    @Test
    @DisplayName("check the method save( Referee referee) in UserDaoSQL class")
    public void UserDaoSQL2(){
        try {
            user_dao.save(referee5);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Referee temp = (Referee) user_dao.get("MichealOliv","123m");
        Assert.assertEquals(temp.getName(),referee5.getName());
        Assert.assertEquals(temp.getUsername(),referee5.getUsername());
        Assert.assertEquals(temp.getPassword(),referee5.getPassword());
        Assert.assertEquals(temp.is_referee(),referee5.is_referee());

    }
    @Test
    @AfterEach
    public void after(){
        referee_dao.delete(referee5);
    }

    @Test
    @DisplayName("check the method delete( Referee referee) in RefereeDaoSQL class")
    public void RefereeDaoSQL(){
        Assert.assertFalse(referee_dao.delete(referee6)); //try to delete a referee who doesn't exist in the system
        try {
            user_dao.save(referee6);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(referee_dao.delete(referee6));//try to delete existed referee
    }








}
