public class CorporationSquare extends Square {

    public CorporationSquare(String name, String type, int index, double fee,double rent, String color) {
        super(name, type, index, fee,rent, color);
    }

    @Override
    public void play(Player player) {
        int faceV = player.getDice();

        //gelinen city karesi sahipliyse
        if (!(getOwner() == null)) {

            if (!(getOwner() == player)) {//ve sahibi o degilse

                if (true) {//burada gelinen yerin sahibi sadece birine sahip ise
                    double rent = 4 * faceV;
                    player.getMoney().decreaseAmount(rent);
                    getOwner().getMoney().increaseAmount(rent);
                    System.out.println(player.getName() + " pays the rent "+ rent +"-----> " + getOwner().getName());
                }
                if (false) {//burada gelinen yerin sahibi her iki corporationada sahipse
                    double rent = 10 * faceV;
                    player.getMoney().decreaseAmount(rent);
                    getOwner().getMoney().increaseAmount(rent);
                }

            }
            // else kismi sahibi gelen playersa ev dikme olacak 3. asamada
        }
        //gelinen city karesi sahipli degilse
        else {
            if (faceV > 8) {
                if (player.getMoney().getAmount() >= getFee()) {
                    setOwner(player);
                    player.getMoney().decreaseAmount(getFee());
                   System.out.println(player.getName() + " buys the corporation with " + getFee());
                }
            }
        }

    }

}