 


public interface Player {
	//Actions
	void activeAbility();
	
	void interact();
	
	void fundraise();
	
	void upgrade(int level);
	
	void embezzle();
	
	void paycheck();
	
	int findMove(int turncount);
	
	//Getters
	double getReputation();
	
	int getMoney();
	
	String getChar();
	
	int getCooldown();
	
	boolean getEmbezzle();
	
	int getTWE();
	
	boolean isHuman();
	
	boolean getLost();
	
	boolean getToggled();
	
	int getLeadLV();
	
	int getPrLV();
	
	int getEspLV();
	
	int getMarLV();
	
	int getRdLV();
	
	int[] getSkills();
	
	//Setters
	void setReputation(double newReputation);
	
	void setMoney(int newMoney);
	
	void setCooldown(int newCooldown);

	void setEmbezzle();
	
	void setTWE(int newTWE);
	
	void setLost();
	
	void setLeadLV(int levelUp);
	
	void setPrLV(int levelUp);
	
	void setEspLV(int levelUp );
	
	void setMarLV(int levelUp);
	
	void setRdLV(int levelUp);
	
	


}
