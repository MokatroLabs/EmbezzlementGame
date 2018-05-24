
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
		coolDown = 0;
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
		int chance =  Mechanics.randomNumber() + (int) reputation/10 ;
		if(chance <= 50) {
			money -= 750;
			reputation -= 3;
		} else if(chance > 50 &&  chance <= 75) {
			
		} else {
			money += 500;
			Mechanics.setMoney(Mechanics.getMoney() - 500);
		}
	}
	
	@Override
	public void fundRaise() {
		// TODO Auto-generated method stub
		money += 300;
		reputation += .25;
		Mechanics.setMoney(Mechanics.getMoney() + 300);
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
	
	public int getCoolDown()
	{
		return coolDown;
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
	
	public void setChar(String newChar) {
		character = newChar;
	}
	
	public void setCoolDown(int newCoolDown) {
		coolDown = newCoolDown;
	}
	
	public String toString()
	{
		return "This player is part of the " + character + " class . Also, this player has " + reputation + " reputation and " + money + " dollars.";
	}

	

	

	

	
	

}
