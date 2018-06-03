 


/**
 * Write a description of class CSpy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CSpy extends Computer
{
    public CSpy(){
        super();
        this.character = "Spy";
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


    public int findMove(int turncount)
    {
        // DO NOT GET RID OF THIS I SWEAR TO GOD
    
        int action =0;
        //Rep Based Changes
        if(reputation <=15)
        {
            interactW += bound*.5;
            embezzleW -= bound*.5;
        } else if(reputation <=25)

        {
            interactW+=bound*.25;
            embezzleW -= bound*.25;
        } else if(reputation <=35)
        {
            interactW+=bound*.125;
            embezzleW -= bound*.125;
        } else if(reputation <=45)
        {
            interactW+=bound*.0625;
            embezzleW -= bound*.0625;
        }else if(reputation <=55)
        {
            interactW+=bound*.03125;
        }else if(reputation<= 65)
        {
            interactW+=bound*.015625;
            embezzleW -= bound*.015625;
        }else if(reputation <= 75)
        {
            interactW-= bound*.015625;
            embezzleW += bound*.015625;
        }else if(reputation <= 85)
        {
            interactW-=bound*.03125;
            embezzleW += bound*.03125;
        }else if(reputation <= 95)
        {
            interactW-=bound*.0625;
            embezzleW += bound*.0625;
        }

        // Money Based Changes
        if (money <= 1000)
        {
            embezzleW +=bound*.5;
            interactW -= bound*.5;
            upgradeW -= bound*.5;            
        } else if (money <= 3000)
        {
            embezzleW += bound*.25;
            interactW -= bound*.25;
            upgradeW -= bound*.25;
        } else if (money <= 9000)
        {
            embezzleW += bound*.125;
            interactW -= bound*.125;
            upgradeW -= bound*.125;
        } else if (money <= 27000)
        {   embezzleW += bound*.0625;
            interactW -= bound*.0625;
            upgradeW -= bound*.0625;
        } else if (money <= 81000)
        {
            embezzleW += bound*.03125;
            interactW -=bound*.03125;
            upgradeW -= bound*.03125;
        } else if (money <= 243000)
        {
            embezzleW += bound*.015625;
        } else if (money <= 729000)
        {
            embezzleW -= bound*.015625;
        } else if (money <= 2187000)
        {
            embezzleW -= bound*.03125;
        }
        // Turn Based Changes
        if (turncount <= 10)
        {
            embezzleW -=bound*.5;
            upgradeW -=bound*.25;
        } else if (turncount <= 25)
        {
            embezzleW-= bound*.125;
        } else if (turncount <= 40)
        { 
            embezzleW -= bound*.03125;
        } else if (turncount <= 55)
        {
            
        } else if (turncount <= 70)
        {
            embezzleW += bound*.03125;
        } else if (turncount <= 85)
        {
            embezzleW += bound*.125;
        } else if (turncount <= 100)
        {
            embezzleW += bound*25;
        } else if (turncount <=140)
        {
            embezzleW += bound*.5;
        }
        // Consecutive Based Changes
        if (consecutive >= 5)
        {
            embezzleW -= bound*.5;
        } else if (consecutive >3)
        {
            embezzleW -= bound*.25;
        } else if (consecutive >1)
        {
            embezzleW -= bound*.125;
        }
        fundraiseW =0;
        //cooldown Change
        if (cooldown > 0)
            activeW = 0;
        //no negative Weights
        if(embezzleW <0)
            embezzleW= .01;
        fundraiseW= .01;
        if(interactW <0)
            interactW= .01;
        if(upgradeW <0)
            upgradeW= .01; 
        if(activeW <0)
            activeW= .01;
        bound = embezzleW + interactW + upgradeW + activeW;
        double decision =Math.random()*bound;
        if(decision <= embezzleW)
            action =1;
            else if(decision <= embezzleW )
                action = 2;
                else if(decision <= embezzleW+interactW)
                    action =3;
                    else if(decision <= embezzleW+interactW+upgradeW)
                        action=4;
                        else if(decision <= embezzleW+interactW+upgradeW+activeW)
                            action=5;
        System.out.println(action);
        System.out.println(reputation);
        System.out.println(money);
        printWeights();
        if (embezzleW > 10000 || fundraiseW > 10000 || interactW > 10000 || upgradeW > 10000 || activeW > 10000 )
            resetFocus();
        return action;
    }
    
        
    
    
    
    
}
