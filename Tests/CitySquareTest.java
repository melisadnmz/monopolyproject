import org.junit.Test;

import static org.junit.Assert.*;

public class CitySquareTest {

    @Test
    public void action() {
        Player player = new Player("player", 2, new Money(200),1, new Piece());

        player.getMoney().decreaseAmount(30);
        double expected = player.getMoney().getAmount();
        double actual =  170;
        assertEquals(expected,actual,0);

    }

}