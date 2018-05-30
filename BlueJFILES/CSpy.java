 


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
    
    public void activeAbility()
    {
        cooldown = 5;
    }
    
    public void embezzle()
    {
        money += 750;
        reputation -= 0.3;
    }
<<<<<<< HEAD
=======
    
>>>>>>> a284bb96fa38f722274b2e952a95075802907d59
    public int findMove()
    {
        if(cooldown == 0)
        {
            return 5;
        }else
        {
            return 1;
        }
    }
    
        
    
    
    
    
}
