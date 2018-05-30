 


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
	
	int getCooldown();
	
	boolean getEmbezzle();
	
	int getTWE();
	
	boolean isHuman();
<<<<<<< HEAD
	void paycheck();
	int findMove();
=======
	
	//Setters
	void setReputation(double newReputation);
	
	void setMoney(int newMoney);
	
	void setCooldown(int newCooldown);

	void setEmbezzle();
	
	void setTWE(int newTWE);
	
	
>>>>>>> a284bb96fa38f722274b2e952a95075802907d59

}
