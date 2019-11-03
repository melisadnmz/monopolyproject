import java.util.ArrayList;
import java.util.Scanner;

public class Monopoly {

    private Die die1 = new Die();
    private Die die2 = new Die();
    private int diece;
    private int cycle;
    private int currentIndex;
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


    public void startGame() {
        System.out.println("Welcome Perfecto Monopoly Game Simulation!");
        Money money= new Money();
        numOfPlayer = numberOfPlayers();
        String[] nameOfPlayers = playerNames(numOfPlayer);
        money.initialMoney();
        board.crSquare();
        board.locationOfTax();
        ArrayList<Player> players = createPlayers(nameOfPlayers,numOfPlayer,money);

        for (Player i : players) {
            System.out.println(i.getName() + " : $" + i.getMoney().getAmount() + " -> " + i.getTurn());
        }

        int i=0;
        while (i<board.getSquare().length) {
            System.out.println(board.getSquare()[i].getName() + board.getSquare()[i].getIndex() + " --> " + board.getSquare()[i].getFee());
            i++;
        }

        /*while(numOfPlayer>1){
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
*/
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


    public ArrayList<Player> createPlayers(String[] names, int number, Money money){
        for(int i=0;i<number;i++){
            Player person= new Player(names[i],money,i+1);
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



}
