
public class Computer implements Player {

	//Instance Variables
	protected double reputation;
	protected int money;
	protected String character;
	protected int coolDown;
	
	public Computer()
	{
		reputation =  25.0;
		money = 2000;
		character = "";
		coolDown = 5;
	}
	
	public Computer(double newReputation,int newMoney,String newFaction) {
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
	public void setReputation() {
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
	
	
