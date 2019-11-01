import java.io.BufferedReader;
import java.io.FileReader;

public class Board {
    private Square squares[] = new Square[40];

    public void createSquare() {
        try{
            BufferedReader in = new BufferedReader(new FileReader("SquareList.txt"));
            String s;
            int i = 0;
            while((s = in.readLine()) != null){
                String[] var = s.split("-");
                squares[i] = new Square(var[0], var[1], Integer.parseInt(var[2]), Integer.parseInt(var[3]));
                i++;
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
