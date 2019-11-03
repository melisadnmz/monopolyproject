import java.util.Scanner;

public class Money extends Player {

    private double amount= 0.0;

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount(){
        return amount;
    }

    public void decreaseAmount(int money){

        amount = amount - money;
    }

    public void increaseAmount(int money){
       amount = amount+money;
    }

    public void initialMoney(){
        System.out.print("Please enter initial amount for players: ");
        Scanner scanner = new Scanner(System.in);
        amount= scanner.nextDouble();
        setAmount(amount);
    }
}
