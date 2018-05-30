 


/**
 * Write a description of class CSpy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CSpy extends Computer
{
    public CSpy(){
        super();
        this.character = "Spy";
    }
    
    public void activeAbility(Player choice)
    {
        coolDown = 5;
        choice.setReputation(choice.getReputation() - 5);
        choice.setMoney(choice.getMoney() - 500);
    }
    
    public void embezzle()
    {
        money += 750;
        reputation -= 0.3;
    }
    public int findMove()
    {
        if(coolDown == 0)
        {
            return 5;
        }else
        {
            return 2;
        }
        
        
    }
    
        
    
    
    
    
}
