import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Monopoly {

    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Player> bankrupted = new ArrayList<Player>();
    private Die die1 = new Die();
    private Die die2 = new Die();
    private int diece;
    private int cycle;
    private int currentIndex;
    private int numOfPlayer;

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

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

    private Board board ;


    public Monopoly(ArrayList<Player> player, Board board) {
        this.players.addAll(player);
        this.board = board;
        this.numOfPlayer = players.size();

    }

    public void startGame() {
        int newLocation;
        while(numOfPlayer>1){
            for(int i=0;i<=numOfPlayer ;i++) {
                System.out.println(toStringBefore(players.get(i)));
                //Arraylist in ilk elemanı zar atcak die1.rolldie çağırcaz
                setDiece(die1.rollDie() + die2.rollDie());
                setCurrentIndex(players.get(0).getSquareNum().getIndex());
                //player1.setSquare ine diedan geleni ekle
                newLocation = diece + currentIndex;
                if ((newLocation) >= 40){
                    newLocation -= 40;
                    //başlangıctan gecti para alacak
                }
                players.get(i).setSquareNum(board.getSquare()[newLocation]);
                //oyuncuya square ine göre yapacağımız değişiklik için bi fonksiyon yazmalıyız
                System.out.println(toStringAfter(players.get(i)));
                //hangi kareye geldiyse o karenin özelliklerine bakmalıyız vergi vericek mi gibi


            }
            cycle++;
        }

    }


    public String toStringBefore(Player player) { //Duzenlenecek
        return player.getName() + "\n" + player.getTurn() +  "\nSquare " + player.getSquareNum().getIndex() ;
    }
    public String toStringAfter(Player player) { //Duzenlenecek
        return "Die 1 : " + die1.getValue() + " Die2 : " + die2.getValue() + " sum : "+ diece  + "\n" + player.getSquareNum().getIndex() +
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

