public class Money {
    private double amount=200.0;

    public void setMoney(double amount) {
        this.amount = amount;
    }

    public double getAmount(){
        return amount;
    }

    public void decreaseAmount(){
        amount--;
    }

    public void increaseAmount(){
        amount++;
    }
}
