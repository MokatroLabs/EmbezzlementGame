/**
 * Write a description of class CQueen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CQueen extends Computer
{
    public CQueen(){
        super();
        this.character = "Queen";
    }
    
    public void activeAbility()
    {
        money += 1000;
        reputation -= 2.5;
        cooldown = 5;
    }    
    public void fundraise()
    {
        money += 300;
        reputation += .5;
    }
    public void interact()
    {
        
    }
<<<<<<< HEAD
   public int findMove()
=======
    public int findMove()
>>>>>>> a284bb96fa38f722274b2e952a95075802907d59
    {
        if(cooldown == 0) {
            return 5;
<<<<<<< HEAD

        }
        else if (getReputation() < 30)
        {
            return 1;
=======
>>>>>>> a284bb96fa38f722274b2e952a95075802907d59
        }
        else if (reputation < 30)
            return 3;
        else 
            return 2;
    }
    
}
