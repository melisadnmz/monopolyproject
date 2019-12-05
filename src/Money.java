import java.util.Scanner;

public class Money extends Player {

    public Money(){
        amount = 0.0;
    }

    private double amount;

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount(){
        return amount;
    }

    public void decreaseAmount(double money){
        amount = amount - money;
        if(amount < 0) amount = 0;
    }

    public void increaseAmount(double money){
       amount = amount+money;
    }

    public void initialMoney(){
        System.out.print("Please enter initial amount for players: ");
        Scanner scanner = new Scanner(System.in);
        amount= scanner.nextDouble();
        setAmount(amount);
    }
}
