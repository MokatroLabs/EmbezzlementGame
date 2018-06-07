 


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
    
    public void upgrade(int level) { // Action 4
        // TODO Auto-generated method stub
        int noAdd = 0;
        consecutive = 0;
        setNoCons(espLV);
        if(level == 1){
            noAdd = (500 - upgradeDown);
            if(noAdd < 0){
                noAdd = 0;
            } else {
                money -= noAdd;
            }
        }
        if(level == 2){
            noAdd = (1000 - upgradeDown);
            if(noAdd < 0){
                noAdd = 0;
            } else {
                money -= noAdd;
            }
        }
        if(level == 3){
            noAdd = (2000 - upgradeDown);
            if(noAdd < 0){
                noAdd = 0;
            } else {
                money -= noAdd;
            }
        }
        if(level == 4){
            noAdd = (4000 - upgradeDown);
            if(noAdd < 0){
                noAdd = 0;
            } else {
                money -= noAdd;
            }
        }
        if(level == 5){
            noAdd = (6000 - upgradeDown);
            if(noAdd < 0){
                noAdd = 0;
            } else {
                money -= noAdd;
            }
        }
    }
    
    public void setRdLV(int newLevel){
        rdLV = newLevel;
    }
    
}