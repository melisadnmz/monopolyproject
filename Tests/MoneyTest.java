import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MoneyTest {
    private Money money = new Money();


    @Test
    public void setAmount(){
        money.setAmount(100.10);
        assertEquals(100.10, money.getAmount(),0);

    }

    @Test
    public void getAmount() {
        assertEquals(0.0,money.getAmount(),0);

    }

    @Test
    public void increaseAmount() {
        money.increaseAmount(200);
        assertEquals(200.0, money.getAmount(),0);
    }

    @Test
    public void decreaseAmount() {
        money.setAmount(500);
        money.decreaseAmount(200);
        assertEquals(300.0, money.getAmount(),0);
    }
}
