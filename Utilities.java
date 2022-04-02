public class Utilities{
    public static int DateCompare(String date, String comparedDate){
        int[] dateArray = transformStringArray(date.split("/"));
        int[] comparedArray = transformStringArray(comparedDate.split("/"));
        
        // date is before comparedDate
        if (dateArray[2]<comparedArray[2] || (dateArray[2]==comparedArray[2] && dateArray[1]<comparedArray[1])  || (dateArray[2]==comparedArray[2] && dateArray[1]== comparedArray[1] && dateArray[0]== comparedArray[0]) )
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
		int[] dateArray = transformStringArray(date.split("/"));
		//check for month and holiday
		dateArray[0] += 1;
		String newDate = '';
		return newDate;
	}
    
	public static int countFileNumber(File file){
		Scanner fileReader = new Scanner(shares_holding);
		int count = 0;
		while (fileReader.hasNext()){
				count++;
		}
		fileReader.close();
		return count;
	}
	
}