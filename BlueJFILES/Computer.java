 


public abstract class Computer implements Player {
    protected double reputation;
    protected int money;
    protected String character ;
    @Override
    
    public double getReputation() {
        // TODO Auto-generated method stub
        return reputation;
    }
    @Override
    public void setReputation (double ammount)
    {
        reputation += ammount;
    }
    @Override
    public void setMoney(int ammount)
    {
        money += ammount;
    }
    
    public int getMoney() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getChar() {
        // TODO Auto-generated method stub
        return character;
    }
    
    public abstract void activeAbility();
    public abstract void fundRaise();
    
    public abstract void embezzle();
    
    public abstract void upgrade();
    
   
    public abstract void toggleView();
 
    
    

}
