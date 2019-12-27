import org.junit.Test;

import static org.junit.Assert.*;


public class GoToJailSquareTest {

    @Test
    public void action() {
        Player p = new Player("player", 30, new Money(200),1, new Piece());
        System.out.println("Player, " + p.getSquareNum() + " must go to the jail square now !");
        assertEquals(p.getSquareNum(), 30);


    }

}
