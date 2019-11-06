import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Money money = new Money();
    private Piece piece = new Piece("ShapeType");
    private Player player = new Player("PlayerName", 0, money, 1,piece);

    @Test
    public void setName(){
        player.setName("test");
        assertEquals("test", player.getName());
    }

    @Test
    public void getName(){
        assertEquals("PlayerName",player.getName());
    }

    @Test
    public void getMoney(){
        assertEquals(money,player.getMoney());
    }

    @Test
    public void setSquareNum(){
        player.setSquareNum(99);
        assertEquals(99, player.getSquareNum());
    }

    @Test
    public void getSquareNum(){
        assertEquals(0,player.getSquareNum());
    }

    @Test
    public void setTurn(){
        player.setTurn(99);
        assertEquals(99, player.getTurn());
    }

    @Test
    public void getTurn(){
        assertEquals(1,player.getTurn());
    }

    @Test
    public void setPieceType(){
        player.getPiece().setShapeType("test");
        assertEquals("test", player.getPiece().getShapeType());
    }

    @Test
    public void getPieceType(){
        assertEquals("ShapeType",player.getPiece().getShapeType());
    }

}
