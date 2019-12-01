public class ChanceSquare extends Square {

    public ChanceSquare(String name, String type, int index, double fee, double rent, String color) {
        super(name,type,index,fee,rent,color);
    }

    @Override
    public void play(Player player) {
        System.out.println(player.getName() + " is picking a chance card");
        int i = (int)(Math.random()*4);

        if (i == 0){
            player.getMoney().decreaseAmount(50);
            System.out.println(player.getName() + "you have to pay 50 TL to the bank!");
        }else if(i ==1){
            player.getMoney().increaseAmount(70);
            System.out.println(player.getName() + " you found 70 money congratulations!");
        }else{
            player.getMoney().increaseAmount(player.getPlayers().size()*10);
            System.out.println(player.getName() + "Pay 10 times the number of players!");
        }

    }
}
