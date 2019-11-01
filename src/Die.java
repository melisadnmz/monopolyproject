import java.util.Random;

public class Die {
    private int value;

    public Die(int value) {
        this.value = value;
    }
    public int rollDie(){

        int random = (int)(Math.random()*6) + 1; //genereting number between 1 and 6.
        return random;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


}
