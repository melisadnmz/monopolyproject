import java.util.Scanner;

public class Square extends Board{


    private String name = "";
    private String type = "";
    private int index = 0;
    private String owner;
    private double fee = 0.0;


    public Square(String name, String type, int index, double fee) {
        this.name = name;
        this.index = index;
        this.type = type;
        this.fee = fee;
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

    public void setOwner(String owner){
        this.owner = owner;
    }

    public String getOwner(){
        return owner;
    }

}
