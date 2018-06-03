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
    private static int actionDone = 0;
    private static int upgradeDone = 0;
    static Deck deck = new Deck();
    static String[] textArea = {"Gaynald is Gay" , "Next Line", "Next Line", "Next Line", "Next Line"};

    //saveme
    final static int maxTurns = 150;

    
    private static ActionListener taskPerformer = new ActionListener() 
    {
      public void actionPerformed(ActionEvent evt) {
          System.out.println("comp turn");
          timerDelay.stop();
          System.out.println("1 step of the work");
      }
    };
    private static Timer timerDelay = new Timer(2000, taskPerformer);

   
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File OST = new File("OST.WAV");
        boolean playPressed = false;
        boolean charSelect = false;
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
        System.out.println(pickACard().toString());

        while(!(playPressed))
        {
            if(board.getPlayClick())
                playPressed = true;
        }
        while(!(charSelect))
        {
            if(board.getCharPicked())
            {
                charSelect = true;
                System.out.println(board.getCharSelect());
            }
        }
        board.rePic(board.getCharSelect());
        runGame();
    }
    public static void runGame()
    {
        Human human;
        if(board.getCharSelect().equals("Father"))
            human = new HFat();
        else if (board.getCharSelect().equals("Spy"))
            human = new HSpy();
        else if (board.getCharSelect().equals("Queen"))
            human = new HQueen();
        else 
            human = new HBus();
        Computer comp1;
        Computer comp2;
        Computer comp3;
        if(human.getChar().equals("Queen"))
        {
            comp1 = new CSpy();
            comp2 = new CBus();
            comp3 = new CFat();
        }else if (human.getChar().equals("Spy"))
        {
            comp1 = new CQueen();
            comp2 = new CBus();
            comp3 = new CFat();
        }else if (human.getChar().equals("Father"))
        {
            comp1 = new CQueen();
            comp2 = new CSpy();
            comp3 = new CBus();
        }else
        {
            comp1 = new CQueen();
            comp2 = new CSpy();
            comp3 = new CFat();
        }
        
        players = new ArrayList<Player>();
        int currentPlayer = 0;
        int round = 0;
        board.makeTitleScreen();
        board.showTitleScreen();
        board.hideTitleScreen();
        updateBoard(human, textArea, currentPlayer);
        while(economy.getTurns() <= maxTurns) {
            if (currentPlayer  >= players.size() )
                currentPlayer =0;
            if(round > 4)
                round = 0;
            if(economy.getTurns() %5 == 0){
                players.get(currentPlayer).paycheck();
                textArea[0] = "Here is your paycheck!"; // doesnt work for some reason
            }
            if((players.get(currentPlayer).getChar()).equals("Business Man")){
                players.get(currentPlayer).setMoney(players.get(currentPlayer).getMoney() + (50 + players.get(currentPlayer).getMoneyBoost()));
            }
            if(Math.random() * 100 < (5 - ((players.get(currentPlayer)).getReputation()) / 10)){
                audit(players.get(currentPlayer));
            }
            takeTurn(players.get(currentPlayer));
            /*if(players.get(currentPlayer).getToggled()){
                if(actionDone == 1){
                    System.out.println("Player " + (currentPlayer + 1) + "has fundraised");
                }
                if(actionDone == 2){
                    System.out.println("Player " + (currentPlayer + 1) + "has embezzled");
                }
                if(actionDone == 3){
                    System.out.println("Player " + (currentPlayer + 1) + "has interacted");
                }
                if(actionDone == 4){
                    System.out.println("Player " + (currentPlayer + 1) + "has upgraded");
                }
                if(actionDone == 5){
                    System.out.println("Player " + (currentPlayer + 1) + "has used an active ability");
                }
                
            }
            */
            
            textArea[0] = "Money Pot:"+ economy.getMoney();
            updateBoard(human,textArea,currentPlayer);
            System.out.println("Money Pot:"+ economy.getMoney());

            if(players.get(currentPlayer).getReputation() <=0 || players.get(currentPlayer).getMoney() <= 0){
                players.get(currentPlayer).setLost();
            }
            if(players.get(currentPlayer).getReputation() >= 100){
                players.get(currentPlayer).setWon();
            }
            for(int i = 0; i < 4; i++){
                int[] check = players.get(currentPlayer).getSkills();
                if(check[i] != 5){
                    break;
                } else if(i == 4 && check[i] == 5){
                    players.get(currentPlayer).setWon();
                }
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
        int upgrade = 0;
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
            if((current.getChar()).equals("Spy") && economy.getMoney()- 750 >=0){
                economy.setMoney(economy.getMoney() - 750);
                current.embezzle();
                current.setTWE(-1);
            }else if(economy.getMoney()-500 >=0){
                economy.setMoney(economy.getMoney() - 500);
                current.embezzle();
                current.setTWE(-1);
            }
        } 
        if (action == 2)
        {   current.fundraise();
            if(current.getChar().equals("Queen")){
                economy.setMoney(economy.getMoney() + 300 + (current.getFundIncrease()));
            }else {
                economy.setMoney(economy.getMoney() + 400 + (current.getFundIncrease() * 2));
            }
        }
        if (action == 3)
        {
            Card pickedCard = pickACard();
            //current.interact(pickedCard);
            if(Math.random() > .5)
            {
                board.setCardPic(1);
            }
            else
            {
                board.setCardPic(2);
            }
            
        }
        if(action == 4){
            if(current.isHuman()){
                upgrade = board.promptUpgrade();
            } else {
                //upgrade = findUpgrade();
            }
            if(upgrade == 1){
                if(current.getLeadLV() >= 5){
                    upgrade = board.promptUpgrade();
                }
                current.upgrade(current.getLeadLV() + 1);
                current.setLeadLV(current.getLeadLV() + 1);
                board.setUpActive("Leadership : " + (current.getLeadLV()));
            }
            if(upgrade == 2){
                if(current.getPrLV() >= 5){
                    upgrade = board.promptUpgrade();
                }
                current.upgrade(current.getPrLV() + 1);
                current.setPrLV(current.getPrLV() + 1);
                current.setRepIncrease(current.getPrLV());
                board.setUpInteract("Public Relations : " + (current.getPrLV()));
            }
            if(upgrade == 3){
                if(current.getEspLV() >= 5){
                    upgrade = board.promptUpgrade();
                }
                current.upgrade(current.getEspLV() + 1);
                current.setEspLV(current.getEspLV() + 1);
                current.setNoCons(current.getEspLV());
                board.setUpEmbezzle("Espionage" + (current.getEspLV()));
            }
            if(upgrade == 4){
                if(current.getMarLV() >= 5){
                    upgrade = board.promptUpgrade();
                }
                current.upgrade(current.getMarLV() + 1);
                current.setMarLV(current.getMarLV() + 1);
                current.setFundIncrease(current.getMarLV());
                board.setUpFundraise("Marketing" + (current.getMarLV()));
            }
            if(upgrade == 5){
                if(current.getRdLV() >= 5){
                    upgrade = board.promptUpgrade();
                }
                current.upgrade(current.getRdLV() + 1);
                current.setRdLV(current.getRdLV() + 1);
                current.setUpgradeDown(current.getRdLV());
                board.setUpUpgrade("Research and Development" + (current.getRdLV()));
            }
        }
        if(action == 5 && current.getCooldown() <=0){
            if(current.getChar().equals("Businessman")){
                for(int i = 0; i < players.size(); i++){
                    if(players.get(i) !=current && (players.get(i).getCooldown() != 0)){
                        (players.get(i)).setCooldown((players.get(i).getCooldown() + 1));
                    }
                }
                current.activeAbility();
            } else if(current.getChar().equals("Father")){
                for(int i = 0; i < players.size(); i++){
                    if(current.getLeadLV() == 0){
                        (players.get(i)).setMoney((players.get(i).getMoney() - 50));
                        current.setMoney(current.getMoney() + 50);
                    }
                    if(current.getLeadLV() == 1){
                        (players.get(i)).setMoney((players.get(i).getMoney() - 100 ));
                        current.setMoney(current.getMoney() + 100);
                    }
                    if(current.getLeadLV() == 2){
                        (players.get(i)).setMoney((players.get(i).getMoney() - 200));
                        current.setMoney(current.getMoney() + 200);
                    }
                    if(current.getLeadLV() == 3){
                        (players.get(i)).setMoney((players.get(i).getMoney() - 300));
                        current.setMoney(current.getMoney() + 300);
                    }
                    if(current.getLeadLV() == 4){
                        (players.get(i)).setMoney((players.get(i).getMoney() - 400));
                        current.setMoney(current.getMoney() + 400);
                    }
                    if(current.getLeadLV() == 5){
                        (players.get(i)).setMoney((players.get(i).getMoney() - 500));
                        current.setMoney(current.getMoney() + 500);
                    }
                }
                current.activeAbility();
            } else if(current.getChar().equals("Spy")) {
                //current.activeAbility(players.get(0));
            } else {
                current.activeAbility();
            }
        }
        if(current.getCooldown()>0){
            current.setCooldown(current.getCooldown()-1);
        }
        actionDone = action;
        upgradeDone = upgrade;
    }
    public static void audit(Player target){
        if(economy.getTurns() >= 10){
            if(target.getReputation() <= 15 && target.getTWE() <= 5){
                target.setLost();
            } else if(target.getReputation() < 40 && target.getTWE() <= 5) {
                target.setMoney(target.getMoney() - 1000);
                target.setReputation(target.getReputation() - 5);
            } else if(target.getTWE() > 5){
                target.setReputation(target.getReputation() + 1);
            }
        }
    }
    public static void updateBoard(Human human, String[] textArea, int currentPlayer)
    { 
       board.setTurnCount("Turn: " + (economy.getTurns() ));
       board.setRepCount("Rep: " + (human.getReputation()) + "%" );
       board.setMoneyCount("Money: " + human.getMoney() );
       board.setTextArea("-"+ textArea[0] + "\n" + "-" + textArea[1] + "\n" + "-" + textArea[2] + "\n"+ "-" + textArea[3] + "\n" + "-" + textArea[4] );
       board.updateTurnBorder(currentPlayer);
    }
    public static Card pickACard()
    {
        double num = ( 56 * Math.random());
        return deck.getCard((int)num);
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

