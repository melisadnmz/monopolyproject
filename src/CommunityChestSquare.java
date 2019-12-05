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
                System.out.println(player.getName() + " you have to pay 60 TL to the bank!");
                break;
            case 1:
                player.getMoney().increaseAmount(80);
                System.out.println(player.getName() + " you found 80 money, congratulations");
                break;
            case 2:

            case 3:
                player.getMoney().increaseAmount(player.getPlayers().size() * 20);
                System.out.println(player.getName() + " pay 20 times the number of players!");
                break;


        }


    }


}
