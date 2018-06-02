 


/**
 * Write a description of class HCap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HBus extends Human
{
    public HBus(){
        super();
        this.character = "Business Man";
        this.reputation = 25;
    }
    
    public void activeAbility()
    {
        cooldown = 5;
    }
    
    public void interact()
    {
        
    }
    
    public void setRdLV(int newLevel){
        rdLV = newLevel;
    }
    
    public void paycheck()
    {
        money += 150 + (reputation*.01)*150;
    }
}
