public class TaxSquare extends Square {
    public TaxSquare(String name, String type, int index, double fee, double rent, String color) {
        super(name, type, index, fee, rent, color);
    }

    @Override
    public void play(Player player){
            player.getMoney().decreaseAmount(getFee());
            System.out.println( player.getName() + " loses -$" + getFee() + " for tax");
    }
}
