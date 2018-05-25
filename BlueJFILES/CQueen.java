 


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
       money += 5000;
       reputation -= 2.5;
       coolDown = 5;
   }
   
   public void fundraise()
   {
       money += 300;
       reputation += .5;
    }
   public void embezzle()
   {
       money += 200;
        reputation -= 0.7;
       
   }
   
   
   
}
