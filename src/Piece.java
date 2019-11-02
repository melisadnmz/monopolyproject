public class Piece {
    private String shapeType;

    public String Piece(String shapeType) {
        this.shapeType = shapeType;
        return shapeType;
    }

    public String getShapeType() {
        return shapeType;
    }

    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
    }
}
