import org.jetbrains.annotations.Contract;

public class Die {
    private int faceValue;

    @Contract(pure = true)
    public Die() {
        this.faceValue = faceValue;
    }
    public int rollDie(){

        int random = (int)(Math.random()*6) + 1; //genereting number between 1 and 6.
        faceValue = random;
        return random;
    }

    public int getValue() {
        return faceValue;
    }

    public void setValue(int value) {
        this.faceValue = value;
    }


}
