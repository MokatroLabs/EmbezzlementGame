 



public abstract class Human implements Player {


    //Instance Variables
    protected double reputation;
    protected int money;
    protected String character;//refers to the identification of each class by String
    protected int cooldown; //refers to active ability cooldown times
    protected boolean isHuman; //refers to the identification of each class by whether they are human or not
    protected boolean isToggled; //refers to the toggling of actions
    protected boolean hasEmbezzled; //refers to audits 
    protected int twe; //refers to turns without embezzle (also refers to audits)
    protected boolean hasLost; //refers to whether the player has lost the game yet
    
    public Human()
    {
        reputation =  50;
        money = 2000;
        character = "";
        cooldown = 5;
        isHuman = true;
        isToggled = true;
        hasEmbezzled = false;
        twe = 0;
        hasLost = false;
    }
    
    public Human(double newReputation,int newMoney,String Char) { //meant just in case we want difficulties or multiplayer
        super();
        this.reputation = newReputation;
        this.money = newMoney;
        this.character = Char;
    }
    
    // Actions
    public void fundraise() {
        // TODO Auto-generated method stub
        money += 200;
        reputation += .25;
    }
    
    public void embezzle() {
        // TODO Auto-generated method stub
        money += 500;
        reputation -= .25;
        hasEmbezzled = true;
    }
    
    public void interact() {
        // TODO Auto-generated method stub
        reputation += .25;
    }
    
    public void upgrade() {
        // TODO Auto-generated method stub
        
    }
    
    public void activeAbility()
    {
        cooldown = 5;
    }
    
<<<<<<< HEAD
    public int findMove()
    {    
        return 0;
    }  
    
=======
>>>>>>> dff112c5cb64dacb291e931940b7cf1e42da02f9
    //Getters
    public double getReputation() 
    {
        return reputation;
    }

    public String getChar() {
        return character;
    }
    
    public int getMoney() {
        return money;
    }
    
    public int getCooldown(){
        return cooldown;
    }
    
    public boolean isHuman()
    {
        return isHuman;
    }
    
    public boolean getEmbezzle(){
        return hasEmbezzled;
    }
    
    public int getTWE(){
        return twe;
    }
    
    public boolean getLost(){
        return hasLost;
    }
    
    public boolean getToggled(){
        return isToggled;
    }
    
    //Setters
    public void setReputation(double newReputation)
    {
        reputation = newReputation;
    }
    
    public void setMoney(int newMoney)
    {
        money = newMoney;
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
    //toggles show action
    public void toggleView()
    {
        if(isToggled){
            isToggled = false;
        } else {
            isToggled = true;
        }
    }
    //gives paycheck
    public void paycheck()
    {
        money += 100 + (reputation-50)* 10;
    }
    
    public String toString()
    {
       return "This player is part of the " + character + " class . Also, this player has " + reputation + " reputation and " + money + " dollars.";
    }


    

    
    

}
