 


/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Main {
    static Board board;
    static Mechanics economy;
    final static int maxTurns = 150;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Board board = new Board();
        Mechanics economy = new Mechanics();
        CQueen comp = new CQueen();
        HSpy  human = new HSpy();
        ArrayList<Player> players = new ArrayList<Player>();
        int currentPlayer = 0;
        for (int play = 0; play< 2; play++)
        {
            if(play == 0)
                players.set(play,human);
            players.set(play,comp);
        }
        while(economy.getTurns() <= maxTurns) {
            if (currentPlayer  < players.size() )
                currentPlayer++;
            else
                currentPlayer = 1;
            takeTurn(players.get(currentPlayer));
            
            economy.setTurns(economy.getTurns() + 1);
        }

        
    }
    public static void takeTurn(Player current)
    {
        int action=0;
        if(current.isHuman())
            action = board.promptAction();
        else
        {
            //implement findMove() function 
        }
        if (action == 1)
            current.embezzle();
        else if (action == 2)
            {   current.fundraise();
                if(current.getChar().equals("Queen"))
                    economy.setMoney(economy.getMoney() + 400);
            }
    }
}
