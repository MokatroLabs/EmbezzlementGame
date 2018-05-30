 


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
	
	int getCoolDown();
	
	boolean getEmbezzle();
	
	int getTWE();
	//Setters
	void setReputation(double newReputation);
	
	void setMoney(int newMoney);
	
	void setCoolDown(int newCoolDown);

	void setEmbezzle();
	
	void setTWE(int newTWE);
	
	boolean isHuman();
	void paycheck();
	
	int findMove();

}
