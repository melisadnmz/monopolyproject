import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OtherSquareTest {

    @Test
    public void GoSquareTest() {

        Player p = new Player("player", 1, new Money(200),1, new Piece());
        assertEquals(p.getSquareNum(), 1);

    }

    @Test
    public void FreeParkingSquareTest() {

        Player p = new Player("player", 20, new Money(200),1, new Piece());
        assertEquals(p.getSquareNum(), 20);

    }

}
