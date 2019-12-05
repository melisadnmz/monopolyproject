import org.junit.Test;

import static org.junit.Assert.*;

public class DieTest {
    private Die die = new Die();

    @Test
    public void getValue() {
        int rndValue = die.rollDie();
        assertTrue("die must be 1-6",rndValue <= 6 && rndValue >= 1);
    }

}