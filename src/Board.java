import java.io.BufferedReader;
import java.io.FileReader;

public class Board extends Monopoly {
    private Square[] squares = new Square[40];

    public Board(){

    }

    public void createSquare() { //This method will be use 2nd iteration.
        try{
            BufferedReader in = new BufferedReader(new FileReader("SquareList.txt"));
            String s;
            int i = 0;
            while((s = in.readLine()) != null){
                String[] var = s.split("-");
                switch(var[1]) {
                    case "City":
                        CitySquare city = new CitySquare(var[0], var[1], Integer.parseInt(var[2]), Integer.parseInt(var[3]),Integer.parseInt(var[4]), var[5]);
                        squares[i] = city;
                        break;
                    case "Stations":
                        StationsSquare station = new StationsSquare(var[0], var[1], Integer.parseInt(var[2]), Integer.parseInt(var[3]),Integer.parseInt(var[4]), var[5]);
                        squares[i] = station;
                        break;
                    case "Corporation":
                        CorporationSquare corporation = new CorporationSquare(var[0], var[1], Integer.parseInt(var[2]), Integer.parseInt(var[3]),Integer.parseInt(var[4]), var[5]);
                        squares[i] = corporation;
                        break;
                    case "Jail":
                        JailSquare jail = new JailSquare(var[0], var[1], Integer.parseInt(var[2]), Integer.parseInt(var[3]),Integer.parseInt(var[4]), var[5]);
                        squares[i] = jail;
                        break;
                    case "Tax":
                        TaxSquare tax = new TaxSquare(var[0], var[1], Integer.parseInt(var[2]), Integer.parseInt(var[3]),Integer.parseInt(var[4]), var[5]);
                        squares[i] = tax;
                        break;
                    case "Chance":
                        ChanceSquare chance = new ChanceSquare(var[0], var[1], Integer.parseInt(var[2]), Integer.parseInt(var[3]),Integer.parseInt(var[4]), var[5]);
                        squares[i] = chance;
                        break;
                    case "CommunityChest":
                        CommunityChestSquare chest = new CommunityChestSquare(var[0], var[1], Integer.parseInt(var[2]), Integer.parseInt(var[3]),Integer.parseInt(var[4]), var[5]);
                        squares[i] = chest;
                        break;
                    case "Other":
                        OtherSquare other = new OtherSquare(var[0], var[1], Integer.parseInt(var[2]), Integer.parseInt(var[3]),Integer.parseInt(var[4]), var[5]);
                        squares[i] = other;
                        break;
                    default: //for other
                        System.out.println("Invalid Square Type!");
                        break;
                }
                i++;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Square[] getSquare(){
        return squares;
    }
}
