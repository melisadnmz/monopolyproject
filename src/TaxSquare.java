public class TaxSquare extends Square {
    public TaxSquare(String name, String type, int index, double fee) {
        super(name, type, index, fee);
    }

    @Override
    public void play(Player player){
            player.getMoney().decreaseAmount(getFee());
            System.out.println( player.getName() + " loses -$" + getFee() + " for tax");
    }
}
