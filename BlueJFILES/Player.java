 


public interface Player {

	
	//Actions
	void activeAbility();
	
	void interact();
	
	void fundraise();
	
	void upgrade();
	
	void embezzle();
	
	void paycheck();
	
	int findMove();
	//Getters
	double getReputation();
	
	int getMoney();
	
	String getChar();
	
	int getCoolDown();
	
	boolean getEmbezzle();
	
	int getTWE();
	
	boolean isHuman();
	
	//Setters
	void setReputation(double newReputation);
	
	void setMoney(int newMoney);
	
	void setCoolDown(int newCoolDown);

	void setEmbezzle();
	
	void setTWE(int newTWE);
	
	

}
