public class NavigationData{
	private int navTo;
	private String stockId;
	private String startDate;
	private String endDate;
	
	public NavigationData(int n, String _stockId, String _startDate, String _endDate){
		navTo = n;
		stockId = _stockId;
		startDate = _startDate;
		endDate = _endDate;
	}
	
	public int getNavTo(){
		return navTo;
	}
	
	public String getStockId(){
		return stockId;
	}
	
	public String getStartDate(){
		return startDate;
	}
	
	public String getEndDate(){
		return endDate;
	}
	
}