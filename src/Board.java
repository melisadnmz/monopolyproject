import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Board extends Monopoly {
    private Square[] squares = new Square[40];
    int numOfTax=0;
    int numOfJail=1;
    double inputFee;

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

    public void locationOfTax(){
        numOfTax();
        for(int i=0;i< squares.length; i++){
            if (numOfTax==0)
                break;
            if(squares[i].getType().equals("Tax") && squares[i].getName().equals("Free")){
                squares[i].setFee(amountOfTax());
                squares[i].setName("Tax");
                numOfTax--;
            }

        }
    }

    public void numOfTax(){
        System.out.print("Please enter number of Tax square: ");
        Scanner scanner = new Scanner(System.in);
        try{
            numOfTax = scanner.nextInt();
            while(numOfTax > 4) {
                System.out.print("Number of Tax square must be below 4. Please enter again: ");
                numOfTax = scanner.nextInt();
            }
            while(numOfTax < 0) {
                System.out.print("Number of Tax square must be above 0. Please enter again: ");
                numOfJail = scanner.nextInt();
            }

        }catch (InputMismatchException hata){
            System.out.println("please enter valid number - error: " + hata);


        }


    }

    public double amountOfTax(){
        System.out.print("Please enter amount for Tax square: ");
        Scanner scanner = new Scanner(System.in);
        try{
             inputFee = scanner.nextDouble();
        }
       catch (InputMismatchException hata){
           System.out.println("please enter valid number - error: " + hata);

       }
        return inputFee;
    }

    public void locationOfJail(){
        numOfJail();
        for(int i=0;i< squares.length; i++){
            if (numOfJail==1)
                break;
            if(squares[i].getType().equals("Jail") && squares[i].getName().equals("Free")){
                squares[i].setName("GoToJail");
                numOfJail--;
            }

        }
    }

    public void numOfJail(){
        System.out.print("Please enter number of GoToJail square: ");
        Scanner scanner = new Scanner(System.in);
        try{
            numOfJail = scanner.nextInt();
            while(numOfJail > 5) {
                System.out.print("Number of GoToJail square must be below 5. Please enter again: ");
                numOfJail = scanner.nextInt();
            }
            while(numOfJail < 1) {
                System.out.print("Number of GoToJail square must be above 1. Please enter again: ");
                numOfJail = scanner.nextInt();
            }
        }catch (ArithmeticException hata){
            System.out.println("please enter valid number - error: " + hata);
        }

        }

}
