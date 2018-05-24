 


/**
 * Write a description of class CSpy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CSpy extends Computer
{
	public CSpy
	{
		super();
		this.character = "Spy"
		
	}
	public void embezzle()
	{
		
		int moneySteal = (int)math.random() * 300;
		money += moneySteal;
		
		
	}
	public void getMoney()
	{
		return money;
	}
	public void activeAbility(PLayer target)
	{
		target.setReputation(player.getReputation - Math.random() * 20 )
	}
			
	
	public void fundraise()
	{
		System.out.print("can't do that");
	}
	public String getFaction()
	{
		
		return("Spy");
	}
	
}
