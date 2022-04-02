public class StockEnquiryMenu extends Menu{
	private Stock stock;
	
	public StockEnquiryMenu(Stock s){
		stock = s;
	}
	
	@Override
	public void printMenu(){
		Stock[] includedStock = stock.getListOfStockID();
		if(includedStock!=null){
			System.out.println("Below are the friends of "+player.getName());
			for (int i =0; i<includedStock.length;i++){
				printStockOption(i,includedStock[i].getStockID());
			}
		}
		printTradeOption(includedStock.length+1);
		printPriceInDateRangeOption(includedStock.length+2);
		printBackOption(includedStock.length+3);
	}
	#undone
	@Override
	public NavigationData performAction(int optionIndex){
		Player[] friendList = player.getFriendList();
		if (optionIndex == friendList.length + 1){
			return new NavigationData(ConstantFlags.NAV_BACK,null);
		}
		return new NavigationData(
			ConstantFlags.NAV_FRIEND_LIST, friendList[optionIndex-1]);
	}
	
}