 


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
        this.character = "Business Man";
        this.reputation = 25;
    }
    
    public int getTWE(){
        return twe;
    }
    
    public void activeAbility()
    {
        coolDown = 5;
    }
   
    public void paycheck()

    {
        money += 250 + (reputation - 50) * 10;
    }
    
    public int findMove()

    {
        if(coolDown == 0)
        {
            return 5;

        }
        else if (reputation < 40)
        {
            return 1;
        }
        /*else if(reputation < 40)
        {
            //return 3;
        }
        */
        else 
        {
            return 2;
        }
        
        
    }
    
   
}
