import java.util.Scanner;
import java.io.*;
public class StockListMenu extends Menu{
	
	private StockHolding[] stockHolding;
	/*
	public StockListMenu(Player p){
		player = p;
	}
	*/
	@Override
	public void printMenu(){
		/*
		//read file shares_holding.csv
		File shares_holding = new File("shares-holding.csv");
		int numHolding = Utilities.countFileNumber(shares_holding);
		String[] stockHolding = new String[numHolding];
		Scanner fileReader = new Scanner(shares_holding);
		int index = 0;
		while (fileReader.hasNext()){
			String line = fileReader.nextLine();
			String[] dataArr = line.split(",");
			stockHolding[index] = dataArr[0];
			index++;
			 // dataArr[0] stockID; dataArr[1] #shares ....
			Screen.printShareHoldingOption(index, dataArr[0], Integer.parseInt(dataArr[1]), Double.parseDouble(dataArr[2]), Double.parseDouble(dataArr[3]));
		}
		*/
		
		stockHolding = StocksInfo.getListOfStockHolding();
		for(int i=0;i<stockHolding.length;i++){
			Screen.printShareHoldingOption(i+1, stockHolding[i].getId(), stockHolding[i].getNumShare(), stockHolding[i].getAvgPrice(), stockHolding[i].getTotalProfit());
		}
		Screen.printEnquiryTradingRecordsInPeriodOption(stockHolding.length+1);
		Screen.printBackOption(stockHolding.length+2);
	}
	
	
	
	@Override
	public NavigationData performAction(int optionIndex){
		//Stock[] stockList = StocksInfo.getStockList();
		if (optionIndex == stockHolding.length + 1){
			Screen.printStartDatePrompt();
			String startDate = Screen.keyboard.nextLine();
			Screen.printEndDatePrompt();
			String endDate = Screen.keyboard.nextLine();
			return new NavigationData(ConstantFlags.NAV_ORDER_BY,null,startDate,endDate);
		}
		else if (optionIndex == stockHolding.length + 2){
			return new NavigationData(ConstantFlags.NAV_BACK,null,null,null);
		}
		return new NavigationData(
			ConstantFlags.NAV_ORDER_BY, stockHolding[optionIndex-1].getId(),null,null);
	}
	
	
}