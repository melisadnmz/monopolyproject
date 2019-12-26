public class Player extends Monopoly {

        private String name;
        private int squareNum;
        private Money money;
        private int turn;
        private int jailNum = 0;
        private Piece piece;
        private boolean lost;
        private boolean jail;


     public Player() {

     }

     public Player(String name, int squareNum, Money money, int turn, Piece piece) {
            this.name = name;
            this.squareNum = squareNum;
            this.money = money;
            this.turn = turn;
            this.piece = piece;
     }

     public int getNumOfPlayer(){
         return super.getNumOfPlayer();
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

        public int getSquareNum() {
            return squareNum;
        }

        public void setSquareNum(int squareNum) {
            this.squareNum = squareNum;
        }

        public int getTurn() { return turn; }

        public void setTurn(int turn) {
            this.turn = turn;
        }

        public Piece getPiece() {
            return piece;
        }

        public void setPiece(Piece piece) {
            this.piece = piece;
        }

        public boolean isLost() { return lost; }

        public void setLost(boolean lost) { this.lost = lost; }

        public boolean isJail() {return jail; }

        public void setJail(boolean jail) { this.jail = jail; }

        public int getJailNum() {
        return jailNum;
    }

        public void setJailNum(int jailNum) {
        this.jailNum = jailNum ;
    }
}
