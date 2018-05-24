
public class Main {

	final static int maxTurns = 150;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mechanics economy = new Mechanics();
		HQueen play = new HQueen();
		while(economy.getTurns() <= maxTurns) {
			if(play.getChar().equals("Business Man")) {
				play.setMoney(play.getMoney() + 150);
			}
			if(play.getChar().equals("Queen"))
			{
				
			}
			
			
			economy.setTurns(economy.getTurns() + 1);
		}
		
	}

}
