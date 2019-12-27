public class CitySquare extends Square {

    private int same = 0;

    public CitySquare(String name, String type, int index, double fee, double rent, String color) {
        super(name,type,index,fee,rent,color);
    }

    @Override
    public void play(Player player) {
        int faceV = player.getDice();

        if(! (getOwner() == null)){

            if(! (getOwner() == player)){
                double rent;

                if(same == 1){
                    rent = getRent() * 2;
                }
                else {
                    rent = getRent();
                  }
                System.out.println(player.getName() + " pays the rent "+ rent +"-----> " + getOwner().getName());
                player.getMoney().decreaseAmount(rent);
                getOwner().getMoney().increaseAmount(rent);
            }
            // else kısmı sahibi gelen playersa ev dikme olacak 3. aşamada
        }
        //gelinen city karesi sahipli değilse
        else{
            if(faceV > 8){
                if(player.getMoney().getAmount() >= getFee()){
                    setOwner(player);
                    player.getMoney().decreaseAmount(getFee());
                    System.out.println(player.getName() + " buys the city with " + getFee() );
                }else{

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
