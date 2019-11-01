public class Square {
    private String name;
    private String type;
    private int index;
    private int fee;
    private String owner;

    public Square(String name, String type, int index, int fee) {
        this.name = name;
        this.index = index;
        this.type = type;
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

    public int getFee(){
        return fee;
    }

    public void setOwner(String owner){
        this.owner = owner;
    }

    public String getOwner(){
        return owner;
    }

}
