public class StockHolding{
	private String stockId;
	private int numShares;
	private double avgPrice;
	private double totalProfit;


	public StockHolding(String _stockId, int _numShares, double _avgPrice, double _totalProfit){
		stockId = _stockId;
		numShares = _numShares;
		avgPrice = _avgPrice;
		totalProfit = _totalProfit;
	}
	
	public String getId(){
		return stockId;
	}
	
	public int getNumShare(){
		return numShares;
	}
	
	public double getAvgPrice(){
		return avgPrice;
	}
	
	public double getTotalProfit(){
		return totalProfit;
	}
}