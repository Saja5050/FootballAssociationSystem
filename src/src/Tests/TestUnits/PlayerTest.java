package TestUnits;

import Domain.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player1=new Player();
    Player player2=new Player();
    Player player3=new Player();


    @BeforeEach
    public void beforeEach()
    {
        player1.setName("player1");
        player2.setName("player2");
        player3.setName("player3");
    }

    @AfterEach
    public void afterAll()
    {
        player1.setName("player1");
        player2.setName("player2");
        player3.setName("player3");
    }

    @Test
    void getName() {
        Assertions.assertEquals("player1",player1.getName());
        Assertions.assertEquals("player2",player2.getName());
        Assertions.assertEquals("player3",player3.getName());

    }

    @Test
    void setName() {

        player1.setName("number1");
        Assertions.assertEquals("number1",player1.getName());

        player2.setName("number2");
        Assertions.assertEquals("number2",player2.getName());

        player3.setName("number3");
        Assertions.assertEquals("number3",player3.getName());



    }
}