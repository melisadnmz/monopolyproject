import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    private Board board = new Board();

    @Test
    public void testGetSquare() {
        for (int i = 0; i < 40; i++) {
            if (i == 10)
                assertTrue("False Jail", board.getSquare()[i].getName().equals("JailSquare"));
            else if (i == 0)
                assertTrue("False Go", board.getSquare()[i].getName().equals("GO"));
            else if (i == 20)
                assertTrue("False Parking", board.getSquare()[i].getName().equals("FreeParking"));
            else if (i == 30)
                assertTrue("False Go To Jail", board.getSquare()[i].getName().equals("GoToJailSquare"));
            else if (i == 38)
                assertTrue("False Tax", board.getSquare()[i].getName().equals("Tax"));
            }
        }
    }