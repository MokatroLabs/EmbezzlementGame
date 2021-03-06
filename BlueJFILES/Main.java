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
    static String[] textArea = {"First Line" , "Next Line", "Next Line", "Next Line", "Next Line"};
    static int gruul;
    static boolean gruulboo;
    static boolean fourtysix;
    static int fourtysixCounter;
    static boolean thirty;
    static int gruulcounter;
    final static int maxTurns = 150;
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
        board.makeGameWinScreen();
        board.makeGameLoseScreen();
        board.hideGameLoseScreen();
        board.hideGameWinScreen();
        board.updateTurnBorder(economy.getTurns());
        //System.out.println(pickACard().toString());
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
            comp1 = new CFat();
            comp2 = new CBus();
            comp3 = new CQueen();
        }else if (human.getChar().equals("Father"))
        {
            comp1 = new CSpy();
            comp2 = new CBus();
            comp3 = new CQueen();
        }else
        {
            comp1 = new CSpy();
            comp2 = new CFat();
            comp3 = new CQueen();
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
            if(round >= 4)
            {
                round = 0;
                economy.setTurns(economy.getTurns()+1);
            }    
            if(economy.getTurns() %5 == 0){
                players.get(currentPlayer).paycheck();
            }
            if((players.get(currentPlayer).getChar()).equals("Business Man")){
                //players.get(currentPlayer).setMoney(players.get(currentPlayer).getMoney() + (50 + players.get(currentPlayer).getMoneyBoost()));
            }
            if(Math.random() * 100 < (5 - ((players.get(currentPlayer)).getReputation()) / 10)){
                audit(players.get(currentPlayer));
            }
            updateBoard(human,textArea,currentPlayer);
            textArea[0] = "Pot:"+ economy.getMoney();
            takeTurn(players.get(currentPlayer));
            if(players.get(currentPlayer).getToggled()){
                if(actionDone == 1){
                    textArea[currentPlayer+1] = "The "+(players.get(currentPlayer).getChar())  +" embezzled.";
                }
                if(actionDone == 2){
                    textArea[currentPlayer+1] = "The "+(players.get(currentPlayer).getChar())  +" fundraised.";
                }
                if(actionDone == 3){
                    textArea[currentPlayer+1] = "The "+(players.get(currentPlayer).getChar())  +" interacted.";
                }
                if(actionDone == 4){
                    textArea[currentPlayer+1] = "The "+(players.get(currentPlayer).getChar())  +" upgraded.";
                }
                if(actionDone == 5){
                    textArea[currentPlayer+1] = "The "+(players.get(currentPlayer).getChar()) +" used "+ players.get(currentPlayer).getActiveName()+".";
                }
            }
            if(players.get(currentPlayer).getReputation() >= 100){
                players.get(currentPlayer).setWon();
                if(currentPlayer == 0){
                    board.hideGameScreen();
                    board.showGameWinScreen();
                }else{
                    board.hideGameScreen();
                    board.showGameLoseScreen();
                }
            }
            for(int i = 0; i < 4; i++){
                int[] check = players.get(currentPlayer).getSkills();
                if(check[i] != 5){
                    break;
                } else if(i == 4 && check[i] == 5){
                    players.get(currentPlayer).setWon();
                    if(currentPlayer == 0){
                        board.hideGameScreen();
                        board.showGameWinScreen();
                    }else{
                        board.hideGameScreen();
                        board.showGameLoseScreen();
                    }
                }
            }
            if(!(players.get(currentPlayer).getLost())&&(players.get(currentPlayer).getReputation() <=0 || players.get(currentPlayer).getMoney() <= 0))
            {
                players.get(currentPlayer).setLost();
                if(currentPlayer == 0)
                {
                    board.hideGameScreen();
                    board.showGameLoseScreen();
                } 
            }
        
            updateBoard(human,textArea,currentPlayer);
            textArea[0] = "Money Pot:"+ economy.getMoney();
            round++;
            currentPlayer++;
        }   
        int highest = 0;
        int indexHigh = 0;
        for(int i = 0; i < players.size(); i++){
            if(players.get(i).getLost() != true){
                if(players.get(i).getMoney() > highest){
                    highest = players.get(i).getMoney();
                    indexHigh = i;
                }
            }
        }
        players.get(indexHigh).setWon();
        if(indexHigh != 0){
            board.hideGameScreen();
            board.showGameLoseScreen();
        } else {
            board.hideGameScreen();
            board.showGameWinScreen();
        }
    }
    public static void takeTurn(Player current){
        System.out.println(current.getChar() +" turn");
        gruulcounter ++;
        if(gruulboo && gruulcounter <=5)
        {
            current.setMoney(current.getMoney() + 100);
            current.setReputation(current.getReputation() + 1);
        }else
        {
            gruulboo = false;
        }
        if (fourtysix && fourtysixCounter+5 == gruulcounter )
        {
            current.setMoney(current.getMoney() + 1000);
        }
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
            current.setReputation(current.getReputation() + .2);
            if(current.getChar().equals("Queen"))
                current.setReputation(current.getReputation()+.1);
        }
        if(current.isHuman())
        {
            board.checkFundraise();
            board.hideAcctiveQ();
            action = board.promptAction();
            board.checkActive();
            board.checkFundraise();
        }
        else
        {
            action = current.findMove(economy.getTurns());
        }
        //change to fix money pit bug
        if(economy.getMoney() < 975)
        {
           economy.setMoney(economy.getMoney() + 300);
        }
        //end of change
        else if (action == 1) {
            if((current.getChar()).equals("Spy") && economy.getMoney()- 750 >=0){
                if(thirty)
                {
                    economy.setMoney(economy.getMoney() - 825);
                    current.embezzle();
                    current.setMoney(current.getMoney() + 75);
                    current.setTWE(-2);
                    thirty = false;
                }
                economy.setMoney(economy.getMoney() - 750);
                current.embezzle();
                current.setTWE(-1);
            }else if(economy.getMoney()-500 >=0){
                if (thirty)
                {
                    economy.setMoney(economy.getMoney() - 550);
                    current.embezzle();
                    current.setMoney(current.getMoney() + 50);
                    current.setTWE(-2);
                    thirty = false;
                }
                economy.setMoney(economy.getMoney() - 500);
                current.embezzle();
                current.setTWE(-1);
            }
            current.setPastAction(0,1);
        } 
        if (action == 2)
        {   
            current.fundraise();
            if(current.getChar().equals("Queen")){
                economy.setMoney(economy.getMoney() + 300 + (current.getFundIncrease()));
            }else {
                economy.setMoney(economy.getMoney() + 400 + (current.getFundIncrease() * 2));
            }
            current.setPastAction(1,1);
        }
        if (action == 3)
        {
            int counter1 = 0;
            int counter2 = 0;
            Card pickedCard = pickACard();
            //current.interact(pickedCard);
            board.setCardPic(pickedCard.getCardNumber());
            
            if(board.getCharSelect().equals("Father") && current.isHuman())
            {
                board.setRedrawVisible(true);
                System.out.println("The father picked a card");
                int count =0;
                while((board.getCardBackClicked() == false && board.getRedrawClick() == false) )
                {
                   if(counter1 > 999999999)
                   {
                       System.out.println("In loop 1");
                       counter1 = 0; 
                   }
                   else
                   {
                       counter1++;
                   }
                }
                System.out.println("Got out of the loop");
                if(board.getCardBackClicked() == true)
                {
                    board.setCardBackClicked(false);
                }
                if(board.getRedrawClick() == true )
                {
                    pickedCard = pickACard();
                    board.setCardPic(pickedCard.getCardNumber());
                    board.setRedrawVisible(false);
                    while(!board.getCardBackClicked() )
                    {
                        if(counter2 > 999999999)
                        {
                            System.out.println("In loop 2");
                            counter2 = 0;
                        }
                        else
                        {
                            counter2++;
                        }
                    }
                }
                board.setRedrawClick(false);
                board.setCardBackClicked(false);
            }
            //System.out.println(pickedCard.toString());
            
            if(pickedCard.getCardNumber() == 1)
            {
                gruulboo = true;
                gruul = gruulcounter;
                if(!gruulboo && gruul <= (gruul+5))
                {
                    gruulboo = false;
                }
            }
            else if(pickedCard.getCardNumber() == 2)
            {
                current.setMoney(current.getMoney() - 1000);
            } else if(pickedCard.getCardNumber() == 3)
            {
                current.setReputation(current.getReputation() + 2);
            } else if(pickedCard.getCardNumber() == 4)
            {
                current.setCooldown(current.getCooldown()+2);
            }else if (pickedCard.getCardNumber() == 5)
            {
                int choice = (int)Math.random()*4;
                if(choice ==1)
                {
                    if((current.getChar()).equals("Spy") && economy.getMoney()- 750 >=0){
                if(thirty)
                {
                    economy.setMoney(economy.getMoney() - 825);
                    current.embezzle();
                    current.setMoney(current.getMoney() + 75);
                    current.setTWE(-2);
                    thirty = false;
                }
                economy.setMoney(economy.getMoney() - 750);
                current.embezzle();
                current.setTWE(-1);
                }else if(economy.getMoney()-500 >=0){
                if (thirty)
                {
                    economy.setMoney(economy.getMoney() - 550);
                    current.embezzle();
                    current.setMoney(current.getMoney() + 50);
                    current.setTWE(-2);
                    thirty = false;
                }
                economy.setMoney(economy.getMoney() - 500);
                current.embezzle();
                current.setTWE(-1);
            }
                current.setPastAction(0,1);
                // randomized: embezzle
            }
             else if(choice ==2)
            {
                current.fundraise();
                if(current.getChar().equals("Queen"))
                {
                    economy.setMoney(economy.getMoney() + 300 + (current.getFundIncrease()));
                }
                else 
                {
                    economy.setMoney(economy.getMoney() + 400 + (current.getFundIncrease() * 2));
                }
                 current.setPastAction(1,1);
                 // randomized: fundraise
            }
                
            }else if(pickedCard.getCardNumber() == 6)
            {
                current.setReputation(current.getReputation() - 1);
            }else if(pickedCard.getCardNumber() == 7)
            {
                //current.setMoney(current.getMoney() - 1000);
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
                current.setMoney(current.getMoney() - 750);
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
                current.setMoney(current.getMoney() + 560);
            } else if(pickedCard.getCardNumber() == 16)
            {
                current.setReputation(current.getReputation() + 1);
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
                thirty = true;
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
                if(current.getCooldown() > 0)
                {
                    current.setCooldown(current.getCooldown()-1);
                }
            } else if(pickedCard.getCardNumber() == 36)
            {
                //reduce your cooldwon by 2 turns
                if(current.getCooldown() > 0 && current.getCooldown() < 2)
                {
                    current.setCooldown(current.getCooldown()-1);
                } else if(current.getCooldown() > 0)
                {
                    current.setCooldown(current.getCooldown() -2 );
                }
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
            current.setPastAction(2,1);
        }
        if(action == 4){
            if(current.isHuman()){
                upgrade = board.promptUpgrade();
            } else {
                //upgrade = current.findUpgrade();
            }
            if(upgrade == 1){
                if(!(current.getLeadLV() >= 5))
                {
                    current.upgrade(current.getLeadLV() + 1);
                    current.setLeadLV(current.getLeadLV() + 1);
                    board.setUpActive("Leadership Lvl: " + (current.getLeadLV()));
                }
                else
                {
                    board.setUpActive("Leadership Lvl: 5");
                }                   
            }
            if(upgrade == 2){
                if(!(current.getPrLV() >= 5))
                {
                    current.upgrade(current.getPrLV() + 1);
                    current.setPrLV(current.getPrLV() + 1);
                    current.setRepIncrease(current.getPrLV());
                    board.setUpInteract("Public Relations Lvl: " + (current.getPrLV()));
                }
                else
                {
                    board.setUpInteract("Public Relations Lvl: 5");
                }                  
            }
            if(upgrade == 3){
                if(!(current.getEspLV() >= 5))
                {
                    current.upgrade(current.getEspLV() + 1);
                    current.setEspLV(current.getEspLV() + 1);
                    current.setNoCons(current.getEspLV());
                    current.setEmbezzleBoost(current.getEspLV());
                    board.setUpEmbezzle("Espionage Lvl: " + (current.getEspLV()));
                }
                else
                {
                    board.setUpEmbezzle("Espionage Lvl: 5");
                }                
            }
            if(upgrade == 4){
                if(!(current.getMarLV() >= 5))
                {
                    current.upgrade(current.getMarLV() + 1);
                    current.setMarLV(current.getMarLV() + 1);
                    current.setFundIncrease(current.getMarLV());
                    board.setUpFundraise("Marketing Lvl: " + (current.getMarLV()));
                }
                else
                {
                    board.setUpFundraise("Marketing Lvl: 5");
                }
            }
            if(upgrade == 5){
                    if(!(current.getRdLV() >= 5))
                    {
                        current.upgrade(current.getRdLV() + 1);
                        current.setRdLV(current.getRdLV() + 1);
                        current.setUpgradeDown(current.getRdLV());
                        board.setUpUpgrade("Research and Development Lvl: " + (current.getRdLV()));                      
                    }
                    else
                    {
                        board.setUpUpgrade("Research and Development Lvl: 5");
                    }
            }
            if(current.getRdLV() >= 5 && current.isHuman()) 
            {
                if(current.getMarLV() >= 5)
                {
                    if(current.getEspLV() >= 5)
                    {                                               
                        if(current.getPrLV() >= 5)
                        {
                            if(current.getLeadLV() >= 5)
                            {
                                board.hideGameScreen();
                                board.showGameWinScreen();
                            }
                        }
                    }
                }
            }
            if(current.isHuman())
            {
                if(current.getRdLV() == 1)
                    board.setUpgradeUpgradeDes(750);
                if(current.getRdLV() == 2)
                    board.setUpgradeUpgradeDes(1125);
                if(current.getRdLV() == 3)
                    board.setUpgradeUpgradeDes(2250);
                if(current.getRdLV() == 4)
                    board.setUpgradeUpgradeDes(4500);              
                    
                if(current.getMarLV() == 1)
                    board.setUpgradeFundriaseDes(750);
                if(current.getMarLV() == 2)
                    board.setUpgradeFundriaseDes(1125);
                if(current.getMarLV() == 3)
                    board.setUpgradeFundriaseDes(2250);
                if(current.getMarLV() == 4)
                    board.setUpgradeFundriaseDes(4500);     
                    
                if(current.getEspLV() == 1)
                    board.setUpgradeEmbezzleDes(750);
                if(current.getEspLV() == 2)
                    board.setUpgradeEmbezzleDes(1125);
                if(current.getEspLV() == 3)
                    board.setUpgradeEmbezzleDes(2250);
                if(current.getEspLV() == 4)
                    board.setUpgradeEmbezzleDes(4500);                     
                    
                if(current.getPrLV() == 1)
                    board.setUpgradeInteractDes(750);
                if(current.getPrLV() == 2)
                    board.setUpgradeInteractDes(1125);
                if(current.getPrLV() == 3)
                    board.setUpgradeInteractDes(2250);
                if(current.getPrLV() == 4)
                    board.setUpgradeInteractDes(4500);                    

                if(current.getLeadLV() == 1)
                    board.setUpgradeActiveDes(750);
                if(current.getLeadLV() == 2)
                    board.setUpgradeActiveDes(1125);
                if(current.getLeadLV() == 3)
                    board.setUpgradeActiveDes(2250);
                if(current.getLeadLV() == 4)
                    board.setUpgradeActiveDes(4500);                    
                    
            }
            current.setPastAction(3,1);
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
                current.activeAbility();
                for(int i = 0; i < 4; i++){
                    if(players.get(i) != current && !players.get(i).getLost()){
                        players.get(i).setReputation(players.get(i).getReputation() - 5);
                    }
                }
            } else {
                current.activeAbility();
            }
            current.setPastAction(4,1);
        }
        if(current.getCooldown()>0){
            current.setCooldown(current.getCooldown()-1);
        }
        actionDone = action;
        upgradeDone = upgrade;
        System.out.println(current.getReputation());
    }
    public static void audit(Player target){
        if(economy.getTurns() >= 10){
            if(target.getReputation() <= 15 && target.getTWE() <= 5){
                target.setLost();
                board.hideGameScreen();
                board.showGameLoseScreen();
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
        board.setRepCount("Rep: " + (int) (human.getReputation()) + "%" );
        board.setMoneyCount("Money: " + human.getMoney() );
        board.setTextArea("-"+ textArea[0] + "\n" + "-" + textArea[1] + "\n" + "-" + textArea[2] + "\n"+ "-" + textArea[3] + "\n" + "-" + textArea[4] );
        board.updateTurnBorder(currentPlayer);
        if(human.getChar().equals("Queen"))
        {
            if(players.get(currentPlayer).getLost() && players.get(currentPlayer).getChar().equals("Businessman"))
                board.setLostChar(1,1);
            if(players.get(currentPlayer).getLost() && players.get(currentPlayer).getChar().equals("Father"))
                board.setLostChar(2,2);
            if(players.get(currentPlayer).getLost() && players.get(currentPlayer).getChar().equals("Spy"))
                board.setLostChar(3,3);
            if(players.get(currentPlayer).getLost() && players.get(currentPlayer).getChar().equals("Queen"))
                board.setLostChar(4,4);
        }
        if(human.getChar().equals("Spy"))
        {
            if(players.get(currentPlayer).getLost() && players.get(currentPlayer).getChar().equals("Businessman"))
                board.setLostChar(1,1);
            if(players.get(currentPlayer).getLost() && players.get(currentPlayer).getChar().equals("Father"))
                board.setLostChar(2,2);
            if(players.get(currentPlayer).getLost() && players.get(currentPlayer).getChar().equals("Queen"))
                board.setLostChar(3,4);
            if(players.get(currentPlayer).getLost() && players.get(currentPlayer).getChar().equals("Spy"))
                board.setLostChar(4,3);
        }
        if(human.getChar().equals("Father"))
        {
            if(players.get(currentPlayer).getLost() && players.get(currentPlayer).getChar().equals("Businessman"))
                board.setLostChar(1,1);
            if(players.get(currentPlayer).getLost() && players.get(currentPlayer).getChar().equals("Queen"))
                board.setLostChar(2,4);
            if(players.get(currentPlayer).getLost() && players.get(currentPlayer).getChar().equals("Spy"))
                board.setLostChar(3,3);
            if(players.get(currentPlayer).getLost() && players.get(currentPlayer).getChar().equals("Father"))
                board.setLostChar(4,2);
        }
        if(human.getChar().equals("Businessman"))
        {
            if(players.get(currentPlayer).getLost() && players.get(currentPlayer).getChar().equals("Queen"))
                board.setLostChar(1,4);
            if(players.get(currentPlayer).getLost() && players.get(currentPlayer).getChar().equals("Father"))
                board.setLostChar(2,2);
            if(players.get(currentPlayer).getLost() && players.get(currentPlayer).getChar().equals("Spy"))
                board.setLostChar(3,3);
            if(players.get(currentPlayer).getLost() && players.get(currentPlayer).getChar().equals("Businessman"))
                board.setLostChar(4,1);
        }
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