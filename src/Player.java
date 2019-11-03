public class Player extends Monopoly {

        private String name;
        private Square squareNum;
        private Money money;
        private int turn;
        private Piece piece;

     public Player() {

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

        public Money getMoney() {
        return this.money;
    }

        public void setMoney(Money money) {
        this.money = money;
    }

        public Square getSquareNum() {
            return squareNum;
        }

        public void setSquareNum(Square squareNum) {
            this.squareNum = squareNum;
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
