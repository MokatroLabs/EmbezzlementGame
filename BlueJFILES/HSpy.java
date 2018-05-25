 


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
    }
    
    public void activeAbility(Player choice)
    {
        coolDown = 5;
        choice.setReputation(choice.getReputation() - 5);
        choice.setMoney(choice.getMoney() - 500);
    }
    
    public void embezzle()
    {
        money += 750;
        reputation -= 0.25;
    }
}
