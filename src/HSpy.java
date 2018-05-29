
public class HSpy extends Human {

	public HSpy()
	{
		super();
		this.character = "Spy";
	}

	public void embezzle() {
		int chance =  Mechanics.randomNumber() + (int) reputation/10 + 5;
		if(chance <= 50) {
			money -= 750;
			reputation -= 3;
		} else if(chance > 50 &&  chance <= 75) {
			
		} else {
			money += 750;
			Mechanics.setMoney(Mechanics.getMoney() - 500);
		}
	}
	
	public void activeAbility(Computer target) { //Active Ability: Sabotage
		target.setReputation(target.getReputation() - 3);
		target.setMoney(target.getMoney() - 750);
		
	}
	@Override
	public void setReputation() {
		// TODO Auto-generated method stub
		
	}
	
	
}
