 


public abstract class Computer implements Player {
    protected double reputation;
    protected int money;
    protected String character ;
    
    @Override
    
    public double getReputation() {
        // TODO Auto-generated method stub
        return 0;
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
    
    public void activeAbility()
    {
        
    }
    public void fundraise()
    {
        
    }
    public void embezzle()
    {   
        
    }
    public void upgrade()
    {
        
    }
    //toggles show action feture
    public void toggleView()
    {
        
    }
    public boolean isHuman()
    {
        return false;
    }
    
    public int findMove()
    {
        return 1;
    }
}
