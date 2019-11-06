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
    private boolean losed=false;
    private ArrayList<Player> players = new ArrayList<>();


    public Monopoly() {
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


    public void startGame() {
        Board board = new Board();
        Square[] squares = new Square[40];
        System.out.println("Welcome Perfecto Monopoly Game Simulation!");
        numOfPlayer = numberOfPlayers();
        String[] nameOfPlayers = playerNames(numOfPlayer);
        board.crSquare();
        board.locationOfTax();
        ArrayList<Player> players = createPlayers(nameOfPlayers,numOfPlayer,board);
        decideTurn();

        System.out.println("----------------Game starts---------------\n");

        int d1, d2, dcounter=0;
        while(numOfPlayer>1){
            System.out.println("---------------Cycle " + cycle + "---------------\n");

            for (int i = 0; i < numOfPlayer; i++) {
                System.out.println(toStringBefore(players.get(i),board));
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
                System.out.println("After rolling diece");
                if ((newLocation) >= 39){
                    newLocation -= 39;
                    players.get(i).getMoney().increaseAmount(200);
                    System.out.println(players.get(i).getName() + " has past the start and won 200$");
                    //başlangıctan gecti para alacak
                }
                players.get(i).setSquareNum(board.getSquare()[newLocation].getIndex());


                System.out.println(toStringAfter(players.get(i),board));
                organizeTaxSquare(players.get(i),board);
                System.out.println(toStringMoney(players.get(i)));

                if(players.get(i).getMoney().getAmount() <= 0){
                    players.get(i).setLosed(true);
                    losed= true;
                }

                if(d1 == d2)
                    i--;

            }

            cycle++;
            if(losed) {
                changeTurn(players);
            }


        }
        System.out.println("---------------Game Over-------------\n----------" + players.get(0).getName() + " is winner-----------");

    }


    public String toStringBefore(Player player , Board board) { //Duzenlenecek
        return player.getName() + " is " + player.getTurn() +  ". player \nIn " + player.getSquareNum() + " square right now.\n" +
                "It is "+ board.getSquare()[player.getSquareNum()].getType() +" square\nHas "+ player.getMoney().getAmount()+"$\n   --------------" ;
    }
    public String toStringAfter(Player player, Board board) { //Duzenlenecek
        return "Die 1 : " + die1.getValue() + " Die 2 : " + die2.getValue() + " sum : "+ diece  + "\n" + player.getName() + " is in " +
                player.getSquareNum() + " square now\nIt is "+ board.getSquare()[player.getSquareNum()].getType() +" square" ;
    }

    public String toStringMoney(Player player) {
        return "Total money is : " + player.getMoney().getAmount() +"\n ------------------------------";
    }

    public void changeTurn(ArrayList<Player> losers){
        for(int i = 0;i<players.size();i++){
           if(players.get(i).isLosed()){
               players.remove(players.get(i));
               numOfPlayer--;
           }
        }
        for(int i = 0;i<players.size();i++){
           players.get(i).setTurn(i+1);
        }
        losed=false;
    }



    public ArrayList<Player> createPlayers(String[] names, int number, Board board){
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

    private void organizeTaxSquare(Player player, Board board){
        if(board.getSquare()[player.getSquareNum()].getType().equals("Tax")){
            player.getMoney().decreaseAmount((board.getSquare()[player.getSquareNum()].getFee()));
            System.out.println( player.getName() + " loses -$" + board.getSquare()[player.getSquareNum()].getFee() + " for tax");
        }
    }

    public void decideTurn(){
        ArrayList<Player> temp = new ArrayList<Player>();
        System.out.println();
        System.out.println("Players are rolling diece for decide turns.");
        int d1, d2, sum;
        System.out.println();
        for (int i = 0; i < numOfPlayer; i++) {
            //to string 1
            d1 = die1.rollDie();
            d2 = die2.rollDie();
            sum = d1 + d2;
            players.get(i).setDiece(sum);
            System.out.println(players.get(i).getName() + " rolled " + d1 + "-" + d2 + "." + " Sum of:" + players.get(i).getDiece());
        }
        System.out.println();

        for (int i = 0; i < numOfPlayer; i++)
        {
            int where=0;
            int value=0;
            for (int j = 0; j < numOfPlayer; j++)
            {
                if(players.get(j).getDiece()> value){
                    where=j;
                    value=players.get(j).getDiece();
                }
            }
            temp.add(players.get(where));
            players.get(where).setDiece(0);
        }

        for (int j = 0; j < numOfPlayer; j++)
        {
            players.remove(0);
            players.add(temp.get(j));
        }
        System.out.println("Player turn : ");
        for (int j = 0; j < numOfPlayer; j++)
        {
            players.get(j).setTurn(j+1);
            System.out.println("Player " + players.get(j).getTurn() + " --> " + players.get(j).getName() + " and " + players.get(j).getName() + "'s piece is: " + players.get(j).getPiece().getShapeType());
        }
    }
}
