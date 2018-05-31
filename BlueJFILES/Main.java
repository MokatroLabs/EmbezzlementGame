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
    //saveme
    final static int maxTurns = 150;

    
    private static ActionListener taskPerformer = new ActionListener() 
    {
      public void actionPerformed(ActionEvent evt) {
          timerDelay.stop();
          System.out.println("1 step of the work");
      }
    };
    private static Timer timerDelay = new Timer(2000, taskPerformer);

   
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File OST = new File("OST.WAV");
        boolean playPressed = false;
        PlaySoundLoop(OST);
        board.makeTitleScreen();
        board.showTitleScreen();
        board.makeGameScreen();
        board.hideGameScreen();
        board.makeUpgradeScreen();
        board.hideUpgradeScreen();
        board.makeCharScreen();
        board.hideCharScreen();
        board.updateTurnBorder(economy.getTurns());
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
        board.makeTitleScreen();
        board.showTitleScreen();
        CBus comp1 = new CBus();
        CBus comp2 = new CBus();
        CBus comp3 = new CBus();
        HQueen  human = new HQueen();
        board.hideTitleScreen();
        players.add(human);
        players.add(comp1);
        players.add(comp2);
        players.add(comp3);
        updateBoard(human, textArea);
        while(economy.getTurns() <= maxTurns) {
            if (currentPlayer  >= players.size() )
                currentPlayer =0;
            if(round > 4)
                round = 0;
            if(economy.getTurns() %5 == 0){
                players.get(currentPlayer).paycheck();
            }
            if(Math.random() * 100 < (10 - ((players.get(currentPlayer)).getReputation()) / 10)){
                //audit(players.get(currentPlayer));
            }
            takeTurn(players.get(currentPlayer));
            updateBoard(human,textArea);


            if(players.get(currentPlayer).getReputation() <=0 || players.get(currentPlayer).getMoney() <= 0){
                players.get(currentPlayer).setLost();
            }
            if(round == 4)
                economy.setTurns(economy.getTurns() + 1);
            if(players.get(currentPlayer).getReputation() <=0 || players.get(currentPlayer).getMoney() <= 0){
                players.get(currentPlayer).setLost();
            }

            round++;
            currentPlayer++;
            
            
         }
    }
    public static void takeTurn(Player current){
        System.out.println("turn");
        int action=0;
        int target=-1;
        current.setTWE(current.getTWE() +1);
        current.setCooldown(current.getCooldown()-1);
        if(current.getToggled() == true)
        {
            //current.setReputation(current.getReputation() + .2);
            //if(current.getChar().equals("Queen"))
            //    current.setReputation(current.getReputation()+.1);
        }
        if(current.isHuman())
            action = board.promptAction();
            else
            {
                timerDelay.start();
                action = current.findMove(economy.getTurns());
            }
        if (action == 1) {
            current.embezzle();
            current.setTWE(-1);
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
        if (action == 3)
        {
            current.interact();
        }
        if(action == 5){
            if(current.getChar().equals("Businessman")){
                for(int i = 0; i < players.size(); i++){
                    if(players.get(i) !=current)
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
                current.activeAbility();
            }
        }
        if(current.getCooldown()>0)
            current.setCooldown(current.getCooldown()-1);

    }
    /*  public static void audit(Player target){


   
    /*    public static void audit(Player target){


    /*    if(economy.getTurns() >= 10){
    /*    if(target.getReputation() <= 15 && target.getTWE() <= 5){
                target.setLost();
            } else if(target.getReputation() < 40 && target.getTWE() <= 5) {
                target.setMoney(target.getMoney() - 1000);
                target.setReputation(target.getReputation() - 5);
            } else if(target.getTWE() > 5){
                target.setReputation(target.getReputation() + 1);
            }
        }



    }



    }

    }*/


  

    public static void updateBoard(Human human, String[] textArea)
    { 
       board.setTurnCount("Turn: " + (economy.getTurns() + 1));
       board.setRepCount("Rep: " + ((int)human.getReputation()) + "%" );
       board.setMoneyCount("Money: " + human.getMoney() );
       board.setTextArea("-"+ textArea[0] + "\n" + "-" + textArea[1] + "\n" + "-" + textArea[2] + "\n"+ "-" + textArea[3] + "\n" + "-" + textArea[4] );
       board.updateTurnBorder(economy.getTurns());
    }

    static void PlaySoundLoop(File Sound)
    {
        ContinuousAudioDataStream loop = null;
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;        
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            BGM = new AudioStream(new FileInputStream("OST.WAV"));
            MD = BGM.getData();
            loop = new ContinuousAudioDataStream(MD);
        }catch(Exception e){}
        MGP.start(loop);
    }
}

