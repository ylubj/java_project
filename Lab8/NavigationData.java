public class NavigationData{
	private int navTo;
	private Player player;
	
	public NavigationData(int n, Player p){
		navTo = n;
		player = p;
	}
	
	public int getNavTo(){
		return navTo;
	}
	
	public Player getPlayer(){
		return player;
	}
}