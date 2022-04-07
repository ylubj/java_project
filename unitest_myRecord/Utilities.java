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
	
	public static void quickSortEffprice(TradeRecord[] array,int start, int end){
		if (start>=end)
			return ;
		
		int m = partitionEffprice(array,start,end);
		quickSortEffprice(array,start,m-1);
		quickSortEffprice(array,m+1,end);
	}
	
	public static int partitionEffprice(TradeRecord[] array,int start, int end){
		TradeRecord pivot = array[end];
		
		int currProcessing = start;
		int firstElementInRight = start;
		
		while (currProcessing <end){
			if (array[currProcessing].getPrice() < pivot.getPrice()){ 
				// swap array[currProcessing] with array[firstElementInRight]
				// currProcessing++ and firstElementInRight++
				TradeRecord tmp = array[currProcessing];
				array[currProcessing]=array[firstElementInRight];
				array[firstElementInRight]=tmp;
				currProcessing++;
				firstElementInRight++;
			}else{
				currProcessing++;
			}
		}
		array[end]=array[firstElementInRight];
		array[firstElementInRight]=pivot;
		
		return firstElementInRight; // pivot position
	}
	
	
}