
public class Computer implements Players {

	@Override
	public double getReputation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMoney() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getFaction() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void activeAbility()
	{
		
	}
	public void doThings()
	{
		if(Computer.getReputation < 50)
		{
			Computer.fundraise();
		}
		else
		{
			Computer.embezzle();
		}
	}
	//test to see if i workjhj
	

}