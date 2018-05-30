 



public abstract class Human implements Player {


    //Instance Variables
    protected double reputation;
    protected int money;
    protected String character;//refers to the identification of each class by String
    protected int coolDown; //refers to active ability cooldown times
    protected boolean isHuman; //refers to the identification of each class by whether they are human or not
    protected boolean isToggled; //refers to the toggling of actions
    protected boolean hasEmbezzled; //refers to audits
    protected int twe; //refers to turns without embezzle
    
    public Human()
    {
        reputation =  50;
        money = 2000;
        character = "";
        coolDown = 5;
        isHuman = true;
        isToggled = true;
        hasEmbezzled = false;
        twe = 0;
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
        
    }
    public int findMove()
    {    
        return 0;
    }    
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
    
    public int getCoolDown(){
        return coolDown;
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
    
    //Setters
    public void setReputation(double newReputation)
    {
        reputation = newReputation;
    }
    
    public void setMoney(int newMoney)
    {
        money = newMoney;
    }
    
    public void setCoolDown(int newCoolDown){
        coolDown = newCoolDown;
    }
    
    public void setEmbezzle(){
        hasEmbezzled = false;
    }
    
    public void setTWE(int newTWE){
        twe = newTWE;
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
