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
			Screen.printSelectOption();
			int optionIndex = Integer.parseInt(Screen.keyboard.nextLine());
			#check if the index is valid
			optionIndex = currMenu.checkIndex(optionIndex);
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
			case ConstantFlags.NAV_MY_RECORD:
				Menu recordMenu = new StockListMenu();
				recordMenu.setParentMenu(currMenu);
				currMenu = recordMenu;
				break;
			
			case ConstantFlags.NAV_FRIEND_LIST:
				Menu friendMenu = new FriendListMenu(nd.getPlayer());
				friendMenu.setParentMenu(currMenu);
				currMenu = friendMenu;
				break;
				
		}
	}
}