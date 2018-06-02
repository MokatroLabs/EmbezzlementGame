public abstract class Human implements Player {


    //Instance Variables
    protected double reputation;
    protected int money;
    protected String character;//refers to the identification of each class by String
    protected int cooldown; //refers to active ability cooldown times
    protected boolean isHuman; //refers to the identification of each class by whether they are human or not
    protected boolean isToggled; //refers to the toggling of actions
    protected boolean hasEmbezzled; //refers to audits 
    protected int twe; //refers to turns without embezzle (also refers to audits)
    protected boolean hasLost; //refers to whether the player has lost the game yet
    protected int[] skills; //refers to the skill tree levels
    protected int consecutive; // punishes players that embezzle too much
    protected int rdLV; // Research and Development Level
    protected int marLV; // Marketing Level
    protected int prLV; // Public Relations Level
    protected int leadLV; // Leadership Level
    protected int espLV; // Espionage Level
    
    
    
    public Human()
    {
        reputation =  50;
        money = 2000;
        character = "";
        cooldown = 5;
        isHuman = true;
        isToggled = true;
        hasEmbezzled = false;
        twe = 0;
        hasLost = false;
        skills = new int[5];
        skills[0] = leadLV;
        skills[1] = prLV;
        skills[2] = espLV;
        skills[3] = marLV;
        skills[4] = rdLV;
        consecutive = 0;
    }
    
    public Human(double newReputation,int newMoney,String Char) { //meant just in case we want difficulties or multiplayer
        super();
        this.reputation = newReputation;
        this.money = newMoney;
        this.character = Char;
    }
    
    // Actions
    public void fundraise() { //Action 1
        // TODO Auto-generated method stub
        money += 200;
        reputation += .25;
        consecutive = 0;
    }
    
    public void embezzle() { //Action 2
        // TODO Auto-generated method stub
        money += 500;
        reputation -= .25 + consecutive * .25;
        hasEmbezzled = true;
        consecutive++;
    }
    
    public void interact() { // Action 3
        // TODO Auto-generated method stub
        reputation += .25;
        consecutive =0;
        //Draws a Chance Card
    }
    
    public void upgrade(int level) { // Action 4
        // TODO Auto-generated method stub
        consecutive = 0;
        if(level == 1){
            money -= 500;
        }
        if(level == 2){
            money -= 1000;
        }
        if(level == 3){
            money -= 2000;
        }
        if(level == 4){
            money -= 4000;
        }
        if(level == 5){
            money -= 6000;
        }
    }
    
    public void activeAbility() // Action 5
    {
        cooldown = 5;
        consecutive =0;
    }



    public int findMove(int turncount)
    {    
        return 0;
    }  

    
    //Getters
    public double getReputation() 
    {
        return reputation;
    }

    public String getChar() {
        return character;
    }
    
    public int getMoney() {
        return money;
    }
    
    public int getCooldown(){
        return cooldown;
    }
    
    public boolean isHuman()
    {
        return isHuman;
    }
    
    public boolean getEmbezzle(){
        return hasEmbezzled;
    }
    
    public int getTWE(){
        return twe;
    }
    
    public boolean getLost(){
        return hasLost;
    }
    
    public boolean getToggled(){
        return isToggled;
    }
    
    public int getLeadLV(){
        return leadLV;
    }
    
    public int getPrLV(){
        return prLV;
    }
    
    public int getEspLV(){
        return espLV;
    }
    
    public int getMarLV(){
        return marLV;
    }
    
    public int getRdLV(){
        return rdLV;
    }
    
    public int[] getSkills(){
        return skills;
    }
    
    //Setters
    public void setReputation(double newReputation)
    {
        reputation = newReputation;
    }
    
    public void setMoney(int newMoney)
    {
        money = newMoney;
    }
    
    public void setCooldown(int newCooldown){
        cooldown = newCooldown;
    }
    
    public void setEmbezzle(){
        hasEmbezzled = false;
    }
    
    public void setTWE(int newTWE){
        twe = newTWE;
        }
        
    public void setLost(){
        hasLost = true;
    }
    
    public void setLeadLV(int newLevel){
        leadLV = newLevel;
    }
    
    public void setPrLV(int newLevel){
        prLV = newLevel;
    }
    
    public void setEspLV(int newLevel){
        espLV = newLevel;
    }
    
    public void setMarLV(int newLevel){
        marLV = newLevel;
    }
    
    public void getRdLV(int newLevel){
        rdLV = newLevel;
    }
    
    //Miscellaneous
    //toggles show action
    public void toggleView()
    {
        if(isToggled){
            isToggled = false;
        } else {
            isToggled = true;
        }
    }
    //gives paycheck
    public void paycheck()
    {
        money += 100 + (reputation*.01)* 100;
    }
    
    public String toString()
    {
       return "This player is part of the " + character + " class . Also, this player has " + reputation + " reputation and " + money + " dollars.";
    }


    

    
    

}
