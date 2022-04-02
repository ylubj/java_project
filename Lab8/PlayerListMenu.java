public class PlayerListMenu extends Menu{
	
	@Override
	public void printMenu(){
		Player[] playerList = PlayersInfo.getPlayerList();
		for (int i = 0; i<playerList.length;i++){
			System.out.println(
				(i+1) + ". " + playerList[i].getName() + " " + playerList[i].getScore()
			);
		}
		System.out.println((playerList.length+1)+". Back");
	}
	
	@Override
	public NavigationData performAction(int optionIndex){
		Player[] playList = PlayersInfo.getPlayerList();
		if (optionIndex == playList.length+1)
			return new NavigationData(ConstantFlags.NAV_BACK,null);
		return new NavigationData(ConstantFlags.NAV_FRIEND_LIST,playList[optionIndex-1]);
	}
}