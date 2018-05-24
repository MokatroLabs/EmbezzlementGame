 


public interface Player {
	
	//Actions
	void activeAbility();
	
	void interact();
	
	void fundraise();
	
	void upgrade();
	
	void embezzle();
	
	//Getters
	double getReputation();
	
	int getMoney();
	
	String getChar();
	
	//Setters
	void setReputation(double rep);
	
	void setMoney(int ammount);
	
	boolean isHuman();
	

}
