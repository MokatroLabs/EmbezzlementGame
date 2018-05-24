 


/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Main {

    final static int maxTurns = 150;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Board board = new Board();
        Mechanics economy = new Mechanics();
        HQueen human = new HQueen();
        //CSpy  comp = new CSpy();
        ArrayList<Player> players = new ArrayList<Player>();
        int currentPlayer = 0;
        while(economy.getTurns() <= maxTurns) {
            if (currentPlayer  < players.size() )
                currentPlayer++;
            else
                currentPlayer = 1;
            
            
            economy.setTurns(economy.getTurns() + 1);
        }

        Mechanics mechanics = new Mechanics(400);
        board2 board2 = new board2();

        
    }

}
