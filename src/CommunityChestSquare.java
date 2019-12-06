public class CommunityChestSquare extends Square {

    public CommunityChestSquare(String name, String type, int index, double fee, double rent, String color) {
        super(name,type,index,fee,rent,color);
    }

    @Override
    public void play(Player player) {
        System.out.println(player.getName() + " is picking a CommunityChest card");
        int i = (int)(Math.random()*4);
        switch (i) {
            case 0:
                player.getMoney().decreaseAmount(60);
                System.out.println(player.getName() + " you have to pay $60 to the bank!");
                break;
            case 1:
                player.getMoney().increaseAmount(80);
                System.out.println(player.getName() + " you found $80, congratulations");
                break;
            case 2:

            case 3:
                player.getMoney().decreaseAmount(1500);
                System.out.println(player.getName() + " you have to pay $1500 to the bank!");
                //player.getMoney().increaseAmount(player.getNumOfPlayer() * 20);
                //System.out.println(player.getName() + " gain 20 times the number of players!");
                break;


        }


    }


}
