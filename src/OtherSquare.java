public class OtherSquare extends Square {

    public OtherSquare(String name, String type, int index, double fee,double rent,String color) {
        super(name,type,index,fee,rent,color);
    }

    @Override
    public void play(Player player) {
        if(getName().equals("GO")){
            player.getMoney().increaseAmount(200);
            System.out.println(player.getName() + " has past the start and won 200$");
        }else if(getName().equals("FreeParking")){
            System.out.println("You are in free parking");
        }
    }
}
