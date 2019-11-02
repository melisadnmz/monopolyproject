import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Money money= new Money();
        System.out.println("Welcome Perfecto Monopoly Game Simulation!");
        int numberOfPlayers = numberOfPlayers();
        String[] nameOfPlayers = playerNames(numberOfPlayers);
        ArrayList<Player> players = createPlayers(nameOfPlayers,numberOfPlayers,money);
        for (Player i : players) {
            System.out.println(i.getName() + " : $" + i.getMoney().getAmount() + " -> " + i.getTurn());
        }
        Board board = new Board();
        //board.createSquare();
        //Monopoly monopoly = new Monopoly(players,board);
        //monopoly.startGame();
    }


    private static int numberOfPlayers() {
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

    private static String[] playerNames(int numberOfPlayers){
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

    private static boolean controlForName(String name, String[] names){

        for (int i=0;i<names.length;i++)
            if(name.toLowerCase().equals(names[i])) return false;
            return true;
    }

    private static ArrayList<Player> createPlayers(String[] names, int number, Money money){
        ArrayList<Player> players = new ArrayList<>(number);
        for(int i=0;i<number;i++){
            Player person= new Player(names[i],money,i+1);
            players.add(i,person);
        }
        return players;
    }


}
