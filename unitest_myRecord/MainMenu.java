public class MainMenu extends Menu{
	
	@Override
	public int checkIndex(int i){
		while(i<1||i>6){
			Screen.printInvalidMainMenuOption();
			i = Integer.parseInt(Screen.keyboard.nextLine());
		}
		return i;
	}
	
	@Override
	public void printMenu(){
		String today = StockTrader.getCurrentDate();
		Screen.printMainMenu(today);
	}
	//undone for trade
	@Override
	public NavigationData performAction(int optionIndex){
		switch (optionIndex){
			case 1:
				return new NavigationData(ConstantFlags.NAV_MY_RECORD,null,null,null);
			/*
			case 2:
				return new NavigationData(ConstantFlags.NAV_STOCK_ENQUIRY,null,null,null);
			case 3:
				return new NavigationData(ConstantFlags.NAV_TRADE,null,null,null);
			case 4:
				#get an end date and do auto buy/sell
				printEndDatePrompt();
				String endDate = Screen.keyboard.nextLine();
				return new NavigationData(ConstantFlags.NAV_AUTO_TRADE,'00700',null,endDate);
			case 5:
				#but the date is changed, need a mark(also load price then)
				return new NavigationData(ConstantFlags.NAV_MAIN,null,null,null);
			case 6:
				System.exit(0);
			*/
		}
		return null;
	}
	
}