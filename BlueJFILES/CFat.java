 


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
    
    public void activeAbility(Player choice, Player father )
    {
        coolDown = 5;
        choice.setMoney(choice.getMoney() - 300);
        father.setMoney(father.getMoney() + 300);
    }
    
    public void interact()
    {
    }
    
<<<<<<< HEAD
=======
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
>>>>>>> ce8e48d271be84933c5ba94a7cf9f0cfe2b4677c
    
}
