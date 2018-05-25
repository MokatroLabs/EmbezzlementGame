 


public class HQueen extends Human {
    
    public HQueen()
    {
        super();
        super.character = "Queen";
    }
    
    public void fundraise()
    {
        money += 75;
        reputation += .5;
        
    }
    
    public void activeAbility() // Special Active Ability: Royal Wealth
    {
        coolDown = 5;
        reputation -=  2.5;
        money += 5000;  // Amount of Increase TBD
    } 
    
    public void interact()
    {
    
    }
    
    
    
    
}
