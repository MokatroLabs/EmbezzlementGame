 


public abstract class Computer implements Player {
    protected double reputation;
    protected int money;
    protected String character ; //refers to the identification of each class by String
    protected int cooldown; //refers to active ability cooldown times
    protected boolean isHuman; //refers to the identification of each class by whether they are human or not
    protected boolean isToggled; //refers to the toggling of actions 
    protected boolean hasEmbezzled; //refers to audits
    protected int twe; //refers to turns without embezzle
    double embezzleW=.2;
    double fundraiseW=.2;
    double interactW=.2;
    double upgradeW=.2;
    double activeW=.2;
    double bound=1;
    int[] skills = new int[5];
    int consecutive;
  

    protected boolean hasLost; //refers to whether the player has lost the game yet
    public Computer(){
        reputation = 50;
        money = 100;
        character = "";
        cooldown = 5;
        isToggled = true;
        hasEmbezzled = false;
        twe = 0;
        consecutive = 0;
        hasLost = false;
        embezzleW = .2;
        fundraiseW = .2;
        interactW = .2;
        upgradeW = .2;
        activeW = .2;
        bound = 1;
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
    }
    
    public void embezzle() //Action 2
    {   
        money += 500;
        reputation -= .25 - consecutive * .5;
        hasEmbezzled = true;
        
    }
    
    public void interact(){ //Action 3
        reputation += .5;
        //Draws a Chance Card
    }
    
    public void upgrade() // Action 4
    {
        
    }
    
    public void activeAbility() //Action 5
    {
        
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
    
    public boolean getToggled(){
        return isToggled;
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
    public int findMove()
    {
        return 0;
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
