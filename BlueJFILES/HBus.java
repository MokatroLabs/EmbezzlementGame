 


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
        activeName = "Class Action Lawsuit";
    }
    
    public void activeAbility()
    {
       cooldown = 5;;
       setNoCons(espLV);
       consecutive = 0;
    }
    
    public void setMoneyBoost(){
        if(leadLV == 0){
            moneyBoost = 0;
        }
        if(leadLV == 1){
            moneyBoost = 50;
        }
        if(leadLV == 2){
            moneyBoost = 100;
        }
        if(leadLV == 3){
            moneyBoost = 150;
        }
        if(leadLV == 4){
            moneyBoost = 200;
        }
        if(leadLV == 5){
            moneyBoost = 250;
        }
        
    }
    
    public void setRdLV(int newLevel){
        rdLV = newLevel;
    }
    
    public void paycheck()
    {
        money += 150 + (reputation*.01)*150;
    }
}