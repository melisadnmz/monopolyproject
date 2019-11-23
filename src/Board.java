import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Board extends Monopoly {
    private int numOfTax;
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
                System.out.println("var1: "+ var[1]);
                switch(var[1]){
                    case "City":
                        CitySquare city = new CitySquare(var[0], var[1], Integer.parseInt(var[2]), Integer.parseInt(var[3]));
                        squares[i] = city;
                        break;
                    case "Stations":
                        StationsSquare station = new StationsSquare(var[0], var[1], Integer.parseInt(var[2]), Integer.parseInt(var[3]));
                        squares[i] = station;
                        break;
                    case "Corporation":
                        CorporationSquare corporation = new CorporationSquare(var[0], var[1], Integer.parseInt(var[2]), Integer.parseInt(var[3]));
                        squares[i] = corporation;
                        break;
                    case "Jail":
                        JailSquare jail = new JailSquare(var[0], var[1], Integer.parseInt(var[2]), Integer.parseInt(var[3]));
                        squares[i] = jail;
                        break;
                    case "Tax":
                        TaxSquare tax = new TaxSquare(var[0], var[1], Integer.parseInt(var[2]), Integer.parseInt(var[3]));
                        squares[i] = tax;
                        break;
                    case "Chance":
                        ChanceSquare chance = new ChanceSquare(var[0], var[1], Integer.parseInt(var[2]), Integer.parseInt(var[3]));
                        squares[i] = chance;
                        break;
                    case "CommunityChest":
                        CommunityChestSquare chest = new CommunityChestSquare(var[0], var[1], Integer.parseInt(var[2]), Integer.parseInt(var[3]));
                        squares[i] = chest;
                        break;
                    case "Other":
                        OtherSquare other = new OtherSquare(var[0], var[1], Integer.parseInt(var[2]), Integer.parseInt(var[3]));
                        squares[i] = other;
                        break;
                    default: //for other
                        System.out.println("Invalid Square Type!");
                        break;
                }
                //squares[i] = new Square(var[0], var[1], Integer.parseInt(var[2]), Integer.parseInt(var[3]));
                i++;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Square[] getSquare(){
        return squares;
    }

    public void locationOfTax(){
        ArrayList<Integer> rndList = new ArrayList<>(40);
        numOfTax();
        for(int i=0;i< numOfTax; i++){
            int rnd = (int)(Math.random()* 39 + 1);
            if(!rndList.contains(rnd)) {
                rndList.add(rnd);
                squares[rnd].setName("Tax Square");
                squares[rnd].setType("Tax");
                squares[rnd].setIndex(rnd);
                squares[rnd].setFee(amountOfTax());
            }else
                i--;
        }
    }

    public void crSquare() {
        /*for(int i=0;i<squares.length;i++){
            if(i == 0){
                squares[i] = new Square("Square", "GO", i, 0);
            }
            else squares[i] = new Square("Square", "Other", i, 0);
        }*/
    }

    public void numOfTax(){
        System.out.print("Please enter number of Tax square: ");
        Scanner scanner = new Scanner(System.in);
        numOfTax= scanner.nextInt();
        while(numOfTax > 20) {
            System.out.print("Number of Tax square must be below 20. Please enter again: ");
            numOfTax = scanner.nextInt();
        }
    }

    public double amountOfTax(){
        System.out.print("Please enter amount for Tax square: ");
        Scanner scanner = new Scanner(System.in);
        double inputFee = scanner.nextDouble();
        return inputFee;
    }
}
