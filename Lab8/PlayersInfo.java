import java.util.Scanner;
import java.io.*;

public class PlayersInfo{
	private static Player[] playerList;
	
	public static void loadPlayers() throws IOException{
		File playScoreFile = new File("player-score.txt");
		File friendListFile = new File("player-friends.txt");
		
		// know how many players
		int numPlayers = countNumPlayers(playScoreFile);
		
		// create the array of player
		playerList = new Player[numPlayers];
		for (int i =0;i<numPlayers;i++){
			playerList[i] = new Player();
		}
		
		// load the player name and score
		loadPlayerNameAndScore(playScoreFile);
		
		// load the friend lsit
		loadFriendList(friendListFile);
		
	
	}
	public static Player[] getPlayerList(){
		return playerList;
	}
	
	private static int countNumPlayers(File file) throws IOException {
		Scanner fileReader = new Scanner(file);
		int count = 0;
		while (fileReader.hasNext()){
			fileReader.nextLine();
			count++;
		}
		fileReader.close();
		return count;
	}
	
	private static void loadPlayerNameAndScore(File file) throws IOException {
		Scanner fileReader = new Scanner(file);
		int index = 0;
		while (fileReader.hasNext()){
			String line = fileReader.nextLine();
			String[] dataArr = line.split(",");
			playerList[index].setName(dataArr[0]);
			playerList[index].setScore(Integer.parseInt(dataArr[1]));
			index++;
		}
		fileReader.close();
	}
	
	
	private static void loadFriendList(File file) throws IOException {
		Scanner fileReader = new Scanner(file);
		int index = 0;
		while (fileReader.hasNext()){
			String line = fileReader.nextLine();
			String[] dataArr = line.split(",");
			Player targetPlayer = findPlayerByName(dataArr[0]);
			// dataArr[1] to dataArr[dataArr.length -1]  -> friendLsit
			// dataArr[0] targetPlayer
			setFriendListOfSinglePlayer(targetPlayer,dataArr);
		}
		fileReader.close();
	}
	
	private static Player findPlayerByName(String name){
		for (int i = 0; i <playerList.length;i++){
			if (name.equals(playerList[i].getName()))
				return playerList[i];
		}
		return null;
	}
	
	private static void setFriendListOfSinglePlayer(Player p, String[] names){
		Player[] friendList = new Player[names.length - 1];
		for (int i = 1; i<names.length;i++){
			Player friendPlayer = findPlayerByName(names[i]);
			friendList[i-1] = friendPlayer;
		}
		p.setFriendList(friendList);
	}
	
	/**
	public static void main(String[] args) throws IOException{
		loadPlayers();
		for (int i =0; i<playerList.length;i++){
			System.out.println(playerList[i].getName());
			System.out.println(playerList[i].getScore());
		}
		Player[] firstFriendList = playerList[0].getFriendList();
		for (int i=0;i<firstFriendList.length;i++){
			System.out.println(firstFriendList[i].getName());
		}
	}
	*/
	
	
}