 


/**
 * Write a description of class HSpy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HSpy extends Human
{
    public HSpy()
    {
        super();
        super.character = "Spy";
        activeName = "Sabotage";
    }
    
    public void activeAbility()
    {
        cooldown = 5;
        setNoCons(espLV);
        consecutive = 0;
    }
    
    public void embezzle()
    {
        money += (750 + embezzleBoost);
        reputation -= .25 + consecutive * .25;
        if(noCons == 0){
            consecutive++;
        }else{
            noCons--;
        }
        hasEmbezzled = true;
    }
    
    public void setRdLV(int newLevel){
        rdLV = newLevel;
    }
}
