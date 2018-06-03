 


/**
 * Write a description of class HFat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HFat extends Human
{
    public HFat(){
        super();
        this.character = "Father";
        activeName = "Power of the Mobster";
    }
    
    public void activeAbility()
    {
        cooldown = 5;
        setNoCons(espLV);
        consecutive = 0;
    }
    
    public void setRdLV(int newLevel){
        rdLV = newLevel;
    }
    
}
