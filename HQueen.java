
public class HQueen extends Human {
	
	public HQueen()
	{
		super();
		super.character = "Queen";
	}
	
	public void fundRaise()
	{
		money += 500;
		reputation += .5;
	}
	
	public void activeAbility() // Special Active Ability: Royal Wealth
	{
		reputation -=  2.5;
		money += 5000;  // Amount of Increase TBD
	}

	@Override
	public void setReputation() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
