import org.junit.Test;

import static org.junit.Assert.*;

public class JailSquareTest {
    @Test
    public void action() throws Exception {
        Player p = new Player("player1", 10, new Money(200),1,new Piece());

        assertEquals(p.getSquareNum(),10);
        assertEquals(p.getMoney().getAmount(),200,0);



    }

}