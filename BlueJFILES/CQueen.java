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
        consecutive = 0;
        setNoCons(espLV);
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

    public int findMove(int turncount)
    {
        // DO NOT GET RID OF THIS I SWEAR TO GOD
    
        int action =0;
        //Rep Based Changes
        if(reputation <=15)
        {
            fundraiseW += bound*.25;
            interactW += bound*.5;
            embezzleW -= bound*.5;
            activeW -=bound*.75;
        } else if(reputation <=25)

        {
            fundraiseW += bound*.125;
            interactW+=bound*.25;
            embezzleW -= bound*.25;
            activeW -=bound*.5;
        } else if(reputation <=35)
        {
            fundraiseW +=bound*.0625;
            interactW+=bound*.125;
            embezzleW -= bound*.125;
            activeW -=bound*.125;
        } else if(reputation <=45)
        {
            fundraiseW +=bound*.03125;
            interactW+=bound*.0625;
            embezzleW -= bound*.0625;
            activeW -=bound*.0625;
        }else if(reputation <=55)
        {
            fundraiseW +=bound*.015625;
            interactW+=bound*.03125;
            activeW +=bound*.125;
        }else if(reputation<= 65)
        {
            fundraiseW -=bound*.015625;
            interactW+=bound*.015625;
            embezzleW -= bound*.015625;
            activeW +=bound*.25;
        }else if(reputation <= 75)
        {
            fundraiseW -=bound*.03125;
            interactW-= bound*.015625;
            embezzleW += bound*.015625;
            activeW +=bound*.5;
        }else if(reputation <= 85)
        {
            fundraiseW -=bound*.0625;
            interactW-=bound*.03125;
            embezzleW += bound*.03125;
            activeW +=bound*.75;
        }else if(reputation <= 95)
        {
            fundraiseW -=bound*.125;
            interactW-=bound*.0625;
            embezzleW += bound*.0625;
            activeW -=bound*1;
        }

        // Money Based Changes
        if (money <= 1000)
        {
            embezzleW -=bound*.015625;
            fundraiseW += bound*.25;
            interactW -= bound*.5;
            upgradeW += bound*.015625;            
        } else if (money <= 3000)
        {
            embezzleW -= bound*.03125;
            fundraiseW += bound*.125;
            interactW -= bound*.25;
            upgradeW += bound*.03125;
        } else if (money <= 9000)
        {
            embezzleW -= bound*.0625;
            fundraiseW +=bound*.0625;
            interactW -= bound*.125;
            upgradeW += bound*.0625;
        } else if (money <= 27000)
        {   embezzleW -= bound*.125;
            fundraiseW +=bound*.03125;
            interactW -= bound*.0625;
            upgradeW += bound*.125;
        } else if (money <= 81000)
        {
            embezzleW -= bound*.25;
            fundraiseW += bound*.015625;
            interactW -=bound*.03125;
            upgradeW += bound*.25;
        } else if (money <= 243000)
        {
            embezzleW -= bound*.5;
            fundraiseW -= bound*.015625;
            upgradeW +=bound*.5;
        } else if (money <= 729000)
        {
            embezzleW -= bound*1;
            fundraiseW -= bound*.03125;
            upgradeW +=bound*1;
        } else if (money <= 2187000)
        {
            embezzleW -= bound*1;
            fundraiseW -=bound*.0625;
            upgradeW +=bound *1;
        }
        // Turn Based Changes
        if (turncount <= 10)
        {
            fundraiseW +=bound*.5;
            embezzleW -=bound*.5;
            upgradeW -=bound*.25;
        } else if (turncount <= 25)
        {
            fundraiseW +=bound*.25;
            embezzleW-= bound*.25;
            upgradeW +=bound*.125;
        } else if (turncount <= 40)
        { 
            fundraiseW +=bound*.125;
            embezzleW -= bound*.125;
            upgradeW +=bound*.25;
        } else if (turncount <= 55)
        {
            fundraiseW +=bound*.0625;
            embezzleW -=bound*.0625;
            upgradeW +=bound*.5;
        } else if (turncount <= 70)
        {
            fundraiseW += bound*.03125;
            embezzleW -= bound*.03125;
            upgradeW +=bound*.5;
        } else if (turncount <= 85)
        {
            fundraiseW += bound*.015625;
            embezzleW -= bound*.015625;
            upgradeW +=bound*.5;
        } else if (turncount <= 100)
        {
            fundraiseW -= bound*.25;
            embezzleW += bound*25;
            upgradeW +=bound*1;
        } else if (turncount <=140)
        {
            fundraiseW -= bound*.95;
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
        //cooldown Change
        if (cooldown > 0)
            activeW = 0;
        //no negative Weights
        if(embezzleW <0)
            embezzleW= .01;
        if(fundraiseW <0)
            fundraiseW= .01;
        if(interactW <0)
            interactW= .01;
        if(upgradeW <0)
            upgradeW= .01; 
        if(activeW <0)
            activeW= .01;
        bound = embezzleW + fundraiseW + interactW + upgradeW + activeW;
        double decision =Math.random()*bound;
        if(decision <= embezzleW)
            action =1;
            else if(decision <= embezzleW +fundraiseW)
                action = 2;
                else if(decision <= embezzleW+fundraiseW+interactW)
                    action =3;
                    else if(decision <= embezzleW+fundraiseW+interactW+upgradeW)
                        action=4;
                        else if(decision <= embezzleW+fundraiseW+interactW+upgradeW+activeW)
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
    

