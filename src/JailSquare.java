public class JailSquare extends Square {

    public JailSquare(String name, String type, int index, double fee, double rent, String color) {
        super(name,type,index,fee,rent,color);
    }

    @Override
    public void play(Player player) {
        if(getName().equals("Jail")){
            System.out.println("Visitor at jail");

        }
        else if(getName().equals("GoToJail")){
            System.out.println("Going to jail");
            player.setSquareNum(10);
            player.setJail(true);
        }

    }





}
