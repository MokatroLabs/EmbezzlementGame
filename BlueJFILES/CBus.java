 


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
    
    public void activeAbility()
    {
        coolDown = 5;
    }
    
    public void interact()
    {
    }
    public int findMove(Player choice)
    {
        if(coolDown == 0)
        {
            return 5;

        }
        else if (choice.getReputation() < 30)
        {
            return 1;
        }
        else if(choice.getReputation() < 40)
        {
            return 3;
        }
        else 
        {
            return 2;
        }
        
        
    }
    
   
}
