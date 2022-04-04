public class OrderMenu extends Menu{
	private String stockId;
	private String startDate;
	private String endDate;
	private int orderFlag;
	
	public OrderMenu(String _stockId, String _startDate, String _endDate, int option){
		stockId = _stockId;
		startDate = _startDate;
		endDate = _endDate;
		orderFlag = option;
	}
	
	@Override
	public void printMenu(){
		//print trade record based on stock id or date period
		TradeRecord[] record = null;
		if(stockId!=null)
			record = StocksInfo.getTradeRecordById(stockId);
		else{
			record = StocksInfo.getTradeRecordByPeriod(startDate,endDate);
		}
		for(int i=0;i<record.length;i++){
			Screen.printTradeRecord(record[i].getDate(),record[i].getId(),record[i].getDirection(),record[i].getPrice(),record[i].getShares(),record[i].getPrice()*record[i].getShares());
		}
		Screen.printOrderMenu();
	}
	
	//undone
	@Override
	public NavigationData performAction(int optionIndex){
		switch (optionIndex){
			case 1:
				//order by trade sequence
				return new NavigationData(ConstantFlags.NAV_ORDER_BY,null,null,null);
			case 2:
				//order by trade price
				return new NavigationData(ConstantFlags.NAV_ORDER_BY,null,null,null);
			case 3:
				//order by trade shares
				return new NavigationData(ConstantFlags.NAV_ORDER_BY,null,null,null);
			case 4:
				//order by total trade amount
				return new NavigationData(ConstantFlags.NAV_ORDER_BY,null,null,null);
			case 5:
				//order by stock id
				return new NavigationData(ConstantFlags.NAV_ORDER_BY,null,null,null);
			case 6:
				return new NavigationData(ConstantFlags.NAV_BACK,null,null,null);
		}
		return null;
	}
	
}