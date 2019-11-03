import java.util.ArrayList;
import java.util.Scanner;

public class Monopoly {

    private Die die1 = new Die();
    private Die die2 = new Die();
    private int diece;
    private int cycle = 1;
    private int currentIndex;
    private int newLocation;
    private int numOfPlayer;
    private Board board;
    private Square[] squares;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Player> bankrupted = new ArrayList<>();


    public Monopoly() {

    }

    public Monopoly(Board board,Square[] squares) {
        this.board=board;
        this.squares = squares;
    }

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



    public void startGame() {
        System.out.println("Welcome Perfecto Monopoly Game Simulation!");
        numOfPlayer = numberOfPlayers();
        String[] nameOfPlayers = playerNames(numOfPlayer);
        board.crSquare();
        board.locationOfTax();
        ArrayList<Player> players = createPlayers(nameOfPlayers,numOfPlayer);
        ArrayList<Player> losers=new ArrayList<>();

        System.out.println("----------------Game starts...---------------\n");

        int d1, d2, dcounter=0;
        while(numOfPlayer>1){
            System.out.println("---------------Cycle " + cycle + "---------------\n");
            for (int i = 0; i < numOfPlayer; i++) {
                //to string 1
                d1= die1.rollDie();
                d2=  die2.rollDie();
                setDiece(d1 + d2);
                if(d1 == d2){
                    dcounter++;
                    if(dcounter==3) {
                        dcounter=0;
                        continue;
                    }
                }else{
                    dcounter=0;
                }
                setCurrentIndex(players.get(i).getSquareNum());
                newLocation = diece + currentIndex;
                if ((newLocation) >= 39){
                    newLocation -= 39;
                    players.get(i).getMoney().increaseAmount(200);
                    //başlangıctan gecti para alacak
                }
                players.get(i).setSquareNum(board.getSquare()[newLocation].getIndex());
                //oyuncuya square ine göre yapacağımız değişiklik için bi fonksiyon yazmalıyız (for 2nd iteration)

                System.out.println(toStringAfter(players.get(i)));
                //hangi kareye geldiyse o karenin özelliklerine bakmalıyız vergi vericek mi gibi
                organizeTaxSquare(players.get(i));


                if(players.get(i).getMoney().getAmount() < 0){
                    losers.add(players.get(i));
                    players.remove(players.get(i));
                    numOfPlayer--;

                }

                if(d1 == d2)
                    i--;
                //to string ikincisi
            }
            for (Player k : players) {
                System.out.println(k.getName() + " : $" + k.getMoney().getAmount() + " -> " + k.getTurn() + " : " + k.getPiece().getShapeType());
            }
            cycle++;

        }




     /*   for (Player i : players) {
            System.out.println(i.getName() + " : $" + i.getMoney().getAmount() + " -> " + i.getTurn() + " : " + i.getPiece().getShapeType());
        }

         int i=0;
        while (i<board.getSquare().length) {
            System.out.println(board.getSquare()[i].getName() + board.getSquare()[i].getIndex() + " --> " + board.getSquare()[i].getFee());
            i++;
        } */


    }


    public String toStringBefore(Player player) { //Duzenlenecek
        return player.getName() + "\n" + player.getTurn() +  "\nSquare " + player.getSquareNum() ;
    }
    public String toStringAfter(Player player) { //Duzenlenecek
        return "Die 1 : " + die1.getValue() + " Die2 : " + die2.getValue() + " sum : "+ diece  + "\n" + player.getSquareNum() +
                " buraya square bilgileri gelecek " ;
    }


    public ArrayList<Player> createPlayers(String[] names, int number){
        Money intMoney = new Money();
        intMoney.initialMoney();
        for(int i=0;i<number;i++){
            Money money=new Money();
            Piece piece=new Piece();
            money.setAmount(intMoney.getAmount());
            Player person= new Player(names[i],board.getSquare()[0].getIndex(),money,i+1,piece);
            piece.setShapeType(piece.getPieces()[i]);
            person.setPiece(piece);
            this.players.add(i,person);
        }
        return players;
    }

    public int numberOfPlayers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter number of players(Number of players must be between 2 and 8): ");
        int numberOfPlayers = scanner.nextInt();
        //Check the number because of that players must be between 2-8.
        while(numberOfPlayers < 2 || numberOfPlayers > 8) {
            System.out.print("Number of players must be between 2 and 8. Please enter again: ");
            numberOfPlayers = scanner.nextInt();
        }
        return numberOfPlayers;
    }

    public String[] playerNames(int numberOfPlayers){
        Scanner scanner = new Scanner(System.in);
        String[] playerNames = new String[numberOfPlayers];
        int num=1;
        while (num <= numberOfPlayers){
            System.out.println("Please enter name for " + num + ". Player: ");
            String name = scanner.nextLine();
            if(controlForName(name,playerNames))
                playerNames[num-1]=name;
            else{
                System.out.println("This name is already taken. Please entered again!");
                num--;
            }
            num++;
        }
        return playerNames;
    }

    private boolean controlForName(String name, String[] names){

        for (int i=0;i<names.length;i++)
            if(name.toLowerCase().equals(names[i])) return false;
        return true;
    }

    private void organizeTaxSquare(Player player){
        if(board.getSquare()[player.getSquareNum()].getType().equals("Tax")){
            player.getMoney().decreaseAmount((board.getSquare()[player.getSquareNum()].getFee()));
            System.out.println("Player " + player.getTurn() + "loses -$" + board.getSquare()[player.getSquareNum()].getFee());
        }
    }

}
