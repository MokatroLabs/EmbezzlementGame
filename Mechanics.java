
public class Mechanics {
	private static int moneyPot ;
	private int turnCount;
	final int maxTurns = 150;
	
	public Mechanics()
	{
		moneyPot = 400;
		turnCount = 0;
	}
	
	// setter for moneyPot
	public static void setMoney(int ammount)
	{
		moneyPot = ammount;
	}
	//getter for moneyPot
	public static int getMoney()
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
	
	public static int randomNumber()
	{
		return (int) Math.random() * 99 + 1;
	}
	
}