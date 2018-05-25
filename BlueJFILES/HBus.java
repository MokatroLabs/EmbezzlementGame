 


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
        coolDown = 5;
    }
    public void fundraise()
    {
        
        reputation += 0.5;
    }
    public void embezzle()
    {
        money += 200;
        reputation -= 0.7;
    }
}
