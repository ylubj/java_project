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
			//check if the index is valid
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
				Menu main = new MainMenu();
				main.setParentMenu(currMenu);
				currMenu = main;
				break;
			case ConstantFlags.NAV_MY_RECORD:
				Menu recordMenu = new StockListMenu();
				recordMenu.setParentMenu(currMenu);
				currMenu = recordMenu;
				break;
			
			case ConstantFlags.NAV_ORDER_BY:
				Menu orderMenu = new OrderMenu(nd.getStockId(),nd.getStartDate(),nd.getEndDate(),1);
				orderMenu.setParentMenu(currMenu);
				currMenu = orderMenu;
				break;
				/*
			case ConstantFlags.NAV_STOCK_ENQUIRY:
				Menu enquiryMenu = new StockEnquiryMenu(nd.getStockId());
				enquiryMenu.setParentMenu(currMenu);
				currMenu = enquiryMenu;
				break;
			case ConstantFlags.NAV_AUTO_TRADE:
				//perform auto trade with given id and end date
				String id = nd.getStockId();
				String endDate = nd.getEndDate();
				//after that set currentDate to this end Date 
				//return mainMenu
				Menu mainMenu = new MainMenu();
				currMenu = mainMenu;
			*/
		}
	}
}