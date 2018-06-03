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
        players.add(human);
        players.add(comp1);
        players.add(comp2);
        players.add(comp3);
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
            }
            if((players.get(currentPlayer).getChar()).equals("Business Man")){
                players.get(currentPlayer).setMoney(players.get(currentPlayer).getMoney() + (50 + players.get(currentPlayer).getMoneyBoost()));
            }
            if(Math.random() * 100 < (5 - ((players.get(currentPlayer)).getReputation()) / 10)){
                audit(players.get(currentPlayer));
            }
            updateBoard(human,textArea,currentPlayer);
            textArea[0] = "Money Pot:"+ economy.getMoney();
            takeTurn(players.get(currentPlayer));
            if(players.get(currentPlayer).getToggled()){
                if(actionDone == 1){
                    textArea[currentPlayer+1] = "The" + players.get(currentPlayer).getChar() +" embezzled.";
                }
                if(actionDone == 2){
                    textArea[currentPlayer+1] = "The" + players.get(currentPlayer).getChar() +" fundraised.";
                }
                if(actionDone == 3){
                    textArea[currentPlayer+1] = "The" + players.get(currentPlayer).getChar() +" interacted.";
                }
                if(actionDone == 4){
                    textArea[currentPlayer+1] = "The" + players.get(currentPlayer).getChar() +" upgraded.";
                }
                if(actionDone == 5){
                    textArea[currentPlayer+1] = "The" + players.get(currentPlayer).getChar() +" used "+ players.get(currentPlayer).getActiveName();
                }
            }
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
            updateBoard(human,textArea,currentPlayer);
            textArea[0] = "Money Pot:"+ economy.getMoney();
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
        current.setCard46(current.getCard46()-1);
        if (current.getCard46() == 0)
            current.setMoney(current.getMoney() +1000);
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
            if(pickedCard.getCardNumber() == 1)
            {
                //+1rep/+100 dollars im dying here
            }
            else if(pickedCard.getCardNumber() == 2)
            {
                current.setMoney(current.getMoney() - 1000);
            } else if(pickedCard.getCardNumber() == 3)
            {
                current.setReputation(current.getReputation() + 2);
            } else if(pickedCard.getCardNumber() == 4)
            {
                //increase your cooldown
            }else if (pickedCard.getCardNumber() == 5)
            {
                //move is randomized 
                //what is this
            }else if(pickedCard.getCardNumber() == 6)
            {
                current.setReputation(current.getReputation() - 1);
            }else if(pickedCard.getCardNumber() == 7)
            {
                //lose a turn
            }else if(pickedCard.getCardNumber() == 8)
            {
                current.setReputation(current.getReputation() - 1);
                current.setMoney(current.getMoney() - 200);
            } else if(pickedCard.getCardNumber() == 9)
            {
                current.setReputation(current.getReputation()-3);
                current.setMoney(current.getMoney() - 500);
            } else if(pickedCard.getCardNumber() == 10)
            {
                //every player lose 750 dollars
            }else if(pickedCard.getCardNumber() == 11)
            {
                current.setReputation(current.getReputation() + 3);
            } else if(pickedCard.getCardNumber() == 12)
            {
                current.setMoney(current.getMoney() - 800);
            } else if(pickedCard.getCardNumber() == 13)
            {
                current.setMoney(current.getMoney() + 400);
            } else if(pickedCard.getCardNumber() == 14)
            {
                current.setMoney(current.getMoney() + 700);
            } else if(pickedCard.getCardNumber() == 15)
            {
                current.setReputation(current.getReputation() - 2);
                //draw another card
            } else if(pickedCard.getCardNumber() == 16)
            {
                //draw a card and give it to another player
            } else if(pickedCard.getCardNumber() == 17)
            {
                current.setReputation(current.getReputation() - 4);
            } else if(pickedCard.getCardNumber() == 18)
            {
                current.setReputation(current.getReputation() - 3);
            } else if(pickedCard.getCardNumber() == 19)
            {
                current.setReputation(current.getReputation() - 3);
            } else if(pickedCard.getCardNumber() == 20)
            {
                current.setReputation(current.getReputation() - 1);
            } else if(pickedCard.getCardNumber() == 21)
            {
                current.setMoney(current.getMoney() - 200);
                current.setReputation(current.getReputation() + 2);
            } else if(pickedCard.getCardNumber() == 22)
            {
                current.setReputation(current.getReputation() + 2);
            } else if(pickedCard.getCardNumber() == 23)
            {
                current.setReputation(current.getReputation() - 3);
            } else if(pickedCard.getCardNumber() == 24)
            {
                current.setReputation(current.getReputation() + 4);
            } else if(pickedCard.getCardNumber() == 25)
            {
                current.setReputation(current.getReputation() + 1);
            } else if(pickedCard.getCardNumber() == 26)
            {
                current.setReputation(current.getReputation() + 2);
            } else if(pickedCard.getCardNumber() == 27)
            {
                current.setReputation(current.getReputation() + 3);
            } else if(pickedCard.getCardNumber() == 28)
            {
                audit(current);
            } else if(pickedCard.getCardNumber() == 29)
            {
                current.setReputation(current.getReputation() + 3);
            } else if(pickedCard.getCardNumber() == 30)
            {
                // if you embezzle next turn, increase the amount but also increase the risk
            } else if(pickedCard.getCardNumber() == 31)
            {
                current.setReputation(current.getReputation() - 3);
                current.setMoney(current.getMoney() - 500);
            } else if(pickedCard.getCardNumber() == 32)
            {
                current.setReputation(current.getReputation() + 1);
            } else if(pickedCard.getCardNumber() == 33)
            {
                current.setReputation(current.getReputation() - 3);
            } else if(pickedCard.getCardNumber() == 34)
            {
                current.setMoney(current.getMoney() + 2500);
            } else if(pickedCard.getCardNumber() == 35)
            {
                //reduce your cooldown by 1 turns
            } else if(pickedCard.getCardNumber() == 36)
            {
                //reduce your cooldwon by 2 turns
            } else if(pickedCard.getCardNumber() == 37)
            {
                current.setReputation(current.getReputation() - 2);
            } else if(pickedCard.getCardNumber() == 38)
            {
                current.setReputation(current.getReputation() + 3);
            } else if(pickedCard.getCardNumber() == 39)
            {
                current.setReputation(current.getReputation() - 1);
                current.setMoney(current.getMoney() + 2000);
            } else if(pickedCard.getCardNumber() == 40)
            {
                current.setReputation(current.getReputation() + 2);
            } else if(pickedCard.getCardNumber() == 41)
            {
                current.setMoney(current.getMoney() - 600);
            } else if(pickedCard.getCardNumber() == 42)
            {
                current.setReputation(current.getReputation() + 3);
            } else if(pickedCard.getCardNumber() == 43)
            {
                current.setMoney(current.getMoney() - 200);
            } else if(pickedCard.getCardNumber() == 44)
            {
                current.setMoney(current.getMoney() + 300);
            } else if(pickedCard.getCardNumber() == 45)
            {
                current.setMoney(current.getMoney() + 700);
            } else if(pickedCard.getCardNumber() == 46)
            {
                current.setCard46(4);
            } else if(pickedCard.getCardNumber() == 47)
            {
                current.setReputation(current.getReputation() - 2);
            } else if(pickedCard.getCardNumber() == 48)
            {
                current.setReputation(current.getReputation() - 2);
            } else if(pickedCard.getCardNumber() == 49)
            {
                current.setMoney(current.getMoney() - 1000);
            } else if(pickedCard.getCardNumber() == 50)
            {
                current.setReputation(current.getReputation() + 2);
            } else if(pickedCard.getCardNumber() == 51)
            {
                current.setReputation(current.getReputation() + 1);
                current.setMoney(current.getMoney() - 400);
            } else if(pickedCard.getCardNumber() == 52)
            {
                current.setReputation(current.getReputation() - 3);
            } else if(pickedCard.getCardNumber() == 53)
            {
                current.setReputation(current.getReputation() - 5);
                current.setMoney(current.getMoney() + 2000);
            } else if(pickedCard.getCardNumber() == 54)
            {
                current.setMoney(current.getMoney() + 1500);
            } else if(pickedCard.getCardNumber() == 55)
            {
                current.setReputation(current.getReputation() + 2);
            } else if(pickedCard.getCardNumber() == 56)
            {
                current.setCooldown(current.getCooldown() + 1);
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
        /*if(economy.getTurns() >= 10){
            if(target.getReputation() <= 15 && target.getTWE() <= 5){
                target.setLost();
            } else if(target.getReputation() < 40 && target.getTWE() <= 5) {
                target.setMoney(target.getMoney() - 1000);
                target.setReputation(target.getReputation() - 5);
            } else if(target.getTWE() > 5){
                target.setReputation(target.getReputation() + 1);
            }
        }*/
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

