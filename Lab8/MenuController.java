public class MenuController {
	private static Menu currMenu;
	
	public static void startMenu(){
		currMenu = new MainMenu();
		askMenuOption();
	}
	
	public static void askMenuOption(){
		NavigationData data = null;
		do {
			currMenu.printMenu();
			System.out.print("Select an option: ");
			int optionIndex = Integer.parseInt(MenuDemo.keyboard.nextLine());
			data = currMenu.performAction(optionIndex);
			if (data!= null)
				navigate(data);
		} while (data!= null);
	}
	
	public static void navigate(NavigationData nd){
		switch (nd.getNavTo()){
			case ConstantFlags.NAV_BACK:
				Menu parentMenu = currMenu.getParentMenu();
				currMenu.setParentMenu(null);
				currMenu = parentMenu;
				break;
			case ConstantFlags.NAV_MAIN:
				Menu mainMenu = new MainMenu();
				mainMenu.setParentMenu(currMenu);
				currMenu = mainMenu;
				break;
			case ConstantFlags.NAV_PLAYER_LIST:
				Menu playerMenu = new PlayerListMenu();
				playerMenu.setParentMenu(currMenu);
				currMenu = playerMenu;
				break;
			
			case ConstantFlags.NAV_FRIEND_LIST:
				Menu friendMenu = new FriendListMenu(nd.getPlayer());
				friendMenu.setParentMenu(currMenu);
				currMenu = friendMenu;
				break;
				
		}
	}
}