 


public class HQueen extends Human {
    
    public HQueen()
    {
        super();
        super.character = "Queen";
    }
    

    public void activeAbility() //Royal Wealth
    {
       if(leadLV == 0){
           money +=  1000;
        } 
       if(leadLV == 1){
           money += 1500;
        }
       if(leadLV == 2){
           money += 2000;
        }
       if(leadLV == 3){
           money += 2500;
        }
       if(leadLV == 4){
           money += 3000;
        }
       if(leadLV == 5){
           money += 3500;
        }
       reputation -= 2.5;
       setNoCons(espLV);
       consecutive = 0;
       cooldown = 5;
    }
   
    public void fundraise()
    {
        money += 300;
        reputation += .5;
    }
   
    public void setRdLV(int newLevel){
        rdLV = newLevel;
    }
    
    public void toggleAction(){ //The queen cannot toggle her actions off
        
    }

}
