public class Piece {

    private final String[] pieces={"Car","Baloon", "Wheel", "Shoe", "Apple", "Plane", "Train", "Hat"};
    private String shapeType;

    public String Piece(String shapeType) {
        this.shapeType = shapeType;
        return shapeType;
    }

    public String[] getPieces() {
        return pieces;
    }

    public String getShapeType() {
        return shapeType;
    }

    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
    }
}
