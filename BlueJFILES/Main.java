import java.io.File;
import java.awt.event.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import sun.audio.*;
import java.io.*;
import java.util.ArrayList;
public class Main {
    public static Board board = new Board();
    public static Mechanics economy = new Mechanics();
    static Deck deck;
    final static int maxTurns = 150;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File OST = new File("OST.WAV");
        PlaySound(OST);
        CBus comp = new CBus();
        HQueen  human = new HQueen();
        ArrayList<Player> players = new ArrayList<Player>();
        int currentPlayer = 0;
        int round = 0;
        board.makeTitleScreen();
        board.showTitleScreen();
        board.makeGameScreen();
        board.hideGameScreen();
        players.add(human);
        players.add(comp);
        while(economy.getTurns() <= maxTurns) {
            if (currentPlayer  <= players.size() )
                currentPlayer =0;
            if(round >= 4)
                round = 0;
            if(economy.getTurns() %5 == 0)
                players.get(currentPlayer).paycheck();
            takeTurn(players.get(currentPlayer));
            if (currentPlayer  <= players.size() )
                currentPlayer++;
            
            //System.out.print("test");
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
        ContinuousAudioDataStream loop = null;
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;        
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();
                           BGM = new AudioStream(new FileInputStream("OST.WAV"));
               MD = BGM.getData();
               loop = new ContinuousAudioDataStream(MD);
        }catch(Exception e){}
        MGP.start(loop);

    }
}
