import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Money startM = new Money();
        startM.setMoney(100);
        Piece sheep = new Piece();
        sheep.setShapeType("sheep");
        Board board = new Board();
        board.createSquare();
        ArrayList<Player>  players = new ArrayList<Player>();
        Player one = new Player("berre",board.getSquare()[0],startM,1,sheep);
        players.add(one);
        Monopoly monopoly = new Monopoly(players,board);
        monopoly.startGame();



    }
}
