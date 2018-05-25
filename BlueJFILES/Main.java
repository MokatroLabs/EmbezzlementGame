 import java.io.File;
 import javax.sound.sampled.AudioSystem;
 import javax.sound.sampled.Clip;


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
        File OST = new File("OST.WAV");
        PlaySound(OST);
        Board board = new Board();
        Mechanics economy = new Mechanics();
        CQueen comp = new CQueen();
        HSpy  human = new HSpy();
        ArrayList<Player> players = new ArrayList<Player>();
        int currentPlayer = 0;
        int round = 0;
        for (int play = 0; play< 2; play++)
        {
            if(play == 0)
                players.set(play,human);
            players.set(play,comp);
        }
        while(economy.getTurns() <= maxTurns) {
            if(round >= 4)
                round = 0;
            if (currentPlayer  < players.size() )
                currentPlayer++;
            else
                currentPlayer = 1;
            if(economy.getTurns() %5 == 0)
                players.get(currentPlayer).paycheck();
            takeTurn(players.get(currentPlayer));
            
            
            if(round == 4)
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
        if (action == 1) {
            current.embezzle();
            if((current.getChar()).equals("Spy")){
                economy.setMoney(economy.getMoney() - 750);
            
            }else {
                economy.setMoney(economy.getMoney() - 500);
            }
        }else if (action == 2)
            {   current.fundraise();

                if(current.getChar().equals("Queen")){
                    economy.setMoney(economy.getMoney() + 300);
                }else {
                    economy.setMoney(economy.getMoney() + 400);
                }

            }
    }
    static void PlaySound(File Sound)
    {
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();
            
        }catch(Exception e){}
    }
}
