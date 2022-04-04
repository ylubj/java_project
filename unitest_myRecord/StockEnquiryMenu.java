public class StockEnquiryMenu extends Menu{
	private String stockId;
	private int len;
	
	public StockEnquiryMenu(String id){
		stockId = id;
		Stock enquiryStock = StocksInfo.findStockByID(stockId);
		Stock[] includedStock = enquiryStock.getListOfStockID();
		if(includedStock == null)
			len = 1;
		else
			len = includedStock.length;
	}
	
	@Override
	public void printMenu(){
		Stock enquiryStock = StocksInfo.findStockByID(stockId);
		Stock[] includedStock = enquiryStock.getListOfStockID();
		if(includedStock == null){
			Screen.printListedCompanyInfo(stockId,enquiryStock.getCurrentPrice(),enquiryStock.getProfit(),enquiryStock.getNAV(),enquiryStock.getDividend());
		}
		else{
			Screen.printStockPriceInfo(stockId,enquiryStock.getCurrentPrice());
			for (int i = 1; i<len+1;i++){
				Screen.printStockOption(i,includedStock[i].getStockID());
			}
		}
		Screen.printTradeOption(len+1);
		Screen.printPriceInDateRangeOption(len+2);
		Screen.printBackOption(len+3);
	}
	//undone
	@Override
	public NavigationData performAction(int optionIndex){
		Stock enquiryStock = StocksInfo.findStockByID(stockId);
		Stock[] includedStock = enquiryStock.getListOfStockID();
		if (optionIndex == len + 1){
			return new NavigationData(ConstantFlags.NAV_TRADE,stockId,null,null);
		}
		else if(optionIndex == len + 2){
			//here its about enquiry price within data range
			Screen.printStartDatePrompt();
			String startDate = Screen.keyboard.nextLine();
			Screen.printEndDatePrompt();
			String endDate = Screen.keyboard.nextLine();
			//here i plan to have a helper function in utility which return price provided with date period
			//return new NavigationData(ConstantFlags.NAV_STOCK_ENQUIRY,null,null,null);
		}
		else if(optionIndex == len + 3){
			return new NavigationData(ConstantFlags.NAV_BACK,null,null,null);
		}
		return new NavigationData(
			ConstantFlags.NAV_STOCK_ENQUIRY, includedStock[optionIndex].getStockID(),null,null);
	}
	
}