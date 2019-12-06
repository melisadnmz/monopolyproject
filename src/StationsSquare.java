public class StationsSquare extends Square {

    public StationsSquare(String name, String type, int index, double fee,double rent,String color) {
        super(name, type, index, fee,rent,color);
    }

    @Override
    public void play(Player player) {
        int faceV = player.getDice();

        //gelinen city karesi sahipliyse
        if(! (getOwner() == null)){

            if(! (getOwner() == player)){//ve sahibi o degilse

                if(true){//burada gelinen yerin sahibi sadece birine sahip ise
                    double rent = getRent();
                    player.getMoney().decreaseAmount(rent);
                    getOwner().getMoney().increaseAmount(rent);
                    System.out.println(player.getName() + " pays the rent "+ rent +"-----> " + getOwner().getName());
                }
                if(false){//burada gelinen yerin sahibi  2 stationada sahipse
                    double rent = getRent()*2;
                    player.getMoney().decreaseAmount(rent);
                    getOwner().getMoney().increaseAmount(rent);
                }
                if(false){//burada gelinen yerin sahibi  3 stationada sahipse
                    double rent = getRent()*3;
                    player.getMoney().decreaseAmount(rent);
                    getOwner().getMoney().increaseAmount(rent);
                }
                if(false){//burada gelinen yerin sahibi  4 stationada sahipse
                    double rent = getRent()*4;
                    player.getMoney().decreaseAmount(rent);
                    getOwner().getMoney().increaseAmount(rent);

                }

            }
            // else kismi sahibi gelen playersa ev dikme olacak 3. asamada
        }
        //gelinen city karesi sahipli degilse
        else{

            if(faceV > 8){
                if(player.getMoney().getAmount() >= getFee()){
                    setOwner(player);
                    player.getMoney().decreaseAmount(getFee());
                    System.out.println(player.getName() + " buys the station with " + getFee());
                }
            }
        }

    }


}
