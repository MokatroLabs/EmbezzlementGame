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
        ArrayList<Player> players = new ArrayList<Player>();
        CBus comp = new CBus();
        HQueen  human = new HQueen();
        String[] textArea = new String[5];
        textArea[0] = "Gaynald is gay";
        textArea[1] = "Next Line";
        textArea[2] = "Next Line";
        textArea[3] = "Next Line";
        textArea[4] = "Next Line";
        PlaySound(OST);
        int currentPlayer = 0;
        int round = 0;
        board.makeTitleScreen();
        board.showTitleScreen();


        for (int play = 0; play< players.size(); play++)
        {
            if(play == 0)
                players.add(human);
            players.add(comp);
        }

        board.makeGameScreen();
        board.hideGameScreen();
        players.add(human);
        players.add(comp);
        updateBoard(human, textArea);

        while(economy.getTurns() <= maxTurns) {
            
            if (currentPlayer  <= players.size() )
                currentPlayer =0;
            if(round > 4)
                round = 0;
            if(economy.getTurns() %5 == 0)
                players.get(currentPlayer).paycheck();
            takeTurn(players.get(currentPlayer));
            updateBoard(human,textArea);
            if (currentPlayer  <= players.size() )
                currentPlayer++;
            if(round == 4)

                economy.setTurns(economy.getTurns() + 1);

            
            round++;
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
    
    public static void updateBoard(Human human, String[] textArea)
    { 
       board.setTurnCount("Turn: " + economy.getTurns());
       board.setRepCount("Rep: " + ((int)human.getReputation()) + "%" );
       board.setMoneyCount("Money: " + human.getMoney() );
       board.setTextArea("-"+ textArea[0] + "\n" + "-" + textArea[1] + "\n" + "-" + textArea[2] + "\n"+ "-" + textArea[3] + "\n" + "-" + textArea[4] );
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
