 


public interface Player {
    //Actions
    void activeAbility();
    
    void interact(); //There should be a Card Parameter in here, not putting it Becuase it will not complie 
    
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
    
    int getMoneyBoost();
    
    int getNoCons();
    
    String getActiveName();
    
    int getCard46();
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
    
    void setMoneyBoost();
    
    void setNoCons(int level);
    
    void setCard46(int turn);
    
    


}
