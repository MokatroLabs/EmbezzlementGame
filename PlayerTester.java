
public class PlayerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human player = new Human();
		System.out.println(player.getMoney());
		System.out.println(player.getReputation());
		player.raiseFunds();
		System.out.println(player.getMoney());
		System.out.println(player.getReputation());
		
		HQueen queen = new HQueen();
		System.out.println(queen.getFaction());
		System.out.println(queen.getMoney());
		System.out.println(queen.getReputation());
		queen.raiseFunds();
		System.out.println(queen.getMoney());
		queen.activeAbility();
		System.out.println(queen.getMoney());
		System.out.println(queen.getReputation());
		System.out.println(queen.toString());
		

	}

}
