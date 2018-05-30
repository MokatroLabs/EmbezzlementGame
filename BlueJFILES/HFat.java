 


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
        cooldown = 5;
        choice.setMoney(choice.getMoney() - 300);
        father.setMoney(father.getMoney() + 300);
    }
    
    public void interact()
    {
    }
    
}
