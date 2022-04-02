public class MainMenu extends Menu{
	
	@Override
	public void printMenu(){
		System.out.println("1. Player game");
		System.out.println("2. List all players");
		System.out.println("3. exit ");
	}
	
	@Override
	public NavigationData performAction(int optionIndex){
		switch (optionIndex){
			case 1:
				System.out.println("Play game now...");
				System.out.println("Game over");
				return new NavigationData(ConstantFlags.NAV_MAIN,null);
			case 2:
				return new NavigationData(ConstantFlags.NAV_PLAYER_LIST,null);
			case 3:
				System.exit(0);
		}
		return null;
	}
	
}