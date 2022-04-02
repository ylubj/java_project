import java.io.*;
public class StockTrader{
	private static String currentDate;
	
	public static String getCurrentDate(){
		return currentDate;
	}
	
	public static void oneDayPass(){
		//one day passes, update the date 
		currentDate = Utilities.oneDayPass(currentDate);
	}
	
	public static void main(String[] args) throws IOException{
		
		/*
			Set today
			assume the date input is always valid
		*/
		Screen.printDateInsertion();
		currentDate = Screen.keyboard.nextLine();
		
		// load Stocks Information
		StocksInfo.loadStocks(currentDate);
		//start main menu
		MenuController.startMenu();
		
		
	}
}