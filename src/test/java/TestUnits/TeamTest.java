package TestUnits;

import Domain.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {


    Team barca= new  Team(1,"Barca","pep","BBVA","spain");
    Team realMadrid= new  Team(2,"RealMadrid","Zedan","BBVA","spain");

    @Test
    void getTeamId() {
        Assertions.assertNotEquals(2,barca.getTeamId());
        Assertions.assertNotEquals(1,realMadrid.getTeamId());
        Assertions.assertNotEquals(7,barca.getTeamId());
        Assertions.assertNotEquals(21,realMadrid.getTeamId());


        Assertions.assertEquals(1,barca.getTeamId());
        Assertions.assertEquals(2,realMadrid.getTeamId());


    }

    @Test
    void getName() {

        /** Right Names */
        Assertions.assertEquals("Barca",barca.getName());
        Assertions.assertEquals("RealMadrid",realMadrid.getName());

        /** Wrong Names */
        Assertions.assertNotEquals(2,barca.getName());
        Assertions.assertNotEquals("barca",realMadrid.getName());
        Assertions.assertNotEquals("Hola",barca.getName());
        Assertions.assertNotEquals(21,realMadrid.getName());




    }

    @Test
    void getCoachName() {

        Assertions.assertEquals("pep",barca.getCoachName());
        Assertions.assertEquals("Zedan",realMadrid.getCoachName());

        Assertions.assertNotEquals("pep1",barca.getCoachName());
        Assertions.assertNotEquals("Zedan1",realMadrid.getCoachName());
        Assertions.assertNotEquals("Pep",barca.getCoachName());
        Assertions.assertNotEquals("zedan",realMadrid.getCoachName());
    }

    @Test
    void getLeagueName() {
        Assertions.assertEquals("BBVA",barca.getLeagueName());
        Assertions.assertEquals("BBVA",realMadrid.getLeagueName());

        Assertions.assertNotEquals("bbva",barca.getLeagueName());
        Assertions.assertNotEquals("elAl",realMadrid.getLeagueName());


    }

    @Test
    void getCountryName() {
        Assertions.assertEquals("spain",barca.getCountryName());
        Assertions.assertEquals("spain",realMadrid.getCountryName());

        Assertions.assertNotEquals("israel",barca.getCountryName());
        Assertions.assertNotEquals("Spain",realMadrid.getCountryName());

    }
}