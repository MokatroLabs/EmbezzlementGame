 


public class HQueen extends Human {
    
    public HQueen()
    {
        super();
        super.character = "Queen";
    }
    
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
    
    
    
    
    
}
