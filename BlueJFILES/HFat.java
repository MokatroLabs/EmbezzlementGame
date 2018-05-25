 


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
    }
    
    public void activeAbility(Player choice, Player father)
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
