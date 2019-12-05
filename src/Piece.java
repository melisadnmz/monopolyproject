public class Piece extends Player {

    private final String[] pieces={"Car","Baloon", "Wheel", "Shoe", "Apple", "Plane", "Train", "Hat"};
    private String shapeType;

    public Piece(){
    shapeType="";
    }

    public Piece(String shapeType) {
        this.shapeType = shapeType;
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
