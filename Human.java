
public abstract class Human implements Player {

	//Instance Variables
	protected double reputation;
	protected int money;
	protected String character;
	protected int coolDown;
	
	public Human()
	{
		reputation =  25.0;
		money = 2000;
		character = "";
		coolDown = 5;
	}
	
	public Human(double newReputation,int newMoney,String newFaction) {
		super();
		this.reputation = newReputation;
		this.money = newMoney;
		this.character = newFaction;
	}
	
	// Actions
	
	@Override
	public void embezzle() {
		// TODO Auto-generated method stub
		if(Mechanics.randomNumber() <= 25) {
			money -= 500;
			reputation -= 2;
		} else if(Mechanics.randomNumber() > 25 &&  Mechanics.randomNumber() <= 50) {
			money += 500;
			Mechanics.setMoney(Mechanics.getMoney() - 500);
		} else {
			
		}
	}
	
	@Override
	public void fundRaise() {
		// TODO Auto-generated method stub
		money += 300;
		reputation += .25;
	}
	
	@Override
	public void interact() {
		// TODO Auto-generated method stub
	}

	

	@Override
	public void upgrade() {
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

	

	

	

	
	

}
