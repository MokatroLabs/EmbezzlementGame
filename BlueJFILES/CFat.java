 


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
        cooldown = 5;
    }
    
    public void interact()
    {
    }
    
    public void setRdLV(int newLevel){
        rdLV = newLevel;
    }
    

    public int findMove()
    {
        if(cooldown == 0)
        {
            return 5;

        }
        else if (getReputation() < 30)
        {
            return 1;
        }
        else if(getReputation() < 40)
        {
            return 3;
        }
        else 
        {
            return 2;
        }
        
        
    }
    
}
