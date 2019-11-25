import java.util.ArrayList;
import java.util.Scanner;

public class Monopoly {

    private Die die1 = new Die();
    private Die die2 = new Die();
    private int dice;
    private int cycle = 1;
    private int currentIndex;
    private int newLocation;
    private int numOfPlayer;
    private boolean lost =false;
    private ArrayList<Player> players = new ArrayList<>();


    public Monopoly() {
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public int getDice() {
        return dice;
    }

    public void setDice(int dice) {
        this.dice = dice;
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


    public void startGame() {
        Board board = new Board();
        int numOfLost = 0;
        boolean defeated = false;
        System.out.println("Welcome Perfecto Monopoly Game Simulation!");
        numOfPlayer = numberOfPlayers();
        String[] nameOfPlayers = playerNames(numOfPlayer);
        //board.crSquare();
        board.createSquare();
        //board.locationOfTax();
        ArrayList<Player> players = createPlayers(nameOfPlayers,numOfPlayer,board);
        decideTurn();

        System.out.println("----------------Game starts---------------\n");

        int d1, d2, dcounter=0;
        while(numOfPlayer>1){
            numOfLost = 0;
            System.out.println("---------------Cycle " + cycle + "---------------\n");

            for (int i = 0; i < numOfPlayer; i++) {
                System.out.println(toStringBefore(players.get(i),board));
                d1= die1.rollDie();
                d2=  die2.rollDie();
                setDice(d1 + d2);
                System.out.println("After rolling dice");
                System.out.println(toStringAfter());

                if( players.get(i).isJail()){
                    if(jailCase(players.get(i),d1,d2)){
                        continue;
                    }

                }
                if(d1 == d2){
                    dcounter++;
                    if(dcounter==3) {
                        dcounter=0;
                        players.get(i).setSquareNum(10);
                        players.get(i).setJail(true);
                        continue;
                    }
                }else{
                    dcounter=0;
                }
                setCurrentIndex(players.get(i).getSquareNum());
                players.get(i).setDice(dice);
                newLocation = dice + currentIndex;


                if ((newLocation) > 39){
                    newLocation -= 39;
                    if(!(board.getSquare()[newLocation].getName().equals("GoToJail")))
                      board.getSquare()[0].play(players.get(i));
                }
                players.get(i).setSquareNum(board.getSquare()[newLocation].getIndex());


                board.getSquare()[newLocation].play(players.get(i));
                System.out.println(toStringMoney(players.get(i),board));

                if(players.get(i).getMoney().getAmount() <= 0){
                    players.get(i).setLost(true);
                    lost = true;
                }

                if(d1 == d2)
                    if(!players.get(i).isLost()) i--;

            }

            cycle++;
            if(lost) {
                for(int i = 0; i < numOfPlayer; i++){
                    if(players.get(i).isLost()){
                        numOfLost ++;
                        if(numOfLost == numOfPlayer){
                            defeated = true;
                            System.out.println("---------------Game Over-------------\n*********" + players.get(i).getName() + " IS WINNER **********");
                        }
                        else System.out.println(players.get(i).getName() + " LOST THE GAME !!!");
                    }
                }
                changeTurn(numOfLost);
            }
        }
        if(!defeated) {
            System.out.println("---------------Game Over-------------\n*********" + players.get(0).getName() + " IS WINNER **********");
        }
    }


    public String toStringBefore(Player player , Board board) {
        return player.getName() + " is " + player.getTurn() +  ". player \nIn " + player.getSquareNum() + " square right now.\n" +
                "It is "+ board.getSquare()[player.getSquareNum()].getType() +" square\nHas "+ player.getMoney().getAmount()+"$\n   --------------" ;
    }
    public String toStringAfter() {
        return "Die 1 : " + die1.getValue() + " Die 2 : " + die2.getValue() + " sum : "+ dice   ;
    }

    public String toStringMoney(Player player , Board board) {
        return  player.getName() + " is in " + player.getSquareNum() + " square now\nIt is "+ board.getSquare()[player.getSquareNum()].getType() +" square"+
                "\nTotal money is : " + player.getMoney().getAmount() + "\n"+"\n ------------------------------";
    }

    public void changeTurn(int number){
        for(int i = players.size()-1; i >= 0; i--){
           if(players.get(i).isLost()){
               players.remove(players.get(i));
           }
        }
        numOfPlayer =  numOfPlayer - number;
        if(numOfPlayer > 0) {
            for (int i = 0; i < players.size(); i++) {
                players.get(i).setTurn(i + 1);
            }
        }
        lost =false;
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

    public void decideTurn(){
        ArrayList<Player> temp = new ArrayList<Player>();
        System.out.println();
        System.out.println("Players are rolling dice for decide turns.");
        int d1, d2, sum;
        System.out.println();
        for (int i = 0; i < numOfPlayer; i++) {
            //to string 1
            d1 = die1.rollDie();
            d2 = die2.rollDie();
            sum = d1 + d2;
            players.get(i).setDice(sum);
            System.out.println(players.get(i).getName() + " rolled " + d1 + "-" + d2 + "." + " Sum of:" + players.get(i).getDice());
        }
        System.out.println();

        for (int i = 0; i < numOfPlayer; i++)
        {
            int where=0;
            int value=0;
            for (int j = 0; j < numOfPlayer; j++)
            {
                if(players.get(j).getDice()> value){
                    where=j;
                    value=players.get(j).getDice();
                }
            }
            temp.add(players.get(where));
            players.get(where).setDice(0);
        }
        printTurn(temp);
    }

    public void printTurn(ArrayList<Player> temp){
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

    public boolean jailCase(Player player, int d1,int d2){
        if(player.getJailNum() < 3){
            if( !(d1 == d2) ){
                System.out.println( player.getName()+" couldn't roll double ");
                player.setJailNum(player.getJailNum()+1);
                if(player.getJailNum() == 3){
                    System.out.println( player.getName()+" couldn't roll double for 3 turn\nLoses 500m");
                    player.getMoney().decreaseAmount(500);
                    if(player.getMoney().getAmount() <= 0){
                        player.setLost(true);
                        lost = true;
                        System.out.println(  player.getName()+" does not have 500m money to get out of jail");
                        System.out.println("---------------------");
                        return true;
                    }
                    player.setJail(false);
                    player.setJailNum(0);
                }
                else {
                    System.out.println("----------------------");
                    return true;
                }
            }
            if( (d1 == d2) ){
                player.setJail(false);
                player.setJailNum(0);

            }
        }
        return false;
    }
}
