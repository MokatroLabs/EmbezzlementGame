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
    
    public void setRdLV(int newLevel){
        rdLV = newLevel;
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
    

