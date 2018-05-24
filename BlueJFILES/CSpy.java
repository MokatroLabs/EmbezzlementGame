 


/**
 * Write a description of class CSpy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CSpy extends Computer


	public CSpy
	{
		super();
		this.character = "Spy"
		
	}
	public void embezzle()
	{
		
		int moneySteal = (int)math.random() * 300;
		money += moneySteal;
		reputation -= 1.7;
		
		
	}
	public void getMoney()
	{
		return money;
	}
	public void activeAbility(PLayer target)
	{
		target.setReputation(target.getReputation - Math.random() * 20 )
	}
			
	
	public void fundraise()
	{
		System.out.print("can't do that");
	}
	public String getFaction()
	{
		
		return("Spy");
	}
	public void setReputation(double newRep)
	{
		Reputation = newRep;
	}
	
	
>>>>>>> c851d9b205161430b7b644d87833eb67c7381957
}
