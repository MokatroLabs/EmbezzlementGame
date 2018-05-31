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
    private static ArrayList<Player> players;
    static Deck deck;
    final static int maxTurns = 150;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File OST = new File("OST.WAV");
        boolean playPressed = false;
        PlaySound(OST);
        board.makeTitleScreen();
        board.showTitleScreen();
        board.makeGameScreen();
        board.hideGameScreen();
        board.makeUpgradeScreen();
        board.hideUpgradeScreen();
        while(!(playPressed))
        {
            if(board.getPlayClick())
                playPressed = true;
        }
        runGame();
    }
    public static void runGame()
    {
        String[] textArea = new String[5];
        textArea[0] = "Gaynald is Gay";
        textArea[1] = "Next Line";
        textArea[2] = "Next Line";
        textArea[3] = "Next Line";
        textArea[4] = "Next Line";
        players = new ArrayList<Player>();
        int currentPlayer = 0;
        int round = 0;
        CBus comp = new CBus();
        HQueen  human = new HQueen();
        board.hideTitleScreen();
        players.add(human);
        players.add(comp);
        updateBoard(human, textArea);
        while(economy.getTurns() <= maxTurns) {
            if (currentPlayer  >= players.size() )
                currentPlayer =0;
            if(round > 2)
                round = 0;
            if(economy.getTurns() %5 == 0)
                players.get(currentPlayer).paycheck();
            if(Math.random() * 100 < (10 - ((players.get(currentPlayer)).getReputation()) / 10)){
                audit(players.get(currentPlayer));
            }
            takeTurn(players.get(currentPlayer));
            updateBoard(human,textArea);
            if (currentPlayer  <= players.size() ){
                players.get(currentPlayer).setCooldown((players.get(currentPlayer)).getCooldown() -1);
                if(players.get(currentPlayer).getEmbezzle() == false){
                    players.get(currentPlayer).setTWE(players.get(currentPlayer).getTWE() -1);
                }
                currentPlayer++;
                if(round == 2)
                    economy.setTurns(economy.getTurns() + 1);
                round++;
            }         
        }
    }
    
    public static void takeTurn(Player current)
    {
        System.out.println("turn");
        int action=0;
        if(current.isHuman())
            action = board.promptAction();
        else
        {
            action = current.findMove();
        }
        if (action == 1) {
            current.embezzle();
            if((current.getChar()).equals("Spy")){
                economy.setMoney(economy.getMoney() - 750);
            }else {
                economy.setMoney(economy.getMoney() - 500);
            }
        } 
        if (action == 2)
        {   current.fundraise();
            if(current.getChar().equals("Queen")){
                economy.setMoney(economy.getMoney() + 300);
            }else {
                economy.setMoney(economy.getMoney() + 400);
            }
        }
        if(action == 5){
            if(current.getChar().equals("Businessman")){
                for(int i = 0; i < players.size(); i++){
                    (players.get(i)).setCooldown((players.get(i).getCooldown() + 2));
                }
                current.activeAbility();
            } else if(current.getChar().equals("Father")){
                for(int i = 0; i < players.size(); i++){
                    (players.get(i)).setMoney((players.get(i).getMoney() - 300));
                    current.setMoney(current.getMoney() + 300);
                }
                current.activeAbility();
            } else if(current.getChar().equals("Spy")) {
                //current.activeAbility(players.get(0));
            } else {
                current .activeAbility();
            }
        }
    }

    
    public static void audit(Player target){
        if(economy.getTurns() >= 10){
            if(target.getReputation() <= 15 && target.getTWE() <= 5){
                //Lose the Game
            } else if(target.getReputation() < 40 && target.getTWE() <= 5) {
                target.setMoney(target.getMoney() - 500);
                target.setReputation(target.getReputation() - 2.5);
            } else if(target.getTWE() > 5){
                target.setReputation(target.getReputation() + 1);
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

