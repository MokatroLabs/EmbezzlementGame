
public class Mechanics {
    private int moneyPot;
    private int turnCount;
    final int maxTurns = 150;

    public Mechanics()
    {
        moneyPot = 400;
        turnCount = 1;
    }
    // setter for moneyPot

   
    public Mechanics( int moneyPot)
    {
        super();
        this.moneyPot = moneyPot;
    }
    //setter for moneypot
    public void setMoney(int amount)
    {
        moneyPot = amount;
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
