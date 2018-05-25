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
    Mechanics economy;
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
            current.fundraise();

        
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
