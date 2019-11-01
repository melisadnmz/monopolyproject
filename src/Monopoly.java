import java.util.ArrayList;

public class Monopoly {

    private  ArrayList<Player> players;
    private Die die1;
    private Die die2;

    private Board board;


    public Monopoly(){

    }

    public void startGame(){

        //Arraylist in ilk elemanı zar atcak die1.rolldie çağırcaz
        diece = die1.rollDie() + die2.rollDie;
        //player1.setSquare ine diedan geleni ekle
        players.get(0).setSquareNum(diece);
        //hangi kareye geldiyse o karenin özelliklerine bakmalıyız vergi vericek mi gibi

    }


    public String toString() { //Duzenlenecek
        return "Monopoly{" +
                "players=" + players +
                ", die1=" + die1 +
                ", die2=" + die2 +
                ", board=" + board +
                '}';
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Die getDie1() {
        return die1;
    }

    public void setDie1(Die die1) {
        this.die1 = die1;
    }

    public Die getDie2() {
        return die2;
    }

    public void setDie2(Die die2) {
        this.die2 = die2;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}

