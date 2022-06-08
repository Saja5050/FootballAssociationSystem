package TestUnits;

import Domain.Coach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoachTest {

    Coach coach1=new Coach("coach1","barca");
    Coach coach2=new Coach("coach2","baqa");
    Coach coach3=new Coach("coach3","haifa");


    @Test
    void getName() {

        Assertions.assertEquals("coach1",coach1.getName());
        Assertions.assertEquals("coach2",coach2.getName());
        Assertions.assertEquals("coach3",coach3.getName());

        Assertions.assertNotEquals("coa1ch1",coach1.getName());
        Assertions.assertNotEquals("coaach2",coach2.getName());
        Assertions.assertNotEquals("cocach3",coach3.getName());

    }

    @Test
    void setName() {

        coach1.setName("Ehsan");
        coach2.setName("Orel");

        Assertions.assertEquals("Ehsan",coach1.getName());
        Assertions.assertEquals("Orel",coach2.getName());

        coach1.setName("coach1");
        coach2.setName("coach2");


    }

    @Test
    void getTeam() {

        Assertions.assertEquals("barca",coach1.getTeam());
        Assertions.assertEquals("baqa",coach2.getTeam());
        Assertions.assertEquals("haifa",coach3.getTeam());

        Assertions.assertNotEquals("real",coach1.getName());
        Assertions.assertNotEquals("haifa",coach2.getName());
        Assertions.assertNotEquals("baqa",coach3.getName());

    }

    @Test
    void setTeam() {
        coach1.setTeam("team1");
        coach2.setTeam("team2");

        Assertions.assertEquals("team1",coach1.getTeam());
        Assertions.assertEquals("team2",coach2.getTeam());

        coach1.setTeam("barca");
        coach2.setTeam("baqa");


    }
}