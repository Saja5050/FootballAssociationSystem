package IntegrationTests;

import DataAccess.Dao;
import DataAccess.MatchDaoSQL;
import DataAccess.RefereeDaoSQL;
import DataAccess.UserDaoSQL;

import Domain.Game.Match;

import Service.UserApplication;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
//import org.testng.annotations.Ignore;


import java.util.List;

public class MatchSchedule {


    static  private UserApplication userApplication ;
    static private Dao matches_dao;
    static private Dao user_dao;


    @BeforeAll
    static public void before_test() {

        MatchSchedule.userApplication = new UserApplication();
        MatchSchedule.matches_dao=MatchDaoSQL.getInstance();
        MatchSchedule.user_dao = UserDaoSQL.getInstance();

        MatchSchedule.userApplication.scudualeMaches("israel","1",2000);
        MatchSchedule.userApplication.scudualeMaches("spain","1",2000);

    }

    @AfterAll
    static public void after_tests()
    {
        ((MatchDaoSQL)matches_dao).deleteSeason("israel",2000);
        ((MatchDaoSQL)matches_dao).deleteSeason("spain",2000);

    }

    @Test
    @DisplayName("Try To  Schedule a busy Season")
    public void seaonsExisit()
    {
        List<Match> Spainmatches= MatchSchedule.userApplication.scudualeMaches("spain","1",2000);
        List<Match> israelMatches= MatchSchedule.userApplication.scudualeMaches("israel","1",2000);

        Assertions.assertEquals(null,Spainmatches);
        Assertions.assertNull(israelMatches);

    }


    @Test
    @DisplayName("Invalid Country Name")
    public void addWithWrongCountry() {


        List<Match> m1 = MatchSchedule.userApplication.scudualeMaches("NoName", "1", 1900);
        List<Match> m2 = MatchSchedule.userApplication.scudualeMaches("Honal", "1", 1900);
        List<Match> m3 = MatchSchedule.userApplication.scudualeMaches("UK", "1", 1900);
        List<Match> m4 = MatchSchedule.userApplication.scudualeMaches("Poland", "1", 1900);
        List<Match> m5 = MatchSchedule.userApplication.scudualeMaches("Russia", "1", 1900);



        Assertions.assertNull(m1);
        Assertions.assertNull(m2);
        Assertions.assertNull(m3);
        Assertions.assertNull(m4);
        Assertions.assertNull(m5);

    }




}
