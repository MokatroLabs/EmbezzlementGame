 


/**
 * Write a description of class CFat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class CFat extends Computer
{
    public CFat(){
        super();
        this.character = "Father";
    }
    
    public void activeAbility(Player choice, Player father )
    {
        coolDown = 5;
        choice.setMoney(choice.getMoney() - 300);
        father.setMoney(father.getMoney() + 300);
    }
    
    public void interact()
    {
    }
    public void fundraise()
    {
        setMoney(getMoney() + 200);
        reputation += 0.5;
    }
    public void embezzle()
    {
        money += 200;
        reputation -= 0.7;
    }
    
    
}
