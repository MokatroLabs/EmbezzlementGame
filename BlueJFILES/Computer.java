 


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
        money += 300;
        reputation += .25;
        hasEmbezzled = false;
        consecutive = 0;
    }
    
    public void embezzle() //Action 2
    {   
        money += 500;
        reputation -= .25 + consecutive * .25;
        hasEmbezzled = true;
        consecutive++;
    }
    
    public void interact(){ //Action 3
        reputation += .5;
        consecutive = 0;
        //Draws a Chance Card
    }
    
    public void upgrade(int level) { // Action 4
        // TODO Auto-generated method stub
        int noAdd = 0;
        consecutive = 0;
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
        consecutive =0;
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
    
    public int getFundIncrease(){
        return fundIncrease;
    }
    
    public int getUpgradeDown(){
        return upgradeDown;
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
