public class Main {

    public static void main(String[] args) {
        Board board= new Board();
        Square[] squares = new Square[40];
        Monopoly monopoly = new Monopoly(board,squares);
        monopoly.startGame();
    }


}
