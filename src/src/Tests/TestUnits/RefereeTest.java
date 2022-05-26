package TestUnits;

import Domain.Referee;
import Domain.SystemManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {


    Referee manager=new Referee("Ehsan","ehsan","123");
    Referee manager2=new Referee("Khalil","khalil","123");

    @Test
    void getName() {
        Assertions.assertEquals("Ehsan",manager.getName());
        Assertions.assertEquals("Khalil",manager2.getName());

        Assertions.assertNotEquals("khalil",manager.getName());
        Assertions.assertNotEquals("Ehsan",manager2.getName());

    }
    @Test
    void setName() {
        manager.setName("NewName");
        manager2.setName("Man2");
        Assertions.assertEquals("NewName",manager.getName());
        Assertions.assertEquals("Man2",manager2.getName());
        manager.setName("Ehsan");
        manager2.setName("Khalil");

    }



    @Test
    void getUser() {
        Assertions.assertEquals("ehsan",manager.getUsername());
        Assertions.assertEquals("khalil",manager2.getUsername());

        Assertions.assertNotEquals("khalil",manager.getUsername());
        Assertions.assertNotEquals("Ehsan",manager2.getUsername());


    }


    @Test
    void getPass() {

        Assertions.assertEquals("123",manager.getPassword());
        Assertions.assertEquals("123",manager2.getPassword());

        Assertions.assertNotEquals("khal412il",manager.getPassword());
        Assertions.assertNotEquals("Ehs3an",manager2.getPassword());


    }

    @Test
    void getType() {
        Assertions.assertEquals(true,manager.is_referee());
        Assertions.assertEquals(true,manager2.is_referee());

        Assertions.assertNotEquals(false,manager.is_referee());
        Assertions.assertNotEquals(false,manager2.is_referee());



    }

}