 


/**
 * Write a description of class CCap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CBus extends Computer
{
    public CBus(){
        super();
        this.character = "Businessman";
        this.reputation = 25;
    }
    
    public int getTWE(){
        return twe;
    }
    
    public void activeAbility()
    {
        cooldown = 5;
    }
   
    public void paycheck()

    {
        money += 250 + (reputation * .01) * 10;
    }
    
    public int findMove()

    {
        if(cooldown == 0)
        {
            return 5;

        }else if (reputation < 40)
        {
            
        }

        

        else if (getReputation() < 40)

        {
            return 1;
        }
        
        
        else 
        {
            return 2;
        }
        return 1;
    }
    
   
}
