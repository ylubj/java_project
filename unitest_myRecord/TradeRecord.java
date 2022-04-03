public class TradeRecord{
	private String stockId;
	private String tradeDate;
	private double price;
	private int shares;
	private int direction;
	
	public TradeRecord(String _stockId, String _tradeDate, double _price, int _shares, int _direction){
		stockId = _stockId;
		tradeDate = _tradeDate;
		price = _price;
		shares = _shares;
		direction = _direction;
	}
	
	public String getId(){
		return stockId;
	}
	
	public String getDate(){
		return tradeDate;
	}
	
	public double getPrice(){
		return price;
	}
	
	public int getShares(){
		return shares;
	}
	
	public int getDirection(){
		return direction;
	}
	
}