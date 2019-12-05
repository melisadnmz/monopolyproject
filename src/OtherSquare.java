public class OtherSquare extends Square {

    public OtherSquare(String name, String type, int index, double fee,double rent,String color) {
        super(name,type,index,fee,rent,color);
    }

    @Override
    public void play(Player player) {
            player.getMoney().increaseAmount(200);
            System.out.println(player.getName() + " has past the start and won 200$");
            if(getName().equals("Free Parking")){
                System.out.println("You are in free parking");
            }
    }
}
