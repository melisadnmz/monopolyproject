public class ChanceSquare extends Square {

    public ChanceSquare(String name, String type, int index, double fee) {
        super(name,type,index,fee);
    }

    @Override
    public void play(Player player) {
        System.out.println(player.getName() + " is picking a chance card");
        for(int i = 0; i<5; i++){
            switch (i){
                case 0 :
                    player.getMoney().decreaseAmount(50);
                    System.out.println(player.getName() + "you have to pay 50 TL to the bank!");
                    break;
                case 1 :
                    player.getMoney().increaseAmount(70);
                    System.out.println(player.getName() + " you found 70 money congratulations!");
                    break;
                case 2 :
                    player.setSquareNum(20);
                    System.out.println(player.getName() + " go to free parking square(20)");
                    break;
                case 3 :
                    player.getMoney().increaseAmount(player.numberOfPlayers()*10);
                    System.out.println(player.getName() + "Pay 10 times the number of players!");
                    break;
                case 4 :
                    i=0;
                    break;

        }




        }
    }
}
