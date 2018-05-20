
public class Human implements Players {

	//Instance Variables
	protected double reputation;
	protected int money;
	protected String faction;
	
	public Human()
	{
		reputation =  25.0;
		money = 2000;
		faction = "";
	}
	
	public Human(double newReputation,int newMoney,String newFaction) {
		super();
		this.reputation = newReputation;
		this.money = newMoney;
		this.faction = newFaction;
	}
	
	// Actions
	public void raiseFunds()
	{
		money += 300;
		reputation += .5;
	}
	
	public boolean chancetoEmbezzle() {
		// TODO Auto-generated method stub
		int chance = (int) Math.random() * 99 + 1;
		if(chance <= 25) {
			return false; // Nothing happens
		} else if(chance > 25 && chance <= 50 ) {
			money += 500;
			//Opponent.setMoney(money - 500); // Embezzle Succeeds
			return true;
		} else {
			reputation -= 5;
			money -= 500;
			return false; // Embezzle fails
		}
	}
	
	public void activeAbility()
	{
		
	}
	
	//Getters
	public double getReputation() 
	{
		
		return reputation;
	}

	public int getMoney() {
		return money;
	}
	
	public String getFaction()
	{
		return faction;
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
	
	public void setFaction(String newFaction)
	{
		faction = newFaction;
	}
	
	public String toString()
	{
		return "This player is part of the " + faction + " class . Also, this player has " + reputation + " reputation and " + money + " dollars.";
	}

	
	

}
