
public class HQueen extends Human {
	
	public HQueen()
	{
		super();
		super.faction = "Queen";
	}
	
	public void raiseFunds()
	{
		money += 500;
		reputation += .5;
	}
	
	public void activeAbility() // Special Active Ability: Royal Wealth
	{
		reputation -=  2.5;
		money += 5000;  // Amount of Increase TBD
	}
	
	
	
	
}