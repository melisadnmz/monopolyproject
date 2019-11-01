import java.util.ArrayList;

public class Monopoly {

    private ArrayList<Player> players;
    private Die die1;
    private Die die2;
    private int diece;
    private int cycle;
    private Board board;

    public int getDiece() {
        return diece;
    }

    public void setDiece(int diece) {
        this.diece = diece;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }


    public Monopoly() {

    }

    public void startGame() {


        //Arraylist in ilk elemanı zar atcak die1.rolldie çağırcaz
        setDiece(die1.rollDie() + die2.rollDie());
        //player1.setSquare ine diedan geleni ekle
        players.get(0).setSquareNum(board.getSquares()[diece]);
        //hangi kareye geldiyse o karenin özelliklerine bakmalıyız vergi vericek mi gibi

    }


    public String toStringBefore(Player player) { //Duzenlenecek
        return player.getName() + "\n" + player.getTurn() + "\n" + cycle + "\n" + player.getSquareNum()+
        " buraya square bilgileri gelecek " ;
    }
    public String toStringAfter(Player player) { //Duzenlenecek
        return "Die 1 : "+ die1.getValue() + "Die2 : " + die2.getValue() + "sum : "+ diece + cycle + "\n" + player.getSquareNum()+
        " buraya square bilgileri gelecek " ;
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

