
public interface Player {
	
	//Actions
	void activeAbility();
	
	void interact();
	
	void fundRaise();
	
	void upgrade();
	
	void embezzle();
	
	//Getters
	double getReputation();
	
	int getMoney();
	
	String getChar();

	int getCoolDown();
	
	//Setters
	void setReputation();
	
	void setMoney();
	
	void setChar();
	
	void setCoolDown();

}
