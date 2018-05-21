
public class Computer implements Players {

	@Override
	static bankAccount = 100;
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
	public void fundraise()
	{
		bandFund += 50;
		reputation += 3;
	}
	public void embezzle()
	{
		int stealcash = (int) math.random() * 50;
		band Fund -= stealCash;
		bankAccount += stealCash;
		
	}
	public void audit()
	{
		
	}
	
	

}
