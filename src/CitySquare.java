public class CitySquare extends Square {

    public CitySquare(String name, String type, int index, double fee, double rent, String color) {
        super(name,type,index,fee,rent,color);
    }

    @Override
    public void play(Player player) {
        int faceV = player.getDice();
        System.out.println(faceV);
        //gelinen city karesi sahipliyse
        if(! (getOwner() == null)){
            //System.out.println("noluyor get owner null degıl");
            if(! (getOwner() == player)){
              //  System.out.println("getowner ben degılım");
                double rent = getRent(); // verilecek kira bedeli
                player.getMoney().decreaseAmount(rent);
                getOwner().getMoney().increaseAmount(rent);
            }
            // else kısmı sahibi gelen playersa ev dikme olacak 3. aşamada
        }
        //gelinen city karesi sahipli değilse
        else{
            //System.out.println("ıcerdeyımm");
            if(faceV > 8){
                if(player.getMoney().getAmount() >= getRent()){
                    setOwner(player);
                    player.getMoney().decreaseAmount(getRent());
                   // System.out.println("ev alındıı");
                }else{

                }
            }
        }
    }
}
