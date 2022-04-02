public class MainMenu extends Menu{
	
	@Override
	public void printMenu(){
		String today = StockTrader.getCurrentDate();
		Screen.printMainMenu(today);
	}
	
	@Override
	public NavigationData performAction(int optionIndex){
		switch (optionIndex){
			case 1:
				return new NavigationData(ConstantFlags.NAV_MY_RECORD,null);
			case 2:
				return new NavigationData(ConstantFlags.NAV_STOCK_ENQUIRY,null);
			case 3:
				return new NavigationData(ConstantFlags.NAV_TRADE,null);
			case 4:
				#get an end date and do auto buy/sell
				#return new NavigationData(ConstantFlags.NAV_PLAYER_LIST,null);
			case 5:
				#but the date is changed
				return new NavigationData(ConstantFlags.NAV_MAIN,null);
			case 6:
				System.exit(0);
		}
		return null;
	}
	
}