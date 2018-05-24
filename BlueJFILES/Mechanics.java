
public class Mechanics {
	private int moneyPot = 0;
	private int turnCount = 0;
	final int maxTurns = 150;
	// setter for moneyPot
	public void setMoney(int ammount)
	{
		moneyPot = ammount;
	}
	//getter for moneyPot
	public int getMoney()
	{
		return moneyPot;
	}
	// setter for turnCount
	public void setTurns(int turnSet)
	{
		turnCount = turnSet;
	}
	//getter for turnCount
	public int getTurns()
	{
		return turnCount;
	}
	
}
