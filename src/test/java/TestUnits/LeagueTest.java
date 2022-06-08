package TestUnits;

import Domain.Game.League;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class LeagueTest {

    League leagueAl=new League("israel",2022);
    League bbva=new League("spain",2022);

    @BeforeEach
    void beforeEach()
    {
        leagueAl.setStartDate(new java.sql.Date(122,1,1));
        bbva.setStartDate(new java.sql.Date(122,1,1));

    }


    @Test
    void setStartDate() {

        leagueAl.setStartDate(new java.sql.Date(2000,1,1));
        bbva.setStartDate(new java.sql.Date(2000,1,1));

        Assertions.assertEquals(2000,leagueAl.getStartDate().getYear());
        Assertions.assertEquals(2000,bbva.getStartDate().getYear());

        leagueAl.setStartDate(new java.sql.Date(2010,1,1));
        bbva.setStartDate(new java.sql.Date(2010,1,1));

        Assertions.assertEquals(2010,leagueAl.getStartDate().getYear());
        Assertions.assertEquals(2010,bbva.getStartDate().getYear());


    }

    @Test
    @DisplayName("Right Name")
    void getName() {

        Assertions.assertEquals("israel",leagueAl.getName());
        Assertions.assertEquals("spain",bbva.getName());

    }

    @Test
    @DisplayName("Wrong Name")
    void getWrongName() {

        Assertions.assertNotEquals("israaael",leagueAl.getName());
        Assertions.assertNotEquals("spaain",bbva.getName());

    }

    @Test
    void getStartDate() {
    }

    @Test
    void getOfficalTime() {

    }


}