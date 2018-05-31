 


/**
 * Write a description of class CCap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CBus extends Computer
{
    public CBus(){
        super();
        this.character = "Businessman";
        this.reputation = 25;
    }
    
    public int getTWE(){
        return twe;
    }
    
    public void activeAbility()
    {
        cooldown = 5;
    }
   
    public void paycheck()

    {
<<<<<<< HEAD
        money += 250 + (reputation * .01) * 10;

    }
    public void printWeights()
    {
        System.out.println("EmbezzleW:"+embezzleW);
        System.out.println("FundraiseW:"+fundraiseW);
        System.out.println("InteractW:"+interactW);
        System.out.println("UpgradeW:"+upgradeW);
        System.out.println("ActiveW:"+activeW);

    }
    public int findMove()
    {
        // DO NOT GET RID OF THIS I SWEAR TO GOD
    
        int action =0;
        //Rep Based Changes
        if(reputation <=15)
        {
            fundraiseW += bound*.25;
            interactW += bound*.5;
            embezzleW -= bound*.5;
        } else if(reputation <=25)

        {
            fundraiseW += bound*.125;
            interactW+=bound*.25;
            embezzleW -= bound*.25;
        } else if(reputation <=35)
        {
            fundraiseW +=bound*.0625;
            interactW+=bound*.125;
            embezzleW -= bound*.125;
        } else if(reputation <=45)
        {
            fundraiseW +=bound*.03125;
            interactW+=bound*.0625;
            embezzleW -= bound*.0625;
        }else if(reputation <=55)
        {
            fundraiseW +=bound*.015625;
            interactW+=bound*.03125;
        }else if(reputation<= 65)
        {
            fundraiseW -=bound*.015625;
            interactW+=bound*.015625;
            embezzleW -= bound*.015625;
        }else if(reputation <= 75)
        {
            fundraiseW -=bound*.03125;
            interactW-= bound*.015625;
            embezzleW += bound*.015625;
        }else if(reputation <= 85)
        {
            fundraiseW -=bound*.0625;
            interactW-=bound*.03125;
            embezzleW += bound*.03125;
        }else if(reputation <= 95)
        {
            fundraiseW -=bound*.125;
            interactW-=bound*.0625;
            embezzleW += bound*.0625;
=======
        money += 150 + (reputation * .01) * 100;
    }
    
    public int findMove()
    // DO NOT GET RID OF THIS I SWEAR TO GOD
    {
        int action =0;
        //Rep Based Changes
        if(reputation <=15)
        {
            fundraiseW += bound*.25;
            interactW += bound*.5;
            embezzleW -= bound*.5;
        } else  if(reputation <=25)
        {
            fundraiseW += bound*.125;
            interactW+=bound*.25;
            embezzleW -= bound*.25;
        } else if(reputation <=35)
        {
            fundraiseW +=bound*.0625;
            interactW+=bound*.125;
            embezzleW -= bound*.125;
        } else if(reputation <=45)
        {
            fundraiseW +=bound*.03125;
            interactW+=bound*.0625;
            embezzleW -= bound*.0625;
        }else if(reputation <=55)
        {
            fundraiseW +=bound*.015625;
            interactW+=bound*.03125;
        }else if(reputation<= 65)
        {
            fundraiseW -=bound*.015625;
            interactW+=bound*.015625;
            embezzleW -= bound*.015625;
        }else if(reputation <= 75)
        {
            fundraiseW -=bound*.03125;
            interactW-= bound*.015625;
            embezzleW += bound*.015625;
        }else if(reputation <= 85)
        {
            fundraiseW -=bound*.0625;
            interactW-=bound*.03125;
            embezzleW += bound*.03125;
        }else if(reputation <= 95)
        {
            fundraiseW -=bound*.125;
            interactW-=bound*.0625;
            embezzleW += bound*.0625;

>>>>>>> feb1f7d97406f0aa65ffa649499f36727e1a3c29
        }

        // Money Based Changes
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
        return action;
<<<<<<< HEAD

=======
>>>>>>> feb1f7d97406f0aa65ffa649499f36727e1a3c29
    }
    
    public void printWeights()
    {
        System.out.println("EmbezzleW:"+embezzleW);
        System.out.println("FundraiseW:"+fundraiseW);
        System.out.println("InteractW:"+interactW);
        System.out.println("UpgradeW:"+upgradeW);
        System.out.println("ActiveW:"+activeW);

    }
   
}
