public class CitySquare extends Square {

    public CitySquare(String name, String type, int index, double fee, double rent, String color) {
        super(name,type,index,fee,rent,color);
    }

    @Override
    public void play(Player player) {
        int faceV = player.getDice();

        if(! (getOwner() == null)){

            if(! (getOwner() == player)){

                double rent = getRent(); // verilecek kira bedeli
                System.out.println(player.getName() + " pays the rent "+ rent +"-----> " + getOwner().getName());
                player.getMoney().decreaseAmount(rent);
                getOwner().getMoney().increaseAmount(rent);
            }
            // else kısmı sahibi gelen playersa ev dikme olacak 3. aşamada
        }
        //gelinen city karesi sahipli değilse
        else{
            //System.out.println("ıcerdeyımm");
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
}
