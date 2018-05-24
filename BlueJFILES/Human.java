 



public abstract class Human implements Player {

    //Instance Variables
    protected double reputation;
    protected int money;
    protected String character;
    boolean isHuman = true;
    public Human()
    {
        reputation =  25.0;
        money = 2000;
        character = "";
    }
    
    public Human(double newReputation,int newMoney,String Char) {
        this.reputation = newReputation;
        this.money = newMoney;
        this.character = Char;
    }
    
    // Actions
    
    
    public void interact() {
        // TODO Auto-generated method stub
        
    }

    
    public void fundraise() {
        // TODO Auto-generated method stub
        money += 300;
        reputation += .5;
    }

    
    public void upgrade() {
        // TODO Auto-generated method stub
        
    }

    
    public void embezzle() {
        // TODO Auto-generated method stub
        
    }
    
    
    
    public void activeAbility()
    {
        
    }
    
    //Getters
    public double getReputation() 
    {
        
        return reputation;
    }

    
    public String getChar() {
        // TODO Auto-generated method stub
        return character;
    }
    
    public int getMoney() {
        return money;
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
    

    public void setReputation() {
        // TODO Auto-generated method stub
        
    }


    public void setMoney() {
        // TODO Auto-generated method stub
        
    }
    
    public String toString()
    {
                    return "This player is part of the " + character + " class . Also, this player has " + reputation + " reputation and " + money + " dollars.";
    }
    //toggles show action
    public void toggleView()
    {
        
    }
    public boolean isHuman()
    {
        return true;
    }
    

    

    
    

}
