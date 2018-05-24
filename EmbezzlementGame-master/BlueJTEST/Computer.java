
public abstract class Computer implements Players {

	double reputation = 50;
	int moneyPot = 400;
	int money = 50;
    @Override
	
	public double getReputation() {
		// TODO Auto-generated method stub
		return reputation;
	}
    public void setMoneyPersonal(int ammount)
    {
        money = ammount;
    }
    public void setMoneyPot(int ammount)
    {
        moneyPot = ammount;
    }
    public void setReputation(double ammount)
    {
        reputation = ammount;
    }
	
	public int getMoneyPersonal() {
		// TODO Auto-generated method stub
		return money;
	}
	public int getMoneyPot()
	{
	    return moneyPot;
	}

	
	public String getFaction() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void activeAbility()
	{
		
	}
	public void fundraise()
	{
		int moneyChange = (int)Math.random() * 35;
		setMoneyPot(getMoney() + moneyChange);
		setReputation(getReputation() + 1);
	}
	public void embezzle()
	{   
		int moneyChange = (int)Math.random() * 50;
		money += moneyChange;
		setMoneyPot(getMoneyPot() - moneyChange);
	    getReputation();
		
	}
	public void upgrade()
	{
		
	}
	//toggles show action feture
	public void toggleView()
	{
		
	}
	
	
	

}
