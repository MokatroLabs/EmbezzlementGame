 


public abstract class Computer implements Player {
    protected double reputation;
    protected int money;
    protected String character ; //refers to the identification of each class by String
    protected int cooldown; //refers to active ability cooldown times
    protected boolean isHuman; //refers to the identification of each class by whether they are human or not
    protected boolean isToggled; //refers to the toggling of actions 
    protected boolean hasEmbezzled; //refers to audits
    protected int twe; //refers to turns without embezzle
    protected boolean hasLost; //refers to whether the player has lost the game yet
    protected boolean hasWon; //refers to whether the player has won the game
    double embezzleW=.2;
    double fundraiseW=.2;
    double interactW=.2;
    double upgradeW=.2;
    double activeW=.2;
    double bound=1;
    int[] skills = new int[5];
    protected int consecutive; // punishes players that embezzle too much
    protected int rdLV; // Research and Development Level
    protected int marLV; // Marketing Level
    protected int prLV; // Public Relations Level
    protected int leadLV; // Leadership Level
    protected int espLV; // Espionage Level
    protected int fundIncrease; // Helps Implement Marketing
    protected int upgradeDown; //Helps Implement Research and Development
    protected double repIncrease; //Helps Implement Public Relations
    protected int moneyBoost; //Only refers to businessman
    protected int noCons; // Helps Implement Espionage (Fewer Consecutive)
    protected int embezzleBoost;
    

    
    public Computer(){
        reputation = 50;
        money = 100;
        character = "";
        cooldown = 5;
        isToggled = true;
        hasEmbezzled = false;
        twe = 0;
        hasLost = false;
        hasWon = false;
        embezzleW = .2;
        fundraiseW = .2;
        interactW = .2;
        upgradeW = .2;
        activeW = .2;
        bound = 1;
        skills = new int[5];
        skills[0] = leadLV;
        skills[1] = prLV;
        skills[2] = espLV;
        skills[3] = marLV;
        skills[4] = rdLV;
        consecutive = 0;
        fundIncrease = 0;
        upgradeDown = 0;
        repIncrease = 0;
        moneyBoost = 0;
        noCons = 0;
        embezzleBoost =0;
    }
    
    public Computer(double newReputation,int newMoney,String Char) {
        super();
        this.reputation = newReputation;
        this.money = newMoney;
        this.character = Char;
    }
    
    // Actions
    public void fundraise() //Action 1
    {
        money += 200;
        reputation += (.25 + repIncrease);
        hasEmbezzled = false;
        consecutive = 0;
        setNoCons(espLV);
    }
    
    public void embezzle() //Action 2
    {   
        money += (500 + embezzleBoost);
        reputation -= .25 + consecutive * .25;
        if(noCons == 0){
            consecutive++;
        }else{
            noCons--;
        }
        hasEmbezzled = true;
    }
    
    public void interact(){ //Action 3
        reputation += (.5 + repIncrease);
        consecutive = 0;
        setNoCons(espLV);
        //Draws a Chance Card
    }
    
    public void upgrade(int level) { // Action 4
        // TODO Auto-generated method stub
        int noAdd = 0;
        consecutive = 0;
        setNoCons(espLV);
        if(level == 1){
            noAdd = (500 - upgradeDown);
            if(noAdd < 0){
                noAdd = 0;
            } else {
                money -= noAdd;
            }
        }
        if(level == 2){
            noAdd = (1000 - upgradeDown);
            if(noAdd < 0){
                noAdd = 0;
            } else {
                money -= noAdd;
            }
        }
        if(level == 3){
            noAdd = (2000 - upgradeDown);
            if(noAdd < 0){
                noAdd = 0;
            } else {
                money -= noAdd;
            }
        }
        if(level == 4){
            noAdd = (4000 - upgradeDown);
            if(noAdd < 0){
                noAdd = 0;
            } else {
                money -= noAdd;
            }
        }
        if(level == 5){
            noAdd = (6000 - upgradeDown);
            if(noAdd < 0){
                noAdd = 0;
            } else {
                money -= noAdd;
            }
        }
    }
    
    public void activeAbility() //Action 5
    {
        consecutive = 0;
        setNoCons(espLV);
    }
    
    
    //Getters 
    public double getReputation() {
        // TODO Auto-generated method stub
        return reputation;
    }
    
    public int getMoney() {
        // TODO Auto-generated method stub
        return money;
    }
    
    public String getChar() {
        // TODO Auto-generated method stub
        return character;
    }
    
    public int getCooldown(){
        return cooldown;
    }
    
    public boolean getEmbezzle(){
        return hasEmbezzled;
    }
    
    public int getTWE()
    {
        return twe;
    }
    
    public boolean getLost() {
        return hasLost;
    }
    
    public boolean getWon(){
        return hasWon;
    }
    
