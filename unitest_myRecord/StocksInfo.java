import java.util.Scanner;
import java.io.*;

public class StocksInfo {
	
	private static Stock[] stockList;
	private static int listedNum;
	private static int ETFnum;
	private static TradeRecord[] tradeRecordList;
	private static StockHolding[] stockHolding;
	
	public static void loadStocks(String currentDate) throws IOException{
		File stockMeta = new File("stock-meta.csv");
		File dailyPrice = new File("daily-price.csv");
		File performance = new File("performance.csv");
		
		listedNum = countNumStocks(stockMeta,1);
		ETFnum = countNumStocks(stockMeta,2);
		stockList = new Stock[listedNum+ETFnum];
		
		for (int i=0; i<listedNum;i++)
			stockList[i] = new ListedCompany();
		for (int i= listedNum;i<(listedNum+ETFnum);i++)
			stockList[i] = new ETF();
		
		loadStockId(stockMeta);
		loadStockPrice(dailyPrice,currentDate);
		 
		loadETFinfo(stockMeta);
		loadListedInfo(performance,currentDate);
		
	}
	
	//
	public static void loadTradeRecord()throws IOException{
		File tradeRecord = new File("trade-record.csv");
		int number = Utilities.countFileNumber("trade-record.csv");
		tradeRecordList = new TradeRecord[number];
		Scanner fileReader = new Scanner(tradeRecord);
		int count = 0;
		while (fileReader.hasNext()){
			String line = fileReader.nextLine();
			String[] dataArr = line.split(","); // dataArr[0] date; dataArr[1] id; dataArr[2] price; dataArr[3] #shares, dataArr[4] direction
			tradeRecordList[count] = new TradeRecord(dataArr[1],dataArr[0], Double.parseDouble(dataArr[2]),Integer.parseInt(dataArr[3]),Integer.parseInt(dataArr[4]));
			count++;
		}
		fileReader.close();
	}
	public static void loadStockHolding()throws IOException{
		String filename = "shares-holding.csv";
		File sharesHolding = new File("shares-holding.csv");
		int number = Utilities.countFileNumber(filename);
		stockHolding = new StockHolding[number];
		Scanner fileReader = new Scanner(sharesHolding);
		int count = 0;
		while (fileReader.hasNext()){
			String line = fileReader.nextLine();
			String[] dataArr = line.split(","); // dataArr[0] id; dataArr[1] #shars; dataArr[2] avg price; dataArr[3] total price
			stockHolding[count] = new StockHolding(dataArr[0],Integer.parseInt(dataArr[1]),Double.parseDouble(dataArr[2]),Double.parseDouble(dataArr[3]));
			count++;
		}
		//System.out.println(count);
		fileReader.close();
	}
	public static TradeRecord[] getListOfTradeRecord(){
		return tradeRecordList;
	}
	public static StockHolding[] getListOfStockHolding(){
		return stockHolding;
	}
	
	public static TradeRecord[] getTradeRecordById(String id){
		int count=0;
		for(int i=0;i<tradeRecordList.length;i++){
			if(id.equals(tradeRecordList[i].getId()))
				count++;
		}
		TradeRecord[] record = new TradeRecord[count];
		count=0;
		for(int i=0;i<tradeRecordList.length;i++){
			if(id.equals(tradeRecordList[i].getId())){
				record[count] = tradeRecordList[i];
				count++;
			}
		}
		return record;
	}
	
	/*
	public static getTradeRecordByPeriod(String id){
		
	}
	*/
	//
	
	public static Stock[] getStockList(){
		return stockList;
	}
	
	/**
		@param file "stock-meta.csv"
		@param type 1 = Listed company, 2 = ETF
	*/
	private static int countNumStocks(File file, int type) throws IOException{  
		Scanner fileReader = new Scanner(file);
		int count = 0;
		while (fileReader.hasNext()){
			String line = fileReader.nextLine();
			String[] dataArr = line.split(","); // dataArr[0] stockID; dataArr[1] type
			if (Integer.parseInt(dataArr[1]) == type)
				count++;
		}
		fileReader.close();
		return count;
	}
	
