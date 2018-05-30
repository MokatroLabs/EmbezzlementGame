 


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
=======

	
>>>>>>> dff112c5cb64dacb291e931940b7cf1e42da02f9
	
	boolean getLost();
	
	boolean getToggled();
	//Setters
	void setReputation(double newReputation);
	
	void setMoney(int newMoney);
	
	void setCooldown(int newCooldown);

	void setEmbezzle();
	
	void setTWE(int newTWE);
	
	void setLost();
	
	


}
