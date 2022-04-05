import java.util.Scanner;
import java.io.*;
public class Utilities{
    public static int DateCompare(String date, String comparedDate){
        int[] dateArray = transformStringArray(date.split("/"));
        int[] comparedArray = transformStringArray(comparedDate.split("/"));
        
        // date is before comparedDate
        if (dateArray[2]<comparedArray[2] || (dateArray[2]==comparedArray[2] && dateArray[1]<comparedArray[1])  || (dateArray[2]==comparedArray[2] && dateArray[1]== comparedArray[1] && dateArray[0]<comparedArray[0]) )
            return -1;
        else if (dateArray[0]== comparedArray[0] && dateArray[1]== comparedArray[1] && dateArray[2]== comparedArray[2]) // same date
            return 0;
        else
            return 1; // date is after comparedDate
    }
    
	public static int[] transformStringArray(String[] array){
		int[] dateArray = new int[array.length];
		for (int i=0; i<dateArray.length;i++){
			dateArray[i] = Integer.parseInt(array[i]);
		}
		return dateArray;
	}
	public static String oneDayPass(String currentDate){
		String[] allDates = StocksInfo.getListOfTradeDates();
		for(int i=0;i<allDates.length;i++){
			if(allDates[i].equals(currentDate)&&i!=(allDates.length-1))
				return allDates[i+1];
		}
		return null;
	}
	public static int countFileNumber(File file)throws IOException{
		Scanner fileReader = new Scanner(file);
		int count = 0;
		while (fileReader.hasNext()){
			String line = fileReader.nextLine();
			count++;
		}
		fileReader.close();
		//System.out.println(count);
		return count;
	}
	
	public static void updateTradeRecord(String date,String id,double price,int amount,int direction){
		
	}
	
}