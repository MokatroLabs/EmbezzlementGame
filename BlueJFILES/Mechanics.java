 


public class Mechanics {
    private int moneyPot = 0;
    private int turnCount = 0;
    final int maxTurns = 150;
    public Mechanics()
    {
        
    }
    // setter for moneyPot
=======
   
    public Mechanics( int moneyPot)
    {
        this.moneyPot = moneyPot;
    }
    //setter for moneypot
>>>>>>> a66adb51297a38abe1af9c2e9409700840e126d3
    public void setMoney(int ammount)
    {
        moneyPot = ammount;
    }
    //getter for moneyPot
    public int getMoney()
    {
        return moneyPot;
    }
    // setter for turnCount
    public void setTurns(int turnSet)
    {
        turnCount = turnSet;
    }
    //getter for turnCount
    public int getTurns()
    {
        return turnCount;
    }
    
}
