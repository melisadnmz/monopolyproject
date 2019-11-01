public class Player {

    private String name;
    private Square squareNum;
    private Money money;
    private int turn;
    private Piece piece;

    public Player(String name, Money money, int turn) {
        this.name = name;
        this.money = money;
        this.turn = turn;
    }

    public Player(String name, Square squareNum, Money money, int turn, Piece piece) {
        this.name = name;
        this.squareNum = squareNum;
        this.money = money;
        this.turn = turn;
        this.piece = piece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Square getSquareNum() {
        return squareNum;
    }

    public void setSquareNum(Square squareNum) {
        this.squareNum = squareNum;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
