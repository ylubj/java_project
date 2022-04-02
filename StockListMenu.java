public class StockListMenu extends Menu{
	
	private St player;
	
	public StockListMenu(Player p){
		player = p;
	}
	
	@Override
	public void printMenu(){
		Stock[] stockList = StocksInfo.getStockList();
		for (int i =0; i<stockList.length;i++){
			#printShareHoldingOption(optionNum, id, amountOfShare, avgPrice, totalProfit);
		}
		printEnquiryTradingRecordsInPeriodOption(stockList.length+1);
		printBackOption(stockList.length+2);
	}
	
	
	
	@Override
	public NavigationData performAction(int optionIndex){
		Stock[] stockList = StocksInfo.getStockList();
		if (optionIndex == stockList.length + 1){
			printStartDatePrompt();
			String startDate = Screen.keyboard.nextLine();
			printEndDatePrompt();
			String endDate = Screen.keyboard.nextLine();
			return new NavigationData(ConstantFlags.NAV_ORDER_BY,null,startDate,endDate);
		}
		else if (optionIndex == stockList.length + 2){
			return new NavigationData(ConstantFlags.NAV_BACK,null,null,null);
		}
		return new NavigationData(
			ConstantFlags.NAV_ORDER_BY, stickList[optionIndex-1],null,null);
	}
	
	
}