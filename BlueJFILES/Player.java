 


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
	
	boolean getWon();
	
	boolean getToggled();
	
	int getLeadLV();
	
	int getPrLV();
	
	int getEspLV();
	
	int getMarLV();
	
	int getRdLV();
	
	int[] getSkills();
	
	int getFundIncrease();
	
	int getUpgradeDown();
	
	double getRepIncrease();
	
	//Setters
	void setReputation(double newReputation);
	
	void setMoney(int newMoney);
	
	void setCooldown(int newCooldown);

	void setEmbezzle();
	
	void setTWE(int newTWE);
	
	void setLost();
	
	void setWon();
	
	void setLeadLV(int level);
	
	void setPrLV(int level);
	
	void setEspLV(int level);
	
	void setMarLV(int level);
	
	void setRdLV(int level);
	
	void setFundIncrease(int level);
	
	void setUpgradeDown(int level);
	
	void setRepIncrease(int level);
	
	


}
