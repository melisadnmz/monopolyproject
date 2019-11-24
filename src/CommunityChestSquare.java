public class CommunityChestSquare extends Square {

    public CommunityChestSquare(String name, String type, int index, double fee) {
        super(name, type, index, fee);
    }

    @Override
    public void play(Player player) {
        System.out.println(player.getName() + " is picking a CommunityChest card");
        for (int i = 0; i < 5; i++) {
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
                    player.setSquareNum(0);
                    System.out.println(player.getName() + "  go to goSquare!");
                    break;
                case 3:
                    player.getMoney().increaseAmount(player.numberOfPlayers() * 20);
                    System.out.println(player.getName() + " Pay 20 times the number of players!");
                    break;
                case 4:
                    i = 0;
                    break;

            }


        }

    }
}