    public boolean getToggled(){
        return isToggled;
    }
    
    public int getLeadLV(){
        return leadLV;
    }
    
    public int getPrLV(){
        return prLV;
    }
    
    public int getEspLV(){
        return espLV;
    }
    
    public int getMarLV(){
        return marLV;
    }
    
    public int getRdLV(){
        return rdLV;
    }
    
    public int[] getSkills(){
        return skills;
    }
    
    public double getRepIncrease(){
        return repIncrease;
    }
    
    public int getFundIncrease(){
        return fundIncrease;
    }
    
    public int getUpgradeDown(){
        return upgradeDown;
    }
    
    public int getMoneyBoost(){
        return moneyBoost;
    }
    
    public int getNoCons(){
        return noCons;
    }
    
    public int getEmbezzleBoost(){
        return embezzleBoost;
    }
    
    //Setters
    public void setReputation (double amount)
    {
        reputation += amount;
    }
    
    public void setMoney(int amount)
    {
        money = amount;
    }
    
    public void setCooldown(int newCooldown){
        cooldown = newCooldown;
    }
    
    public void setEmbezzle(){
        hasEmbezzled = false;
    }
    
    public void setTWE(int newTWE){
        twe = newTWE;
    }
    
    public void setLost(){
        hasLost = true;
    }
    
    public void setWon(){
        hasWon = true;
    }
    
    public void setLeadLV(int newLevel){
        leadLV = newLevel;
    }
    
    public void setPrLV(int newLevel){
        prLV = newLevel;
    }
    
    public void setEspLV(int newLevel){
        espLV = newLevel;
    }
    
    public void setMarLV(int newLevel){
        marLV = newLevel;
    }
    
    public void getRdLV(int newLevel){
        rdLV = newLevel;
    }
    
    public void setRepIncrease(int level){
        if(level == 0){
            repIncrease = 0;
        }
        if(level ==  1){
            repIncrease =  .1;
        }
        if(level == 2){
            repIncrease = .2;
        }
        if(level == 3){
            repIncrease = .3;
        }
        if(level == 4){
            repIncrease = .4;
        }
        if(level == 5){
            repIncrease = .5;
        }
    }
    
    public void setFundIncrease(int level){
        if(level == 0){
            fundIncrease = 0;
        }
        if(level ==  1){
            fundIncrease =  50;
        }
        if(level == 2){
            fundIncrease = 100;
        }
        if(level == 3){
            fundIncrease = 200;
        }
        if(level == 4){
            fundIncrease = 400;
        }
        if(level == 5){
            fundIncrease = 600;
        }
    }
    
    public void setUpgradeDown(int level){
        if(level == 0){
            upgradeDown = 0;
        }
        if(level ==  1){
            upgradeDown =  250;
        }
        if(level == 2){
            upgradeDown = 500;
        }
        if(level == 3){
            upgradeDown = 750;
        }
        if(level == 4){
            upgradeDown = 1000;
        }
        if(level == 5){
            upgradeDown = 1250;
        }
    }
    
    public void setMoneyBoost(){
        
    }
    
    public void setNoCons(int level){
        if(level == 0){
            noCons = 0;
        }
        if(level >= 2 && level < 4){
            noCons = 1;
        }
        if(level >= 4){
            noCons = 2;
        }
    }
    
    public void setEmbezzleBoost(int level){
        if(level == 0){
            embezzleBoost = 0;
        }
        if(level == 1){
            embezzleBoost = 250;
        }
        if(level <= 4 && level > 2){
            embezzleBoost = 500;
        }
        if(level == 5){
            embezzleBoost = 750;
        }
    }
    
    //Miscellaneous
    //toggles show action feture
    public void toggleView()
    {
        if(isToggled){
            isToggled = false;
        } else {
            isToggled = true;
        }
    }
    
    //Differentiates between Humans and Computers
    public boolean isHuman()
    {
        return isHuman;
    }

    //This is the AI function
    public int findMove(int turncount)
    {
        return 0;
    }
    public void printWeights()
    {
        System.out.println("EmbezzleW:"+embezzleW);
        System.out.println("FundraiseW:"+fundraiseW);
        System.out.println("InteractW:"+interactW);
        System.out.println("UpgradeW:"+upgradeW);
        System.out.println("ActiveW:"+activeW);

    }
    public void resetFocus()
    {
        embezzleW=.2;
        fundraiseW=.2;
        interactW=.2;
        upgradeW=.2;
        activeW=.2;
        bound=1;
    }
    //Gives paycheck
    public void paycheck()
    {
        money += 100 + (reputation*.01)*100;
    }
    
    public String toString()
    {
          return "This player is part of the " + character + " class . Also, this player has " + reputation + " reputation and " + money + " dollars.";
    }
}
