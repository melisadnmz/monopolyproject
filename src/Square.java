
public abstract class Square extends Board{


    private String name = "";
    private String type = "";
    private int index = 0;
    private Player owner;
    private double fee = 0.0;

    public Square(){}


    public Square(String name,String type, int index, double fee) {
     this.name=name;
     this.type=type;
     this.index=index;
     this.fee=fee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public int getIndex(){
        return index;
    }

    public double getFee(){
        return fee;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getOwner(){
        return owner;
    }

    public void LosingSquares(Player player){
        for (int i = 0; i < getSquare().length; i++) {
            if (getOwner() == player){
                setOwner(null);
            }
        }
    }

    public abstract void play(Player player);

}
