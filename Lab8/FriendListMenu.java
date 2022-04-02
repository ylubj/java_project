public class FriendListMenu extends Menu{
	private Player player;
	
	
	public FriendListMenu(Player p){
		player = p;
	}
	
	@Override
	public void printMenu(){
		Player[] friendList = player.getFriendList();
		System.out.println("Below are the friends of "+player.getName());
		for (int i =0; i<friendList.length;i++){
			System.out.println( (i+1)+". "+ friendList[i].getName());
		}
		System.out.println((friendList.length+1)+". Back");
	}
	
	@Override
	public NavigationData performAction(int optionIndex){
		Player[] friendList = player.getFriendList();
		if (optionIndex == friendList.length + 1){
			return new NavigationData(ConstantFlags.NAV_BACK,null);
		}
		return new NavigationData(
			ConstantFlags.NAV_FRIEND_LIST, friendList[optionIndex-1]);
	}
	
	
}