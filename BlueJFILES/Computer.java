 


public abstract class Computer implements Player {
    protected double reputation;
    protected int money;
    protected String character ; //refers to the identification of each class by String
    protected int coolDown; //refers to active ability cooldown times
    protected boolean isHuman; //refers to the identification of each class by whether they are human or not
    double embezzleW= .5; //weights for how much the comp wants to do each thing
    double fundraiseW= .5;
    double interactW;
    double upgradeW;
    double activeW;
    public Computer(){
        reputation = 50;
        money = 100;
        character = "";
        coolDown = 5;
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
    }
    
    public void embezzle() //Action 2
    {   
        money += 500;
        reputation -= .25;
    }
    
    public void interact(){ //Action 3
        reputation += .5;
    }
    
    public void upgrade() // Action 4
    {
        
    }
    
    public void activeAbility() //Action 5
    {
        
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
    
    public int getCoolDown(){
        return coolDown;
    }
    //Setters
    public void setReputation (double ammount)
    {
        reputation += ammount;
    }
    
    public void setMoney(int ammount)
    {
        money = ammount;
    }
    
    public void setCoolDown(int newCoolDown){
        coolDown = newCoolDown;
    }
    
    //Miscellaneous
    //toggles show action feture
    public void toggleView()
    {
        
    }
    
    //Differentiates between Humans and Computers
    public boolean isHuman()
    {
        return isHuman;
    }

    //This is the AI function
    public int findMove()
    {
        double action = Math.random();
        if(reputation <= 50)
        {
            if(reputation <=25)
            {
                
            }
        }
        if (action < embezzleW)
            return 1;
        
        if (action < embezzleW + fundraiseW)
            return 2; 
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
