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

    public int findMove()

    {
        if(cooldown == 0) {
            return 5;


        }
        else if (getReputation() < 30)
        {
            return 1;
        }
        else 
            return 2;
    }
}
    

