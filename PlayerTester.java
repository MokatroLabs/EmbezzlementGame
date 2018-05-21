
public class PlayerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HQueen queen = new HQueen();
		System.out.println(queen.getChar());
		System.out.println(queen.getMoney());
		System.out.println(queen.getReputation());
		queen.fundRaise();
		System.out.println(queen.getMoney());
		queen.activeAbility();
		System.out.println(queen.getMoney());
		System.out.println(queen.getReputation());
		System.out.println(queen.toString());
		

	}

}
