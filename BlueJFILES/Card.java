 


public class Card 
{
    String name;
    String code;
    int number;
    //protected int choice;
    //protected int random;
    public Card(String name, String code, int number)
    {
        this.name = name;
        this.code = code;
        this.number= number;
    }
    
    public int getCardNumber()
    {
        return number;
 
    }
    
    public String getCardName()
    {
        return name;
    }
    
    public String getCardCode()
    {
        return code;
    }
    
    public String toString() // testing function, overrides toString
    {
        return "Name : " + getCardName() + "Code: " + getCardCode() + "Num: " + getCardNumber();  
    }
    
    
}
