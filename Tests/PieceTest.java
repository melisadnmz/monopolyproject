import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PieceTest {
    Piece piece = new Piece();

    @Test
    public void getShapeType(){
        assertEquals("",piece.getShapeType());
    }

    @Test
    public void setShapeType(){
        piece.setShapeType("test");
        assertEquals("test",piece.getShapeType());
    }

    @Test
    public void getPieces(){
        final String[] array={"Car","Baloon", "Wheel", "Shoe", "Apple", "Plane", "Train", "Hat"};
        int count=0;
        int ln= piece.getPieces().length;
        for(int i=0; i< ln ; i++){
            if(piece.getPieces()[i].equals(array[i])){
                count++;
            }
        }
        assertEquals(count,ln);
    }

}
