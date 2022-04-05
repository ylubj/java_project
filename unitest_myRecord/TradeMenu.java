public class TradeMenu extends Menu{
	private String stockId;
	
	public TradeMenu(String id){
		stockId = id;
	}
	
	@Override
	public void printMenu(){
		Stock s = StocksInfo.findStockByID(stockId);
		Screen.printStockPriceInfo(stockId,s.getCurrentPrice());
		Screen.printTradeMenu();
	}
	//undone
	@Override
	public NavigationData performAction(int optionIndex){
		switch (optionIndex){
			//for 1 and 2, check the money and update record !!!! IMPORTANT Without re-launch the program, all enquiry and record should be up-to-date
			case 1:
				return new NavigationData(ConstantFlags.NAV_TRADE_BUY,stockId,null,null);
			case 2:
				return new NavigationData(ConstantFlags.NAV_TRADE_SELL,stockId,null,null);
			case 3:
				return new NavigationData(ConstantFlags.NAV_BACK,null,null,null);
		}
		return null;
	}
	
}