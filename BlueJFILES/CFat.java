 


/**
 * Write a description of class CFat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class CFat extends Computer
{
    public CFat(){
        super();
        this.character = "Father";
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
        /*else if(choice.getReputation() < 40)
        {
            return 3;
        }*/
        else 
        {
            return 2;
        }
        
        
    }
    
}
