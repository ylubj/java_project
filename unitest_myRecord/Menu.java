public abstract class Menu{
	private Menu parentMenu;
	
	public void setParentMenu(Menu m){
		parentMenu = m;
	}
	
	public Menu getParentMenu(){
		return parentMenu;
	}
	
	public int checkIndex(int i){
		return i;
	}
	
	public abstract void printMenu();
	
	public abstract NavigationData performAction(int optionIndex);
	
}