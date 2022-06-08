package TestUnits;

import Domain.Game.Match;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {

    Match match1=new Match(new Date(2020,10,2),"baqa","haifa","liga a","Hakam",new Time(20,30,0),2020);
    Match match2=new Match(new Date(2020,5,2),"real","barca","Laliga","Jhon",new Time(20,30,0),2020);
    Match match3=new Match(new Date(2020,10,2),"barca","real","Laliga","Dave",new Time(20,30,0),2020);



    @Test
    void setDate() {
    }

    @Test
    void getSeason() {


        Assertions.assertEquals(2020,match1.getSeason());
        Assertions.assertEquals(2020,match2.getSeason());
        Assertions.assertEquals(2020,match3.getSeason());

        Assertions.assertNotEquals(2015,match1.getSeason());
        Assertions.assertNotEquals(1980,match2.getSeason());
        Assertions.assertNotEquals(201,match3.getSeason());

    }

    @Test
    void getHome() {

        Assertions.assertEquals("baqa",match1.getHome());
        Assertions.assertEquals("real",match2.getHome());
        Assertions.assertEquals("barca",match3.getHome());

        Assertions.assertNotEquals("Away",match1.getHome());
        Assertions.assertNotEquals("Baqa",match2.getHome());
        Assertions.assertNotEquals("Real",match3.getHome());


    }

    @Test
    void getAway() {


        Assertions.assertEquals("haifa",match1.getAway());
        Assertions.assertEquals("barca",match2.getAway());
        Assertions.assertEquals("real",match3.getAway());

        Assertions.assertNotEquals("home1",match1.getAway());
        Assertions.assertNotEquals("barca1",match2.getAway());
        Assertions.assertNotEquals("Real",match3.getAway());

    }

    @Test
    void getLeague() {



        Assertions.assertEquals("liga a",match1.getLeague());
        Assertions.assertEquals("Laliga",match2.getLeague());
        Assertions.assertEquals("Laliga",match3.getLeague());

        Assertions.assertNotEquals("Laliga",match1.getLeague());
        Assertions.assertNotEquals("barca1",match2.getLeague());
        Assertions.assertNotEquals("Real",match3.getLeague());



    }

    @Test
    void getREfereeName() {

        Assertions.assertEquals("Hakam",match1.getREfereeName());
        Assertions.assertEquals("Jhon",match2.getREfereeName());
        Assertions.assertEquals("Dave",match3.getREfereeName());

        Assertions.assertNotEquals("Laliga",match1.getREfereeName());
        Assertions.assertNotEquals("barca1",match2.getREfereeName());
        Assertions.assertNotEquals("Real",match3.getREfereeName());





    }

    @Test
    void getDate() {



        Date d1=new Date(2020,10,2);
        Date d2=new Date(2020,5,2);

        Assertions.assertEquals(d1,match1.getDate());
        Assertions.assertEquals(d2,match2.getDate());
        Assertions.assertEquals(d1,match3.getDate());

        Assertions.assertNotEquals("20:30:00",match1.getDate());
        Assertions.assertNotEquals("barca1",match2.getDate());
        Assertions.assertNotEquals("Real",match3.getDate());

    }

    @Test
    void getSQlDate() {


        String str="";
        str+=2020;
        str+="-";
        str+=10;
        str+="-";
        str+=2;

        java.sql.Date d1=java.sql.Date.valueOf(str);

        Assertions.assertEquals(d1,match1.getSQlDate());




    }

    @Test
    void getTime() {
        Time t1=new Time(20,30,0);

        Assertions.assertEquals(t1,match1.getTime());
        Assertions.assertEquals(t1,match2.getTime());
        Assertions.assertEquals(t1,match3.getTime());

        Assertions.assertNotEquals("20:30:00",match1.getTime());
        Assertions.assertNotEquals("barca1",match2.getTime());
        Assertions.assertNotEquals("Real",match3.getTime());


    }


}