	/**
		@param file "stock-meta.csv"
	*/
	private static void loadStockId(File file) throws IOException{
		Scanner fileReader = new Scanner(file);
		int listedIndex = 0;
		int ETFindex = 0;
		
		while (fileReader.hasNext()){
			String line = fileReader.nextLine();
			String[] dataArr = line.split(","); // dataArr[0] stockID; dataArr[1] type
			int type = Integer.parseInt(dataArr[1]);
			if (type ==1)
				stockList[listedIndex++].setStockID(dataArr[0]);
			else if (type == 2){
				stockList[listedNum+ETFindex].setStockID(dataArr[0]);
				ETFindex++;
			}
		}
		fileReader.close();
	}
	
	
	
	/**
		@param file "daily-price.csv"
		@param currentDate input from StockTraderDemo.java
	*/
	private static void loadStockPrice(File file, String currentDate) throws IOException{
		Scanner fileReader = new Scanner(file);
		while (fileReader.hasNext()){
            String line = fileReader.nextLine();
            String[] dataArr = line.split(","); // [0] stockID [1] date [2] close
			
			for (int i = 0;i<stockList.length;i++){
				if (dataArr[0].equals(stockList[i].getStockID()) && dataArr[1].equals(currentDate))
					stockList[i].setCurrentPrice(Double.parseDouble(dataArr[2]));
			}
        }
		fileReader.close();
	}
	
	/**
		@param file "performance.csv"
	*/
	private static void loadListedInfo(File file, String currentDate) throws IOException{
		Scanner fileReader = new Scanner(file);
		String lastDate = "00/00/9999";
		while (fileReader.hasNext()){
			String line = fileReader.nextLine();
            String[] dataArr = line.split(",") ;// [0] stockID, [1] date, [2] profit, [3] NAV, [4] dividend
			for (int i=0; i<listedNum;i++){
				if (dataArr[0].equals(stockList[i].getStockID()) && Utilities.DateCompare(currentDate,dataArr[1])>=0 && Utilities.DateCompare(currentDate,lastDate)<0){
					stockList[i].setProfit(Double.parseDouble(dataArr[2]));
					stockList[i].setNAV(Double.parseDouble(dataArr[2]));
					stockList[i].setDividend(Double.parseDouble(dataArr[3]));
				}
			}
			lastDate = dataArr[1];
		}
		fileReader.close();
	}
	
	
	
	/**
		@param file "stock-meta.csv"
	*/
	private static void loadETFinfo (File file) throws IOException {
		Scanner fileReader = new Scanner(file);
		int index = 0;
		while (fileReader.hasNext()){
			String line = fileReader.nextLine();
			String[] dataArr = line.split(","); // dataArr[0] stockID; dataArr[1] type
			if (Integer.parseInt(dataArr[1]) == 2){ // ETF
				// dataArr[2] to dataArr[dataArr.length-1] -> listOfStock
				setListOfStockOfSingleETF(findStockByID(dataArr[0]), dataArr);
			}
		}
		fileReader.close();
	}
	
	private static Stock findStockByID(String id){
		for (int i = 0; i<stockList.length;i++)
			if (id.equals(stockList[i].getStockID()))
				return stockList[i];
		return null;
	}
	
	private static void setListOfStockOfSingleETF (Stock stock, String[] meta){
		Stock[] listOfStockID = new ListedCompany[meta.length-2];
		for (int i=2;i<meta.length;i++){
			listOfStockID[i-2] = findStockByID(meta[i]);
		}
		stock.setListOfStockID(listOfStockID);
	}
	
	/*
	public static void main(String[] args) throws IOException{
		loadStocks("23/11/2019");
		for (int i=0; i<listedNum;i++){
			System.out.println(stockList[i].getStockID());
			System.out.println(stockList[i].getProfit());
		}
		
		Stock[] list = stockList[listedNum].getListOfStockID();
		for (int i=0;i<list.length;i++)
			System.out.println(list[i].getStockID());
	
	}
	*/
}