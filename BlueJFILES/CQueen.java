 


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
       coolDown = 5;
   }
   
   public void fundraise()
   {
<<<<<<< HEAD
       money += 300;
       reputation += .5;
   }
    
=======

       money += 300;
       reputation += .5;

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
   
   
>>>>>>> ce8e48d271be84933c5ba94a7cf9f0cfe2b4677c
}
