public class Player{
	private int score;
	private String name;
	private Player[] friendList;
	
	public void setScore(int s){
		score = s;
	}
	
	public void setName(String n){
		name = n;
	}
	
	public void setFriendList(Player[] fl){
		friendList = fl;
	}
	
	public int getScore(){
		return score;
	}
	
	public String getName(){
		return name;
	}
	
	public Player[] getFriendList(){
		return friendList;
	}
	
}