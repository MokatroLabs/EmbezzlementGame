 


public class HQueen extends Human {
    
    public HQueen()
    {
        super();
        super.character = "Queen";
    }
    

    public void activeAbility() //Royal Wealth
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
    
   public void toggleAction(){ //The queen cannot toggle her actions off
       
    }

}
