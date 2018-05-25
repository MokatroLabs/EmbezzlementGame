 


public class HQueen extends Human {
    
    public HQueen()
    {
        super();
        super.character = "Queen";
    }
    
<<<<<<< HEAD
    public void activeAbility()
   {
       money += 1000;
       reputation -= 2.5;
       coolDown = 5;
   }
   
   public void fundraise()
   {
       money += 300;
       reputation += .5;
   }
    
=======
    public void fundraise()
    {
        money += 300;
        reputation += .5;
        
    }
    
    public void activeAbility() // Special Active Ability: Royal Wealth
    {
        coolDown = 5;
        reputation -=  2.5;
        money += 5000;  // Amount of Increase TBD
    } 
    
    public void interact()
    {
    
    }
>>>>>>> ce8e48d271be84933c5ba94a7cf9f0cfe2b4677c
    
    
    
    
}
