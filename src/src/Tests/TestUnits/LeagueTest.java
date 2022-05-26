package TestUnits;

import Domain.Game.League;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class LeagueTest {

    League leagueAl=new League("israel",2022);
    League bbva=new League("spain",2022);

    @BeforeEach
    void beforeEach()
    {
        leagueAl.setStartDate(new Date(122,1,1));
        bbva.setStartDate(new Date(122,1,1));

    }


    @Test
    void setStartDate() {

        leagueAl.setStartDate(new Date(100,1,1));
        bbva.setStartDate(new Date(100,1,1));

        Assertions.assertEquals(2000,leagueAl.getStartDate().getYear());
        Assertions.assertEquals(2000,bbva.getStartDate().getYear());


    }

    @Test
    void getName() {
    }

    @Test
    void getStartDate() {
    }

    @Test
    void getOfficalTime() {
    }

    @Test
    void setSpainLeague() {
    }
}