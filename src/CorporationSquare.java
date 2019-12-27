public class CorporationSquare extends Square {

    private int same = 0;
    public CorporationSquare(String name, String type, int index, double fee,double rent, String color,double houseCost) {
        super(name, type, index, fee,rent, color , houseCost);
    }

    @Override
    public void play(Player player) {
        int faceV = player.getDice();

        //gelinen city karesi sahipliyse
        if (!(getOwner() == null)) {

            if (!(getOwner() == player)) {//ve sahibi o degilse

                if (same == 0) {//burada gelinen yerin sahibi sadece birine sahip ise
                    double rent = 4 * faceV;
                    player.getMoney().decreaseAmount(rent);
                    getOwner().getMoney().increaseAmount(rent);
                    System.out.println(player.getName() + " pays the rent "+ rent +"-----> " + getOwner().getName());
                }
                if (same == 1) {//burada gelinen yerin sahibi her iki corporationada sahipse
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

    public int getSame() {
        return same;
    }

    public void setSame(int same) {
        this.same = this.same + same;
    }

}
