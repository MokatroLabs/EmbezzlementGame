 


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
    
<<<<<<< HEAD
    public void embezzle()
=======
    public void interact()
    {
    }
    public void paycheck()
>>>>>>> ce8e48d271be84933c5ba94a7cf9f0cfe2b4677c
    {
        money += 150 + (reputation-50)*150;
    }
    
    public int findMove(Player choice)

    {
        if(coolDown == 0)
        {
            return 5;

        }
        else if (choice.getReputation() < 40)
        {
            return 1;
        }
        /*else if(choice.getReputation() < 40)
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
