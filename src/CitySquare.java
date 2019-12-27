public class CitySquare extends Square {

    private int same = 0;
    private int houseNumber = 0;

    public CitySquare(String name, String type, int index, double fee, double rent, String color,double houseCost) {
        super(name,type,index,fee,rent,color,houseCost);
    }

    @Override
    public void play(Player player) {
        int faceV = player.getDice();

        if(! (getOwner() == null)){

            if(! (getOwner() == player)){
                double rent;

                if(same == 1){
                    if(houseNumber == 0) rent = getRent() * 2;

                    else{
                        rent = getRent() * 2 *(houseNumber+1);
                    }
                }
                else {
                    rent = getRent();
                  }
                System.out.println(player.getName() + " pays the rent "+ rent +"-----> " + getOwner().getName());
                player.getMoney().decreaseAmount(rent);
                getOwner().getMoney().increaseAmount(rent);
            }

            else{
                System.out.println("owner ben");
                if (same == 1){
                    System.out.println("owner ben1");
                    if(player.getMoney().getAmount() >= getHouseCost()){
                        houseNumber++;
                        player.getMoney().decreaseAmount(getHouseCost());
                        System.out.println(player.getName() + " ------> buyed 1 house");
                    }
                    else{
                        System.out.println(player.getName() + " ------> does not have enough money to buy house.");
                    }

                }


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

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }
}
