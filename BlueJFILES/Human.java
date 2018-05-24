package BlueJFILES;



public abstract class Human implements Players {

	//Instance Variables
	protected double reputation;
	protected int money;
	protected String character;
	
	public Human()
	{
		reputation =  25.0;
		money = 2000;
		character = "";
	}
	
	public Human(double newReputation,int newMoney,String newFaction) {
		super();
		this.reputation = newReputation;
		this.money = newMoney;
		this.character = newFaction;
	}
	
	// Actions
	
	@Override
	public void interact() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fundRaise() {
		// TODO Auto-generated method stub
		money += 300;
		reputation += .5;
	}

	@Override
	public void upgrade() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void embezzle() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public void activeAbility()
	{
		
	}
	
	//Getters
	public double getReputation() 
	{
		
		return reputation;
	}

	@Override
	public String getChar() {
		// TODO Auto-generated method stub
		return character;
	}
	
	public int getMoney() {
		return money;
	}
	
	
	//Setters
	public void setReputation(double newReputation)
	{
		reputation = newReputation;
	}
	
	public void setMoney(int newMoney)
	{
		money = newMoney;
	}
	
	@Override
	public void setRep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMoney() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setChar() {
		// TODO Auto-generated method stub
		
	}
	
	public String toString()
	{
		return "This player is part of the " + character + " class . Also, this player has " + reputation + " reputation and " + money + " dollars.";
	}
	//toggles show action
	public void toggleView()
	{
		
	}
	//to be called in interact
	public void embezzle()
	{
		
	}
	//upgrades skill tree
	public void upgrade()
	{
		
	}
	

	

	

	
	

}
